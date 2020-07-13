package com.isiyi.leecode.simple;

/**
 * 删除数组重复的数据
 * @ClassName RemoveDuplicatesSolution
 * @Description TODO
 * @Author Ash-Shang
 * @Date 2020/3/21 8:40
 * @Version 1.0
 */
public class RemoveDuplicatesSolution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int flag = 0;
        for(int i =1; i < nums.length; i++){
            if(nums[flag] != nums[i]){
                flag++;
                nums[flag] = nums[i];
            }
        }
        return flag+1;


    }
}
