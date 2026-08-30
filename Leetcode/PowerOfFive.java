// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 5x.

package Leetcode;

public class PowerOfFive {

    public static boolean isPowerOfFive(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 5 == 0) {
            n = n / 5;
        }

        return n == 1;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfFive(25));
        System.out.println(isPowerOfFive(15));
        System.out.println(isPowerOfFive(50));
        System.out.println(isPowerOfFive(90));

    }
    
}
