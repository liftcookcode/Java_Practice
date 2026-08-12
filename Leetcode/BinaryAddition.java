// Given two binary strings a and b, return their sum as a binary string.

package Leetcode;

public class BinaryAddition {

    public static String addBinary(String a, String b) {

        // StringBuilder lets us effieciently add characters to a string
        StringBuilder result = new StringBuilder();

        // Start at end of a
        int i = a.length() - 1;
        // Start at end of b
        int j = b.length() - 1;
        // Counter for adding binary terms
        int carry = 0;
            // Loop continues until on of the conditions is true
            while (i >= 0 || j >= 0 || carry > 0) {
            // Start sum with the carry
            int sum = carry;
            
            // Checks if a still has digits
            if (i >= 0) {
                // get the current binary bit
                // EX:
                // '1' is a character -> So '1' - '0' = 1
                sum += a.charAt(i) - '0';
                i--;
            }
            // Same for b
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            // Result modulo 2 gives us 0 or 1 
            result.append(sum % 2);
            // Use integer division to get carry
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));       // 100
        System.out.println(addBinary("1010", "1011")); // 10101
        System.out.println(addBinary("0", "0"));       // 0
        System.out.println(addBinary("111", "1"));     // 1000
    }
}
