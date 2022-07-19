package com.learner.leetcodelearner.lib.game;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/07/19 10:41
 **/
public class No_302 {
}
class Solution_2342{
//给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与
//nums[j] 的数位和相等。
//
// 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
//
//
//
// 示例 1：
//
//
//输入：nums = [18,43,36,13,7]
//输出：54
//解释：满足条件的数对 (i, j) 为：
//- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
//- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
//所以可以获得的最大和是 54 。
//
// 示例 2：
//
//
//输入：nums = [10,12,19,14]
//输出：-1
//解释：不存在满足条件的数对，返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
//
// Related Topics 数组 哈希表 排序 堆（优先队列） 👍 5 👎 0
    public int maximumSum(int[] nums) {
       // 维护哈希表 哈希表键为 数位和 值为当前数  遍历过程中维护数位和相等两数和的最大值
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = get(num);
            if (map.containsKey(val)) {
                max = Math.max(max, map.get(val) + num);
            }
            map.put(val, num);
        }
        return max;
    }

    /**
     * 获取位数和
     * @param num
     * @return
     */
    public int get(int num) {
        int s = 0;
        while(num > 0) {
            s += num % 10;
            num = num / 10;
        }
        return s;
    }


}






class Solution_2343 {
//给你一个下标从 0 开始的字符串数组 nums ，其中每个字符串 长度相等 且只包含数字。
//
// 再给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [ki, trimi] 。对于每个 queries[i] ，你
//需要：
//
//
// 将 nums 中每个数字 裁剪 到剩下 最右边 trimi 个数位。
// 在裁剪过后的数字中，找到 nums 中第 ki 小数字对应的 下标 。如果两个裁剪后数字一样大，那么下标 更小 的数字视为更小的数字。
// 将 nums 中每个数字恢复到原本字符串。
//
//
// 请你返回一个长度与 queries 相等的数组 answer，其中 answer[i]是第 i 次查询的结果。
//
// 提示：
//
//
// 裁剪到剩下 x 个数位的意思是不断删除最左边的数位，直到剩下 x 个数位。
// nums 中的字符串可能会有前导 0 。
//
//
//
//
// 示例 1：
//
//
//输入：nums = ["102","473","251","814"], queries = [[1,1],[2,3],[4,2],[1,2]]
//输出：[2,2,1,0]
//解释：
//1. 裁剪到只剩 1 个数位后，nums = ["2","3","1","4"] 。最小的数字是 1 ，下标为 2 。
//2. 裁剪到剩 3 个数位后，nums 没有变化。第 2 小的数字是 251 ，下标为 2 。
//3. 裁剪到剩 2 个数位后，nums = ["02","73","51","14"] 。第 4 小的数字是 73 ，下标为 1 。
//4. 裁剪到剩 2 个数位后，最小数字是 2 ，下标为 0 。
//   注意，裁剪后数字 "02" 值为 2 。
//
//
// 示例 2：
//
//
//输入：nums = ["24","37","96","04"], queries = [[2,1],[2,2]]
//输出：[3,0]
//解释：
//1. 裁剪到剩 1 个数位，nums = ["4","7","6","4"] 。第 2 小的数字是 4 ，下标为 3 。
//   有两个 4 ，下标为 0 的 4 视为小于下标为 3 的 4 。
//2. 裁剪到剩 2 个数位，nums 不变。第二小的数字是 24 ，下标为 0 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i].length <= 100
// nums[i] 只包含数字。
// 所有 nums[i].length 的长度 相同 。
// 1 <= queries.length <= 100
// queries[i].length == 2
// 1 <= ki <= nums.length
// 1 <= trimi <= nums[0].length
//
// Related Topics 数组 字符串 分治 快速选择 基数排序 排序 堆（优先队列） 👍 7 👎 0
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int m = nums[0].length();
        for (int p = 0; p < queries.length; p++) {
            int[] q = queries[p];
            List<Integer> idx = new ArrayList<>(Arrays.asList(IntStream.range(0, nums.length).boxed().toArray(Integer[]::new)));
            Collections.sort(idx, Comparator.comparing(i -> nums[i].substring(m - q[1]))); // 稳定排序
            ans[p] = idx.get(q[0] - 1);
        }
        return ans;
    }
}
