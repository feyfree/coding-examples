package com.feyfree.leetcode.p0151;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 普通解法
 * --WARNING--本地case 测试和线上测试有出入 不知道哪里出问题了--
 *
 * @author leilei
 */
public class CommonSolution {
    public String reverseWords(String s) {
        // 双指针
        int start = 0;
        int current = 0;
        int n = s.length();
        List<String> container = new ArrayList<>();
        while (current < n) {
            // 是否是最后
            boolean last = current == n - 1;
            char cc = s.charAt(current);
            if (last) {
                if (cc != ' ') {
                    container.add(s.substring(start, n));
                }
                break;
            } else {
                char next = s.charAt(current + 1);
                // 如果当前为空
                if (cc == ' ') {
                    start++;
                } else {
                    if (next == ' ') {
                        container.add(s.substring(start, current + 1));
                        start++;
                    }
                }
            }
            current++;
        }
        Collections.reverse(container);
        return String.join(" ", container);
    }

    public static void main(String[] args) {
        String s = " Bob Loves Alice ";
        Solution solution = new Solution();
        System.out.println((solution.reverseWords(s)));
    }
}
