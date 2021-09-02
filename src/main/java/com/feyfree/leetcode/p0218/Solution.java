package com.feyfree.leetcode.p0218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/the-skyline-problem/
 * 218. 天际线问题
 *
 * @author leilei
 */
class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        // {x, h, id}
        List<int[]> es = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            es.add(new int[]{buildings[i][0], buildings[i][2], i});
            es.add(new int[]{buildings[i][1], -buildings[i][2], i});
        }

        es.sort((e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);


        List<List<Integer>> ans = new ArrayList<>();

        MaxHeap heap = new MaxHeap(n);

        for (int[] e : es) {
            int x = e[0];
            int h = e[1];
            int id = e[2];

            boolean entering = h > 0;
            h = Math.abs(h);

            if (entering) {
                if (h > heap.max()) {
                    ans.add(Arrays.asList(x, h));
                }
                heap.add(h, id);
            } else {
                heap.remove(id);
                if (h > heap.max()) {
                    ans.add(Arrays.asList(x, heap.max()));
                }
            }
        }

        return ans;
    }

    private static class MaxHeap {
        // (key, id)
        private final List<int[]> nodes;

        // idx[i] = index of building[i] in nodes
        private final int[] idx;

        public MaxHeap(int size) {
            idx = new int[size];
            nodes = new ArrayList<>();
        }

        public void add(int key, int id) {
            idx[id] = nodes.size();
            nodes.add(new int[]{key, id});
            heapifyUp(idx[id]);
        }

        public void remove(int id) {
            int idxToEvict = idx[id];
            swapNode(idxToEvict, nodes.size() - 1);
            idx[id] = -1;
            nodes.remove(nodes.size() - 1);
            heapifyUp(idxToEvict);
            heapifyDown(idxToEvict);
        }

        public Boolean empty() {
            return nodes.isEmpty();
        }

        public int max() {
            return empty() ? 0 : nodes.get(0)[0];
        }

        private void heapifyUp(int i) {
            while (i != 0) {
                int p = (i - 1) / 2;
                if (i >= nodes.size() || nodes.get(i)[0] <= nodes.get(p)[0]) {
                    return;
                }
                swapNode(i, p);
                i = p;
            }
        }

        private void swapNode(int i, int j) {
            int tmpIdx = idx[nodes.get(i)[1]];
            idx[nodes.get(i)[1]] = idx[nodes.get(j)[1]];
            idx[nodes.get(j)[1]] = tmpIdx;

            int[] tmpNode = nodes.get(i);
            nodes.set(i, nodes.get(j));
            nodes.set(j, tmpNode);
        }

        private void heapifyDown(int i) {
            while (true) {
                int c1 = i * 2 + 1;
                int c2 = i * 2 + 2;

                if (c1 >= nodes.size()) {
                    return;
                }

                int c = (c2 < nodes.size()
                        && nodes.get(c2)[0] > nodes.get(c1)[0]) ? c2 : c1;

                if (nodes.get(c)[0] <= nodes.get(i)[0]) {
                    return;
                }

                swapNode(c, i);
                i = c;
            }
        }
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        Solution solution = new Solution();
        System.out.println(solution.getSkyline(buildings));
    }
}