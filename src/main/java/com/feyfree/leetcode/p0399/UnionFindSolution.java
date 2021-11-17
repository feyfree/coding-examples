package com.feyfree.leetcode.p0399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UnionFind 算法
 *
 * @author leilei
 */
public class UnionFindSolution {
    static class Node {
        public String parent;
        public double ratio;

        public Node(String parent, double ratio) {
            this.parent = parent;
            this.ratio = ratio;
        }
    }

    static class UnionFindSet {
        private final Map<String, Node> parents = new HashMap<>();

        public Node find(String s) {
            if (!parents.containsKey(s)) {
                return null;
            }
            Node n = parents.get(s);
            if (!n.parent.equals(s)) {
                Node p = find(n.parent);
                n.parent = p.parent;
                n.ratio *= p.ratio;
            }
            return n;
        }

        public void union(String a, String b, double ratio) {
            boolean hasA = parents.containsKey(a);
            boolean hasB = parents.containsKey(b);
            if (!hasA && !hasB) {
                parents.put(a, new Node(b, ratio));
                parents.put(b, new Node(b, 1.0));
            } else if (!hasA) {
                parents.put(a, new Node(b, ratio));
            } else if (!hasB) {
                parents.put(b, new Node(a, 1.0 / ratio));
            } else {
                Node rA = find(a);
                Node rB = find(b);
                parents.put(rA.parent,
                        new Node(rB.parent, ratio / rA.ratio * rB.ratio));
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFindSet u = new UnionFindSet();

        for (int i = 0; i < equations.size(); ++i) {
            u.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); ++i) {
            Node rx = u.find(queries.get(i).get(0));
            Node ry = u.find(queries.get(i).get(1));
            if (rx == null || ry == null || !rx.parent.equals(ry.parent)) {
                ans[i] = -1.0;
            } else {
                ans[i] = rx.ratio / ry.ratio;
            }
        }
        return ans;
    }
}
