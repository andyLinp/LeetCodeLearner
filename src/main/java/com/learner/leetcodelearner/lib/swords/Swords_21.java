package com.learner.leetcodelearner.lib.swords;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/24 14:10
 **/
public class Swords_21 {
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
//
//
//
// 示例：
//
//
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 50000
// 0 <= nums[i] <= 10000
//
// Related Topics 数组 双指针 排序 👍 231 👎 0

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {  //   1 2 3 4 5 6 7 8
            int n = nums.length;
            int l = 0, r = n -1 ;
            while(l < r) {
                while(l < r && nums[l] % 2 != 0) {
                    l++;
                }
                while(l < r && nums[r] % 2 == 0) {
                    r--;
                }
                if (l < r) {
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                }
            }
            return nums;
        }

}
