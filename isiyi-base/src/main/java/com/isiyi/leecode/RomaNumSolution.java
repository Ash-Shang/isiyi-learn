package com.isiyi.leecode;

/**
 * @ClassName RomaNumSolution
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/20 22:30
 * @Version 1.0
 */
public class RomaNumSolution {

    public int romanToInt(String s) {
        int res = 0;
        int preNum = getIntByChar(s.charAt(0));
        for(int i=1; i< s.length();i++){
            int nextNum = getIntByChar(s.charAt(i));
            if(preNum < nextNum){
                res -= preNum;
            }else{
                res += preNum;
            }
            preNum = nextNum;
        }
        res += preNum;//最后一位相加
        return res;
    }


    private int getIntByChar(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default:return 0;
        }
    }

}
