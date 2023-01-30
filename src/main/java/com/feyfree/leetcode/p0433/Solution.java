package com.feyfree.leetcode.p0433;

import java.util.*;

/**
 * 433. 最小基因变化
 * https://leetcode.cn/problems/minimum-genetic-mutation/
 * <p>
 * 感觉是 BFS 搜索
 *
 * @author leilei
 */
public class Solution {

    private Map<String, Integer> indexMap;
    private Map<Integer, List<Integer>> adj;

    private int[] marked;

    private int[] distTo;

    public int minMutation(String startGene, String endGene, String[] bank) {

        marked = new int[bank.length + 1];
        distTo = new int[bank.length + 1];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        indexMap = new HashMap<>(bank.length);
        adj = new HashMap<>(bank.length);
        indexMap.put(startGene, 0);
        for (int i = 0; i < bank.length; i++) {
            indexMap.put(bank[i], i + 1);
        }
        // 终点不存在
        if (!indexMap.containsKey(endGene)) {
            return -1;
        }
        // 构建邻居数组
        for (int i = 0; i < bank.length; i++) {
            for (int j = i + 1; j < bank.length; j++) {
                String a = bank[i];
                String b = bank[j];
                if (canModify(a, b)) {
                    // 加入 临接数组
                    List<Integer> neighbors = adj.computeIfAbsent(i + 1, k -> new ArrayList<>());
                    neighbors.add(j + 1);
                }
            }
        }
        // startGene 处理
        for (int i = 0; i < bank.length; i++) {
            String end = bank[i];
            if (canModify(startGene, end)) {
                List<Integer> neighbors = adj.computeIfAbsent(0, k -> new ArrayList<>());
                neighbors.add(i);
            }
        }
        // 进行bfs
        bfs();
        Integer endIndex = indexMap.get(endGene);
        return distTo[endIndex + 1];
    }

    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        marked[0] = 1;
        distTo[0] = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            List<Integer> neighbors = adj.get(poll);
            if (neighbors != null) {
                for (Integer neighbor : neighbors) {
                    if (marked[neighbor] == 0) {
                        distTo[neighbor] = distTo[poll] + 1;
                        marked[neighbor] = 1;
                        queue.add(neighbor);
                    }
                }
            }
        }

    }

    private boolean canModify(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            char ac = a.charAt(i);
            char bc = b.charAt(i);
            if (ac != bc) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}
