
// Given a string s, find the length of the longest substring without duplicate characters.

// USE SLIDING WINDOW TECHNIQUE

package Leetcode;
import java.util.HashMap;
import java.util.Map;


public class LengthOfLongestSubString {
    
    // returns an integer the length of the longest substring without repeating characters
    public static int lengthOfLongestSubString(String s) {

        // Create a Hashmap:
        // Key = Character
        // Value = Index where the key last appeared 
        Map<Character, Integer> map = new HashMap<>();
        
        // Starting index for the sliding window
        int left = 0;
        // Store the maximum substring length we've seen so far. Currently set to 0
        int maxLength = 0;

        // Right is the ending index of the sliding window -> Loop moves right one step at a time
        for (int right = 0; right < s.length(); right++) {
            // Gets the current character in "String s"
            char ch = s.charAt(right);

            // Checks if we have seen this character before
            if (map.containsKey(ch)) {

                // EX:
                // s = abc
                // left = 0 , right = 2
                // New window:
                // s = abca -> previous "a" was at index 0
                // so -> left = 0 + 1 = 1
                // New window:
                // bca -> No duplicates
                left = Math.max(left, map.get(ch) + 1);
            }
            // update last index of this character
            map.put(ch, right);
            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("abcabcbb"));
        System.out.println(lengthOfLongestSubString("bbbb"));
        
    }
}
