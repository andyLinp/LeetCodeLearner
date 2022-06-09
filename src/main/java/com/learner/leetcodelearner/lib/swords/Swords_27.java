package com.learner.leetcodelearner.lib.swords;

import com.learner.leetcodelearner.lib.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Swords_27 {
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//
// 4
// / \
// 2 7
// / \ / \
//1 3 6 9
//镜像输出：
//
// 4
// / \
// 7 2
// / \ / \
//9 6 3 1
//
//
//
// 示例 1：
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 264 👎 0

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        return root == null ? null : new TreeNode(root.val, mirrorTree(root.right),mirrorTree(root.left));
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        //如果为空直接返回
        if (root == null)
            return null;
        //队列
        final Queue<TreeNode> queue = new LinkedList<>();
        //首先把根节点加入到队列中
        queue.add(root);
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            //交换node节点的两个子节点
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            //如果当前节点的左子树不为空，就把左子树
            //节点加入到队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            //如果当前节点的右子树不为空，就把右子树
            //节点加入到队列中
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
