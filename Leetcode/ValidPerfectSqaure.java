
// Given a positive integer num, return true if num is a perfect square or false otherwise.

// A perfect square is an integer that is the square of an integer. In other words, it is 
// the product of some integer with itself.

// You must not use any built-in library function, such as sqrt.

package Leetcode;

public class ValidPerfectSqaure {
    
    public static boolean isPerfectSqure(int num) {
            
        if (num < 1) {
            return false;
        }
        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] testCases = {1, 4, 9, 16, 25, 8, 36, 88, 100};

        for (int num: testCases) {
            System.out.println(num + " -> " + isPerfectSqure(num));
        }
    }
}
