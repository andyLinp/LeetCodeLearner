package com.learner.leetcodelearner.lib.codetop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/7/13
 */
public class No_76 {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while(r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }

                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
    public boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }


    /**
     *  官方题解
     *  执行耗时:2 ms,击败了98.12% 的Java用户
     * 	内存消耗:42.8 MB,击败了53.79% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public String minWindowTop(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        // 维护两个数组 记录已有字符串指定字符的出现次数 和目标字符串指定字符的出现次数
        // ASCII表总长128
        int[] need = new int[128];
        int[] have = new int[128];

        // 将目标字符串指定字符的出现次数记录
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        // 分别为左指针, 右指针, 最小长度(初始值为一定不可能达到的长度)
        // 已有字符串中目标字符串指定字符的出现总次数以及最小覆盖子串在原字符串中的起始位置
        int left = 0, right = 0, min = s.length() + 1, count = 0, start = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            // 说明该字符不被目标字符串需要, 此时有两种情况
            // 1.循环刚开始, 那么直接移动右指针即可, 不需要多余判断
            // 2.循环已经开始一段时间, 此处又有两种情况
            //  2.1 上一次条件不满足, 已有字符串指定字符出现次数不满足目标字符串指定字符出现次数, 那么此时如果该字符还不被目标字符串需要, 就不需要进行多余判断,右指针移动即可
            //  2.2 左指针已经移动完毕, 那么此时就相当于循环刚开始, 同理直接移动右指针
            if (need[r] == 0) {
                right++;
                continue;
            }
            // 当且仅当已有字符串目标字符出现此时小于目标字符串字符的出现此时时, count才会+1
            // 是为了后续能直接判断已有字符串是否已经包含了目标字符串的所有字符, 不需要挨个比对字符出现的次数
            if (have[r] < need[r]) {
                count++;
            }
            // 已有字符串中目标字符出现的次数++
            have[r]++;
            // 移动右指针
            right++;
            // 当且仅当已有字符串已经包含了所有目标字符串的字符, 且出现频次一定大于或等于指定频次
            while (count == t.length()) {
                // 当窗口的长度已经比已有的最短值小, 更改最小值, 并记录起始位置
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                // 如果左边即将要去掉的字符不被目标字符串需要,那么不需要多余的判断,直接左移
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                // 如果左边即将要失去的字符被目标字符需要, 且出现的频次正好等于指定频次, 那么如果去掉了这个字符,就不满足覆盖子串的条件,此时要破坏循环条件跳出循环,即控制目标字符串指定字符出现的总频次(count) - 1
                if (have[l] == need[l]) {
                    count--;
                }
                // 已有字符串中目标字符出现的次数 -1
                have[l]--;
                // 移动左指针
                left++;
            }
        }
        // 如果最小长度还未初始值 , 说明没有符合条件的子串
        if (min == s.length() + 1) {
            return "";
        }
        // 返回的为以记录的起始位置为起点,记录的最短长度为距离的指定字符串中截取的子串
        return s.substring(start, start + min);
    }

}
