package com.learner.leetcodelearner.lib.codetop;

import java.util.Arrays;

/**
 * @Description
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

    /**
     * 技术排序
     * 通过构建一个长度略大于原数组的暂存数组
     * 将原数组通过减去原数组最小值来映射到暂存数组(在暂存数组下标对应位置计数)
     * 倒序遍历暂存数组,通过计数标识取出原数组从大到小的排序数组
     * @param nums
     * @return
     */
    public int[] countNum(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
            if (min > nums[i]) min = nums[i];
        }
        int[] temp = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]-min]++;
        }
        int j = nums.length - 1;
        for (int i = max - min; i > -1; i--) {
            int n = temp[i];
            while(n > 0) {
                nums[j] = i + min;
                n--;
                j--;
            }
        }
        return nums;
    }
}
