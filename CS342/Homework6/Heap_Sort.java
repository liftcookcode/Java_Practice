package CS342.Homework6;

public class Heap_Sort {

    public static void heapSort(int[] arr) {

        int n = arr.length; // store array length

        // building out the heap
        // (n/2-1) -> leaf nodes are already heaps
        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr, n, i); // first iteration -> parents must be smaller than children
        }
        // extract elemtents in array
        for (int i = n - 1; i >= 0; i--) {

            // Swap root with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Restore heap to original order
            // Last element is ignored becasue it'a already stored
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {

        int smallest = i; // assume root is smallest
        // find children 
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Compare left child 
        // Checks if Child exists & if child is smaller
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        // Same as left
        // Also find the smallest among left and right
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        // Swap if needed
        if (smallest != i) {

            // If root isn't the smallest, swap root with smallest child
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // recursive call due to after swapping it could break the tree
            // restores natural order
            heapify(arr, n, smallest);

        }
    }

    public static void printArray(int[] arr) {

        for (int num: arr) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1,5,8,9,3};

        System.out.println("\nOriginal: ");
        printArray(arr);

        heapSort(arr);

        System.out.print("\nAfter Heap Sort: ");
        printArray(arr);
    }
    
}
