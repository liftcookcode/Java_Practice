// Given an integer n, return true if it is a power of three. Otherwise, return false.

// An integer n is a power of three, if there exists an integer x such that n == 3x.



package Leetcode;
import java.util.*;

public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {

        // Return false if it number is negative
        if (n <= 0) {
            return false;
        }

        // Keep dividing by 3 while it's divisible by 3
        while (n % 3 == 0) {
            n = n / 3;
        }

        // If it ends in 1, it's a power of 3
        return n == 1;

    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println("\n" + isPowerOfThree(3));
        System.out.println("\n" + isPowerOfThree(48));
        System.out.println("\n" + isPowerOfThree(54));
    }
    
}
