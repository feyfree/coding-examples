package com.feyfree.leetcode.p46;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author leilei
 */
public class CommonSolution {

    private boolean[] used;

    private int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        this.used = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, new ArrayList<>(), result);
        return result;

    }

    /**
     * 排列具体实现
     *
     * @param nums    输入数组
     * @param d       当前递归深度
     * @param current 当前生成的排列
     * @param result  输出的排列
     */
    private void permute(int[] nums, int d, List<Integer> current, List<List<Integer>> result) {
        if (d == n) {
            // leet-code上面需要new ArrayList<>(current)
            result.add(current);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            permute(nums, d + 1, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1, 2, 3};
        System.out.println(solution.permute(input));
    }
}
