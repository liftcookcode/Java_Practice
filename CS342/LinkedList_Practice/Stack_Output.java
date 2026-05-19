package CS342.LinkedList_Practice;

//Problem 3:
//
//Based on the attached Stack.java file and the bottomInsert method shown in the class and slides (also copied below), 
//use recursion to implement the method
//
//public static void reverseStack(Stack stk)
//
//to reverse the input stack. You can put both bottomInsert and reverseStack in the same java file with the main method. 
//Test your code in the main method.
//
//Hint: after popping an item, the stack is smaller. Think about how to use the bottomInsert method.
//
//public static void bottomInsert(Stack stk, int element) {
//
//  int temp;
//
//  if (stk.isEmpty()){
//
//    stk.push(element);
//
//  }
//
//  else {
//
//    temp = stk.pop();
//
//    bottomInsert(stk, element);
//
//    stk.push(temp);
//
//  }
//
//}
package Homework2;

public class Stack_Output {
	
	
	public static void bottomInsert(Stack stk, int element) {
		
		int temp;
		
		if (stk.isEmpty()) {
			
			stk.push(element);
		}
		
		else {
			temp = stk.pop();
			bottomInsert(stk, element);
			stk.push(temp);
		}	
	}
	
	public static void reverseStack(Stack stk) {
		
		if (stk.isEmpty()) {
			return;
		}
		
		int temp = stk.pop();
		reverseStack(stk);
		bottomInsert(stk, temp);
	}
	
	public static void main(String[] args) {
		
		Stack stk = new Stack();
		
		stk.push(4);
		stk.push(5);
		stk.push(7);
		stk.push(12);
		stk.push(1);
		
		System.out.println("Original: ");
		stk.print();
		
		reverseStack(stk);
		
		System.out.println("Reversed: ");
		stk.print();
	}
 
}
