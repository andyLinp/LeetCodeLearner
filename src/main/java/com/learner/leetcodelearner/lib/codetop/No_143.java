package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/05/11 15:58
 **/
public class No_143 {
    // 存储法
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size()-1;
        while(i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    // 递归
    public void reorderListRecursion(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode h = head;
        int len = 0;
        while (h != null) {
            len++;
            h = h.next;
        }
        reorderListHelper(head, len);
    }

    /**
     * 当前节点
     *
     * @param head
     * @param len
     * @return
     */
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
