package com.feyfree.leetcode.p68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null) {
            return res;
        }
        // l, r are the boundary of the window that constitutes one line
        int l = 0, r = 0;
        while (l < words.length) {
            int len = 0;
            while (r < words.length && len + words[r].length() + 1 <= maxWidth + 1) {
                len += words[r++].length() + 1;
            }
            int space = 1, extra = 0;
            if (r != words.length && r != l + 1) {
                space = (maxWidth - len + 1) / (r - l - 1) + 1;
                extra = (maxWidth - len + 1) % (r - l - 1);
            }
            StringBuilder sb = new StringBuilder(words[l++]);
            while (l < r) {
                for (int i = 0; i < space; i++) {
                    sb.append(' ');
                }
                if (extra-- > 0) {
                    sb.append(' ');
                }
                sb.append(words[l++]);
            }
            int remaining = maxWidth - sb.length();
            while (remaining-- > 0) {
                sb.append(' ');
            }
            res.add(sb.toString());
        }
        return res;
    }
}