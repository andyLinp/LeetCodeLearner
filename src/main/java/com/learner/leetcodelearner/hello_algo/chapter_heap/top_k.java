package com.learner.leetcodelearner.hello_algo.chapter_heap;

import com.learner.leetcodelearner.lib.utils.PrintUtil;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/12/1
 */
public class top_k {
    /* 基于堆查找数组中最大的 k 个元素 */
    static Queue<Integer> topKHeap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<Integer>();
        // 将数组的前 k 个元素入堆
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        // 从第 k+1 个元素开始，保持堆的长度为 k
        for (int i = k; i < nums.length; i++) {
            // 若当前元素大于堆顶元素，则将堆顶元素出堆、当前元素入堆
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 7, 6, 3, 2 };
        int k = 3;

        Queue<Integer> res = topKHeap(nums, k);
        System.out.println("最大的 " + k + " 个元素为");
        PrintUtil.printHeap(res);
    }
}
