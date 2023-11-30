package com.learner.leetcodelearner.hello_algo.chapter_tree;


import com.learner.leetcodelearner.lib.bean.TreeNode;
import com.learner.leetcodelearner.lib.utils.PrintUtil;

import java.util.*;

/**
 * @Description 层序遍历
 * @Author: andy lin
 * @DATE: 2023/10/27
 */
public class binary_tree_bfs {

    static List<Integer> levelOrder(TreeNode root) {
        // 初始化队列, 加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 初始化一个列表,用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();// 队列出队
            list.add(node.val);// 保存节点值
            if (node.left != null)
                queue.offer(node.left);//左子节点入队
            if (node.right != null)
                queue.offer(node.right);// 右子节点入队
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.listToTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("\n初始化二叉树\n");
        PrintUtil.printTree(root);

        /*层序遍历*/
        List<Integer> list = levelOrder(root);
        System.out.println("\n层序遍历的节点打印序列 = " + list);
    }

}
