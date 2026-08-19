// Given a binary tree, determine if it is height-balanced.

package Leetcode;

public class BalancedTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Returns true if tree is balanced
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Checks height of tree
    // Returns -1 if tree isn't balanced
    public static int checkHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(node.right);
            if (rightHeight == -1) {
                return -1;
            } 
        
        // If height difference is greater than 1, tree is not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Height of current node
        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static void main(String[] args) {

        // Tree 1

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println("Tree 1 balanced: " +  "\n" + isBalanced(root1));


        // Tree 2

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);

        System.out.println("Tree 2 balanced: " + "\n" + isBalanced(root2));

    }
    
}
