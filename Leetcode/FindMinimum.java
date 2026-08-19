// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the 
// nearest leaf node.

// Note: A leaf is a node with no children.

package Leetcode;

public class FindMinimum {

    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int minDepth(TreeNode root) {

        // Empty Tree
        if (root == null) {
            return 0;
        }

        // Leaf Node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Only right child exists
        if (root.left == null) {
            // return 1 + minDepth because minDepth doesn't include the first node of the recurrsive call
            return 1 + minDepth(root.right);
        }

        // Only left child exisits
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Both children exists
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              /     \
             4       5
                    /
                   6

        Shortest path to a leaf:
        1 -> 2 -> 4

        Minimum depth = 3
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);


        System.out.println("Minimum depth: " + "\n" + minDepth(root));
    }
    
}
