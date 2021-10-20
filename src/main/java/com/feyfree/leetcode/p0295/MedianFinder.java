package com.feyfree.leetcode.p0295;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 * 295. 数据流的中位数 (有序列表)
 *
 * @author leilei
 */
public class MedianFinder {

    private PriorityQueue<Integer> smaller;
    private PriorityQueue<Integer> larger;

    public MedianFinder() {
        this.smaller = new PriorityQueue<>((a, b) -> (b - a));
        this.larger = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (smaller.isEmpty() || num <= smaller.peek()) {
            smaller.add(num);
        } else {
            larger.add(num);
        }

        if (smaller.size() < larger.size()) {
            smaller.add(larger.peek());
            larger.poll();
        } else if (smaller.size() - larger.size() == 2) {
            larger.add(smaller.peek());
            smaller.poll();
        }
    }

    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek();
        } else {
            return (smaller.peek() + larger.peek()) / 2.0;
        }
    }
}
