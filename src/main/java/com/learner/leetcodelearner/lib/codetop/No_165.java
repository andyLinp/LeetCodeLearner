package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/7/5
 */
public class No_165 {
    /**
     * 执行耗时:1 ms,击败了70.62% 的Java用户
     * 内存消耗:39.6 MB,击败了48.70% 的Java用户
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        if (versions1.length < versions2.length) {
            return -compareVersion(version2, version1);
        }

        for (int i = 0; i < versions1.length; i++) {
            String v1 = versions1[i];
            String v2 = null;
            if (i < versions2.length) {
                v2 = versions2[i];
            } else {
                v2 = "0";
            }
            if (Integer.valueOf(v1).equals(Integer.valueOf(v2))) {
                continue;
            } else if (Integer.valueOf(v1) > Integer.valueOf(v2)) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了64.24% 的Java用户
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersionWithoutSpilt(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        for (int i = 0, j = 0; i < m || j < n; i++, j++) {
            int a = 0, b = 0;
            while (i < m && version1.charAt(i) != '.')
                a = 10 * a + (version1.charAt(i++) - '0');
            while (j < n && version2.charAt(j) != '.')
                b = 10 * b + (version2.charAt(j++) - '0');
            if (a < b)
                return -1;
            else if (a > b)
                return 1;
        }
        return 0;
    }

}
