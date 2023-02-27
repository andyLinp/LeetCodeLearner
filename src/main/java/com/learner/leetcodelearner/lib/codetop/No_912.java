package com.learner.leetcodelearner.lib.codetop;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @Author andy lin
 * @Description
 * @Date: 2023/02/27 19:52
 **/
public class No_912 {
    /**
     * 用jdk自带的排序直接过..看了一下排序的实现代码脑壳痛
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 插入排序
     * 思路:
     *
     * 从数组第二个元素开始->逆序与它之前的所有元素比较大小
     *                   当元素比他大时->就把元素后移
     *                   直到找到比他小的元素时->把它插入该元素后面
     * @param nums
     * @return
     */
    public int[] insertArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 技术排序
     * 通过构建一个长度略大于原数组的暂存数组
     * 将原数组通过减去原数组最小值来映射到暂存数组(在暂存数组下标对应位置计数)
     * 倒序遍历暂存数组,通过计数标识取出原数组从大到小的排序数组
     *
     * @param nums
     * @return
     */
    public int[] countNum(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) max = nums[i];
            if (min > nums[i]) min = nums[i];
        }
        int[] temp = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i] - min]++;
        }
        int j = nums.length - 1;
        for (int i = max - min; i > -1; i--) {
            int n = temp[i];
            while (n > 0) {
                nums[j] = i + min;
                n--;
                j--;
            }
        }
        return nums;
    }

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public int[] quitSortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }
    // 优化了随机选取轴,减小原数组特殊分布对排序时长的影响
    // 基于随机选取轴的快速排序时间复杂度为期望 O(nlogn)，其中 n 为数组的长度
    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] quitSortBySelf(int[] nums) {
        int begin = 0, end = nums.length - 1;
        quicksort(nums, begin, end);
        return nums;
    }

    /**
     * 单轴快排
     * 思路:
     *      从数组中随机选一个数作为比较数(轴)
     *      将轴交换置数组最左侧
     *      定义两指针,一个指向最左,一个指向最右
     *      从左往右移动左指针,当找到数大于轴,停止移动
     *      从右往左移动右指针,当找到数小于轴,停止移动
     *      交换两指针的值
     *      继续移动
     *      直至左右指针重合,此时为轴在数组中的位置
     *      递归至所有轴都找到自己的位置
     *
     * @param nums
     * @param begin
     * @param end
     */
    public void quicksort(int[] nums, int begin, int end) {
        if (begin > end) return;
        int pivot = nums[begin];
        int i = begin, j = end;
        while(i != j) {
            while(nums[j] >= pivot && j > i) {
                j--;
            }
            while(nums[i] <= pivot && j > i) {
                i++;
            }
            if (j > i) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[begin] = nums[i];
        nums[i] = pivot;
        quicksort(nums, begin, i - 1);
        quicksort(nums, i + 1, end);
    }

    /**
     * 堆排序
     * 大根堆(大顶堆):父节点比子节点大
     * 小根堆(小顶堆):父节点比子节点小
     *
     * @param nums
     */
    public void heapSort(int[] nums) {
        int right = nums.length - 1;
        buildMaxHeap(nums, right);
        for (int i = right; i >= 1; --i) {
            swap(nums, i, 0);
            right -= 1;
            maxHeapify(nums, 0, right);
        }
    }

    public void buildMaxHeap(int[] nums, int right) {
        for (int i = right / 2; i >= 0; --i) {
            maxHeapify(nums, i, right);
        }
    }

    public void maxHeapify(int[] nums, int i, int right) {
        for (; (i << 1) + 1 <= right;) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= right && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }

            if (rson <= right && nums[rson] > nums[large]) {
                large = rson;
            }

            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }
}
