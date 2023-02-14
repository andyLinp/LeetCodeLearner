package com.learner.leetcodelearner.lib.bean;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/06 10:07
 **/
public class Node {
    // init
    static {
        System.out.println("Node init");
    }
    public int val;
    public Node left, right, next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
