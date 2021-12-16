package com.feyfree.leetcode.p0388;

/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 388. 文件的最长绝对路径
 * <p>
 * 这个不需要去思考如何构建树, 如何搜索
 * 因为输入的形式上面， 一次遍历实际上就能计算出结果
 * 每次遍历的时候都会更新前一层的长度, 这种更新相当于是为下一个文件/文件夹保存当前的路径长度
 *
 * @author leilei
 */
class Solution {
    public int lengthLongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int res = 0;
        //从1开始，第0层就是0
        int[] sum = new int[input.length() + 1];
        // 计算当前在第几层（从第一层开始，没有\t就是第一层）
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 2;
            // 计算当前这一行的长度
            int len = s.length() - (level - 1);
            if (s.contains(".")) {
                res = Math.max(res, sum[level - 1] + len);
            } else {
                //是目录，要+1，目录有个/的
                sum[level] = sum[level - 1] + len + 1;
            }
        }
        return res;
    }
}
