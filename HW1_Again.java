import java.util.Random;
import java.util.Scanner;

public class HW1_Again{

// Problem 1:

// Write a program to help carpenters. Sometimes measurements are given in terms of yards, feet, and inches. 
// Your program will convert these three numbers into a total number of inches. When running, 
// it will prompt the user first for the number of yards, then the number of feet, and finally 
// the number of inches. Assume all numbers are whole (integers). Your program must compute the total 
// number of inches by converting each of the three inputs into inches and summing them all together. 
// Finally, print out the total length in inches. Recall that 1 yard = 3 feet, and 1 foot = 12 inches.

// The following represents a sample run of the program in which the user inputs 1 for the number of yards, 
// 2 for the number of feet, and 3 for the number of inches (yielding a correct output of 63 total inches).

// Enter number of yards: 1

// Enter number of feet: 2

// Enter number of inches: 3

// Total number of inches: 63  

// =================
// CODE STARTS HERE:
// =================
    // public static void main(String[] args) {

    //     Scanner input = new Scanner(System.in);

    //     // Asking user for inputs
    //     System.out.println("Enter the number of yards: ");
    //     int yards = input.nextInt();

    //     System.out.println("Enter the number of feet: ");
    //     int feet = input.nextInt();

    //     System.out.println("Enter the number of inches: ");
    //     int inches = input.nextInt();

    //     // Conversion to inches
    //     final int FEET_PER_YARD = 3;
    //     final int INCHES_PER_FOOT = 12;

    //     // Convert all to inches
    //     int totalinches = (yards * FEET_PER_YARD * INCHES_PER_FOOT) + (feet * INCHES_PER_FOOT) + inches;

    //     // Print result
    //     System.out.println("The are a total number of " + totalinches + " inches.");

    //     input.close();


    // }





// Problem 2: 

// Write a program to do the reverse of Problem a. It prompts the user for a length in inches, 
// then converts that total number of inches into yards, feet, and inches. 
// Note that you do not convert the number of inches separately into yards, then feet, then inches. 
// Instead the program must calculate how many yards there are in the given number of inches, 
// then convert the remaining inches into feet, and finally have the left over inches directly. 
// For example, if the user enters 63 for the total number of inches, your program should compute
//  that that is equal to 1 yard, 2 foot, and 3 inches. The following represents a run of the program 
// using this sample input.

// Enter number of inches: 63

// Yards: 1

// Feet: 2

// Inches: 3

// =================
// CODE STARTS HERE:
// =================
// public static void main(String[] args) {

//     Scanner input = new Scanner(System.in);

//     // Ask user for input
//     System.out.println("What are the total number of inches?: ");
//     int totalinches = input.nextInt();


//     // Conversion to inches
//     final int FEET_PER_YARD = 3;
//     final int INCHES_PER_FOOT = 12;
//     final int INCHES_PER_YARD = FEET_PER_YARD * INCHES_PER_FOOT;

//     // Calcualte total number of yards, feet, inches and remainder inches

//     // yards
//     int yards = totalinches / INCHES_PER_YARD;

//     //Left over inches to yards
//     int remainingInchesAfterYards = totalinches % INCHES_PER_YARD;

//     // feet
//     int feet = remainingInchesAfterYards / INCHES_PER_FOOT;
    
//     // Left over inches to feet
//     int inches = remainingInchesAfterYards % INCHES_PER_FOOT;

//     // output
//     System.out.println("\nYards: " + yards);
//     System.out.println("\nFeet: " + feet);
//     System.out.println("\nInches: " + inches);

//     input.close();


// }


// Problem 3:

// Write a program to generate a random integer n with 10 <= n <= 19. Print out the generated number.

// Hint: Math.random() will generate a random number between 0 and 0.9999999. 
// How to convert the range [0, 0.999999) to [10, 19]?

// =================
// CODE STARTS HERE:
// =================

public static void main(String[] args) {

    Random rand = new Random();

    // Number 10 - 19
    int n = rand.nextInt(10) + 10;

    // Output
    System.out.println("Random Generated number: " + n);
}



}