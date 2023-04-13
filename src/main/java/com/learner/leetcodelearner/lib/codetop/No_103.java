package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/04/13 09:34
 **/
public class No_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean flag = true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()) {
            Deque<Integer> curVal = new LinkedList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.pollFirst();
                if (flag) {
                    curVal.offerLast(cur.val);
                } else {
                    curVal.offerFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.offerLast(cur.left);
                }
                if (cur.right != null) {
                    queue.offerLast(cur.right);
                }
            }
            flag = !flag;
            result.add(new LinkedList<>(curVal));
        }
        return result;
    }
}
