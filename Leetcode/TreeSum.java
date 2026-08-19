// Given the root of a binary tree and an integer targetSum, return true if the tree has a 
// root-to-leaf path such that adding up all the values along the path equals targetSum.

// A leaf is a node with no children.

package Leetcode;

public class TreeSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        // Empty tree has no root-to-leaf path
        if (root == null) {
            return false;
        }

        // If this is a leaf, check if it's value equals the remaining sum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recursively search left and right subtrees
        int remainingSum = targetSum - root.val;

        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }


    public static void main(String[] args) {

        /*
                 5
                / \
               4   8
              /   / \
             11  13  4
            /  \      \
           7    2      1

           Path: 5 -> 4 -> 11 -> 2
           Sum = 22
        */

           TreeNode root = new TreeNode(5);
           root.left = new TreeNode(4);
           root.right = new TreeNode(8);
   
           root.left.left = new TreeNode(11);
           root.left.left.left = new TreeNode(7);
           root.left.left.right = new TreeNode(2);
   
           root.right.left = new TreeNode(13);
           root.right.right = new TreeNode(4);
           root.right.right.right = new TreeNode(1);
   
           int targetSum = 22;
   
           System.out.println("Has path sum " + targetSum + "? "
                   + hasPathSum(root, targetSum));
   
           // Test a target that doesn't exist
           targetSum = 26;
   
           System.out.println("Has path sum " + targetSum + "? "
                   + hasPathSum(root, targetSum));
    }


    
}
