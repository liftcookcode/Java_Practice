//Problem 1:
//
//Based on the attached Tree.java, write a method
//
//public void insertIT(int value)
//
//to insert a node to the tree using iterative (rather than recursive) method. Test your code in the main method


//===============================================


//Problem 2:
//
//Based on the attached Tree.java, write a method
//
//public void printBreadthFirst()
//
//to print the tree by level, i.e. print the root node first, then level 1, then level 2, etc.
//
//Hint: remember how we solve the chess knight problem? To do breadth first traversal, think about queue.
//
//Note that you need the ArrayDeque in JCF so you can add/remove a Node to the queue:
//
//ArrayDeque<Node> que = new ArrayDeque<Node>(); 
//
//Test your code in the main method.


//================================================


//Problem 3:
//
//Based on the attached Tree.java, write a method
//
//public Tree copyTree()
//
//to return a copy of the current tree.
//
//Hint: a recursive method is easier. You need a helper method
//
//private Node copyTree(Node curr)
//
//In copyTree(), you can create an empty tree first; then call copyTree(Node curr) with the current root 
//node and return the root node of the copied tree. Finally, assign the returned new root to the root of the new tree.
//
//Test your code in the main method.


import java.util.ArrayDeque;



public class Tree {
	
	private Node root; // reference to root node
	
	private static class Node {
		
		private int value; // data stored in node
		private Node left; // left child of root
		private Node right; // right child of root
		
		
		// constructor 1
		public Node(int v, Node l, Node r) {
			
			// stores appropriate values
			value = v;
			left = l;
			right = r;
		}
		
		// constructor 2:
		// creates a node with no children
		public Node(int v) {
			
			value = v;
			left = null;
			right = null;
		}
	}
	
	// Tree constructor
	public Tree() {
		
		root = null; // starts with empty tree
	}
	
	public void printPreOrder() {
		
		printPreOrder(root); // starts traversal at root
		System.out.println(); // moves to next line
	}
	
	// recursively visits nodes
	private void printPreOrder(Node node) {
		
		// stops if node doesn't exist
		if (node != null) {
			System.out.print(node.value + " ");
			printPreOrder(node.left); // visit left subtree
			printPreOrder(node.right); // visit right subtree
		}
	}
	
	// Recursive insertion
	public void insert(int value) {
		
		root = insert(root, value); // starts insertion at root
	}
	
	// recursive insert helper -> returns updated subtree root
	private Node insert(Node node, int value) {
		
		// found insertion location
		if (node == null) {
			node = new Node(value, null, null); // creates new node
		}
		else { // keep searching
			if (node.value > value) { // if new value smaller -> insert in left subtree
				node.left = insert(node.left, value);
			} else { // if new value is greater -> insert in right subtree
				node.right = insert(node.right, value);
			}
		}
		
		return node; // returns subtree root
		
	}
	
	public boolean find(int value) {
		
		return find(root, value);
	}
	
	// recursive search
	private boolean find(Node node, int value) {
		
		// reached end of branch
		if (node == null) {
			return false;
		}
		// values match
		else if (node.value == value) {
			return true;
		}
		// target smaller
		else if (value < node.value) {
			return find(node.left, value);
		}
		// target larger
		else {
			return find(node.right, value);
		}
		
	}
	
	public void printInOrder() {
		
		printInOrder(root);
		System.out.println();
	}
	
	private void printInOrder(Node node) {
		
		if (node != null) {
			printInOrder(node.left); // visit left
			System.out.print(node.value + " "); // print value
			printInOrder(node.right); // visit right
		}
	}
	
	public void printPostOrder(Node node) {
		
		if (node != null) {
			printPostOrder(node.left); // visit left
			printPostOrder(node.right); // visit right
			System.out.print(node.value + " "); // print last node
		}
	}
	
	// starts count of nodes in BST
	public int numNodes() {
		
		return numNodes(root);
	}
	
	public int findMin() {
		
		Node node = root; // start at root
		
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		while (node.left != null) { // keep moving left
			node = node.left; // leftmost node is smallest
		}
		
		return node.value; // return min value
	}
	
