package com.feyfree.questions;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 把正整数 n 分解为 m 个不同的正整数，
 * 如 6 = 3 + 2 + 1，排在后面的数必须大于等于前面的数，输出所有方案。
 * <p>
 * https://oi-wiki.org/search/dfs/
 *
 * @author leilei
 */
public class CalculateSumCombination {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combination(int n, int m) {
        dfs(n, new ArrayList<>(), m);
        return result;
    }

    private void dfs(int remaining, List<Integer> current, int m) {
        if (remaining == 0) {
            if (current.size() == m) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        for (int i = current.size() > 0 ? current.get(current.size() - 1) : 1; i <= remaining; i++) {
            current.add(i);
            dfs(remaining - i, current, m);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CalculateSumCombination solution = new CalculateSumCombination();
        List<List<Integer>> data = solution.combination(100, 20);
        System.out.println(JSONObject.toJSONString(data));
        System.out.println(System.currentTimeMillis() - start);
    }
}
