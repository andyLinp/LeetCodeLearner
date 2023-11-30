package com.learner.leetcodelearner.hello_algo.chapter_tree;

import com.learner.leetcodelearner.lib.bean.TreeNode;
import com.learner.leetcodelearner.lib.utils.PrintUtil;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/10/27
 */
public class binary_tree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println("\n初始化二叉树\n");
        PrintUtil.printTree(n1);

        /* 插入与删除节点*/
        TreeNode P = new TreeNode(0);

        n1.left = P;
        P.left = n2;
        System.out.println("\n插入节点 P 后 \n");
        PrintUtil.printTree(n1);
        // 删除节点 P
        n1.left = n2;
        System.out.println("\n删除节点 P 后\n");
        PrintUtil.printTree(n1);
    }
}
