// Given the root of a binary tree, return the preorder traversal of its nodes' values.

package Leetcode;
import java.util.*;

import java.util.ArrayList;

public class PreOrderTraversalBST {

    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode node, List<Integer> result) {

        // If no nodes, end
        if (node == null) {
            return;
        }

        // Visit root
        result.add(node.val);

        // Visit left subtree
        preorder(node.left, result);

        // Visit right subtree
        preorder(node.right, result);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result = preorderTraversal(root);

        System.out.println("PreOrder Traversal: " + result);
    }


}
