package com.feyfree.questions;

/**
 * 一个环上有10个点，编号为0-9，
 * 从0点出发，每步可以顺时针到下一个点，也可以逆时针到上一个点，
 * 求：经过n步又回到0点有多少种不同的走法？
 * 举例：
 * 如果n = 1，则从0出发只能到1或者9，不可能回到0，共0种走法
 * 如果n = 2，则从0出发有4条路径：0->1->2, 0->1->0, 0->9->8, 0->9->0，其中有两条回到了0点，故一共有2种走法。
 *
 * @author leilei
 */
public class ByteDanceQ1 {

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
        ByteDanceQ1 solution = new ByteDanceQ1();
        System.out.println(solution.routes(0));
    }
}
