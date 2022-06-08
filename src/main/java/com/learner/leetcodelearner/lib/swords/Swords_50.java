package com.learner.leetcodelearner.lib.swords;

import java.util.*;

public class Swords_50 {
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例 1:
//
//
//输入：s = "abaccdeff"
//输出：'b'
//
//
// 示例 2:
//
//
//输入：s = ""
//输出：' '
//
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 50000
// Related Topics 队列 哈希表 字符串 计数 👍 236 👎 0



    // 队列 + Map
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>((int)((float)s.length()/0.75F + 1F));
        Deque<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
                queue.offer(ch);
            } else {
                map.put(ch, -1);
                // 队列不为空 且 队头的元素为重复的ch 弹出队头
                while (!queue.isEmpty() && map.get(queue.peek()) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? ' ' : queue.poll();
    }
    // 哈希表两次遍历
    public char firstUniqChar2(String s) {
        int[] counts = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (counts[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
