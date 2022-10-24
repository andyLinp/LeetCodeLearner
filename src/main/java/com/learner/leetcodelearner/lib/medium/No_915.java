package com.learner.leetcodelearner.lib.medium;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/10/24 15:37
 **/
public class No_915 {
    //给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
//
//
// left 中的每个元素都小于或等于 right 中的每个元素。
// left 和 right 都是非空的。
// left 的长度要尽可能小。
//
//
// 在完成这样的分组后返回 left 的 长度 。
//
// 用例可以保证存在这样的划分方法。
//
//
//
// 示例 1：
//
//
//输入：nums = [5,0,3,8,6]
//输出：3
//解释：left = [5,0,3]，right = [8,6]
//
//
// 示例 2：
//
//
//输入：nums = [1,1,1,0,6,12]
//输出：4
//解释：left = [1,1,1,0]，right = [6,12]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁶
// 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。
//
//
// Related Topics 数组 👍 170 👎 0

    /**
     * 二次遍历
     * 第一次从后往前获取当前位置right中的最小值
     * 第二层从前往后获取当前位置left中的最大值,同时比较满足left中的最大值小于等于right中最小值时,返回left长度
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] min = new int[n + 10];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) min[i] = Math.min(min[i + 1], nums[i]);
        for (int i = 0, max = 0; i < n -1; i++) {
            max = Math.max(max, nums[i]);
            if (max <= min[i + 1]) return i + 1;
        }
        return -1; // never
    }


    /**
     * 一次遍历
     * 定义一个缓存最大值: 从前往后遍历的过程中,可能出现比max大的值,该值定义为tmpMax
     * 每当遍历的值比left中的最大值max小,说明该值应出于left中,此时可以刷新left中的最大值 max = tmpMax  且切割点下标更新 split = i
     * @param nums
     * @return
     */
    public int partitionDisjointOnce(int[] nums) {
        int n = nums.length, max = nums[0], tmpMax = nums[0], split = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= max) {
                tmpMax = Math.max(tmpMax, nums[i]);
            } else {
                split = i;
                max = tmpMax;
            }
        }
        return split + 1;
    }

}
