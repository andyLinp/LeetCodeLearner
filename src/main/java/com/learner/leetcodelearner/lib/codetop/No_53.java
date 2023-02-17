package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/02/17 15:50
 **/
public class No_53 {

    /**
     * O(n^2) 双重for循环
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            max = Math.max(max, sum);
            int j = i + 1;
            while (j < nums.length) {
                sum += nums[j];
                max = Math.max(max, sum);
                j++;
            }
        }
        return max;
    }

    /**
     * O(n) 抄大佬的 哦yeah!
     * 思路就是缓存一个最大值,缓存一个和,从第一位开始向后遍历,当和小于0的时候,重置和为0(就是重新开始一个子列)
     *
     * @param nums
     * @return
     */

    public static int maxSubArr(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * O(n) 抄大佬的 哦yeah!
     * dp数组维护以原数组对应位置为结尾的最大子列和
     * @param nums
     * @return
     */
    public static int maxSubArrDp(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {

            if (dp[i-1] > 0) {
                dp[i] = dp[i -1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        // find max
        int max = dp[0];
        for (int i = 1; i < len; i++) {
           max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[]args) {
        int i = maxSubArrDp(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(i);
    }
}
