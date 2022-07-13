package com.learner.leetcodelearner.lib.medium;

public class No_62 {
    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
//输入：m = 3, n = 7
//输出：28
//
// 示例 2：
//
//
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
//输入：m = 7, n = 3
//输出：28
//
//
// 示例 4：
//
//
//输入：m = 3, n = 3
//输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 10⁹
//
// Related Topics 数学 动态规划 组合数学 👍 1463 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            // 状态: 从[0][0] - > [m-1][n-1] f[i][j] 为对应位置的方法数
            int[][] f = new int[m][n];
            // f[0][0] = 1
            f[0][0] = 1;
            // 完整f二维数组
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 状态转移方程
                    if (i > 0 && j > 0) {
                        // 当前位置可以由俩位置抵达 所以到达该位置的方法数为俩前置位置方法数之和
                        f[i][j] = f[i - 1][j] + f[i][j - 1];
                    } else if (i > 0) {
                        //j = 0 的情况 当前位置与前置位置是一样的方法数
                        f[i][j] = f[i - 1][j];
                    } else if (j > 0) {
                        //i = 0 的情况 当前位置与前置位置是一样的方法数
                        f[i][j] = f[i][j - 1];
                    }
                }
            }
            // 返回答案
            return f[m - 1][n - 1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
