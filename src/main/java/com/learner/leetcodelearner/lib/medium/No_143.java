package com.learner.leetcodelearner.lib.medium;

import com.learner.leetcodelearner.lib.bean.ListNode;

public class No_143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        while(h != null) {
            len++;
            h = h.next;
        }
        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }

        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;
        tail.next = subHead;
        return outTail;
    }
}
