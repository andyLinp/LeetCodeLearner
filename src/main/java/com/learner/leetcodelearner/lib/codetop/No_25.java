package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;


/**
 * @Description
 * @Author andy lin
 * @Date: 2023/02/15 14:15
 **/
public class No_25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy = new ListNode(0, head);
        // 待翻转指针
        ListNode pre = dummy;
        // 翻转尾部
        ListNode end = dummy;
        while (end.next != null) {
            // 移动end指针 找到翻转末尾
            for (int i = 0; i < k && end != null; i++) end = end.next;
            // end指针为空,说明翻转区间不够长度k 直接返回 不进行翻转
            if (end == null) break;
            // start为翻转起点
            ListNode start = pre.next;
            // 翻转区间后链 先缓存
            ListNode next = end.next;
            // 翻转前断开end与后链
            end.next = null;
            // 开始翻转
            pre.next = reverse(start);
            // 翻转完成后 start成为下一翻转区间的待翻转点(不参与翻转) 把后链续上
            start.next = next;
            // 移动待翻转指针及翻转尾部指针
            pre = start;
            end = pre;
        }
        // 翻转后 链表
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[]args) {
        ListNode step5 = new ListNode(6, null);
        ListNode step4 = new ListNode(5, step5);
        ListNode step3 = new ListNode(4, step4);
        ListNode step2 = new ListNode(3, step3);
        ListNode step1 = new ListNode(2, step2);
        ListNode head = new ListNode(1, step1);
        ListNode listNode = reverseKGroup(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
