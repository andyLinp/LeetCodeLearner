package com.learner.leetcodelearner.lib.codetop;

public class No_5 {
    /**
     * 中心扩散法
     * 注意回文串长度可能是单数、偶数
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (null == s || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 回文字符串为单数长度
            int len1 = expandByCenter(s, i, i);
            // 回文字符串为偶数长度
            int len2 = expandByCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // 考虑回文串为就数 对应的len长度不一样
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end +1);
    }

    private int expandByCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && L < R && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        // R/L为回文串边界（） 长度为 R - L + 1 - 2;
        return R - L - 1;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindromeDp(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                // 头疼 健身房健身房
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }




}
