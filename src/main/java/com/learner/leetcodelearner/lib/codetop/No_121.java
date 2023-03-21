package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/21 10:46
 **/
public class No_121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 1) return 0;
        int profit = 0, min = prices[0];
        // 只能操作一次 所以最大利润即最大差值
        // 求最大差值时 存在一个逻辑: 从0开始遍历时,寻找当前最小值,求出当前下标与当前最小值的差值再与全局最大差值对比,寻找最大差值
        // 当前下标最小值与当前下标差值即当前下标对应差值, 当前下标对应差值与全局最大差值对比即为当前全局最大差值
        for (int i = 0; i < len; ++i) {
            if (min >= prices[i]) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }

    /**
     * 差分数组
     * 思路: 利润本就是后置位减去前置位的差值 将价格数组转换成差值数组
     * 利润低于0的视为0
     * 第一天的利润视为0
     * @param prices
     * @return
     */
    public int maxProfixArr(int[] prices) {
        int len = prices.length;
        int[] minusArr = new int[len];
        minusArr[0] = prices[0];
        // [7,1,5,3,6,4]
        // [7,-6,4,-2,3,-2]
        // [0,0,4,2,5,3]
        for (int i = 1; i < len; ++i) {
             minusArr[i] = prices[i] - prices[i-1];
        }
        // profit 当前卖出利润(当天是操作的)
        // max 最大利润
        int profit = 0, max = 0;
        // 此处从1开始遍历! 防止错将第一天的股票价格当成利润
        for (int i = 1; i < len; ++i) {
            profit += minusArr[i];
            if (profit < 0) {
                profit = 0;
            }
            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }
}
