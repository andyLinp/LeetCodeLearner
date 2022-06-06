package com.learner.leetcodelearner.lib.bean;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/06 10:09
 **/
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
