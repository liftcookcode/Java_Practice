// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
// The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

package Leetcode;

public class SquareRoot {

    public static int mySqrt(int x) {

        // handles 0 or 1
        // if x is 0 or 1, return x
        if (x < 2) {
            return x;
        }

        int left = 1;
        // Sqaure root cannot be greater than x / 2
        int right = x / 2;
        // Store the best answer
        int answer = 1;

        // Start binary search
        while (left <= right) {
            // Find the middle
            // mid = left + right / 2 -> chance to cause overflow
            int mid = left + (right - left) / 2;

            // Check if mid is small enough
            if (mid <= x / mid) {
                answer = mid;
                // Search for something larger
                // Since mid works, we want to see if theres even a larger number that works too
                left = mid + 1;
            // If mid is too large
            } else {
                right = mid - 1;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(54));
        System.out.println(mySqrt(61));
        System.out.println(mySqrt(9));
    }
    
}
