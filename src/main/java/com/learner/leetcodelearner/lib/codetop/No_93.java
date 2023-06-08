package com.learner.leetcodelearner.lib.codetop;

import java.util.*;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/8
 */
public class No_93 {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        // 如果长度不够直接返回
        if (len < 4 || len > 12) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        dfs(s, len, splitTimes, 0, path, res);
        return res;

    }

    private void dfs(String s, int len, int splitTimes, int begin, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (splitTimes == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        if (len - begin < (4 - splitTimes) || len - begin > 3 * (4 - splitTimes)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }
            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {
                path.addLast(ipSegment + "");
                dfs(s, len, splitTimes + 1, begin + i + 1, path, res);
                path.removeLast();
            }
        }
    }

    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        int res = 0;

        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }



}

class Solution {
    List<String> result = new ArrayList<>();
    LinkedList list = new LinkedList();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return result;
        }
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
        if (list.size() == 4 && startIndex >= s.length()) {
            result.add(String.join(".", list));
            return;
        }

        if (list.size() == 4 && startIndex < s.length()) {
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i + 1);
            if (str.length() > 1 && str.startsWith("0")) {
                break;
            }
            int strInt = Integer.valueOf(str);
            if (strInt > 255) {
                break;
            }
            // 只手机有效的ip数字
            list.add(str);
            // 继续往下层递归
            backtracking(s, i + 1);
            // 下层路不同, 撤回来上层换条路走
            list.removeLast();
        }
    }
}
