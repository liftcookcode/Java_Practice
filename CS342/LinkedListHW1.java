package CS342;

public class LinkedListHW1 {
    public  void DisplayLinkedList() {
		
		HOMEWORK_1 list = new HOMEWORK_1();
		
		// Insert data
		
		list.ascendingOrder(10);

		list.ascendingOrder(5);

		list.ascendingOrder(15);

		list.ascendingOrder(2);

		list.ascendingOrder(33);

		list.ascendingOrder(1);
		
		
		// print the list
		list.printList();
		
		// reverse the list
		list.reverse();
		
		// print reverse list
		list.printList();
		
		
	}
    
}
