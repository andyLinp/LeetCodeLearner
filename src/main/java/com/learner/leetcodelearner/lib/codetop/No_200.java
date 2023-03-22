package com.learner.leetcodelearner.lib.codetop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/22 14:04
 **/
public class No_200 {
    /**
     * 深度优先搜索,做了好几次了还是拿到手没思路
     * 想了想应该是对dfs的过程中要做什么事情没有思路
     * 此题从原点开始遍历,如果归属于该点的岛屿,用dfs标记为0   ==> 同时count记录该岛屿 + 1  即一个岛屿最后只用一个'1'标记
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || grid[i][j] == '0' || i >= grid.length || j >= grid[0].length) {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 广度优先算法
     * 借助队列来遍历
     * @param grid
     * @param i
     * @param j
     */
    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        if (grid[i][j] == '1' && i > 0 && j > 0 && i < grid.length && j < grid[0].length) {
            queue.add(new int[]{i, j});
        }
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            i = current[0];
            j = current[1];
            if (i < 0 || j < 0 || grid[i][j] == '0' || i > grid.length || j > grid[0].length) {
                continue;
            }
            grid[i][j] = '0';
            queue.add(new int[]{i+1,j});
            queue.add(new int[]{i-1,j});
            queue.add(new int[]{i,j-1});
            queue.add(new int[]{i,j+1});
        }
    }


}
