package com.learner.leetcodelearner.lib.codetop;

import java.util.Stack;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/05/09 19:50
 **/
public class No_42 {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while(!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() -1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum += distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

    public int dpTrap(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int[] maxRight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i], height[i+1]);
        }
        for (int i = 1; i < height.length-1; i++) {
            maxLeft = Math.max(maxLeft, height[i -1]);
            int min = Math.min(maxLeft, maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min- height[i]);
            }
        }
        return sum;
    }
}
