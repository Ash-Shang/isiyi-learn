package com.isiyi.leecode;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/16 11:16
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int i = -121;
        boolean palindrome = isPalindrome(i);
        System.out.println(palindrome);
    }


    public static boolean isPalindrome(int x) {
        if(0 < x && x < 10){
            return true;
        }
        if(x < 0){
            return false;
        }
        if(0 == x%10 ){
            return false;
        }
        long res = 0;
        while(x > 0){

            res = res * 10 + x % 10;
            x = x / 10;
        }

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ){
            return false;
        }
        return res==x;
    }


}
