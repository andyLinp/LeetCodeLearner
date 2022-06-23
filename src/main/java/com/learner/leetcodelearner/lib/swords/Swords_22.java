package com.learner.leetcodelearner.lib.swords;

import com.learner.leetcodelearner.lib.bean.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/23 15:21
 **/
public class Swords_22 {
    //输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
//
//
//
// 示例：
//
//
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5.
// Related Topics 链表 双指针 👍 367 👎 0

    /**
     * 维护一个栈  先进后出  反向k即正向出栈k
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        Deque<ListNode> stack = new LinkedList<ListNode>();
        while (head != null) {
            stack.offer(head);
            head = head.next;
        }
        for (int i = 1; i < k; i++) {
            stack.pollLast();
        }
        return stack.pollLast();
    }

    /**
     * 双指针 维护前后指针之间的距离为k  当前指针到末端节点 后节点即为反向k节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
