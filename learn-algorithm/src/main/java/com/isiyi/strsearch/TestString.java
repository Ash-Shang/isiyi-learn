package com.isiyi.strsearch;

import org.junit.Test;

public class TestString {

    @Test
    public void testEquals(){
        String s01 = "abc";
        String s02 = "abc";
        System.out.println(s01 == s02);
        System.out.println(s01.equals(s02));
    }

}
