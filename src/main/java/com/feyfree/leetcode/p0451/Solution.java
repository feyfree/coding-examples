package com.feyfree.leetcode.p0451;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 根据字符出现频率排序
 * <p>
 * 优先队列
 *
 * @author leilei
 */
public class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o2[1], o1[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int c = poll[0];
            int count = poll[1];
            while (count-- > 0) {
                sb.append((char) c);
            }
        }
        return sb.toString();
    }
}
