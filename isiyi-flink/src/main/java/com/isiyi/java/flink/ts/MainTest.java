package com.isiyi.java.flink.ts;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.junit.Test;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: MainTest
 * @author: 向鹏飞
 * @since: 2021/6/20
 */
public class MainTest {

    @Test
    public void main() throws Exception {
        ExecutionEnvironment environment = ExecutionEnvironment.getExecutionEnvironment();
       // TsOperatorTest.mapFunction(environment);
        TsOperatorTest.firstFunction(environment);
    }

}
