package com.learner.leetcodelearner.lib.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/04/19 13:43
 **/
public class No_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0, i = 0, j = 0;
        for (int c = 0; c < m * n; ++c) {
            order.add(matrix[i][j]);
            // 标记已经遍历过
            matrix[i][j] = 101;
            int nI = i + directions[index][0];
            int nJ = j + directions[index][1];
            if (nI < 0 || nI >= m || nJ < 0 || nJ >= n ||matrix[nI][nJ] == 101) {
                index = (index + 1) % 4;
            }
            i += directions[index][0];
            j += directions[index][1];
        }
        return order;
    }
}
