package com.feyfree.leetcode.p0210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 * https://leetcode-cn.com/problems/course-schedule-ii/
 *
 * @author leilei
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = canFinish(numCourses, prerequisites);
        if (order != null) {
            int[] result = new int[order.size()];
            for (int i = 0; i < order.size(); i++) {
                result[order.size() - i - 1] = order.get(i);
            }
            return result;
        }
        return new int[0];
    }


    public List<Integer> canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        // 记录加入拓扑排序的顶点数
        int num = 0;
        // 度数为 0 的队列
        Queue<Integer> q = new LinkedList<>();
        // 顶点度数列表 (入度)
        int[] degrees = new int[numCourses];
        // 构建的相邻顶点列表
        List<List<Integer>> data = new ArrayList<>(numCourses);

        // 构建顶点列表(图的基础)
        for (int i = 0; i < numCourses; i++) {
            data.add(new ArrayList<>());
        }

        // 将每一条边加入对应的相邻列表
        for (int[] edge : prerequisites) {
            int pre = edge[0];
            int next = edge[1];
            data.get(pre).add(next);
            degrees[next]++;
        }

        // 将所有入度为 0 的顶点加入 队列
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            // 取队列 队首
            int u = q.poll();
            for (int i = 0; i < data.get(u).size(); i++) {
                int v = data.get(u).get(i);
                // 入度 减 1
                degrees[v]--;
                if (degrees[v] == 0) {
                    q.add(v);
                }
            }
            // 关联边 清空
            data.get(u).clear();
            // 顶点数自增
            num++;
            order.add(u);
        }
        if (num == numCourses) {
            return order;
        }
        return null;

    }

}
