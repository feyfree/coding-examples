package com.feyfree.leetcode.p0385;

class Solution {

    /**
     * 全局变量 字符数组
     */
    char[] chars;

    /**
     * 访问索引
     */
    int cur = 0;

    public NestedInteger deserialize(String s) {
        chars = s.toCharArray();
        //本身不是一个集合而是一个整数的情况
        if (chars[0] != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        //调用递归函数返回根集合
        return getNest();
    }

    public NestedInteger getNest() {
        NestedInteger nest = new NestedInteger();
        //num用于缓存用逗号分割的整数类型的值
        int num = 0;
        //当前记录的整数的符号，1代表整数，-1代表负数
        int sign = 1;
        while (cur != chars.length - 1) {
            cur++;
            if (chars[cur] == ',') {
                continue;
            }
            if (chars[cur] == '[') {
                //遇到[递归获取子集合
                nest.add(getNest());
            } else if (chars[cur] == ']') {
                return nest;
            } else if (chars[cur] == '-') {
                sign = -1;
            } else {
                //是数字的情况
                num = 10 * num + sign * (chars[cur] - '0');
                //如果下一个字符是,或者]说明当前数字已经记录完了，需要加入集合中
                if (chars[cur + 1] == ',' || chars[cur + 1] == ']') {
                    nest.add(new NestedInteger(num));
                    num = 0;
                    sign = 1;
                }
            }
        }
        return null;
    }
}

