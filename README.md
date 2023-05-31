# LeetCodeLearner
Whether the experiment succeeds or fails, it should be an interesting learning experience.
Life is hard, learn from Afur.




# 二分查找
在升序数组 nums 中寻找目标值 target，对于特定下标i，比较nums[i] 和 target 的大小：
* 如果 nums[i] == target, 则下标 i 即为要寻找的下标;
* 如果 nums[i] < target, 则 target 只可能在下标 i 右侧;
* 如果 nums[i] > target, 则 target 只可能在下标 i 左侧;

基于上述**事实**, 可以在有序数组中使用二分查找目标值.

二分查找的做法是,定义查找的范围[left, right], 初始查找范围是整个数组. 每次取查找范围的中点 mid, 比较 nums[mid]和 target的大小,如果相等则 mid 即为要寻找的下标,如果不相等则根据 nums[mid] 和 target 的大小关系将查找范围缩小一半.

由于每次查找都会将查找范围缩小一半,因此二分查找的时间复杂度是O(log n),其中n是数组的长度.

二分查找的条件是查找范围不为空,即left <= right. 如果 target在数组中, 二分查找可以保证找到target,返回target在数组中的下标.
如果target不在数组中,则当left > right时结束查找, 返回-1.
```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if(num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
```
