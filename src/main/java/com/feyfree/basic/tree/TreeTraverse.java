package com.feyfree.basic.tree;

/**
 * 二叉树的遍历
 *
 * @author leilei
 */
public class TreeTraverse {

    private TreeNode root;

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.right);
            System.out.println(root.val);
        }
    }
}

