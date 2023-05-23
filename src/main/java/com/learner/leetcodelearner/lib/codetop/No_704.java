package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/5/23
 */
public class No_704 {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid]  > target) {
                r = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
