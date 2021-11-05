package com.feyfree.leetcode.p0310;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-height-trees/
 * 310. 最小高度树
 *
 * @author leilei
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 创建邻接矩阵
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            degree[a]++;
            degree[b]++;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            result = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                result.add(current);
                List<Integer> neighbors = adj.get(current);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }

            }
        }
        return result;
    }
}
