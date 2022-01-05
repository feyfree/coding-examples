package com.feyfree.leetcode.p0372;

class OtherSolution {
    private final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    int dfs(int a, int[] b, int u) {
        if (u == -1) {
            return 1;
        }
        return quickPow(dfs(a, b, u - 1), 10) * quickPow(a, b[u]) % MOD;
    }

    int quickPow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }
}


