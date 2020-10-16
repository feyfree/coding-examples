package com.feyfree.leetcode.p703;

import java.util.PriorityQueue;

/**
 * 数据流的第K个大的元素
 *
 * @author leilei
 */
class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);
        for (int a : nums) {
            add(a);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (pq.peek() != null && pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
