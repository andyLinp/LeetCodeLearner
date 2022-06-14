package com.learner.leetcodelearner.lib.swords;

import java.util.Arrays;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/14 15:52
 **/
public class Swords_63 {
    //假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
//
//
//
// 示例 1:
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
//
//
// 示例 2:
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 10^5
//
//
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
//stock/
// Related Topics 数组 动态规划 👍 257 👎 0

    /**
     * 暴力
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] dp = new int[prices.length];
        for (int i = 0; i < dp.length; i++) {
            int cur = prices[i];
            dp[i] = 0;
            for (int j = i + 1; j < dp.length; j++) {
                int next = prices[j];
                if (next - cur > dp[i]) {
                    dp[i] = next - cur;
                }
            }
        }
        Arrays.sort(dp);
        return dp[prices.length - 1];
    }

    /**
     * 一次遍历
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int min = prices[0], res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                res = Math.max(res, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return res;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
