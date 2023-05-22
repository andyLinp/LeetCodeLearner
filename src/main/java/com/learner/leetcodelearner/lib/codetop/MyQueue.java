package com.learner.leetcodelearner.lib.codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 用栈实现队列
 *
 * @Author: andy lin
 * @DATE: 2023/5/22
 */
public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out(){
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
