package com.feyfree.leetcode.p0467;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 * <p>
 * 循环字符： zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd
 * p 中的字串
 * <p>
 * WARNING: 这个DFS 会超时
 *
 * @author leilei
 */
class Solution {


    private final Set<String> result = new HashSet<>();


    public int findSubstringInWraproundString(String p) {
        // 相当于DFS 前缀, 如果前缀不是的话， 就避免继续搜索
        subsets(p.toCharArray());
        return result.size();
    }


    public void subsets(char[] data) {
        // 子集实际上就是  组合的集合
        int n = data.length;
        for (int i = 1; i <= n; i++) {
            dfs(n, i, 0, new StringBuilder(), data);
        }
    }

    private void dfs(int n, int k, int d, StringBuilder current, char[] nums) {
        if (!judgeConsequential(current.toString())) {
            return;
        }
        if (current.length() == k) {
            result.add(current.toString());
            return;
        }
        for (int i = d; i < n; i++) {
            current.append(nums[i]);
            dfs(n, k, i + 1, current, nums);
            current.deleteCharAt(current.length() - 1);
        }
    }


    private boolean judgeConsequential(String input) {
        if (input.length() == 1) {
            return true;
        }
        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            char before = input.charAt(i - 1);
            if (current - before < 0) {
                if (!(current == 'a' && before == 'z')) {
                    return false;
                }
            }
            if (current - before > 0) {
                if (current - before != 1) {
                    return false;
                }
            }
            if (current - before == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findSubstringInWraproundString("cac");
        System.out.println(result);
    }
}