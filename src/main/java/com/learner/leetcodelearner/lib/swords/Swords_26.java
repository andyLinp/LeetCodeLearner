package com.learner.leetcodelearner.lib.swords;

import com.learner.leetcodelearner.lib.bean.TreeNode;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/09 10:50
 **/
public class Swords_26 {
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
// 例如:
//给定的树 A:
//
// 3
// / \
// 4 5
// / \
// 1 2
//给定的树 B：
//
// 4
// /
// 1
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
// 示例 1：
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
//
//
// 示例 2：
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true
//
// 限制：
//
// 0 <= 节点个数 <= 10000
// Related Topics 树 深度优先搜索 二叉树 👍 569 👎 0

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 边界条件判断
        if(A == null || B == null) return false;
        // 根节点判断    左节点判断   右节点判断
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    /**
     *  当前节点判断规则
     */
    public boolean dfs(TreeNode A, TreeNode B) {
        // 递归至B节点遍历完了 说明B节点是A的子节点
        if(B == null) return true;
        // 递归至A节点遍历完了 而B节点还存在 说明B不是A的子节点
        if(A == null) return false;
        // A B 均未遍历完 当前节点相同需要满足 当前值相等&&当前节点左节点相等&&当前节点右节点相等
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
