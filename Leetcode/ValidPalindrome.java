
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing 
// all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include 
// letters and numbers.

// Given a string s, return true if it is a palindrome, or false otherwise.

package Leetcode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        // While left is before right, keep going
        while (left < right) {

            // Skip non-alphanumeric characters
            // Checks characters, if character is not a character or digit -> move left position one to the right
            // * Skips commas, periods, etc *
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Checks characters, if character is not a character or digit -> move right position backwards one to the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] tests = {
            "A man", "a plan","a canal", "Panama","race a car", " ",
        };

        for (String test : tests) {
            System.out.println("\"" + test + "\" -> " + isPalindrome(test));
        }
    }
    
}
