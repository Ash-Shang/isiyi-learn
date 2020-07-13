package com.isiyi.bubble;

import com.isiyi.utils.ToolUtil;
import org.junit.Test;

public class BubbleSortTest {

    
    public static void  sort01(int[] arr){
        if(null == arr || arr.length < 2) return;

        for (int length = arr.length-1; length > 0; length--) {
            for (int i = 0; i < length; i++) {
                if(arr[i] > arr[i+1]){
                    //换值
                   ToolUtil.swap(arr, i, i+1);
                }
            }
        }
    }


}
