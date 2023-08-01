package com.learner.leetcodelearner.hello_algo.chapter_computational_complexity;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/8/1
 */
public class time_complexity {
    /* 常数阶 */
    static int constant(int n) {
        int count = 0;
        int size = 10000;
        for (int i = 0; i < size; i++) {
            count++;
        }
        return count;
    }
    /* 线性阶 */
    static int linear(int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            count++;
        return count;
    }


    /* 平方阶 */
    static int quadratic(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }
        return count;
    }

    /* 平方阶 (冒泡排序) */
    static int bubbleSort(int[] nums) {
        int count = 0; // 计数器
        // 外循环 : 未排序区间为[0, i]
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环: 将未排序区间[0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    count += 3; //元素交换包含3个单元操作
                }
            }
        }
        return count;
    }


    /* 指数阶 */
    static int exponential(int n) {
        int count = 0, base = 1;
        // cell 每一轮一分为二, 形成数列 1, 2, 4, 8, ... , 2^(n-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < base; j++) {
                count++;
            }
            base *= 2;
        }
        // count = 1 + 2 + 4 + 8 + ... + 2^(n-1) = 2^n - 1
        return count;
    }

    /* 指数阶 (递归实现) */
    static int expRecur(int n) {
        if (n == 1) return 1;
        return expRecur(n - 1) + expRecur(n - 1) + 1;
    }
}
