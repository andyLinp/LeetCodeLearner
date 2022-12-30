package com.learner.leetcodelearner.lib.codetop;

import java.util.HashMap;


/**
 * @Description
 * @Author andy lin
 * @Date: 2022/12/30 10:51
 **/
public class No_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        // 存 字符 : 坐标
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 重复字符 更新左指针位置
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 存入新位置
            map.put(s.charAt(i), i);
            // 计算长度
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
