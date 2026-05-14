//Problem 1:
//
//Based on the attached LinkedList class, add a method
//
//public void sortedInsert(int value)
//
//to insert an element in ascending order ( the head element is the minimal), assuming the elements in 
//the list are already ordered.
//
//Prove that your implementation is correct in the main method.



//=============================================================


//
//Problem 2:
//
//Based on the attached LinkedList class, add a method
//
//public void reverse()
//
//to reverse the elements in the list. For example, if the elements are [1, 2, 3], after the reverse call, 
//the elements become [3, 2, 1].
//
//Hint: you can achieve this with one pass.
//
//Prove that your implementation is correct in the main method.



public class LinkedList {
	
	private static class Node {
		
		private int value;
		private Node next;
		
		public Node(int v, Node n) {
			value = v;
			next  = n;	
		}
	}
	
	private Node head;
	private int size = 0;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("EmptyList");
		}
		return head.value;
	}
	
	public void addHead(int value) {
		head = new Node(value, head);
		size++;
	}
	
	public void addTail(int value) {
		Node newNode = new Node(value, null);
		Node curr = head;
		
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		
		while (curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = newNode;
		size++;
	}
	
	
	// #######################################################
	// Problem 1: 
	// Insert value into sorted Linked List in ascending order	
	// #######################################################
	
	public void sortedInsert(int value) {
		
		Node newNode = new Node(value, null);
		
		// Base Case: empty list or insert before head
		if (head == null || value < head.value) {
			newNode.next = head;
			head = newNode;
			size++;
			return;
		}
		
		Node curr = head;
		
		// Find correct position
		while (curr.next != null && curr.next.value < value) {
			curr = curr.next;
		}
		
		// Insert Node
		
		newNode.next = curr.next;
		curr.next = newNode;
		
		size++;
	}
	
	

	// #######################################################
	// Problem 2: 
	// Reverse the Linked List in one pass	
	// #######################################################
	
	public void reverse() {
		
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while (curr != null) {
			
			next = curr.next; // save next Node
			
			curr.next = prev; // reverse pointer
			
			prev = curr; // move prev forward
			curr = next; // move curr forward
			
		}
		
		head = prev;
	}
	
	public void print() {
		
		Node temp = head;
		
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	public int removeHead() {
		if (isEmpty()) {
			throw new IllegalStateException("EmptyList");
		}
		
		int value = head.value;
		head = head.next;
		size--;
		
		return value;
	}
	
	public boolean deleteNode(int delValue) {
		Node temp = head;
		
		if(isEmpty()) {
			return false;
		}
		
		if (delValue == head.value) {
			head = head.next;
			size--;
			return true;
		}
		
		while (temp.next != null) {
			if (temp.next.value == delValue) {
				temp.next = temp.next.next;
				size--;
				return true;
			}	
		}
		
		return false;
	}
	
	public void deleteList() {
		head = null;
		size = 0;
	}
	
	// Main method
	
	public static void main(String[] args) {
		
		// Test sortedInsert
		
		System.out.println("Test sorting:");
		
		LinkedList list1 = new LinkedList();
		
		list1.sortedInsert(30);
		list1.sortedInsert(10);
		list1.sortedInsert(20);
		list1.sortedInsert(50);
		list1.sortedInsert(15);
		
		System.out.print("Sorted List: ");
		list1.print();
		
		
		// Test Reverse
		
		System.out.println("\nTesting reverse: ");
		
		LinkedList list2 = new LinkedList();
		
		list2.addTail(1);
		list2.addTail(2);
		list2.addTail(3);
		list2.addTail(4);
		
		System.out.print("Original List: ");
		list2.print();
		
		list2.reverse();
		
		System.out.print("Reversed List: ");
		list2.print();
		
	}
  	
	
	
	
	
	
	
	
}