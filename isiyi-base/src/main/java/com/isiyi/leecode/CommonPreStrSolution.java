package com.isiyi.leecode;

/**
 * @ClassName CommonPreStrSolution
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/20 22:41
 * @Version 1.0
 */
public class CommonPreStrSolution {

    public String longestCommonPrefix(String[] strs) {
        if(0 == strs.length)
            return "";
        String res = strs[0];
        for(int i=0; i < strs.length; i++){
            int j =0;
            for(;j< res.length() &&  j< strs[i].length(); j++){
                if(res.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            res = res.substring(0,j);
            if("".equals(res)){
                return res;
            }
        }
        return res;
    }


}
