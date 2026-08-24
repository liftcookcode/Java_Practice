// Given the root of a binary tree, return the postorder traversal of its nodes' values.

// Example 1:

// Input: root = [1,null,2,3]

// Output: [3,2,1]

package Leetcode;
import java.util.*;


public class PostOrderTraversalBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    } 

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(TreeNode root, List<Integer> result) {

        // If no nodes, end
        if (root == null) {
            return;
        }

        // Visit left subtree
        postOrder(root.left, result);

        // Visit right subtree
        postOrder(root.right, result);

        // Visit root
        result.add(root.val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = postOrderTraversal(root);

        System.out.println("Post Order: " + result);
    }
    
}
