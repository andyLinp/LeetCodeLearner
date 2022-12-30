package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/12/30 15:35
 **/
public class No_206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            // 暂存下一个节点
            ListNode next = curr.next;
            // 当前节点的下一个节点转换为当前节点的上一个节点 进行了翻转
            curr.next = prev;
            // 移动上一个节点为当前节点
            prev = curr;
            // 当前节点进一
            curr = next;
        }
        return prev;
    }
}
