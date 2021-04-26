package com.feyfree.leetcode.p0118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 118 杨辉三角
 *
 * @author leilei
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Collections.singletonList(1));
        generateRow(1, numRows, result);
        return result;
    }


    private void generateRow(int currentRow, int target, List<List<Integer>> result) {
        if (currentRow >= target) {
            return;
        }
        currentRow++;
        List<Integer> row = new ArrayList<>(currentRow);
        List<Integer> lastRow = result.get(result.size() - 1);
        for (int i = 0; i < currentRow; i++) {
            if (i == 0 || i == currentRow - 1) {
                row.add(1);
            } else {
                row.add(lastRow.get(i - 1) + lastRow.get(i));
            }
        }
        result.add(row);
        generateRow(currentRow, target, result);
    }
}
