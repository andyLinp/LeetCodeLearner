package com.learner.leetcodelearner.lib.bean;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/06 10:05
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printNode() {
        System.out.println(val + ",");
        if (this.next != null) {
            next.printNode();
        }
    }
}
