// Given a signed 32-bit integer x, return x with its digits reversed. 
// If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0. 
// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

package Leetcode;

public class ReverseInteger {

    public static int reverse (int x) {

        // Step 1: Initalize the answer
        int rev = 0;

        // Step 2: Loop until the number becomes 0
        while (x != 0) {
            // Step 3: Get the last digit
            int digit = x % 10;
            // Step 4: Get the last digit
            // EX: 1234 / 10 = 123
            x = x / 10; // x /= 10 -> shorthand

            // Step 5: Check for overflow -> whatever the max value is, the new number cannot exceed
            // EX: 999 + 10 + 5 = 9995, max is 999
            // this cause overflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            // Step 6: Check for underflow
            // EX: -99 * 10 + (-8) = -998, min is -997
            // the causes underflow 
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            // Step 7: Append the digit
            // EX: 90 * 10 + 9 -> +9 is being appended
            rev = rev * 10 + digit;
        }

        return rev;
    }

    public static void main(String[] args) {

        int[] testCases = {
            123,
            -123,
            120,
            0,
            1659394,
            -929483
        };

        for (int num : testCases) {
            System.out.println("Input: " + num);
            System.out.println("Output: " + reverse(num));
            System.out.println("\n---------------");
            
        }
    }
    
}
