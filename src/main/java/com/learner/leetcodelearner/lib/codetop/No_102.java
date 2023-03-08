package com.learner.leetcodelearner.lib.codetop;

import com.learner.leetcodelearner.lib.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/08 09:56
 **/
public class No_102 {
    /**
     * BFS优化做法:
     * 1.根元素入队
     * 2.队列不为空时:
     *      求当前队列的长度 size
     *      依次从队列中取出元素拓展,进入下一次迭代
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> currentLevel = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
