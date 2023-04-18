package com.learner.leetcodelearner.lib.codetop;

import java.util.*;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/04/17 10:20
 **/
public class No_46 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 1) {
            List<Integer> zero = new ArrayList<>();
            zero.add(nums[0]);
            result.add(zero);
            return result;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, result);
        return result;
    }

    private void dfs(int[]nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("递归之前=>" + path);
                dfs(nums, len, depth + 1, path, used, result);
                System.out.println("递归之后=>" + path);
                used[i] = false;
                path.removeLast();
            }
        }

    }


    public List<List<Integer>> permute1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        for (int num : nums) {
            output.add(num);
        }
        dfs1(output, len, 0, result);
        return result;
    }

    private void dfs1(List<Integer> output, int len, int first, List<List<Integer>> result) {
        if (first == len) {
            result.add(new ArrayList<>(output));
        }
        for (int i = first; i < len; i++) {
            Collections.swap(output, first, i);
            dfs1(output, len, first + 1, result);
            Collections.swap(output, first, i);
        }
    }
}
