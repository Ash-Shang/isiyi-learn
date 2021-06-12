package com.isiyi.collection;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: MapTest
 * @author: 向鹏飞
 * @since: 2021/6/7
 */
public class MapTest {

    @Test
    public void mainTest() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
        System.out.println(JSON.toJSONString(namesNested));
        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(namesFlatStream));
    }


}
