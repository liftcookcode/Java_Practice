// Given the root of a binary tree, return the inorder traversal of its nodes' values.


package Leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class BinaryTreeTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Left
        inorder(node.left, result);

        // Root
        result.add(node.val);

        // Right
        inorder(node.right, result);
    }

 
        public static void main(String[] args) {

            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(3);

            BinaryTreeTraversal solution = new BinaryTreeTraversal();

            List<Integer> result = solution.inorderTraversal(root);

            System.out.println("Inorder traversal: " + result);
        }
}
