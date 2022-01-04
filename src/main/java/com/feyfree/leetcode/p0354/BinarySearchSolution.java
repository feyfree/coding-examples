package com.feyfree.leetcode.p0354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分搜索解法
 * <p>
 *
 * @author leilei
 */
public class BinarySearchSolution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return e1[0] - e2[0];
            } else {
                return e2[1] - e1[1];
            }
        });

        // f 表示长度为 i 的最长上升子序列的中的最小「信封高度」
        List<Integer> f = new ArrayList<>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int h = envelopes[i][1];
            if (h > f.get(f.size() - 1)) {
                f.add(h);
            } else {
                int index = binarySearch(f, h);
                f.set(index, h);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
