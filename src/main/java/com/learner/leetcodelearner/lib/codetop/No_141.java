package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;

import java.util.ArrayList;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/20 11:23
 **/
public class No_141 {
    /**
     * 快慢指针
     * 注意快慢指针的定义时,移动速度不要一致
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.6 MB,击败了46.41% 的Java用户
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        if (null == head || null == head.next) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        // 循环移动的条件是快慢指针不相等 若相等则跳出循环 说明存在环
        while (slow != fast) {
            // 移动条件 快指针非空则慢指针一定非空
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                // 不存在下一个节点且满足 fast != slow 说明链表已经走到尾部且不存在环
                return false;
            }
        }
        return true;
    }


    /**
     * 通过List记录指针移动 判断是否存在过
     * 效率极低..
     * 执行耗时:414 ms,击败了5.10% 的Java用户
     * 内存消耗:42.3 MB,击败了76.77% 的Java用户
     * @param head
     * @return
     */
    public boolean hasCycleByList(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return  true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }
}
