package com.learner.leetcodelearner.hello_algo.chapter_tree;

import com.learner.leetcodelearner.lib.bean.TreeNode;
import com.learner.leetcodelearner.lib.utils.PrintUtil;

import java.util.Arrays;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/10/26
 */
public class binary_search_tree {
    public static void main(String[] args) {
        /* 初始化二叉搜索树 */
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        BinarySearchTree bst = new BinarySearchTree(nums);
        System.out.println("\n初始化的二叉树为\n");
        PrintUtil.printTree(bst.getRoot());

        /* 查找节点 */
        TreeNode node = bst.search(7);
        System.out.println("\n查找到的节点对象为 " + node + "，节点值 = " + node.val);

        /* 插入节点 */
        bst.insert(16);
        System.out.println("\n插入节点 16 后，二叉树为\n");
        PrintUtil.printTree(bst.getRoot());

        /* 删除节点 */
        bst.remove(1);
        System.out.println("\n删除节点 1 后，二叉树为\n");
        PrintUtil.printTree(bst.getRoot());
        bst.remove(2);
        System.out.println("\n删除节点 2 后，二叉树为\n");
        PrintUtil.printTree(bst.getRoot());
        bst.remove(4);
        System.out.println("\n删除节点 4 后，二叉树为\n");
        PrintUtil.printTree(bst.getRoot());
    }
}

/*二叉搜索树*/
class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(int[] nums) {
        Arrays.sort(nums);// 排序数组
        root = buildTree(nums, 0, nums.length - 1);// 构建二叉搜索树
    }

    public TreeNode getRoot(){return root;}

    public TreeNode buildTree(int[] nums, int i, int j) {
        if (i > j)
            return null;
        // 将数组中间节点作为根节点
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归建立左子树和右子树
        root.left = buildTree(nums, i, mid - 1);
        root.right = buildTree(nums, mid + 1, j);
        return root;
    }

    public TreeNode search(int num) {
        TreeNode cur = root;
        // 循环查找,越过叶节点后跳出
        while(cur != null) {
            // 目标节点在 cur 的右子树中
            if (cur.val < num)
                // 目标节点在 cur 的左子树中
                cur = cur.right;
            else if (cur.val > num)
                cur = cur.left;
            // 找到目标节点,跳出循环
            else
                break;
        }
        // 返回目标节点
        return cur;
    }

    /*插入节点*/
    public void insert(int num) {
        //
        if (root == null)
            return;
        TreeNode cur = root, pre = null;

        while(cur != null){
            if (cur.val == num)
                return;
            pre = cur;
            if (cur.val < num)
                cur = cur.right;
            else
                cur = cur.left;
        }
        TreeNode node = new TreeNode(num);
        if (pre.val < num)
            pre.right = node;
        else
            pre.left = node;
    }


    public void remove(int num) {
        if (root == null)
            return;
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.val == num)
                break;
            pre = cur;
            if (cur.val < num)
                cur = cur.right;
            else
                cur = cur.left;
        }
        if (cur == null)
            return;
        if (cur.left == null || cur.right == null) {
            TreeNode child = cur.left != null ? cur.left : cur.right;
            if (cur != root) {
                if (pre.left == cur)
                    pre.left = child;
                else
                    pre.right = child;
            } else {
                root = child;
            }
        } else {
            TreeNode tmp = cur.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            remove(tmp.val);
            cur.val = tmp.val;
        }
    }
}