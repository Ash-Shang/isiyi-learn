package com.isiyi.bitwise;

import org.junit.Test;

public class TestBitwiseOperation {

    @Test
    public void test01(){
        int x = 5;
        int i = x | (1 << 1);
        System.out.println(i);
    }

}
