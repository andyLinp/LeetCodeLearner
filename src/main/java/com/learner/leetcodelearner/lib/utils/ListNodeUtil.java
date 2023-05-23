package com.learner.leetcodelearner.lib.utils;

import com.learner.leetcodelearner.lib.bean.ListNode;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/5/23
 */
public class ListNodeUtil {
    public static ListNode generateLinkedListFromArray(int[] nums) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            current.next = node;
            current = node;
        }
        return dummyHead.next;
    }
}
