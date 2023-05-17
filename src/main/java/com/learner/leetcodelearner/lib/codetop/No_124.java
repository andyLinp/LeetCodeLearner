package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.ListNode;
import com.learner.leetcodelearner.lib.bean.TreeNode;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/05/15 09:29
 **/
public class No_124 {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxTreePath(root);
        return result;
    }
    public int maxTreePath(TreeNode root) {
        int pathSum = Integer.MIN_VALUE;
        if (root == null) return 0;
        // 求左节点最大路径和
        int maxLeftPath = maxTreePath(root.left);
        // 求右节点最大路径和
        int maxRightPath = maxTreePath(root.right);
        // 经过根节点 但只经过一边子树的最大路径
        pathSum = Math.max(Math.max(root.val, maxLeftPath + root.val), maxRightPath + root.val);
        // 刷新result
        result = Math.max(Math.max(pathSum, maxLeftPath + maxRightPath + root.val), result);
        return pathSum;
    }


    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result;
    }

    /**
     * 计算从某一节点出发的路径和的时候
     * 计算公式为: 当前节点值 + 左子树贡献 + 右子树贡献
     * 左右子树贡献为可选, 就是说当某一边贡献小于0时, 计算路径时抛弃这一边
     * 这种情况也就相当于某贡献为0,但是注意路径和至少包含当前节点值.
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左子树贡献
        int leftMax = Math.max(0, dfs(root.left));
        // 右子树贡献
        int rightMax = Math.max(0, dfs(root.right));
        // 更新result
        result = Math.max(result, root.val + leftMax + rightMax);
        // 返回当前节点的总贡献
        return root.val + Math.max(leftMax, rightMax);
    }




}
