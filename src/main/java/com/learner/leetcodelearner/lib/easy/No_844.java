package com.learner.leetcodelearner.lib.easy;

import java.util.Deque;
import java.util.LinkedList;

public class No_844 {
//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
//
// 注意：如果对空文本输入退格字符，文本继续为空。
//
//
//
// 示例 1：
//
//
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
//
//
// 示例 2：
//
//
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
//
//
// 示例 3：
//
//
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 200
// s 和 t 只含有小写字母以及字符 '#'
//
//
//
//
// 进阶：
//
//
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
//
// Related Topics 栈 双指针 字符串 模拟 👍 462 👎 0



    /**
     * 栈模拟字符串输入及#退格过程
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack = new LinkedList<>();
        Deque<Character> stackB = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != '#') {
                stack.offer(s.charAt(i));
            } else {
                if(stack.isEmpty()){
                    continue;
                } else {
                    stack.pollLast();
                }
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            if (t.charAt(i) != '#') {
                stackB.offer(t.charAt(i));
            } else {
                if(stackB.isEmpty()){
                    continue;
                } else {
                    stackB.pollLast();
                }
            }
        }
        if (stack.size() == stackB.size()) {
            for(int i = 0 ; i < stack.size();++i) {
                if (stack.poll() != stackB.poll()){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 双指针 反向移动
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompareTwoPoints(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while(i >= 0 || j >= 0) {
            while(i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while(j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    i--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                //一个已经到头了
                if (i >=0 || j >= 0) {
                   return false;
                }
            }
            // 比较完 指针还能移动
            i--;
            j--;
        }
        return true;
    }
}
