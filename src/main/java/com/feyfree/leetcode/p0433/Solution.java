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
class Solution {

    private static final int GENE_LENGTH = 8;

    private static final int GENE_ENUM_NUM = 4;

    public int minMutation(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();
        char[] keys = {'A', 'C', 'G', 'T'};
        Set<String> container = new HashSet<>(Arrays.asList(bank));
        if (start.equals(end)) {
            return 0;
        }
        if (!container.contains(end)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                // 当前搜索节点
                String current = queue.poll();
                if (current != null) {
                    // 对每一位进行修改, 查找基因库是否存在这个 更改的基因
                    for (int j = 0; j < GENE_LENGTH; j++) {
                        for (int k = 0; k < GENE_ENUM_NUM; k++) {
                            if (keys[k] != current.charAt(j)) {
                                StringBuilder sb = new StringBuilder(current);
                                sb.setCharAt(j, keys[k]);
                                String next = sb.toString();
                                if (!visited.contains(next) && container.contains(next)) {
                                    if (next.equals(end)) {
                                        return step;
                                    }
                                    queue.offer(next);
                                    visited.add(next);
                                }
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
