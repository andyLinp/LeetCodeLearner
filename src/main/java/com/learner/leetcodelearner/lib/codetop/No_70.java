package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/7
 */
public class No_70 {
    public int climbStairs(int n) {
        if (n <= 3) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < n; i++) {
            // 因为每次爬楼梯是一阶或者两阶 所以到达目标台阶前一阶或两阶的走法之和为到达目标台阶的走法之和
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
