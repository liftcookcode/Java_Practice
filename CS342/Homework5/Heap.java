//Problem 1:
//
//Write a method:
//
//public static boolean isMinHeap(int[] arr, int size)
//
//to check if the input array arr represents a min-heap.
//
//Hint: you do not need a Heap class to do this. All you need to do is to check that the value of any parent 
//index is less than or equal to its value at child index. If you forget the relationship between a parent 
//index and its child index, read the slides again.

//========================================


package CS342.Homework5;

    public class Heap {

	public static boolean isMinHeap(int[] arr, int size) {

		if (size <= 1) {
			return true;
		}

		for (int i = 0; i < size / 2; i++) {

			int leftChild = 2 * i + 1;
			int rightChild = 2 * i + 2;

			if (leftChild < size && arr[i] > arr[leftChild]) {
				return false;
			}

			if (rightChild < size && arr[i] > arr[rightChild]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		int[] minHeap = {1, 3, 5, 7, 9, 8};
		int[] notMinHeap = {1, 2, 3, 4, 0};

		System.out.println("\nminHeap is a min-heap: "
				+ isMinHeap(minHeap, minHeap.length));

		System.out.println("\nnotMinHeap is a min-heap: "
				+ isMinHeap(notMinHeap, notMinHeap.length));
	}
}
