package com.feyfree.leetcode.p0433;

import java.util.*;

/**
 * BFS 常规模版做法
 * 1. 预处理增加邻接集合
 *
 * @author leilei
 */
public class BfsCommonSolution {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> container = new HashSet<>(Arrays.asList(bank));
        if (!container.contains(end)) {
            return -1;
        }
        // 构建邻接集合
        Map<String, Set<String>> adj = new HashMap<>(container.size());
        // 构建距离数组
        Map<String, Integer> distTo = new HashMap<>(container.size());
        // 构建访问集合
        Set<String> visited = new HashSet<>(container.size());
        distTo.put(start, 0);
        for (String gene : container) {
            if (!gene.equals(start)) {
                distTo.put(gene, Integer.MAX_VALUE);
            }
        }
        container.add(start);
        for (String current : bank) {
            if (current.equals(start)) {
                continue;
            }
            // 处理 startGene
            if (canModify(current, start)) {
                Set<String> neighbors = adj.computeIfAbsent(start, k -> new HashSet<>());
                neighbors.add(current);
            }
            for (String target : bank) {
                if (!current.equals(target)) {
                    if (canModify(current, target)) {
                        Set<String> neighbors = adj.computeIfAbsent(current, k -> new HashSet<>());
                        neighbors.add(target);
                    }
                }
            }
        }
        // 构建访问对列
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            Set<String> neighbors = adj.get(current);
            if (neighbors != null) {
                for (String target : neighbors) {
                    if (target.equals(end)) {
                        return distTo.get(current) + 1;
                    }
                    if (!visited.contains(target)) {
                        visited.add(target);
                        distTo.put(target, distTo.get(current) + 1);
                        queue.add(target);
                    }
                }
            }
        }
        return -1;
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

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> data = map.computeIfAbsent(1, k -> new ArrayList<>());
        data.add(1);
        System.out.println(map.get(1));

    }
}
