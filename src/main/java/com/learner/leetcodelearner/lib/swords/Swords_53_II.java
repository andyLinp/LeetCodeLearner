package com.learner.leetcodelearner.lib.swords;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/06 10:30
 **/
public class Swords_53_II {

//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。
//
//
//
// 示例 1:
//
// 输入: [0,1,3]
//输出: 2
//
//
// 示例 2:
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 10000
// Related Topics 位运算 数组 哈希表 数学 二分查找
    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        // 左指针小于等于右指针
        while(i <= j) {
            // 二分查找获取中间值
            int m = (i + j) / 2;
            // 数组中对应位置值等于索引值时 左指针右移(说明对应位置值是存在的)
            if(nums[m] == m) i = m + 1;
            // 数组中对应位置值不等于索引值时 右指针左移(说明丢失的值在左边区间)
            else j = m - 1;
        }
        // 左边界值即为缺失值
        return i;
    }
}
