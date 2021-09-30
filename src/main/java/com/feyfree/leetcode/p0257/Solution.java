package com.feyfree.leetcode.p0257;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 257. 二叉树的所有路径
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 *
 * @author leilei
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    public void dfs(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder current = new StringBuilder(path);
            current.append(root.val);
            // 当前节点是叶子节点
            if (root.left == null && root.right == null) {
                // 把路径加入到答案中
                paths.add(current.toString());
            } else {
                // 当前节点不是叶子节点，继续递归遍历
                current.append("->");
                dfs(root.left, current.toString(), paths);
                dfs(root.right, current.toString(), paths);
            }
        }
    }
}

