package com.learner.leetcodelearner.lib.codetop;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/01/03 13:59
 **/
public class No_215 {
    /**
     * 小根堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new  PriorityQueue<>();
        int i = 0;
        for (;i < k; i++) {
            queue.add(nums[i]);
        }
        for (;i < nums.length;i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    /**
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    public int quickSelectDesc(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        while (true) {
            if (start == end) return start;

            int pivot = nums[end];
            int l = start;
            int r = end - 1;
            while(true) {
                while(l < end && nums[l] >= pivot) {
                    ++l;
                }
                while (r >= l && nums[r] <= pivot) {
                    --r;
                }
                if (l < r) {
                    int temp = nums[l];
                    nums[l] = nums[end];
                    nums[end] = temp;
                } else {
                    if (l < end) {
                        int temp = nums[l];
                        nums[l] = nums[end];
                        nums[end] = temp;
                    }
                    break;
                }
             }
            if (k == l) {
                return k;
            } else if(k > l) {
                start = l + 2;
            } else {
                end = l - 1;
            }
        }
    }

}
