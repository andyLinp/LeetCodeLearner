package com.learner.leetcodelearner.lib.easy;

import com.learner.leetcodelearner.lib.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

public class No_876 {
//给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//
// 如果有两个中间结点，则返回第二个中间结点。
//
//
//
// 示例 1：
//
//
//输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next =
//NULL.
//
//
// 示例 2：
//
//
//输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
//
//
//
//
// 提示：
//
//
// 给定链表的结点数介于 1 和 100 之间。
//
// Related Topics 链表 双指针 👍 606 👎 0


    /**
     * 数组
     * 时间复杂度 O（n） 空间复杂度 O（n）
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int index = 0;
        while (head != null) {
            arr[index++] = head;
            head = head.next;
        }
        return arr[index / 2];
    }

    /**
     * 单指针
     * 时间复杂度 O（n） 空间复杂度 O（1）
     * @param head
     * @return
     */
    public ListNode middleNodeTwice(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while(cur != null) {
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 快慢指针
     * 定义两个指针 快指针一次移动是慢指针两倍 当快指针到链表末端结点 慢指针正好为中结点
     * 时间复杂度 O（n） 空间复杂度 O（1）
     * @param head
     * @return
     */
    public ListNode middleNodeFastAndSlow(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
