package com.isiyi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private final static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generate(0, 0, 3, "");
        System.out.println(list);
    }

    private void generate(int left, int right, int n, String s){
        if(left == n &&  right == n){
            list.add(s);
            return;
        }
        if(left < n){
            generate(left + 1, right, n, s+"(");
        }
        if(left > right){
            generate(left, right+1, n, s+")");
        }

    }
}
