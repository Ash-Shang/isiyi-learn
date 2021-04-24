package com.isiyi.objs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestObjs {

    @Test
    public void test1(){

        int i = 0;
        String str = "0";
        swap(i);
        System.out.println(i);
        swap(str);
        System.out.println(str);

        List<String> list = new ArrayList<>();
        swap(list);
        System.out.println(list.size());
        System.out.println(list);

    }

    private void swap(int i){
        i = 2;
    }

    private void swap(String i){
        i = "2";
    }

    private void swap(List<String> list){
        list.add("2");
    }

}
