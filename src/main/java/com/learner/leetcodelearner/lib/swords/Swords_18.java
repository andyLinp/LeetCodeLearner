package com.learner.leetcodelearner.lib.swords;

import com.learner.leetcodelearner.lib.bean.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/23 14:49
 **/
public class Swords_18 {
    //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//
// 返回删除后的链表的头节点。
//
// 注意：此题对比原题有改动
//
// 示例 1:
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//
//
// 示例 2:
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
//
//
//
//
// 说明：
//
//
// 题目保证链表中节点的值互不相同
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
//
// Related Topics 链表 👍 232 👎 0

    /**
     * 简单模拟
     * @param head
     * @param val
     * @return
     */
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val) return head.next;
            ListNode iter = head;
            while(iter.next != null) {
                if (iter.next.val == val) {
                    ListNode next = iter.next.next;
                    iter.next = next;
                    return head;
                } else {
                    iter = iter.next;
                }
            }
            return head;
        }
}
