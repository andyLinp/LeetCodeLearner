package com.learner.leetcodelearner.hello_algo.chapter_tree;

import com.learner.leetcodelearner.lib.bean.TreeNode;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/8/24
 */
public class avl_tree {
}

/* AVL 树 */
class AVLTree {
    TreeNode root; // 根节点

    public int height(TreeNode node) {
        // 空节点高度为 -1 , 叶节点高度为 0
        return node == null ? -1 : node.height;
    }


    /* 更新节点高度 */
    private void updateHeight(TreeNode node) {
        // 节点高度等于最高子树高度 + 1
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    /* 获取平衡因子 */
    public int balanceFactor(TreeNode node) {
        // 空节点平衡因子为 0
        if (node == null)
            return 0;
        // 节点平衡因子 = 左子树高度 - 右子树高度
        return height(node.left) - height(node.right);
    }

    /* 右旋操作 */
    private TreeNode rightRotate(TreeNode node) {
        TreeNode child = node.left;
        TreeNode grandChild = child.right;
        // 以 child 为原点 将 node 向右旋转
        child.right = node;
        node.left = grandChild;
        // 更新节点高度
        updateHeight(node);
        updateHeight(child);
        // 返回旋转后子树的根节点
        return child;
    }
    /* 左旋操作 */
    private TreeNode leftRotate(TreeNode node) {
        TreeNode child = node.right;
        TreeNode grandChild = child.left;
        // 以 child 为原点, 将 node 向左旋转
        child.left = node;
        node.right = grandChild;
        // 更新节点高度
        updateHeight(node);
        updateHeight(child);
        // 返回旋转后子树的根节点
        return child;
    }

    /* 执行旋转操作, 使该子树重新恢复平衡 */
    private TreeNode rotate(TreeNode node) {
        // 获取节点 node 的平衡因子
        int balanceFactor = balanceFactor(node);
        // 左偏树
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                // 右旋
                return rightRotate(node);
            } else {
                // 先左旋后右旋
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // 右偏树
        if (balanceFactor < -1) {
            if (balanceFactor(node.right) <= 0) {
                // 左旋
                return leftRotate(node);
            } else {
                // 先右旋后左旋
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        // 平衡树, 无需旋转, 直接返回
        return node;
    }

    public void insert(int val) {
        root = insertHelper(root, val);
    }

    /* 递归插入节点(辅助方法) */
    private TreeNode insertHelper(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        /* 1. 查找插入位置,并插入节点 */
        if (val < node.val) {
            node.left = insertHelper(node.left, val);
        } else if (val > node.val) {
            node.right = insertHelper(node.right, val);
        } else {
            return node; // 重复节点不插入,直接返回
        }
        // 更新节点高度
        updateHeight(node);
        /* 2.执行旋转操作,使该子树重新恢复平衡 */
        node = rotate(node);
        // 返回子树的根节点
        return node;
    }
}