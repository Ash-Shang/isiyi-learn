package com.isiyi.utils;

import java.util.Arrays;

public class ToolUtil {

    /**
     * 交换值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i != 0){
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    /**
     * 生成随机的数据
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 复制方法
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 觉得正确的方法
     * @param arr
     */
    public static void assertMethod(int[] arr){
        Arrays.sort(arr);
    }

    public static boolean equalAndWriteWrong(int[] arr1, int[] arr2){
        boolean equal = isEqual(arr1, arr2);
        if(!equal){
            print(arr1);
            print(arr2);
        }
        return equal;
    }
    /**
     * 判断两个数组是否相等（长度相等，对应位置的数据相等）
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
