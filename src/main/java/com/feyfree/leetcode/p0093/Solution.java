package com.feyfree.leetcode.p0093;

import java.util.ArrayList;
import java.util.List;

/**
 * p93 复原IP地址
 * <p>
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String ip = "";
        dfs(s, 0, ip, result);
        return result;
    }

    private void dfs(String s, int d, String ip, List<String> result) {
        int length = s.length();
        if (d == 4) {
            if (length == 0) {
                result.add(ip);
            }
            return;
        }
        if (!s.isEmpty()) {
            int end = Math.min(3, s.charAt(0) == '0' ? 1 : length);
            for (int i = 1; i <= end; i++) {
                String ss = s.substring(0, i);
                if (i == 3 && Integer.parseInt(ss) > 255) {
                    return;
                }
                dfs(s.substring(i), d + 1, ip + (d == 0 ? "" : ".") + ss, result);
            }
        }

    }

    public static void main(String[] args) {
        String input = "25525511135";
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses(input));

        String test = "1";
        System.out.println(test.substring(1));
    }
}