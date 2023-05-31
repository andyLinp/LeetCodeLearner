package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/5/24
 */
public class No_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mix = new int[nums1.length + nums2.length];
        int index = 0;
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mix[index] = nums1[i];
                i++;
                index++;
            } else {
                mix[index] = nums2[j];
                j++;
                index++;
            }
        }

        while(i < nums1.length) {
            mix[index] = nums1[i];
            i++;
            index++;
        }

        while(j < nums2.length) {
            mix[index] = nums2[j];
            j++;
            index++;
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            return mix[((nums1.length + nums2.length) / 2)];
        } else {
            // 1 2 3 4    mix[1] + mix[2] / 2
            return (double)(mix[(nums1.length + nums2.length) / 2 - 1] + mix[(nums1.length + nums2.length) / 2])/2;
        }
    }

    /**
     * 直接找出对应位置 比较绕 但是快
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len/2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    /**
     * 二分法
     * 考虑总长为奇数/偶数两种情况
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int t = nums1.length + nums2.length; // 总长度
        if (t % 2 == 0) {
            // 总长度为偶数 中位数为两个数的平均数
            return (f(nums1, 0, nums2, 0, t / 2) + f(nums1, 0, nums2, 0, t/2 + 1)) / 2.0;
        } else {
            // 中位数为中间那个数
            return f(nums1, 0, nums2, 0, t/2 + 1);
        }
    }

    /**
     *
     * @param nums1 数组1
     * @param i 数组1中下标
     * @param nums2 数组2
     * @param j 数组2中下标
     * @param k 目标位置
     * @return 中位数
     */
    public int f(int[]nums1, int i, int[] nums2, int j, int k) {
        if (nums1.length - i > nums2.length - j) {
            // 使得剩余长度小的放在nums1;如果nums1的剩余长度大于nums2,则交换位置
            return f(nums2, j, nums1, i, k);
        }
        if (nums1.length == i) {
            // nums1已经全部遍历完,那么中位数肯定在nums2的第j+k-1个
            return nums2[j+k-1];
        }
        if (k == 1) {
            // 如果k等于1,就代表是第一个数,那么直接返回两个数组中较小的那个数
            return Math.min(nums1[i], nums2[j]);
        }
        // 取nums1第剩余区间的中间那个数
        int si = Math.min(i+k/2, nums1.length);
        // 取nums2剩余区间中间那个数
        int sj = j + k / 2;
        if (nums1[si-1] > nums2[sj - 1]) {
            // 代表可以排除nums2中sj左半边的数
            return f(nums1, i, nums2, sj, k - k/2);
        } else {
            // 排除nums1左半边的数
            return f(nums1, si, nums2, j, k - (si - i));
        }
    }

    /**
     * 划分数组
     * 通过中位数定义解题
     * 中位数是用来将一个集合划分为两个长度相等的子集,其中一个子集中的元素总数大于另一个子集中的元素
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArraysByMean(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // 调整顺序 保证短数组在前
            return findMedianSortedArraysByMean(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = 0;
        // 定义中 median1为前一部分最大值 median2为后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) /2 - i;

            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    /**
     * 网友极限题解
     * 思路最清晰
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMediaSortedArraysByExtremly(int[] nums1, int[] nums2) {
        // 偶数红位数数字,奇数中位数右侧数字
        int num = 0;
        int len = nums1.length + nums2.length;
        // 判断是否为偶数
        boolean b = len % 2 == 0;
        // 偶数中位数位置, 奇数中位数右侧位置
        len /= 2;
        // 空数组返回0
        if (nums1.length + nums2.length == 0) return 0;
        // 数组1为空返回数组2中位数
        if (nums1.length == 0) return b ? (nums2[len - 1] + nums2[len]) / 2.0 : nums2[len];
        // 数组2为空返回数组1中位数
        if (nums2.length == 0) return b ? (nums1[len - 1] + nums1[len]) / 2.0 : nums1[len];
        int i = 0, j = 0;
        // 奇数中位数左侧数字
        int oldNum = num;
        // 判断是否循环至中位数(数组合并 + 数组排序 + 计数)
        while (i + j != len + 1) {
            oldNum = num;
            if (i >= nums1.length || (j < nums2.length && nums1[i] > nums2[j])) num = nums2[j++];
            else num = nums1[i++];
        }
        // 返回中位数
        return b ? (num + oldNum) / 2.0 : num;
    }

}
