package com.learner.leetcodelearner.hello_algo.chapter_computational_complexity;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/8/3
 */
public class worst_best_time_complexity {
    /* 生成一个数组,元素为{1, 2, ... , n}, 顺序被打乱 */
    static int[] randomNumbers(int n) {
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        // 随机打乱数组元素
        Collections.shuffle(Arrays.asList(nums));
        // Integer[] -> int[]
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
        }
        return res;
    }


    /* 查找数组 nums 中数字 1 所在索引 */
    static int findOne(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 当元素 1 在数组头部时, 达到最佳时间复杂度O(1)
            // 当元素 1 在数组尾部时, 达到最差时间复杂度O(n)
            if (nums[i] == 1) {
                return i;
            }
        }
        return -1;
    }
    /* Driver Code */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int n = 100;
            int[] nums = randomNumbers(n);
            int index = findOne(nums);
            System.out.println("\n 数组[ 1, 2, ..., n] 被打乱后 = " + Arrays.toString(nums));
            System.out.println("数字1的索引为" + index);
        }

    }

}
