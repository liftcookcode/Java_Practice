// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 4x.


package Leetcode;

public class PowerOfFour {

    public static boolean isPowerOfFour(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n = n / 4;
        }

        return n == 1;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfFour(16));


        System.out.println("\n" + isPowerOfFour(4));

        System.out.println("\n" + isPowerOfFour(50));

        System.out.println("\n" + isPowerOfFour(92));
    }
    
}
