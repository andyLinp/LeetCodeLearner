package com.learner.leetcodelearner.lib.medium;

import com.learner.leetcodelearner.lib.bean.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/07/06 10:33
 **/
public class No_102 {
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 广度优先搜索 二叉树 👍 1379 👎 0


    /**
     * 执行耗时:1 ms,击败了57.80% 的Java用户
     * 内存消耗:41.3 MB,击败了70.14% 的Java用户
     * 广度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> curAns = new LinkedList<Integer>();
            Integer level = deque.size();
            for (int i = 0; i < level; ++i) {
                TreeNode curNode = deque.poll();
                curAns.add(curNode.val);
                if (curNode.left != null) {
                    deque.offer(curNode.left);
                }
                if (curNode.right != null) {
                    deque.offer(curNode.right);
                }
            }
            res.add(curAns);
        }
        return res;
    }

    /**
     * 执行耗时:1 ms,击败了57.80% 的Java用户
     * 内存消耗:41.8 MB,击败了5.00% 的Java用户
     * 深度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (root == null) return res;
        // 记录层级
        int row = 0;
        dfs(map,row,root);
        if(map.isEmpty()) {
            return res;
        }
        for(Integer key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
    public void dfs(Map<Integer, List<Integer>> map, int row, TreeNode node) {
        if(node == null) return;
        if  (map.get(row) == null) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            map.put(row, list);
        } else {
            List<Integer> list = map.get(row);
            list.add(node.val);
        }
        row++;
        if(node.left != null) {
            dfs(map, row,node.left);
        }
        if(node.right != null) {
            dfs(map, row,node.right);
        }
    }
}
