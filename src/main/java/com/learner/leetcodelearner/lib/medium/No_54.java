package com.learner.leetcodelearner.lib.medium;

import java.util.ArrayList;
import java.util.List;

public class No_54 {
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟 👍 1149 👎 0


    /**
     * 模拟
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int m = matrix.length, n = matrix[0].length;
            boolean [][] visited = new boolean[m][n];
            int i = 0, j = 0;
            // left down right up
            int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
            int directionIndex = 0;
            for (int x = 0; x < m * n;++x) {
                order.add(matrix[i][j]);
                visited[i][j] = true;
                int nextI = i + directions[directionIndex][0], nextJ = j + directions[directionIndex][1];
                if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n || visited[nextI][nextJ]){
                    // 需要改变方向 即取+1坐标的directions值
                    directionIndex = (directionIndex + 1) % 4;
                }
                i += directions[directionIndex][0];
                j += directions[directionIndex][1];
            }
            return order;
        }

    /**
     * 削头旋转
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrderCutHead(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            while (matrix.length >= 1) {
                for (int num : matrix[0]) {
                    res.add(num);
                }
                matrix = reversalArr(matrix);
            }
            return res;
        }

        private int[][] reversalArr(int[][] matrix) {
            int m = matrix[0].length;
            int n = matrix.length - 1;
            int[][] reArr = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    reArr[i][j] = matrix[j + 1][m - i - 1];
                }
            }
            return reArr;
        }

}
