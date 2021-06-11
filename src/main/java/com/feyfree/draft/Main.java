package com.feyfree.draft;

public class Main {

    private int routes = 0;

    public int routes(int n) {
        if (n == 0 || (n & 1) == 1) {
            return 0;
        }
        dfs(n, 0, 0);
        return routes;
    }


    public void dfs(int n, int d, int current) {
        if (d == n && current % 10 == 0) {
            routes++;
            return;
        }
        if (d < n) {
            dfs(n, d + 1, current + 1);
            dfs(n, d + 1, current - 1);
        }
    }


    public static void main(String[] args) {
        Main solution = new Main();
        System.out.println(solution.routes(0));
    }
}
