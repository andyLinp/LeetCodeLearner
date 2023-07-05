package com.learner.leetcodelearner.lib.codetop;

import java.util.*;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/30
 */
public class No_239 {
    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        // 返回数组 长度为nums数组的长度 - 滑块的长度 + 1
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 队列中的头节点的下标小于i - k + 1 那就代表当前的滑块已经超过头节点 把头节点删除
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // 从队列的尾节点开始删除小于元素的节点,确保链表是从头到尾顺序排列,头节点一定是最大的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 把当前元素加入到队列
            deque.offer(i);
            // i - k + 1条件是当前元素已经是第一个滑动的最后一个元素,需要把头节点的值(最大值)放入到返回数组中
            if (i - k + 1 >= 0) {
                result[i-k+1] = nums[deque.peek()];
            }
        }
        return result;
    }


    /**
     * 优先队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowByPriority(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int n = nums.length, m = n -k + 1, idx = 0;
        int[] ans = new int[m];
        for (int i = 0; i < n; i++) {
            q.add(new int[]{i, nums[i]});
            if (i >= k - 1) {
                while (q.peek()[0] <= i - k) q.poll();
                ans[idx++] = q.peek()[1];
            }
        }
        return ans;
    }



}
