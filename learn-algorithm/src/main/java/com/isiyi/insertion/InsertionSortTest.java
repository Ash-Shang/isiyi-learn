package com.isiyi.insertion;

public class InsertionSortTest {


    /**
     * 插入排序， 如果数据有序 O(n), 如果无序O(n*n)
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3,2,9,74,89,56,14};
        sort(arr);
        print(arr);
    }

    public static void sort(int[] arr){

        if(null == arr || arr.length < 2){
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for(int j = i-1; j>= 0 && arr[j] > arr[j+1]; j--){
                swap(arr, j, j+1);
            }
        }
        
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i != 0){
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
}
