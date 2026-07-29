package Leetcode;

public class Palidrome {

    public String longestPalidrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandFromCenter(s, i ,i); // Odd length palidrome
            int len2 = expandFromCenter(s, i ,i + 1); // Even length palidrome
            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    private int expandFromCenter(String s, int left, int right) {
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        } 

        return right - left - 1;
    }
    
}
