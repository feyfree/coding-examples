package com.feyfree.leetcode.p225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @author leilei
 */
public class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while(!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        return q2.
    }

    /**
     * Get the top element.
     */
    public int top() {

    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */