package CS342.LinkedList_Practice;

]//Problem 2:
//
//Based on the attached CircularLinkedList.java, implement the following methods:
//
//public void addTail(int value) // add a node at the tail
//
//public boolean search(int data) // search node storing the input value. Returns true if found; false otherwise
//
//public int removeHead() // remove the head node and returns the value stored in the head node
//
//public boolean removeNode(int key) // remove the first node storing the input value. Returns true if found and removed; 
//false otherwise.
//
//Make the above method part of the implementation of the CircularLinkedList class and test your code in the main method.


public class CircularLinkedList {
	private Node tail = null; // if list is empty
	private int size = 0; // tracks size for LL
	
	
	private static class Node {
		private int value;
		private Node next;
		
		// Constructor Class
		public Node(int v, Node n) {
			value = v;
			next = n;
		}
		
	}
	
	private int size() {
		return size;
	
	}
	
	// checks if LL is empty
	private boolean isEmpty() {
		return size == 0;
	
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Empty List");
		}
		return tail.next.value;
	}
	
	public void addHead(int value) {
		Node temp = new Node(value, null); // create a node to start with
		if (isEmpty()) { // checks if list is empty
			tail = temp;
			temp.next = temp;
		} else { //  if list isn't empty, add head node while keeping tail the same
			temp.next = tail.next;
			tail.next = temp;
		}
		size++;
	
	}
	// Same as addHead but for tail
	public void addTail(int value) {
		
		Node temp = new Node(value, null);
		
		if (isEmpty()) {
			tail = temp;
			temp.next = temp;
		}
		else {
			temp.next = tail.next;
			tail.next = temp;
			tail = temp;
		}
		
		size++;
	}
	
	public boolean search(int data) {
		
		if(isEmpty()) {
			return false;
		}
		
		Node current = tail.next;
		
		do { // used a do while loop, because circular list are never null
			if(current.value == data) {
				return true;
			}
			current = current.next;
			
		} while (current != tail.next);
			return false;
		}
		
	public int removeHead() {
		
		// Case if LL is empty
		if(isEmpty()) {
			throw new IllegalStateException("Empty List");
			
		}
		Node head = tail.next; // save head node
		int removedValue = head.value; // save value
		
		// Case 1: if only one node in LL
		if (tail == head) {
			tail = null; // removing leaves LL empty
		} else {
			tail.next = head.next; // Case 2: multiple nodes in LL
		}
		
		size--;
		
		return removedValue;
	}
	
	
	public boolean removeNode(int data) {
		
		if(isEmpty()) {
			return false;
		}
		// Two pointers 
		Node current = tail.next;
		Node prev = tail;
		
		do {
			if (current.value == data) {
				// Case 1: if only one node in LL, current is tail and head(tail.next)
				if (current == tail && current == tail.next) {
					tail = null;
				}
				
			} else if (current == tail) { // Case 2: removes tail node
				prev.next = current.next;
				tail = prev;
			} else { // Case 3: removes middle node/head
				prev.next = current.next;
			}
			
			size--;
			return true;
			
		} while (current != tail.next); // loops through entire list and stops after full loop
		
	}
	
	public void print() {
		// empty list
		if (isEmpty()) {
			System.out.print("Empty List: ");
			return;
		}
		
		Node temp = tail.next;
		// print everything except tail first
		while (temp != tail) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println(temp.value);
	}
	
	
	public static void main(String[] args) {
		
		CircularLinkedList list = new CircularLinkedList();
		
		
		// Test for empty LL
		System.out.println("Initial List: ");
		list.print();
		
		// Add head node
		list.addHead(10);
		list.addHead(20);
		list.addHead(30);
		
		list.print();
		
		// Add tail
		System.out.println("\nAdding tail:");
		list.addTail(40);
		list.addTail(60);
		
		list.print();
		
		// Peek
		System.out.println("\n Peek (head val): ");
		System.out.println(list.peek());
		
		
		// Search
		System.out.println("\nSearching: ");
		System.out.println("Find 10: " + list.search(10));
		System.out.println("Find 10: " + list.search(1));
		
		// Remove Head
		System.out.println("\nRemoving Head: ");
		int removeHead = list.removeHead();
		System.out.println("Removed: " + removeHead);
		
		list.print();
		
	
	}

}
