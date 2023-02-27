package com.learner.leetcodelearner.lib.codetop;

import java.util.Arrays;

/**
 * @Description  回家看 加个勾八班
 * @Author andy lin
 * @Date: 2023/02/27 19:52
 **/
public class No_912 {
    /**
     * 用jdk自带的排序直接过..看了一下排序的实现代码脑壳痛
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 插入排序
     * 思路:
     * 从数组第二个元素开始,逆序与它之前的所有元素比较大小,当元素比他大时,就把元素后移,直到找到比他小的元素时,把它插入该元素后面
     * @param nums
     * @return
     */
    public int[] insertArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
           int temp = nums[i];
           int j = i;
           while(j > 0 && nums[j - 1] > temp) {
               nums[j] = nums[j -1];
               j--;
           }
           nums[j] = temp;
        }
        return nums;
    }
}
