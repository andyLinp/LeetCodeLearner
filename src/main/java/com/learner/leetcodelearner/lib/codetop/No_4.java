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
}
