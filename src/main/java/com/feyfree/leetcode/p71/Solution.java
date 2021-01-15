package com.feyfree.leetcode.p71;

import com.feyfree.algs4.Stack;

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
            pathStack.push("/");
            StringBuilder current = new StringBuilder();
            for (int j = i + 1; j < path.length(); j++) {
                if (path.charAt(j) == '/' && current.length() == 0) {
                    continue;
                }
                if (path.charAt(j) == '.') {
                    current.append('.');
                }
                if (path.charAt(j) == '/' && current.length() > 0) {
                    break;
                }
            }
            // 堆栈弹出
            String currentPath = current.toString();
            if ("..".equals(currentPath)) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                    continue;
                }
            }
            if (current.length() == 0 || ".".equals(currentPath)) {
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
        String result = builder.toString();
        if (result.length() > 1 && result.endsWith("/")) {
            return result.substring(0, result.length() - 1);
        }
        return result;
    }
}