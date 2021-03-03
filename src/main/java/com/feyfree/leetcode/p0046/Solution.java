package com.feyfree.leetcode.p0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author leilei
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> input = new ArrayList<>(nums.length);
        Arrays.stream(nums).forEach(input::add);
        permute(input, new ArrayList<>(), result);
        return result;
    }

    private void permute(List<Integer> remaining, List<Integer> prefix, List<List<Integer>> result) {
        if (remaining.size() == 0) {
            result.add(prefix);
        }
        for (int i = 0; i < remaining.size(); i++) {
            List<Integer> part1 = remaining.subList(0, i);
            List<Integer> part2 = remaining.subList(i + 1, remaining.size());
            List<Integer> part = new ArrayList<>();
            List<Integer> newPrefix = new ArrayList<>(prefix);
            newPrefix.add(remaining.get(i));
            part.addAll(part1);
            part.addAll(part2);
            permute(part, newPrefix, result);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }

}
