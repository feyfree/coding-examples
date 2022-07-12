package com.feyfree.leetcode.p0482;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/license-key-formatting/
 * 给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
 * <p>
 * 我们想要重新格式化字符串s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
 * <p>
 * 输入：S = "5F3Z-2e-9-w", k = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/license-key-formatting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        List<String> container = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (current.length() == k) {
                container.add(current.reverse().toString());
                current = new StringBuilder();
            }
            char c = s.charAt(i);
            if (c != '-') {
                current.append(Character.toUpperCase(c));
            }
        }
        if (current.length() > 0) {
            container.add(current.reverse().toString());
        }
        reverse(container);
        return String.join("-", container);
    }


    private void reverse(List<String> data) {
        int start = 0;
        int end = data.size() - 1;
        while (start < end) {
            String se = data.get(end);
            data.set(end, data.get(start));
            data.set(start, se);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String data = solution.licenseKeyFormatting("5F3Z-2e-9-w", 4);
        System.out.println(data);
    }
}