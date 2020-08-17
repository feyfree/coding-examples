package com.feyfree.leetcode.p40;


import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        combination(candidates, 0, target, current, result);
        return result;
    }

    /**
     * 组合 dfs 递归
     *
     * @param nums    输入数组
     * @param s       递归深度
     * @param target  目标总和
     * @param current 当前的组合
     * @param result  输出的结果
     */
    private void combination(int[] nums, int s, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        // 实际上这个大循环是一个最左前缀
        for (int i = s; i < nums.length; i++) {
            int num = nums[i];
            if (num > target) {
                break;
            }
            // 如果相邻数字相等  进行跳跃， 因为该前缀的组合已经筛选完毕
            if (i > s && num == nums[i - 1]) {
                continue;
            }
            current.add(num);
            combination(nums, i + 1, target - num, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = solution.combinationSum2(candidates, 8);
        System.out.println(lists);
    }


}
