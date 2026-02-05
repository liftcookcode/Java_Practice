package CS342.Homework2.java;


public class HOMEWORK_2 {
		
	
	public static void bottomInsert(Stack stk, int element) {

		  int temp;

		  if (stk.isEmpty()){

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

		stk.push(6);

		stk.push(9);

		stk.push(1);
		
		
		
		System.out.print("Original: ");
		stk.print();
		
		reverseStack(stk);
		
		System.out.print("Reversed: ");
		stk.print();
		
	}
	
}
