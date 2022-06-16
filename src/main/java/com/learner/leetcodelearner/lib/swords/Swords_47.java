package com.learner.leetcodelearner.lib.swords;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/16 16:11
 **/
public class Swords_47 {
//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//
//
//
// 示例 1:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//
//
//
// 提示：
//
//
// 0 < grid.length <= 200
// 0 < grid[0].length <= 200
//
// Related Topics 数组 动态规划 矩阵 👍 301 👎 0

    /**
     * 优化边界方法
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        // dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }

    /**
     * f[i][j] 为grid[0][0] 到 grid[i][j] 礼物价值最大和
     * 传统方法
     * @param grid
     * @return
     */
    public int maxValue2(int[][] grid) {
         int m = grid.length, n = grid[0].length;
         int[][] f = new int[m][n];
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if(i == 0 && j == 0) {
                     f[i][j] = grid[i][j];
                 } else if(i > 0  && j > 0) {
                     f[i][j] = grid[i][j] + Math.max(f[i][j - 1],f[i - 1][j]);
                 } else if(i > 0) {
                     f[i][j] = grid[i][j] + f[i - 1][j];
                 } else if(j > 0) {
                     f[i][j] = grid[i][j] + f[i][j - 1];
                 }
             }
         }
         return f[m - 1][n - 1];
    }

}
