package com.feyfree.leetcode.p71;


import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        if (path == null) {
            return "/";
        }
        int i = 0;
        boolean valid = false;
        Stack<String> pathStack = new Stack<>();
        while (i < path.length()) {
            if (path.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (path.charAt(i) != '/' && !valid) {
                return "/";
            }
            valid = true;
            StringBuilder current = new StringBuilder();
            int idx = i;
            while (idx < path.length()) {
                if (path.charAt(idx) == '/' && current.length() > 0) {
                    idx++;
                    continue;
                }
                current.append(path.charAt(idx));
                idx++;
                if (idx < path.length() && path.charAt(idx) == '/') {
                    break;
                }
            }
            i = idx;
            // 堆栈弹出
            String currentPath = current.toString();
            if ("/..".equals(currentPath)) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
                continue;
            }
            if (current.length() == 0 || "/".equals(currentPath) || "/.".equals(currentPath)) {
                continue;
            }
            pathStack.push(currentPath);
        }
        if (pathStack.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for (String s : pathStack) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String input = "/../";
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath(input));
    }
}