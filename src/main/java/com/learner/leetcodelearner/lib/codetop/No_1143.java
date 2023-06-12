package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/12
 */
public class No_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // 初始化dp数组
        int[][] dp = new int[text1.length() + 1][text2.length() +1];
        // 默认为0 和空串的最长公共子序列的自然为0
        for (int i = 1; i <= text1.length(); i++) {
            // string 类型变成char类型
            char char1 = text1.charAt(i-1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);

                // 相同的情况
                if (char1 == char2) {
                    // 开始列出状态转移方程
                    dp[i][j] = dp[i-1][j-1] + 1;
                    // 不同的情况 看看谁的最长公共子序列最大
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


}
