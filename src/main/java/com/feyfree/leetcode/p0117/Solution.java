package com.feyfree.leetcode.p0117;

/**
 * 117
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author leilei
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            }
        }
        if (root.next != null && root.right != null) {
            if (root.next.left != null) {
                root.right.next = root.next.left;
            } else {
                root.right.next = root.next.right;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}


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
