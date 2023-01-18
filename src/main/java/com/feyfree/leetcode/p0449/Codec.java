package com.feyfree.leetcode.p0449;

import com.feyfree.leetcode.commons.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leilei
 */
public class Codec {


    private static final String NULL = "NULL";

    /**
     * Encodes a tree to a single string.
     *
     * @param root 根节点
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        return sb.toString();
    }

    /**
     * Decodes your encoded data to tree.
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] container = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(container));
        return doDeserialize(list);
    }


    public void doSerialize(TreeNode root, StringBuilder container) {
        if (root == null) {
            container.append(NULL).append(",");
        } else {
            container.append(root.val).append(",");
            doSerialize(root.left, container);
            doSerialize(root.right, container);
        }
    }


    private TreeNode doDeserialize(List<String> list) {
        if (list.get(0).equals(NULL)) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = doDeserialize(list);
        root.right = doDeserialize(list);
        return root;
    }
}
