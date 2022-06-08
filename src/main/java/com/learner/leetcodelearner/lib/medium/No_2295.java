package com.learner.leetcodelearner.lib.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/08 13:35
 **/
public class No_2295 {
//给你一个下标从 0 开始的数组 nums ，它包含 n 个 互不相同 的正整数。请你对这个数组执行 m 个操作，在第 i 个操作中，你需要将数字
//operations[i][0] 替换成 operations[i][1] 。
//
// 题目保证在第 i 个操作中：
//
//
// operations[i][0] 在 nums 中存在。
// operations[i][1] 在 nums 中不存在。
//
//
// 请你返回执行完所有操作后的数组。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,4,6], operations = [[1,3],[4,7],[6,1]]
//输出：[3,2,7,1]
//解释：我们对 nums 执行以下操作：
//- 将数字 1 替换为 3 。nums 变为 [3,2,4,6] 。
//- 将数字 4 替换为 7 。nums 变为 [3,2,7,6] 。
//- 将数字 6 替换为 1 。nums 变为 [3,2,7,1] 。
//返回最终数组 [3,2,7,1] 。
//
//
// 示例 2：
//
// 输入：nums = [1,2], operations = [[1,3],[2,1],[3,2]]
//输出：[2,1]
//解释：我们对 nums 执行以下操作：
//- 将数字 1 替换为 3 。nums 变为 [3,2] 。
//- 将数字 2 替换为 1 。nums 变为 [3,1] 。
//- 将数字 3 替换为 2 。nums 变为 [2,1] 。
//返回最终数组 [2,1] 。
//
//
//
//
// 提示：
//
//
// n == nums.length
// m == operations.length
// 1 <= n, m <= 10⁵
// nums 中所有数字 互不相同 。
// operations[i].length == 2
// 1 <= nums[i], operations[i][0], operations[i][1] <= 10⁶
// 在执行第 i 个操作时，operations[i][0] 在 nums 中存在。
// 在执行第 i 个操作时，operations[i][1] 在 nums 中不存在。
//
// Related Topics 数组 哈希表 模拟 👍 6 👎 0

    /**
     * 二元组 + 哈希表记录修改下标
     * @param nums
     * @param operations
     * @return
     */
    public int[] arrayChange(int[] nums, int[][] operations) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Pair> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], new Pair(nums[i],i));
        }
        for (int i = 0; i < operations.length; i++) {
            int[] operation = operations[i];
            int index = map.get(operation[0]).index;
            map.remove(operation[0]);
            map.put(operation[1], new Pair(operation[1],index));
        }
        int[] ans = new int[nums.length];
        for (Pair pair: map.values()) {
            ans[pair.index] = pair.num;
        }
        return ans;
    }
    class Pair {
        int num,index;
        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    /**
     * 哈希表记录修改下标
     * @param nums
     * @param operations
     * @return
     */
    public int[] arrayChange2(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 记录下标
            map.put(nums[i],i);
        }
        for (int[] operation : operations) {
            int index = map.get(operation[0]);
            // 置换数字
            nums[index] = operation[1];
            // 存储下标新值
            map.put(operation[1], index);
        }
        return nums;
    }


}
