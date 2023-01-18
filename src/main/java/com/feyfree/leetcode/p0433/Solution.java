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

    private int[] edgeTo;

    private int[] distTo;

    public int minMutation(String startGene, String endGene, String[] bank) {
        indexMap = new HashMap<>(bank.length);
        adj = new HashMap<>(bank.length);
        for (int i = 0; i < bank.length; i++) {
            indexMap.put(bank[i], i);
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
                    List<Integer> neighbors = adj.computeIfAbsent(i, k -> new ArrayList<>());
                    neighbors.add(j);
                }
            }
        }
        // 检查起点
        if (!indexMap.containsKey(startGene)) {
            indexMap.put(startGene, -1);
            // 将 startGene 用 -1 index 标记
            for (int i = 0; i < bank.length; i++) {
                String end = bank[i];
                if (canModify(startGene, end)) {
                    List<Integer> neighbors = adj.computeIfAbsent(-1, k -> new ArrayList<>());
                    neighbors.add(i);
                }
            }
        }
        // 进行bfs
        return 0;
    }

    private void bfs() {
        LinkedList<Integer> queue = new LinkedList<>();

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
