package com.learner.leetcodelearner.lib.medium;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/08/04 10:31
 **/
public class No_2131 {
    //给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
//
// 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
//
// 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
//
// 回文串 指的是从前往后和从后往前读一样的字符串。
//
//
//
// 示例 1：
//
// 输入：words = ["lc","cl","gg"]
//输出：6
//解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
//"clgglc" 是另一个可以得到的最长回文串。
//
//
// 示例 2：
//
// 输入：words = ["ab","ty","yt","lc","cl","ab"]
//输出：8
//解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
//"lcyttycl" 是另一个可以得到的最长回文串。
//
//
// 示例 3：
//
// 输入：words = ["cc","ll","xx"]
//输出：2
//解释：最长回文串是 "cc" ，长度为 2 。
//"ll" 是另一个可以得到的最长回文串。"xx" 也是。
//
//
//
// 提示：
//
//
// 1 <= words.length <= 10⁵
// words[i].length == 2
// words[i] 仅包含小写英文字母。
//
//
// Related Topics 贪心 数组 哈希表 字符串 计数 👍 20 👎 0

    /**
     * 思路:
     * 把字符串转成二维数组,并且标记数量
     * 分类讨论存在回文字符串的情况
     *      当不是aa型字符串时, 最小的那个字符串的数量就是一半回文的长度
     *      当是aa型字符串时,就要考虑奇数和偶数的问题
     *              当是偶数时,可以形成回文,直接添加数量
     *              当是奇数时,就要考虑这里面有多少个奇数的字符串.奇数字符串只能取一个放到中间.
     * @param words
     * @return
     */
    public int longestPalindrome(String[] words) {
            int[][] one = new int[123][123];
            int n = words.length;
            for (int i = 0; i < n; ++i) {
                String str = words[i];
                char a = str.charAt(0);
                char b = str.charAt(1);
                one[a][b] += 1;
            }
            int ans = 0;
            boolean flag = false;
            for (int i = 0; i < n; ++i) {
                String str = words[i];
                char a = str.charAt(0);
                char b = str.charAt(1);
                if (one[b][a] < 1) {
                    continue;
                }
                if (a != b) {
                    ans += (Math.min(one[a][b],one[b][a]) << 1);
                } else if (a == b) {
                    int num = one[a][b];
                    if (num % 2 == 1) {
                        ans += ((num >> 1) << 1);
                        flag = true;
                    } else {
                        ans += num;
                    }
                }
                one[a][b] = 0;
                one[b][a] = 0;
            }
            return flag ? (1 + ans) * 2 : ans * 2;
        }

}
