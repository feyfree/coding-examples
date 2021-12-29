package com.feyfree.leetcode.p0332;

import java.util.*;

/**
 * 332. 重新安排行程
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 * <p>
 * topological sort
 * post order 遍历
 * 然后reverse
 *
 * @author leilei
 */
public class Solution {

    private final Map<String, PriorityQueue<String>> trips = new HashMap<>();

    private final List<String> routes = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> pair : tickets) {
            String src = pair.get(0);
            String dest = pair.get(1);
            PriorityQueue<String> queue = trips.get(src);
            if (queue == null) {
                queue = new PriorityQueue<>(this::compareString);
                queue.add(dest);
                trips.put(src, queue);
            } else {
                queue.add(dest);
            }
        }

        String start = "JFK";
        visit(start);
        Collections.reverse(routes);
        return routes;
    }

    private void visit(String src) {
        PriorityQueue<String> destinations = trips.get(src);
        while (destinations != null && !destinations.isEmpty()) {
            String dest = destinations.poll();
            visit(dest);
        }
        routes.add(src);
    }

    private int compareString(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return -1;
            } else if (a.charAt(i) > b.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("MUC", "LHR"));
        input.add(Arrays.asList("JFK", "MUC"));
        input.add(Arrays.asList("SFO", "SJC"));
        input.add(Arrays.asList("LHR", "SFO"));
        solution.findItinerary(input);

    }
}
