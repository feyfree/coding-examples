package com.feyfree.leetcode.p0468;

/**
 * 有效的IP 地址
 *
 * @author leilei
 */
class Solution {
    String INVALID = "Neither";
    String IPV4 = "IPv4";
    String IPV6 = "IPv6";

    public String validIPAddress(String queryIP) {
        int ipv4 = 0;
        int ipv6 = 0;
        for (int i = 0; i < queryIP.length(); i++) {
            char c = queryIP.charAt(i);
            if (c == '.') {
                ipv4 += 1;
                continue;
            }
            if (c == ':') {
                ipv6 += 1;
                continue;
            }
            if (!Character.isLetterOrDigit(c) || (Character.isLetter(c) && Character.toLowerCase(c) - 'f' > 0)) {
                return INVALID;
            }
        }
        if (ipv4 > 0 && ipv4 < 4) {
            return validIPv4(queryIP) ? IPV4 : INVALID;
        }
        if (ipv6 > 0 && ipv6 < 8) {
            return validIPv6(queryIP) ? IPV6 : INVALID;
        }
        return INVALID;
    }


    private boolean validIPv4(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String part : split) {
            if (part.isEmpty()) {
                return false;
            }
            for (int j = 0; j < part.length(); j++) {
                if (!Character.isDigit(part.charAt(j))) {
                    return false;
                }
                // 不能有prefix 为0 的
                if (j == 0 && part.charAt(j) == '0' && part.length() > 1) {
                    return false;
                }
            }
            if (part.length() > 3) {
                return false;
            }
            int partNumber = Integer.parseInt(part);
            if (partNumber > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean validIPv6(String ip) {

        String[] split = ip.split(":");

        if (split.length != 8) {
            return false;
        }
        for (String part : split) {
            if (part.isEmpty()) {
                return false;
            }
            if (part.length() > 4) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
//        Solution solution = new Solution();
//        System.out.println(solution.validIPAddress(ip));

        String[] split = "12..3".split("\\.");
        System.out.println(split);
    }
}
