package com.learner.leetcodelearner.lib.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/7/20
 */
public class No_78 {
    static List<Integer> t = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        // 从第0个元素开始
        dfs(0, nums);
        return ans;
    }

    public  static void dfs(int cur, int[] nums) {
        if (cur == nums.length) { // 如果枚举完所有的元素 返回
            ans.add(new ArrayList<>(t));
            return;
        }
        // 选择当前的元素
        t.add(nums[cur]);
        // 递归
        dfs(cur+1, nums);
        // 不选择当前的元素(但是并不是与上部分选择当前元素同一个元素 为从t集合移除一个元素 反向递归:回溯)
        t.remove(t.size()-1);
        // 递归
        dfs(cur+1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
    }
}
