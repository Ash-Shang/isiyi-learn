package com.isiyi.java.flink.excutor;

import com.isiyi.java.flink.domain.Tokenizer;
import com.isiyi.java.flink.domain.WordCountDomain;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.HeaderTokenizer;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * 统计一个文件的单词出现的总次数，并将结果存储到文件中
 * <p></p>
 *
 * @version 1.0.0
 * @description: WordCountExecutor
 * @author: 向鹏飞
 * @since: 2021/6/6
 */
public class WordCountBatchExecutor {

    public static void main(String[] args) throws Exception {

        String input = "";
        String output = "";

        //获取Flink运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> textFile = env.readTextFile(input);

        DataSet<Tuple2<String, Integer>> counts = textFile.flatMap(new Tokenizer()).groupBy(0).sum(1);

        counts.writeAsCsv(output, "\n", " ").setParallelism(1);

        env.execute("执行了、、、、");
    }


}
