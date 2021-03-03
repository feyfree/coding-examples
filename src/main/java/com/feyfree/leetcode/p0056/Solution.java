package com.feyfree.leetcode.p0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. merge-intervals
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * Hint: intervals[i][0] <= intervals[i][1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> result = new ArrayList<>();
        for (int[] data : intervals) {
            if (result.size() == 0 || data[0] > result.get(result.size() - 1).get(1)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(data[0]);
                temp.add(data[1]);
                result.add(temp);
            } else {
                result.get(result.size() - 1).set(1, Math.max(result.get(result.size() - 1).get(1), data[1]));
            }
        }
        // list to array
        int[][] output = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            output[i][0] = result.get(i).get(0);
            output[i][1] = result.get(i).get(1);
        }
        return output;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 2}, {0, 2}};
        int[][] merge = solution.merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }
}
