package com.learner.leetcodelearner.lib.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/10/27 16:41
 **/
public class No_934 {
//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
//
// 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
//
//
//
// 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
//
//
//
// 返回必须翻转的 0 的最小数目。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,1],[1,0]]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
//
//
// 示例 3：
//
//
//输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
//
//
//
//
// 提示：
//
//
// n == grid.length == grid[i].length
// 2 <= n <= 100
// grid[i][j] 为 0 或 1
// grid 中恰有两个岛
//
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 340 👎 0


    private int[] dirs = {-1, 0, 1, 0, -1};
    private Deque<int[]> q = new ArrayDeque<>();
    private int[][] grid;
    private int n;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        // 通过dfs搜索第一个岛屿 找到后退出(通过x == 1 来控制退出寻找)
        for (int i = 0, x = 1; i < n && x == 1; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    x = 0;
                    break;
                }
            }
        }
        // ans 为岛屿1到岛屿2 圈层数(即岛屿1到岛屿2最近距离)
        int ans = 0;
        while (true) {
            for (int i = q.size(); i > 0; --i) {
                // 从岛屿最开始的点向外展开
                int[] p = q.pollFirst();
                for (int k = 0; k < 4; ++k) {
                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        // 向外扩展的过程中接触到了岛屿2 此时ans(即向外扩展的层级)就是最短距离
                        if (grid[x][y] == 1) {
                            return ans;
                        }
                        // 向外扩展的过程中接触到海 标记并收入队列中
                        if (grid[x][y] == 0) {
                            grid[x][y] = 2;
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
            ans++;
        }
    }

    private void dfs(int i, int j) {
        // 搜索时属于岛屿1的点做记号 标记为2 并将该地点加入队列
        grid[i][j] = 2;
        q.offer(new int[]{i, j});
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(x, y);
            }
        }
    }

}
