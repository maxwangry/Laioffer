package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/11/14.
 */
public class Maximum_Path_Sum_Binary_Tree_I {

    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public static int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        helper(root, result);
        return result[0];
    }

    private static int helper(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int leftMax = helper(root.left, result);
        int rightMax = helper(root.right, result);

        if (root.left != null && root.right != null) {
            result[0] = Math.max(result[0], (leftMax + rightMax + root.key));
            return Math.max(leftMax, rightMax) + root.key;
        }
        return root.left == null ? rightMax + root.key : leftMax + root.key;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode n1 = new TreeNode(-2);
        TreeNode n2 = new TreeNode(-6);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(-4);
        TreeNode n5 = new TreeNode(-7);
        TreeNode n6 = new TreeNode(-5);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n5;
        n4.left = n6;

        TreeNode root2 = new TreeNode(-15);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(16);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(8);

        root2.left = n7;
        root2.right = n8;
        n7.left = n9;
        n7.right = n10;

        System.out.print(maxPathSum(root));
    }
}
