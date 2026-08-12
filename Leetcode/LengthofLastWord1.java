
// Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal substring consisting of non-space characters only.

package Leetcode;

public class LengthofLastWord1 {

    public static int LengthofLastWord(String s) {

        // Start at the end of the word
        int i = s.length() - 1;
        
        // i >= 0 makes sure we don't go before the beginning of the string
        // charAt checks what position the character is located at
        while (i >= 0 && s.charAt(i) == ' ') {
            // move position to the left
            i--;
        }

        // create counter
        int length = 0;
        
        // count the last word
        // moves backward through the last word
        // loop stops when it reaches a space
        while (i >= 0 && s.charAt(i) != ' ') {
            // each time we find a character
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "Hello World";

        int result = LengthofLastWord(s);

        System.out.println("String: " + s);
        System.out.println("Length of last word: " + result);


    }
    
}
