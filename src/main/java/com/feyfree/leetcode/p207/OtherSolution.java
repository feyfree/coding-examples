package com.feyfree.leetcode.p207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 队列解法
 *
 * @author leilei
 */
public class OtherSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int num = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] degrees = new int[numCourses];
        List<List<Integer>> data = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            data.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int pre = edge[0];
            int next = edge[1];
            data.get(pre).add(next);
            degrees[next]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i < data.get(u).size(); i++) {
                int v = data.get(u).get(i);
                degrees[v]--;
                if (degrees[v] == 0) {
                    q.add(v);
                }
            }
            data.get(u).clear();
            num++;
        }
        return num == numCourses;
    }

}
