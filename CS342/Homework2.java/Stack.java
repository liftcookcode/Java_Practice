package CS342;


//Problem 3:
//
//Based on the attached Stack.java file and the bottomInsert method shown in the class and slides (also copied below),
// use recursion to implement the method
//
//public static void reverseStack(Stack stk)
//
//to reverse the input stack. You can put both bottomInsert and reverseStack in the same java file with the main method. 
// Test your code in the main method.
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




public class Stack {
	private int capacity;
	private int[] data;
	private int top = -1;

	public Stack() {
		this(1000);
	}

	public Stack(int s) {
		data = new int[s];
		capacity = s;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return top + 1;
	}

	public void print() {
		for (int i = top; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public void push(int value) {
		if (top + 1 == capacity) {
			throw new IllegalStateException("StackOverflowException");
		}
		top++;
		data[top] = value;
	}

	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("StackEmptyException");
		}
		int topVal = data[top];
		top--;
		return topVal;
	}

	public int top(){
		if (isEmpty()) {
			throw new IllegalStateException("StackEmptyException");
		}
		return data[top];
	}

}
