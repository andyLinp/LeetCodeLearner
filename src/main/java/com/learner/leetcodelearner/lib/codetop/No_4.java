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
}
