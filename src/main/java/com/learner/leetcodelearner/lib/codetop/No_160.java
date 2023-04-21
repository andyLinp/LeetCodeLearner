package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;

import java.util.HashSet;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/04/21 09:25
 **/
public class No_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            visited.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while(tmp != null) {
            if (visited.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
