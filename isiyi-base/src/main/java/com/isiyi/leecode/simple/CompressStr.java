package com.isiyi.leecode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CompressStr
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/16 11:40
 * @Version 1.0
 */
public class CompressStr {


    public static  String compress(String S){

        char[] chars = S.toCharArray();
        char tempChar = 0;
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for(char c : chars){
            if(tempChar == c){
                count++;
            }else{
                builder.append(c).append(count);
                count = 1;
                tempChar = c;
            }
        }
        String compress = builder.toString();
        if(compress.length() >=  S.length()){
            return S;
        }
        return compress;

    }
}
