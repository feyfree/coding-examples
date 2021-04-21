package com.feyfree.leetcode.p0116;


/**
 * Definition for a Node.
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

/**
 * 116 填充下一个指针
 *
 * @author leilei
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null || root.right == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
