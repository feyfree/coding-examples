package com.feyfree.leetcode.p0207;

import java.util.ArrayList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourse 门课程，记为0到numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * <p>
 * <p>
 * example 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * <p>
 * <p>
 * example 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释:总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * mention:
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <=numCourses <= 10^5
 *
 * <p>
 * 来源：力扣（Leet-Code）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] ints : prerequisites) {
            int course = ints[0];
            int prerequisite = ints[1];
            graph.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (dfs(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int curr, List<List<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) {
            return true;
        }
        if (visited[curr] == 2) {
            return false;
        }

        visited[curr] = 1;

        for (int next : graph.get(curr)) {
            if (dfs(next, graph, visited)) {
                return true;
            }
        }

        visited[curr] = 2;
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = new int[2][1];
        data[0] = new int[]{1, 0};
        data[1] = new int[]{0, 1};
        System.out.println(solution.canFinish(2, data));
    }
}
