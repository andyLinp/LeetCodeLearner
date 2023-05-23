package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;
import com.learner.leetcodelearner.lib.utils.ListNodeUtil;

/**
 * @Description 删除倒数第n个节点
 * @Author: andy lin
 * @DATE: 2023/5/23
 */
public class No_19 {
    /**
     * 双指针 一个指针从哑点出发 一个指针从原始节点出发 实际间隔 n
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode pre = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while(cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5};
        ListNode listNode = ListNodeUtil.generateLinkedListFromArray(nums);
        ListNode listNode1 = removeNthFromEnd(listNode, 2);
    }
}
