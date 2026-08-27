// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a
// non-empty word in s. Specifically:

// Each letter in pattern maps to exactly one unique word in s.
// Each unique word in s maps to exactly one letter in pattern.
// No two letters map to the same word, and no two words map to the same letter.

package Leetcode;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static boolean isWordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");

        // Number of characters and words must match
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check character -> word mapping
            if (charToWord.containsKey(c)) {
                if(!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            // Check word -> character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Test 1
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";

        System.out.println(isWordPattern(pattern1, s1));


        // Test 2
        String pattern2 = "abba";
        String s2 = "dog cat fish dog";

        System.out.println("\n" + isWordPattern(pattern2, s2));
    }
    
}
