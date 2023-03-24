package com.learner.leetcodelearner.lib.medium;

import java.util.*;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/24 10:23
 **/
public class No_1630 {
    /**
     * 直接思路:按题意一步步的判断当前位置对应的子数组是否等差
     * 暴力模拟
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len = l.length;
        List<Boolean> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            list.add(check(nums, l[i], r[i]));
        }
        return list;
    }


    private Boolean check(int[] nums, int left, int right) {
        int[] temp = new int[right - left + 1];

        for (int i = left; i <= right; i++) {
            temp[i - left] = nums[i];
        }
        int d = temp[1] - temp[0];
        for (int i = 1; i < right - left + 1; i++) {
            Arrays.sort(temp);
            if (temp[i] - temp[i-1] != d) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不用排序 速度也没有排序快
     * 垃圾
     * @param i
     * @param j
     * @param nums
     * @return
     */
    public boolean isArithmetic(int i, int j, int[] nums) {
        if (j - i < 2)
            return true;
        Set<Integer> set = new HashSet<>();
        // 记录一下最大最小值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            set.add(nums[k]);
            max = Math.max(max, nums[k]);
            min = Math.min(min, nums[k]);
        }
        // 查看是否可以整除，可以处理不同差值以及重复元素
        if ((max - min) % (j - i) != 0)
            return false;
        int diff = (max - min) / (j - i);
        for (int t = 1; t <= (j - i); t++) {
            if (!set.contains(min + t * diff))
                return false;
        }
        return true;
    }






}
