// You want to build n new buildings in a city. The new buildings will be built in a line and are labeled 
// from 1 to n.

// However, there are city restrictions on the heights of the new buildings:

// The height of each building must be a non-negative integer.
// The height of the first building must be 0.
// The height difference between any two adjacent buildings cannot exceed 1.

// Additionally, there are city restrictions on the maximum height of specific buildings. These restrictions 
// are given as a 2D integer array restrictions where restrictions[i] = [idi, maxHeighti] indicates that 
// building idi must have a height less than or equal to maxHeighti.

// It is guaranteed that each building will appear at most once in restrictions, and building 1 will not be 
// in restrictions.

// Return the maximum possible height of the tallest building.


package Leetcode;
import java.util.Arrays;

public class MaxBuildingHeight {

    public int maxBuilding(int n, int[][] restrictions) {

        // Restricitons to building 1
        int[][] arr = new int[restrictions.length + 1][2];

        for (int i = 0; i < restrictions.length; i++) {
            arr[i] = restrictions[i];
        }

        arr[restrictions.length] = new int[]{1,0};

        // Sort restricitions by building ID
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        // First Pass: adjust max heights from left to right
        for (int i = 1; i < arr.length; i++) {
            int distance = arr[i][0] - arr[i - 1][0];

            arr[i][1] = Math.min(arr[i][1], arr[i - 1][1] + distance);
        }

        // Second Pass: adjust max heights from right to left
        for (int i = arr.length - 2; i >= 0; i--) {
                int distance = arr[i + 1][0] - arr[i][0];


                arr[i][1] = Math.min(arr[i][1], arr[i + 1][1] + distance);
        }

        // Find the max possible height
        int maxHeight = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            int distance = arr[i + 1][0] - arr[1][0];  

            int possibleHeight = (arr[i][1] + arr[i + 1][1] + distance) / 2;

            maxHeight = Math.max(maxHeight, possibleHeight);
        }

        // Consider the buildings after the last restricition
        maxHeight = Math.max(maxHeight, arr[arr.length - 1][1] + n - arr[arr.length - 1][0]);

         return maxHeight;
    }

    public static void main(String[] args) {

        MaxBuildingHeight solution = new MaxBuildingHeight();

        // Test Case 1
        int n1 = 10;
        int[][] restricitions1 = {{
            5,1}, {3,2}
        };

        int result1 = solution.maxBuilding(n1, restricitions1);

        System.out.println("Test Case 1: " + result1); // Expected output = 6


        // Test Case 2
        int n2 = 5;
        int[][] restriciton2 = { {2,1}, {4,1}};

        int result2 = solution.maxBuilding(n2, restriciton2);

        System.out.println("Test Case 2: " + result2); // Expected Output = 2
    }
    
}
