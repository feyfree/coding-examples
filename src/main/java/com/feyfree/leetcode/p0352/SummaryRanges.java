package com.feyfree.leetcode.p0352;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 * 352. 将数据流变为多个不相交区间
 *
 * 当前是暴力解法可以使用二分搜索
 * 参考https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/solution/gong-shui-san-xie-yi-ti-shuang-jie-er-fe-afrk/
 *
 * @author leilei
 */
class SummaryRanges {

    private final boolean[] marked;

    public SummaryRanges() {
        this.marked = new boolean[4000 + 2];
    }

    public void addNum(int val) {
        marked[val] = true;
    }

    public int[][] getIntervals() {
        List<int[]> data = new ArrayList<>();
        int start = 0;
        int end;
        while (start < marked.length) {
            if (marked[start]) {
                end = start;
                for (int i = start + 1; i < marked.length; i++) {
                    if (marked[i]) {
                        end = i;
                    } else {
                        break;
                    }
                }
                data.add(new int[]{start, end});
                start = end + 1;
            } else {
                start++;
            }
        }
        int[][] result = new int[data.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = data.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges ranges = new SummaryRanges();
        ranges.addNum(1);
        System.out.println(JSONObject.toJSONString(ranges.getIntervals()));
        ranges.addNum(3);
        System.out.println(JSONObject.toJSONString(ranges.getIntervals()));
        ranges.addNum(7);
        System.out.println(JSONObject.toJSONString(ranges.getIntervals()));
        ranges.addNum(2);
        System.out.println(JSONObject.toJSONString(ranges.getIntervals()));
        ranges.addNum(6);
        System.out.println(JSONObject.toJSONString(ranges.getIntervals()));
    }
}
