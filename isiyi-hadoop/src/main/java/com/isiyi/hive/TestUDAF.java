package com.isiyi.hive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.exec.UDFArgumentTypeException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.udf.generic.AbstractGenericUDAFResolver;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFMkCollectionEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFSum;
import org.apache.hadoop.hive.serde2.objectinspector.*;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现MySQL中的GROUP_CONCAT 函数的功能，就是Oracle中list函数
 */
public class TestUDAF extends AbstractGenericUDAFResolver {

    // 创建LOG对象，用来写入警告和错误到hive的log。
    static final Log LOG = LogFactory.getLog(GenericUDAFSum.class.getName());

    public TestUDAF(){
    }

    //重写一个方法：getEvaluator，它根据SQL传入的参数类型,返回正确的evaluator。
    @Override
    public GenericUDAFEvaluator getEvaluator(TypeInfo[] parameters) throws SemanticException {

        if(parameters.length != 1){
            throw new UDFArgumentTypeException(parameters.length - 1,"Exactly one argument is expected.");
        }
        // 判断是不是Hive支持的原始类型
        if (parameters[0].getCategory() != ObjectInspector.Category.PRIMITIVE){
            throw new UDFArgumentTypeException(0,
                    "Only primitive type arguments are accepted but "
                            + parameters[0].getTypeName() + "was passed as parameter 1.");
        }
        //GenericUDAFMkCollectionEvaluator 的父类是GenericUDAFEvaluator，
        // 用于Hive的通用用户定义聚合函数（GenericUDAF）。
        // 它的父类在下面初始化
        return new GenericUDAFMkCollectionEvaluator();
    }

    public static class GenericUDAFMkColistEvaluator extends GenericUDAFEvaluator{

        private PrimitiveObjectInspector inputOI;
        private StandardListObjectInspector loi;
        private StandardListObjectInspector internalMergeOI;

        // Hive会调用此方法来初始实例化一个UDAF evaluator 类
        @Override
        public ObjectInspector init(Mode m, ObjectInspector[] parameters) throws HiveException {
            super.init(m, parameters);

            if(m == Mode.PARTIAL1){
                inputOI = (PrimitiveObjectInspector) parameters[0];
                return ObjectInspectorFactory.getStandardListObjectInspector(
                        (PrimitiveObjectInspector) ObjectInspectorUtils.getStandardObjectInspector(inputOI)
                );
            }else{
                if(!(parameters[0] instanceof StandardListObjectInspector)){
                    inputOI = (PrimitiveObjectInspector) ObjectInspectorUtils.
                            getStandardObjectInspector(parameters[0]);
                    return (PrimitiveObjectInspector) ObjectInspectorFactory.getStandardListObjectInspector(inputOI);
                }else{
                    internalMergeOI = (StandardListObjectInspector) parameters[0];
                    inputOI = (PrimitiveObjectInspector) internalMergeOI.getListElementObjectInspector();
                    loi = (StandardListObjectInspector) ObjectInspectorUtils.getStandardObjectInspector(internalMergeOI);
                    return loi;
                }
            }
        }

        // 自定义函数，对象重用
        static class MKArrayAggregationBuffer implements AggregationBuffer{
            List<Object> container;
        }

        // 自定义函数，完成迭代功能
        private void putIntoList(Object p,MKArrayAggregationBuffer myagg){
            Object pCopy = ObjectInspectorUtils.copyToStandardObject(p,this.inputOI);
            myagg.container.add(pCopy);
        }

        // 用于返回存储临时聚合结果的 GenericUDAFEvaluator.AggregationBuffer 对象
        public AggregationBuffer getNewAggregationBuffer() throws HiveException {
            MKArrayAggregationBuffer ret = new MKArrayAggregationBuffer();
            reset(ret);
            return ret;
        }

        // 重置聚合，该方法在重用相同的聚合时很有用
        public void reset(AggregationBuffer agg) throws HiveException {
            ((MKArrayAggregationBuffer) agg).container = new ArrayList<Object>();

        }

        // 迭代parameters表示的原始数据，并保存到 agg 中
        public void iterate(AggregationBuffer agg, Object[] parameters) throws HiveException {
            assert (parameters.length == 1);
            Object p = parameters[0];

            if(p != null){
                MKArrayAggregationBuffer myagg = (MKArrayAggregationBuffer) agg;
                putIntoList(p,myagg);
            }
        }

        // 以持久的方式返回 agg 表示部分聚合结果，这里的持久化意味着返回值只能是Java基础类型、数组、基础类型包装器、Hadoop的writables、Lists和Maps，
        // 即便实现了java.id.Serializable 也不要使用自定义的类。
        public Object terminatePartial(AggregationBuffer agg) throws HiveException {
            MKArrayAggregationBuffer myagg = (MKArrayAggregationBuffer) agg;
            ArrayList<Object> ret = new ArrayList<Object>(myagg.container.size());
            ret.addAll(myagg.container);
            return ret;
        }

        // 合并由partial 表示的部分聚合结果到 agg
        public void merge(AggregationBuffer agg, Object partial) throws HiveException {
            MKArrayAggregationBuffer myagg = (MKArrayAggregationBuffer) agg;
            ArrayList<Object> partialResult = (ArrayList<Object>)internalMergeOI.getList(partial);
            for (Object i:partialResult) {
                putIntoList(i,myagg);
            }
        }

        // 返回由 agg 表示的最终结果
        public Object terminate(AggregationBuffer agg) throws HiveException {
            MKArrayAggregationBuffer myagg = (MKArrayAggregationBuffer) agg;
            ArrayList<Object> ret = new ArrayList<Object>(myagg.container.size());
            ret.addAll(myagg.container);
            return ret;
        }
    }

}
