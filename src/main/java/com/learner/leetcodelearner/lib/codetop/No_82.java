package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/6
 */
public class No_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int k = cur.next.val;
                // 这里的核心逻注意一下，判断两个节点值不为null ，且相等的情况下
                // 逐步删除一个个相等节点。都是通过cur.next 调整指向来的。
                while(cur.next != null && cur.next.val == k) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 宫水三叶题解
     * tail为有效链表的结尾
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesByTwo(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            // 确保head不会与上一节点相同
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            // head与下一节点相同, 跳过相同节点
            while (head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
