// You are given a large integer represented as an integer array digits, where each digits[i] is 
// the ith digit of the integer. The digits are ordered from most significant to least significant in 
// left-to-right order. The large integer does not contain any leading 0's.

// Increment the large integer by one and return the resulting array of digits.


package Leetcode;

import java.util.Arrays;

public class plusOne1 {

    public static int[] plusOne(int[] digits) {

        // Start from the last digit
        // Add one to the last digit
        for (int i = digits.length - 1; i >= 0; i--) {
            // Check if digit is less than 9
            // 9 becasue 10 cant be represtned in indexing
            if (digits[i] < 9) {
                // increment digits
                digits[i]++;
                // return the array
                return digits;
            }
            // turn 9 into 0
            digits[i] = 0;
        }
        // creates larger array if needed for EX: {9,9,9}
        int[] result = new int[digits.length + 1];
        // put 1 at beginning of array
        result[0] = 1;

        return result;
    }
    
    public static void main(String[] args) {

        int[] digits = {1, 2, 9};

        int[] result = plusOne(digits);

        System.out.println(Arrays.toString(result));
    }
}
