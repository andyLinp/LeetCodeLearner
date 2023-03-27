package com.learner.leetcodelearner.lib.medium;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/27 10:50
 **/
public class No_1638 {
    /**
     * dp
     * @param s
     * @param t
     * @return
     */
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dpl = new int[m + 1][n + 1];
        int[][] dpr = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpl[i][j] + 1) : 0;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dpr[i][j] = s.charAt(i) == t.charAt(j) ? (dpr[i + 1][j + 1] + 1) : 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    ans += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 暴力
     * @param s
     * @param t
     * @return
     */
    public int countSubstringsSimple(String s, String t) {
        int m = s.length(), n = t.length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = 0;
                for (int k = 0; i + k < m && j + k < n; k++) {
                    diff += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    if (diff > 1) {
                        break;
                    } else if (diff == 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
