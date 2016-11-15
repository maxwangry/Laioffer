package com.laioffer.lab;

/**
 * Created by yanan on 2016/10/16.
 */
public class Remove_BST {

    static class TreeNode {

        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public static TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        // Look for the target node
        if (root.val < value) {
            root.right = removeNode(root.right, value);
            return root;
        } else if (root.val > value) {
            root.left = removeNode(root.left, value);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                if (root.right.left == null) {
                    root.right.left = root.left;
                    return root.right;
                } else {
                    TreeNode smallest = removeSmallest(root.right);
                    smallest.left = root.left;
                    smallest.right = root.right;
                    return smallest;
                }
            }
        }
    }

    private static TreeNode removeSmallest(TreeNode root) {
        TreeNode prev = root;
        root = root.left;
        while (root.left != null) {
            prev = root;
            root = root.left;
        }
        prev.right = prev.left.right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(40);
        TreeNode n4 = new TreeNode(35);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        TreeNode root = removeNode(n1, 20);
        System.out.print(root.val);
        System.out.print(root.left.val);
        System.out.print(root.right.val);
    }
}
