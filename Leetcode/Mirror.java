// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

package Leetcode;



public class Mirror {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null -> symmetric
        if (left == null && right == null) {
            return false;
        }

        // One is null and the other isn't -> not symmetric
        if (left == null || right == null) {
            return false;
        }

        // Values must match, and opposite children must be mirrors

        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // Checks is the tree is symmetric
    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    } 

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);


        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("\nIs the tree symmetric? " + isSymmetric(root));
    }

    
}
