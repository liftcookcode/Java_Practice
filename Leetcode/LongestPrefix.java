
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

package Leetcode;

public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {

        // Step 1: Check is string is null, if yes, return empty string
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Step 2: Assume the frist string is the prefix
        String prefix = strs[0];

        // Step 3: Compare with every other string
        for (int i = 1; i < strs.length; i++) {
            // Step 4: startsWith() -> checks whether the current string begins with prefix
            while (!strs[i].startsWith(prefix)) {
                // Step 5: remove the last character    
                prefix = prefix.substring(0, prefix.length() - 1);
                // Step 6: Check if the prefix became empty
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestPrefix sol = new LongestPrefix();

         // Test Case 1
         String[] strs1 = {"flower", "flow", "flight"};
         System.out.println("Test 1: " + sol.longestCommonPrefix(strs1));
         // Expected Output: fl
 
         // Test Case 2
         String[] strs2 = {"dog", "racecar", "car"};
         System.out.println("Test 2: " + sol.longestCommonPrefix(strs2));
         // Expected Output: ""
 
         // Test Case 3
         String[] strs3 = {"apple", "apple", "apple"};
         System.out.println("Test 3: " + sol.longestCommonPrefix(strs3));
         // Expected Output: apple
    }
    
}
