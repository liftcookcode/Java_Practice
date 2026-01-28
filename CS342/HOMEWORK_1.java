package CS342;

public class HOMEWORK_1 {

    private Node head;
	
	// Node class for linked list
	private static class Node {
		int items;
		Node next;
		
		Node(int items) {
			this.items = items;
			this.next = null;
		}
	}
	
	// Insert values in ascending order
	public void ascendingOrder(int val) {
		
		Node newNode = new Node(val);
		
		// Case 1: empty list or insert before head
		
		if (head == null || val <= head.items) {
			newNode.next = 	head;
			head = newNode;
			return;
		}
		
		
		// Case 2: Insert somewhere after head
		
		Node current = head;
		while (current.next != null && current.next.items < val) {
			current = current.next;
			
		}
		
		newNode.next = current.next;
		current.next = newNode;
		
	}
	
	// Print the list
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.items + " -> ");
			current = current.next;
		}
		
		System.out.println("null");
		
		
		
	}
	
	
	// Insert at end of Linked List
	
	public void add(int val) {
		Node newNode = new Node(val);
		
		if (head == null) {
			head = newNode;
			return;
		}
		
		Node current = head;
		
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
		
	}
	
	// Reverse the list 
	
	public void reverse() {
		
		Node prev = null; 
		Node current = head;
		Node next;
		
		while (current != null) {
			
			next = current.next; // store next node
			current.next = prev; // reverse link
			prev= current; 		// move prev forward
			current = next;		// move current forward
			
		}
		
		head = prev;
	}
	
	public void printReverseList() {
		Node current = head;
		
		while (current != null) {
			System.out.print(current.items + " ");
			current = current.next;
		}
		
		System.out.println();
	}
	
	// Test the Linked List with other class
	public static void main(String[] args) {
		LinkedListHW1 LinkedList = new LinkedListHW1();
			
		LinkedList.DisplayLinkedList();
	}
    
}
