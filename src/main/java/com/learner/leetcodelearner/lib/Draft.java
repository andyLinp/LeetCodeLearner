package com.learner.leetcodelearner.lib;




import java.util.*;


/**
 * @Description
 * @Author andy lin
 * @Date: 2022/09/01 15:31
 **/
public class Draft {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static LinkedList<String> threadList = new LinkedList<>();

    Map<Character, Integer> current = new HashMap<>();
    Map<Character, Integer> standard = new HashMap<>();
    public static void main(String[] args) {

    }




    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) return "";
        for (int i = 0; i < tLen; i++) {
            standard.put(t.charAt(i), standard.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = -1;
        // 用于存最小长度  最小长度起始坐标 最小长度终止坐标
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (r < sLen) {
            r++;
            if (r < sLen && standard.containsKey(s.charAt(r))) {
                // 向右扩展滑动窗口时遇到需要记录的值时记录
                current.put(s.charAt(r), current.getOrDefault(s.charAt(r), 0) + 1);
            }
            // 每向右扩展滑动窗口之后 判断一下当前滑动窗口是否已经包含了标准的所有值 如果是 尝试从左端缩小窗口
            while (check() && l <= r) {
                // 判断当前长度是小于暂存 是的话记录当前窗口状态
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = r + 1;
                }
                // 看移动左边界时是否触及统计值 若触及则减去统计值
                if (standard.containsKey(s.charAt(l))) {
                    current.put(s.charAt(l), current.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check(){
        Set<Map.Entry<Character, Integer>> entries = standard.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (current.getOrDefault(key,0) < value) {
                return false;
            }
        }
        return true;
    }

}


