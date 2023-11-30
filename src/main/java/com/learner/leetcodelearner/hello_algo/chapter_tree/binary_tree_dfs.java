package com.learner.leetcodelearner.hello_algo.chapter_tree;

import com.learner.leetcodelearner.lib.bean.TreeNode;
import com.learner.leetcodelearner.lib.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/10/27
 */
public class binary_tree_dfs {
    // 初始化列表, 用于存储遍历序列
    static ArrayList<Integer> list = new ArrayList<>();
    /* 前序遍历 */
    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问优先级: 根节点 -> 左子树 -> 右子树
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(TreeNode root) {
        if (root == null)
            return;
        // 访问优先级: 左子树 -> 根节点 -> 右子树
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    static void postOrder(TreeNode root) {
        if (root == null)
            return;
        // 访问优先级: 左子树 -> 右子树 -> 根节点
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }

    public static void main(String[] args) {
        /* 初始化二叉树 */
        // 这里借助了一个从数组直接生成二叉树的函数
        TreeNode root = TreeNode.listToTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("\n初始化二叉树\n");
        PrintUtil.printTree(root);

        /* 前序遍历 */
        list.clear();
        preOrder(root);
        System.out.println("\n前序遍历的节点打印序列 = " + list);

        /* 中序遍历 */
        list.clear();
        inOrder(root);
        System.out.println("\n中序遍历的节点打印序列 = " + list);

        /* 后序遍历 */
        list.clear();
        postOrder(root);
        System.out.println("\n后序遍历的节点打印序列 = " + list);
    }
}
