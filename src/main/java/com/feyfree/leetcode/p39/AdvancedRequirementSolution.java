package com.feyfree.leetcode.p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照顺序输出符合要求的组合
 *
 * 按照组合中的元素个数 从小到大 依次顺序输出
 *
 * 构造循环 元素个数可能是从 1 ~ target / candidates[0] 这个多， 在循环内部做dfs
 *
 * @author leilei
 */
public class AdvancedRequirementSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        for (int n = 1; n <= target / candidates[0]; ++n) {
            dfs(candidates, target, 0, 0, n, current, result);
        }
        return result;
    }

    public void dfs(int[] candidates, int target, int s, int d, int n, List<Integer> current, List<List<Integer>> result) {
        if (d == n) {
            if (target == 0) {
                result.add(current);
                return;
            }

        }

        for (int i = s; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            current.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, d + 1, n, current, result);
            current.remove(current.size() - 1);
        }
    }
}
