package com.feyfree.leetcode.p68;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * p68 文本左右对齐
 *
 * @author leilei
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        //  put then arrange
        dfs(words, new ArrayList<>(), new StringBuilder(), result, 0, maxWidth);
        return result;
    }

    /**
     * 搜索
     *
     * @param words    输入
     * @param current  当前字符串
     * @param result   结果数组
     * @param d        索引 深度
     * @param maxWidth 最大长度
     */
    private void dfs(String[] words, List<String> current, StringBuilder temp, List<String> result, int d, int maxWidth) {
        if (d == words.length) {
            return;
        }
        if (temp.length() == maxWidth) {
            result.add(temp.toString());
            temp = new StringBuilder();
        }
        boolean flag = append(words[d], current, temp, maxWidth);
        if (flag) {
            dfs(words, current, temp, result, d + 1, maxWidth);
        } else {
            dfs(words, new ArrayList<>(), temp, result, d, maxWidth);
        }
    }

    /**
     * 目标数组追加数据
     *
     * @param data     追加的数据
     * @param current  当前的保存
     * @param temp     字符串拼接
     * @param maxWidth 最大的长度
     */
    private boolean append(String data, List<String> current, StringBuilder temp, int maxWidth) {
        int len = 0;
        for (String item : current) {
            len += item.length() + 1;
        }
        if (len + data.length() > maxWidth) {
            format(current, temp, maxWidth);
            return false;
        }
        // 进行format
        current.add(data);
        format(current, temp, maxWidth);
        return true;
    }

    private void format(List<String> current, StringBuilder temp, int maxWidth) {
        int num = current.size();
        if (num > 0) {
            if (num == 1) {
                char[] data = new char[maxWidth - current.get(0).length()];
                Arrays.fill(data, ' ');
                temp.append(current.get(0)).append(data);
                return;
            }
            int dataLen = 0;
            for (String item : current) {
                dataLen += item.length();
            }
            int room = maxWidth - dataLen;
            int average = room / (num - 1);
            int remaining = room - room / (num - 1) * (num - 1);
            for (int i = 0; i < current.size(); i++) {
                if (remaining > 0) {
                    char[] filling = new char[average + 1];
                    Arrays.fill(filling, ' ');
                    temp.append(current.get(i)).append(filling);
                    remaining--;
                } else {
                    if (i == current.size() - 1) {
                        temp.append(current.get(i));
                    } else {
                        char[] filling = new char[average + 1];
                        Arrays.fill(filling, ' ');
                        temp.append(current.get(i)).append(filling);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int max = 20;
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(words, max);
        for (String item : result) {
            System.out.println(item);
        }

    }
}
