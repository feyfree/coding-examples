package com.feyfree.leetcode.p0399;

import java.util.*;

class Solution {

    private final Map<String, Map<String, Double>> CONTAINER = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); ++i) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            double k = values[i];
            CONTAINER.computeIfAbsent(x, l -> new HashMap<>()).put(y, k);
            CONTAINER.computeIfAbsent(y, l -> new HashMap<>()).put(x, 1.0 / k);
        }

        double[] ans = new double[queries.size()];
        Arrays.fill(ans, -1.0);
        for (int i = 0; i < queries.size(); ++i) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (CONTAINER.containsKey(x) && CONTAINER.containsKey(y)) {
                ans[i] = divide(x, y, new HashSet<>());
            }
        }
        return ans;
    }


    private double divide(String x, String y, Set<String> visited) {
        if (x.equals(y)) {
            return 1.0;
        }
        visited.add(x);
        for (String n : CONTAINER.get(x).keySet()) {
            if (!visited.contains(n)) {
                // 这地方标记防止死循环
                visited.add(n);
                double d = divide(n, y, visited);
                if (d > 0) {
                    return d * CONTAINER.get(x).get(n);
                }
            }
        }
        return -1.0;
    }
}