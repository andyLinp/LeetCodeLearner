package com.learner.leetcodelearner.lib;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/09/01 15:31
 **/
public class Draft {
    public static void main(String[] args) {

    }


}

class Solution2 {
    int[][] grid, coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 上、下、右、左四个方向
    Deque<int[]> edges; // 用户存储边缘格子

    public int shortestBridge(int[][] grid) {
        int result = 0;
        boolean findIsland = false; // 只要找到2个岛屿中其中的1个岛屿，就将其设置为true，并结束步骤1中的两层for循环
        edges = new ArrayDeque();
        this.grid = grid;
        /** 步骤1：为其中一个岛屿打标记（val=2），并保存”边界格子“到edges中 */
        for (int i = 0; !findIsland && i < grid.length; i++)
            for (int j = 0; !findIsland && j < grid[0].length; j++)
                if (findIsland = (grid[i][j] == 1)) markIsland(i, j);

        /** 步骤2：利用边界edges，一层一层扩展岛屿（val=2），直到遇到另一个岛屿（val=1）*/
        while (!edges.isEmpty()) {
            result++; // 扩展层数
            int x = 0, y = 0, num = edges.size();
            for (int i = 0; i < num; i++) {
                int[] edge = edges.removeFirst();
                for (int[] c : coordinates) { // 向edge的四个方向查看格子编号，并扩展岛屿边界
                    int nex = edge[0] + c[0], ney = edge[1] + c[1];
                    if (isLegal(nex, ney) && grid[nex][ney] == 0) {
                        edges.addLast(new int[]{nex, ney}); // 添加新的边界
                        grid[nex][ney] = 2;
                    } else if (isLegal(nex, ney) && grid[nex][ney] == 1) return result; // 与另一个岛屿相遇，则直接返回result
                }
            }
        }
        return result;
    }

    public void markIsland(int row, int column) {
        if (!isLegal(row, column) || grid[row][column] == 2) return;
        if (grid[row][column] == 0) {
            grid[row][column] = 2; // 将边界向外扩展1层岛屿（val=2)
            edges.addLast(new int[]{row, column});
            return;
        }
        grid[row][column] = 2; // 为岛屿打标记（val=2）
        for (int[] c : coordinates) markIsland(row + c[0], column + c[1]); // 深度遍历某个格子的四个方向
    }

    public boolean isLegal(int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
}

class Solution {
    private int[] dirs = {-1, 0, 1, 0, -1};
    private Deque<int[]> q = new ArrayDeque<>();
    private int[][] grid;
    private int n;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        for (int i = 0, x = 1; i < n && x == 1; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    x = 0;
                    break;
                }
            }
        }
        int ans = 0;
        while (true) {
            for (int i = q.size(); i > 0; --i) {
                int[] p = q.pollFirst();
                for (int k = 0; k < 4; ++k) {
                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (grid[x][y] == 1) {
                            return ans;
                        }
                        if (grid[x][y] == 0) {
                            grid[x][y] = 2;
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
            ++ans;
        }
    }

    private void dfs(int i, int j) {
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

class Solution3 {
    private int[] dirs = {-1, 0, 1, 0, -1};
    private Deque<int[]> q = new ArrayDeque<>();
    private int[][] grid;
    private int n;


    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        // 通过dfs搜索到第一个岛屿 找到后退出 通过x控制外层循环退出
        for (int i = 0, x = 1; i < n && x == 1; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    x = 0;
                    break;
                }
            }
        }
        // 找到岛屿后 要计算到达第二岛屿的距离
        int ans = 0;
        while (true) {
            for (int i = q.size(); i > 0; --i) {
                int[] p = q.pollFirst();
                for (int k = 0; k < 4; ++k) {
                    int x = p[0] + dirs[k], y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (grid[x][y] == 1) {
                            return ans;
                        }
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
        grid[i][j] = 2;
        q.offer(new int[]{i, j});
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}
