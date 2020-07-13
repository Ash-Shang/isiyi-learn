package com.isiyi.main;

import com.isiyi.bubble.BubbleSortTest;
import com.isiyi.utils.ToolUtil;
import org.junit.Test;

public class MainTest {

    public static void main(String[] args) {
        int testTime = 50000;
        int max = 100;
        int maxValue = 100;
        boolean success = true;

        for (int i = 0; i < testTime; i++) {
            int[] array = ToolUtil.generateRandomArray(max, maxValue);
            int[] copyArray = ToolUtil.copyArray(array);

            testSort(array);

            ToolUtil.assertMethod(copyArray);
            if(!ToolUtil.isEqual(array, copyArray)){
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice!": "Sorry");
    }


    public static void testSort(int[] array){
        BubbleSortTest.sort01(array);
    }

}
