package com.learner.leetcodelearner.lib.codetop;

import java.util.HashMap;

/**
 * @Description 两数之和 梦开始的地方2333
 * @Author andy lin
 * @Date: 2023/03/06 10:08
 **/
public class No_1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return nums;
    }

}
