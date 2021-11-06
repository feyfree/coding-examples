package com.feyfree.leetcode.p0310;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-height-trees/
 * 310. 最小高度树
 * 注意是返回: 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表
 * <p>
 * 解题思路: 一层一层的剥去叶子节点, 最后剩下的一个或者两个节点就是高度最小的根节点
 * 剥的次数就是它的高度。
 * <p>
 * 叶子节点的边连接数都是1，于是乎我们每次只要将度数为1的顶点拿出来，它们一定都是当前的叶子节点。
 * 为什么说当前呢？因为你把它周围的节点剥下后它才可能变成叶子结点，开始的时候它们并不是
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
        // 相当于每次往内部推进,
        while (!queue.isEmpty()) {
            result.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                // 加入当前节点
                result.add(current);
                // 查看它的邻居
                List<Integer> neighbors = adj.get(current);
                // 它的邻居的连接数都会减掉 1
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    // 如果去除了这个点的话, 连接数变成1 的话, 加入队列
                    if (degree[neighbor] == 1) {
                        // 最后的队列保存的都是
                        queue.offer(neighbor);
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] data = new int[][]{new int[]{0, 4}, new int[]{1, 5}, new int[]{2, 6}, new int[]{3, 7}, new int[]{4, 8}, new int[]{6, 8}, new int[]{7, 8}, new int[]{5, 8}};
        Solution solution = new Solution();
        System.out.println(solution.findMinHeightTrees(n, data));

    }
}
