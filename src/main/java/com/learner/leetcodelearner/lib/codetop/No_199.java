package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/1
 */
public class No_199 {
    /**
     * 解答成功:
     * 	执行耗时:1 ms,击败了82.31% 的Java用户
     * 	内存消耗:40.3 MB,击败了46.13% 的Java用户
     * 	BFS
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }

                if (i == size - 1) {
                    res.add(poll.val);
                }
            }
        }
        return res;
    }


    /**
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:40 MB,击败了84.22% 的Java用户
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        nextRight(root, res, 0);
        return res;
    }

    private void nextRight(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            res.add(root.val);
        }
        if (root.right != null) {
            nextRight(root.right, res, depth + 1);
        }
        if (root.left != null) {
            nextRight(root.left, res, depth + 1);
        }
    }




}


