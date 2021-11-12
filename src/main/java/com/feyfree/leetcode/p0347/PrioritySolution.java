package com.feyfree.leetcode.p0347;

import java.util.*;

/**
 * 优先队列解法
 *
 * @author leilei
 */
public class PrioritySolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (Integer num : counts.keySet()) {
            queue.offer(new int[]{counts.get(num), num});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
