// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] 
// is the number of 1's in the binary representation of i.

// Do not solve it with built-in functions (i.e., like __builtin_popcount in C++).

package Leetcode;

import java.util.Arrays;

public class CountingBits {

    public static int[] countBits(int n) {

        int[] ans = new int[n + 1];

        // Start at 1 because we know first element is 0 at index 0
        for (int i = 1; i <= n; i++) {
            // >> Shift bits right by 1 and bitwise AND on 1 
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;

        int[] ans = countBits(n);

        System.out.println(Arrays.toString(ans));
    }
    
}
