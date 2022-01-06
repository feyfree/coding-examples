package com.feyfree.leetcode.p0401;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-watch/
 *
 * @author leilei
 */
class Solution {


    public List<String> readBinaryWatch(int turnedOn) {
        int[] hours = new int[4];
        int[] minutes = new int[6];

        // i 表示是 hour 亮的灯数
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {
            if (i >= 4) {
                break;
            }
            int j = turnedOn - i;
            if (j <= 6) {
                List<Integer> hourResult = new ArrayList<>();
                dfs(hours, 0, 0, i, 11, hourResult);
                List<Integer> minuteResult = new ArrayList<>();
                dfs(minutes, 0, 0, j, 59, minuteResult);
                assembleResult(result, hourResult, minuteResult);
            }
        }
        return result;
    }


    private void assembleResult(List<String> result, List<Integer> h, List<Integer> m) {
        System.out.println(JSONObject.toJSONString(h));
        System.out.println(JSONObject.toJSONString(m));
        for (Integer hour : h) {
            for (Integer minutes : m) {
                result.add(hour + ":" + (minutes < 10 ? "0" + minutes : minutes));
            }
        }
    }


    /**
     * 深度优先搜索遍历数组
     *
     * @param data 输入数据
     * @param d    当前深度
     * @param n    总共需要
     */
    private void dfs(int[] data, int d, int s, int n, int limitTotal, List<Integer> result) {
        if (s > data.length) {
            return;
        }
        if (d == n) {
            int total = calculate(data);
            if (total <= limitTotal) {
                result.add(total);
                return;
            }
        }
        for (int i = s; i < data.length; i++) {
            data[i] = 1;
            dfs(data, d + 1, i + 1, n, limitTotal, result);
            data[i] = 0;
        }
    }

    private int calculate(int[] data) {
        int total = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                total += 1 << i;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readBinaryWatch(1);
    }
}