package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;

public class No_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dams = new ListNode(0);
        ListNode ans = dams;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dams.next = list1;
                list1 = list1.next;
                dams = dams.next;
            } else {
                dams.next = list2;
                dams = dams.next;
                list2 = list2.next;
            }
        }

        while(list1 != null) {
            dams.next = list1;
            dams = dams.next;
            list1 = list1.next;
        }

        while(list2 != null) {
            dams.next = list2;
            dams = dams.next;
            list2 = list2.next;
        }
        return ans.next;
    }
}
