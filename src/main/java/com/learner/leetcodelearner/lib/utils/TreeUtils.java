package com.learner.leetcodelearner.lib.utils;

import com.learner.leetcodelearner.lib.bean.Node;
import com.learner.leetcodelearner.lib.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author andy lin
 * @Date: 2022/06/06 10:12
 **/
public class TreeUtils {

    public static void printTree(TreeNode result) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(result);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                System.out.println("弹出为空");
            } else {
                System.out.println("弹出为" + poll.val);
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
    }

    public static void printTree(Node result) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(result);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll != null) {
                if (poll.next != null) {
                    System.out.println("弹出为" + poll + ",next为" + poll.val);
                } else {
                    System.out.println("弹出为" + poll.val + ",next为空");
                }
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
    }
}
