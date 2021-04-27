package com.feyfree.leetcode.p0119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 119 杨辉三角 2
 *
 * @author leilei
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> init = Collections.singletonList(1);
        if (rowIndex == 0) {
            return init;
        }
        List<Integer> current = new ArrayList<>();
        List<Integer> lastRow = init;
        for (int i = 1; i <= rowIndex; i++) {
            current.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                } else {
                    current.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            if (i == rowIndex) {
                return current;
            }
            lastRow = new ArrayList<>(current);
        }
        return current;
    }
}
