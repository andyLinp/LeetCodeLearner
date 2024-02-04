package com.learner.leetcodelearner.hello_algo.chapter_tree;

import com.learner.leetcodelearner.lib.bean.TreeNode;
import com.learner.leetcodelearner.lib.utils.PrintUtil;

import java.util.*;

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
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.put("test", list);
        map.get("test").add("ok");
        System.out.println(map.get("test").get(0));
    }
}
