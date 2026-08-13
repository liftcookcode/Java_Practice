// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
package Leetcode;
import java.util.Scanner;


public class Stair {

    public static int climbStairs(int n) {

        // Handles case for 0 or 1
        // If 1 -> only one way 
        // If 0 -> only one way - do nothing
        if (n <= 1) {
            return 1;
        }
        // Represents the number of ways to reach two positions back
        int prev2 = 1;
        // Represents the previous numnber of ways
        int prev1 = 1;

        // Start at stair 2 -> because we alreay know the answer for 0 and 1
        for (int i = 2; i <= n; i++) {
            // Calculate the current number of ways
            int current = prev1 + prev2;
            // Move prev2 forward
            prev2 = prev1;
            // move prev1 forward
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = input.nextInt();

        int result = climbStairs(n);

        System.out.println("Number of ways: " + result);
        
        input.close();
    }
    
}
