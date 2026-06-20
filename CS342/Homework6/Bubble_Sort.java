package CS342.Homework6;

public class Bubble_Sort {

    public static void bubbleSort(int[] arr) {

        int n = arr.length; // get the array length
        // Outter loop controls the number of passes to the array
        for (int i = 0; i < n - 1; i++) { // inner loop -> compares adjacent elements
            for(int j = 0; j < n - i - 1; j++) {

                if (arr[j] < arr[j] + 1) { // compare adjacent elements

                    int temp = arr[j]; // save first value
                    arr[j] = arr[j + 1]; // move second value to the left
                    arr[j + 1] = temp; // moves saved to the right
                }
            }
        }  
    }

    public static void printArray(int arr[]) {
        for (int num: arr) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,7,9,4};

        System.out.println("Orginial: ");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("After bubble sort: ");
        printArray(arr);

    }
    
}
