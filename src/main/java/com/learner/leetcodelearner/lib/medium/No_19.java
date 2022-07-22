package com.learner.leetcodelearner.lib.medium;

import com.learner.leetcodelearner.lib.bean.ListNode;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/07/22 17:16
 **/
public class No_19 {
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
//
//
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
// Related Topics 链表 双指针 👍 2138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


    /**
     * 两遍遍历 第一遍获取节点中长度
     * 第二遍确定要移除的点
     * @param head
     * @param n
     * @return
     */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode cur = head;
            int sz = 0;
            while (cur != null) {
                sz++;
                cur = cur.next;
            }
            if (sz == 1) {
                return null;
            }
            if (sz == 2) {
                if (n == 2) {
                    return head.next;
                } else{
                    head.next = null;
                    return head;
                }
            }
            int index = sz - n;
            if (index == 0) {
                return head.next;
            }
            cur = head;
            while(index > 1) {
                index--;
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return  head;
        }

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndTwoPoints(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        // first指针先移动n个 保证second指针与first指针之间间隔n个节点
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        // first指针移至尾部 second指针正好与尾部差n个节点
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 断开second.next节点
        second.next = second.next.next;
        return dummy.next;
    }
}
