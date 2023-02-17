package com.learner.leetcodelearner.lib.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 三数之和 双指针毫无入手概念,看答案抄思路 哦yeah
 * @Author andy lin
 * @Date: 2023/02/17 09:54
 **/
public class No_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            int left = k + 1, right = nums.length - 1;
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            while (left < right) {
                int s = nums[k] + nums[left] + nums[right];
                if (s > 0) {
                    right--;
                } else if (s < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[k],nums[left],nums[right]));
                    // 找到为0的和时 不急于移动k 当前k值可能存在不同的left 和 right 组合 在当前k值不变的情况下找净其余可能
                    while(left<right&&nums[left]==nums[left+1]) {
                        // 相同值跳过
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        // 相同值跳过
                        right--;
                    }
                    // 移动指针重新判断s大小
                    left++;
                    right--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 4 , -2, -3, -4, 0};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            list.stream().forEach(i-> System.out.print(i+" "));
            System.out.println(" ");
        }
    }
}
