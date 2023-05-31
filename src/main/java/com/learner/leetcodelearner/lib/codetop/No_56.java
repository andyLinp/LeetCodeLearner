package com.learner.leetcodelearner.lib.codetop;

import java.util.*;

/**
 * @Description
 * @Author: andy lin
 * @DATE: 2023/5/31
 */
public class No_56 {
    /**
     *  执行耗时:9 ms,击败了16.94% 的Java用户
     * 	内存消耗:44.7 MB,击败了81.22% 的Java用户
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
            if(intervals.length == 0){
                return new int[0][2];
            }
            Arrays.sort(intervals, Comparator.comparingInt(inter -> inter[0]));
            List<int[]> merge = new ArrayList<>();
            for(int[] inter : intervals){
                int L = inter[0], R = inter[1];
                //当前的左边在已有合并数组最右之前
                if(merge.isEmpty() || L > merge.get(merge.size()-1)[1]){
                    merge.add(new int[]{L,R});
                }else{
                    //合并
                    merge.get(merge.size()-1)[1] = Math.max(R, merge.get(merge.size()-1)[1]);
                }
            }
            return merge.toArray(new int[merge.size()][]);
        }

    /**
     * runtime:3 ms
     * memory:44.5 MB
     * @param intervals
     * @return
     */
    public int[][] mergeWithoutSort(int[][] intervals) {
        BitSet bitSet = new BitSet();
        int max = 0;
        for (int[] interval : intervals) {
            // *2 : 若[3, 4] [5, 6] 进行应该4和5不会相连,但是BitSet中会存在{3, 4, 5, 6}
            // 为避免这种情况 *2 就相当于给每一个相邻值之间插入了一个多余的值
            int temp = interval[1] * 2 + 1;
            // 将指定的 fromIndex(包含) 到 指定的 toIndex(不含) 范围内的位设置为true
            bitSet.set(interval[0] * 2, temp, true);
            max = temp >= max ? temp : max;
        }

        int index = 0, count = 0;
        while (index < max) {
            // 返回index及之后第一个为true的下标
            int start = bitSet.nextSetBit(index);
            // 返回start及之后第一个为false的下标
            int end = bitSet.nextClearBit(start);

            int[] item = {start / 2, (end -1)/2};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        for (int i = 0; i < count; i++) {
            ret[i] = intervals[i];
        }

        return ret;
    }
}
