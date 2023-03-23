package com.learner.leetcodelearner.lib.easy;

/**
 * @Description
 * @Author andy lin
 * @Date: 2023/03/23 16:43
 **/
public class No_338 {
    /**
     * dp
     *
     * 当前数字的二进制中包含的1的个数取决于其二进制位上一位的1的个数。具体而言，对于二进制数中的任意一位，其1的个数可能有如下两种情况：
     *
     * 当前位为0，那么其1的个数就等于上一位二进制数中的1的个数；
     * 当前位为1，那么其1的个数就等于上一位二进制数中的1的个数加1。
     * 具体而言，对于任意数字i，可以将其转换为2进制，然后根据上述规律来计算出其中1的个数。在计算1的个数时，可以使用位运算中的右移操作（”>>“），来依次遍历二进制数的每一位。
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i>>1] + (i & 1);
        }
        return ans;
    }
}
