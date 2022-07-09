package com.learner.leetcodelearner.lib.easy;

import com.learner.leetcodelearner.lib.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/07/08 10:00
 **/
public class No_235 {
    //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
//
//
// 示例 2:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉搜索树中。
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 879 👎 0


    private TreeNode res = null;

    /**
     * 二叉搜索树特性 节点值大小可以判断节点所在位置
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            res = root;
        } else if (root.val < p.val && root.val < q.val) {
            dfs(root.right, p, q);
        } else {
            dfs(root.left, p, q);
        }
    }

    /**
     * 两次遍历找到目标节点,记录目标节点路径
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorTraversing(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); ++i) {
            if (pathP.get(i) == pathQ.get(i)) {
                ancestor = pathP.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }
    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            if (node == target) {
                path.add(node);
                break;
            } else if (node.val > target.val) {
                path.add(node);
                node = node.left;
            } else {
                path.add(node);
                node = node.right;
            }
        }
        return path;
    }
}
