package com.learner.leetcodelearner.lib.medium;

import com.learner.leetcodelearner.lib.bean.TreeNode;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/07/07 09:22
 **/
public class No_98 {
    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1652 👎 0



        public boolean isValidBST(TreeNode root) {
            // Integer.MAX_VALUE  Integer.MIN_VALUE 边界值取不到
            return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        /**
         * 一个节点是二叉树 其val保证小于右子树val 大于左子树val  从根节点开始搜索 根节点跟边界值进行比较 符合定义向下搜索 直到搜索完毕
         */
        public boolean dfs(TreeNode node, long max, long min) {
            if (node == null) {
                return true;
            }
            if (node.val < max && node.val > min) {
                return dfs(node.left, node.val, min) && dfs(node.right, max, node.val);
            } else {
                return false;
            }
        }

}
