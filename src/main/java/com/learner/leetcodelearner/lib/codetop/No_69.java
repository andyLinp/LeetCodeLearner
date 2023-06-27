package com.learner.leetcodelearner.lib.codetop;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/6/14
 */
public class No_69 {
    // 数学归纳
    int s;

    public int mySqrt(int x) {
        s = x;
        if (x == 0) return 0;
        return ((int)(sqrts(x)));
    }

    public double sqrts(double x) {
        double res = (x + s/x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }

    // 二分查找
    public int mySqrt2(int x) {
        if (x == 0 || x == 1) return x;
        return twoSearch(x, 0, x);
    }

    public int twoSearch(int x, int start, int end) {
        int mid = (start + end)/2;
        if (mid <= (x / mid) && (mid + 1) > (x/(mid + 1))) {
            return mid;
        }

        if (mid < (x / mid)) {
            return twoSearch(x, mid, end);
        } else {
            return twoSearch(x, start, mid);
        }
    }
}
