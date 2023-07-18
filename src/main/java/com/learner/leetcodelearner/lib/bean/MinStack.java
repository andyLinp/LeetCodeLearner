package com.learner.leetcodelearner.lib.bean;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Description
 *
 * @Author: andy lin
 * @DATE: 2023/7/17
 */
public class MinStack {
    private Deque<Integer> data = new ArrayDeque<>();
    private Deque<Integer> help = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int val) {
        data.addLast(val);
        if (help.isEmpty() || help.peekLast() >= val) {
            help.addLast(val);
        } else {
            help.addLast(help.peekLast());
        }
    }

    public void pop() {
        data.pollLast();
        help.pollLast();
    }

    public int top() {
        return data.peekLast();
    }

    public int getMin() {
        return help.peekLast();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
