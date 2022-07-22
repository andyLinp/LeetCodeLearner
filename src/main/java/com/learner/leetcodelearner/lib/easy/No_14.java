package com.learner.leetcodelearner.lib.easy;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/07/22 15:01
 **/
public class No_14 {
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
//
// Related Topics 字符串 👍 2352 👎 0

    /**
     * 思路 : 认定最长公共前缀 肯定是字符串数组长度最小的字符串
     * 任意取一个字符串 当作 最长公共前缀
     * 最长公共前缀作为条件 与所有字符串数组中字符串比对 若不满足则最长公共前缀长度减一
     * 直到遍历完所有字符串
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String str : strs) {
            while(!str.startsWith(s)) {
                if (s.length() == 0) return "";
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    /**
     * 纵向比较
     * 从每个子串的第0位开始向高位比较
     * 任一子串不符合条件终止向高位进发
     * 返回当前深度字符串
     * @param strs
     * @return
     */
    public  String longestCommonPrefixVertical(String[] strs) {
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; ++j) {
                // 纵向比较过程中 当前i长度等于子串长度时,直接获取短的子串长度作为标准比较子串
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    //  子串对应深度不等于标准串字符时 不能再深入
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
