package com.feyfree.leetcode.p0207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 队列解法
 * <p>
 * 1 选择⼀个⼊度为 0 的结点并直接输出。
 * 2 删除这个结点以及与它关联的所有边。
 * 3 重复步骤 (1) 和 (2)，直到找不到⼊度为 0 的结点。
 * <p>
 * 通常情况下，在实现的时候会维护⼀个队列以及每个结点的⼊度。在
 * 删除边的时候顺便把相应结点的⼊度减去，当这个结点⼊度为 0 的时
 * 候直接将其加⼊队列。
 *
 * @author leilei
 */
public class OtherSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        }
        return num == numCourses;
    }

}
