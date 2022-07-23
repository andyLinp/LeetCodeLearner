package com.learner.leetcodelearner.lib.easy;

import com.learner.leetcodelearner.lib.bean.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @AUTHOR lp
 * @DATE 2022/7/232:26 PM
 * @VERSION 1.0
 */
public class No_234 {


    /**
     * 思路：
     * 将节点遍历一遍 取出每个值至于数组中
     * 双指针遍历数组 最大时间复杂度O（3/2n）=》 O（n）
     *
     *
     * ps：
     * 使用ArrayList接受可以通过 如果用LinkedList 将超时
     * LinkedList get方法为有序对节点遍历 时间复杂度增加
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }





}
