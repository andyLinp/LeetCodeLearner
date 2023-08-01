package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/7/19
 */
public class No_322 {
    int res = Integer.MAX_VALUE;
    // 递归
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        findway(coins, amount, 0);
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public void findway(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        // 正好凑齐时 记录个数
        if (amount == 0) {
            res = Math.min(res, count);
        }
        // 遍历枚举
        for (int i = 0; i < coins.length; i++) {
            findway(coins, amount - coins[i], count + 1);
        }
    }




    // solution 2
    int[] memo;
    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        memo = new int[amount];
        return findWay(coins, amount);
    }

    public int findWay(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res +1;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }


    // solution 3
    public int coinChangeDp(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }
        // memo[n] 的值 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        memo[0]  = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                // 金额未凑满 且 凑成剩余金额所需硬币数 小于 最小值 继续记录(大于最小值时 没必要再去选取)
                if (i - coins[j] >= 0 && memo[i-coins[j]] < min) {
                    min = memo[i - coins[j]] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}
