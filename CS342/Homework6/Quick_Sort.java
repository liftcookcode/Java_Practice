public class Quick_Sort {

    public static void quickSort(int[] arr, int low, int high) {

        // Base case
        if (low < high) {

            // Choses a pivot
            // Rearranges  elements around the pivot
            // returns the pivots final position
            int pi = partition(arr, low, high);

            // recursive call
            // leftside -> sorts everything before pivot
            quickSort(arr, low, pi - 1);
            // rightside -> sorts everything before pivot
            quickSort(arr, pi + 1, high);
        }
    }
    // Choose a pivot
    // Move larger elements to the left
    // Move smaller elements to the right
    // Put the pivot in the correct position
    public static int partition(int[] arr, int low, int high) {

        // Select the pivot
        int pivot = arr[high];
        // I tracks the boundary of elements greater than the pivot
        int i = low - 1;

        // J scans the array from left to right
        // Array will not check the last index(4) because that is the pivot
        for (int j = low; j < high; j++) {

            if (arr[j] > pivot) {

                i++;
            
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return pivot position
        return i + 1;
    }

    public static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1,9,5,7,3};

        System.out.println("\nOriginal: ");
        printArray(arr);

        quickSort(arr,0, arr.length - 1);
        
        System.out.println("\nAfter Quck Sort:");
        printArray(arr);

        
    }

    
}