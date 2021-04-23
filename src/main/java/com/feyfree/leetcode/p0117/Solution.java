package com.feyfree.leetcode.p0117;

/**
 * 117
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author leilei
 */
public class Solution {
    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNext(root.next);
        } else if (root.left != null) {
            root.left.next = getNext(root.next);
        } else if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        // right first
        // 因为是从左边访问右边 所以右边需要先结束
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node root) {
        if (null == root) {
            return null;
        } else if (null != root.left) {
            return root.left;
        } else if (null != root.right) {
            return root.right;
        }
        return getNext(root.next);
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