	public void findMinNodeAndPrintValue() {
		System.out.println(findMinNode(root).value);
	}
	
	// same as findMin but returns node instead 
	public Node findMinNode(Node curr) {
		
		Node node = curr;
		
		if (node == null) {
			return null;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public int numNodes(Node curr) {
		
		// empty subtree contributes 0
		if (curr == null) {
			return 0;
		}
		else {
			return (1 + numNodes(curr.right) + numNodes(curr.left)); // current subtree 1, right
		}
	}
	
	public void deleteNode(int value) {
		
		root = deleteNode(root, value); // updates root if necessary
	}
	
	// recursive helper
	private Node deleteNode(Node node, int value) {
		
		if (node != null) {
			// delete this node
			if (node.value == value) {
				// Case 1: Leaf node
				if (node.left == null && node.right == null) {
					return null; // delete
				} else {
					// Case 2: Only right child
					if (node.left == null) { // replace node with right child
						return node.right;
					}
					// Case 3: Only left child
					if (node.right == null) { // replace node with left child
						return node.left;
					}
					// Case 4: Two Children 
					Node minNode = findMinNode(node.right); // find smallest node in the right subtree
					int minValue = minNode.value; // get the value
					node.value = minValue; // copy value
					node.right = deleteNode(node.right, minValue); // delete duplicate value
				}
			}else {
				if (node.value > value) { // if value is smaller
					node.left = deleteNode(node.left, value);
				}
				else { // if value is larger
					node.right = deleteNode(node.right, value);
				}
			}
		}	
		return node;
	}
	
	// Problem 1 -> inserIT
	public void insertIT(int value) {
		
		Node newNode = new Node(value); // create new node
		
		// empty tree
		if (root == null) {
			root = newNode;
			return;
		}
		
		Node curr = root; // begin searching
		
		while (true) { // move down tree
			
			// go left
			if (value < curr.value) {
				// if left spot available
				if (curr.left == null) {
					curr.left = newNode; // if not available, continue
					return;
				}
				
				curr = curr.left;	
			}
			// same logic as left but right
			else {
				
				if (curr.right == null) {
					curr.right = newNode;
					return;
				}
				
				curr = curr.right;
			}
		}
		
	}
	
	// Problem 2 -> printBreadthFirst
	
	public void printBreadthFirst() {
		
		if (root == null) {
			return;
		}
		
		ArrayDeque<Node> que = new ArrayDeque<Node>(); // create queue
		
		que.add(root); // add root in queue
		
		while (!que.isEmpty()) { // continue until loop is empty
			
			Node curr = que.remove(); // remove front node
			
			System.out.print(curr.value + " ");
			
			// add left child, is exist
			if (curr.left != null) {
				que.add(curr.left);
			}
			// add right child, if exist
			if (curr.right != null) {
				que.add(curr.right);
			}
		}
		
		System.out.println();
	}
	
	
	// Problem 3 -> copyTree
	public Tree copyTree() {
		
		Tree newTree = new Tree(); // create new tree
		
		newTree.root = copyTree(root); // copy every node
		
		return newTree;
	}
	
	// recursive helper
	private Node copyTree(Node curr) {
		
		// Base Case
		if (curr == null) {
			return null;
		}
		
		Node newNode = new Node(curr.value); // create new node
		
		newNode.left = copyTree(curr.left); // copy left
		newNode.right = copyTree(curr.right);// copy right
		
		return newNode;
	}
	
	
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		
		tree.insertIT(90);
		tree.insertIT(76);
		tree.insertIT(60);
		tree.insertIT(48);
		tree.insertIT(33);
		tree.insertIT(21);
		
		System.out.println("InOrder: ");
		tree.printInOrder();
		
		System.out.println("\nPreOrder: ");
		tree.printPreOrder();
		
		// Breadth First Search
		System.out.println("\nBreadth First: ");
		tree.printBreadthFirst();
		
		// Copy Tree
		Tree copiedTree = tree.copyTree();
		
		System.out.println("\nCopied Tree InOrder: ");
		copiedTree.printInOrder();
		
		
	
	}
		
	
}

