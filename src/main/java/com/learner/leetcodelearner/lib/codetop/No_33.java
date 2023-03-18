package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/13 10:42
 **/
public class No_33 {
    /**
     * 二分查找
     * 经过旋转的数组，显然前半段满足 >= nums[0]，而后半段不满足 >= nums[0]，以此作为依据通过二分找到旋转点。
     * 找到旋转点之后，再通过比较 target 和 nums[0] 的大小，确定 target 落在旋转点的左边还是右边。
     * 三叶说: 二分原理是两段性, 存在一个条件使数组中存在着边界
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if (target >= nums[0]) {
            left = 0;
        } else {
            left = left + 1;
            right = nums.length -1;
        }
        while (left < right) {
            int mid = left + right >>1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
