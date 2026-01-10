import java.util.*;


public class HW2_Again {

    // Problem 1 :
    // Write a program that solves a quadratic equation of the form: ax2+bx+c=0 , where a, b, and c are integers.
    
    // Specifically, the user will input the values of a, b, and c. Your program must then calculate and 
    // output the roots of the equation, following these rules.
    
    // First, calculate the discriminant: d=b2-4ac
    
    // If the discriminant is negative, the roots are imaginary. Print out a message informing the user of 
    // this and stop the program. For example:
    // Enter a b c: 1 1 4
    
    // Roots: imaginary
    
    // If the discriminant is exactly zero, there is one root: -b/(2a). Inform the user of this one root: . 
    // You must provide exactly two decimal places in your response, rounding as necessary. For example:
    // Enter a b c: 1 4 4
    
    // Root: -2.00
    
    // If the discriminant is positive, there are two roots:﻿left parenthesis bevelled fraction numerator 
    // negative b plus-or-minus square root of d right parenthesis over denominator 2 a end fraction﻿ . 
    // Inform the user of the value of the roots in increasing order of value (i.e. the smaller root first, 
    //     followed by the larger). You must provide exactly two decimal places in your response, rounding as 
    //     necessary. For example:
    // Enter a b c: 1 6 5
    
    // Roots: -5.00, -1.00
    
    // =================
    // CODE STARTS HERE:
    // =================
    // public static void main(String[] args) {

    // Scanner input = new Scanner(System.in);

    // System.out.print("Enter values for a,b,c:");
    // int a = input.nextInt();
    // int b = input.nextInt();
    // int c = input.nextInt();

    // // Calculate Discriminat 
    // int d = b * b - 4 * a * c;

    // // Imaginary roots
    // if (d < 0) {
    //     System.out.println("Roots are imaginary");
        
    // }
    // // One real root
    // else if(d == 0) {
    //     double root = -b / (2.0 * a);
    //     System.out.printf("Root: %.2f%n", root);
    // }
    // // Two Roots
    // else {
    //     double sqrtD = Math.sqrt(d);

    //     double root1 = (-b - sqrtD) / (2.0 * a);
    //     double root2 = (-b + sqrtD) / (2.0 * a);

    //     // Have smaller root first, then larger -> Increasing order
    //     double smaller = Math.min(root1,root2);
    //     double larger = Math.max(root1,root2);

    //     System.out.printf("Roots: %.2f, %.2f%n", smaller, larger);
    // }
    // input.close();

    // }





    
    // =====================================================================================================
    
    // Problem 2 :
    // Write a program that reads in five whole numbers from the user. The program will calculate and output 
    // the following statistics about the five numbers:
    
    // The sum of all of the positive numbers (greater than zero).
    // The sum of all of the non-positive numbers (less than or equal to zero).
    // The sum of all five numbers.
    // The average of all of the positive numbers (greater than zero).
    // The average of all of the non-positive numbers (less than or equal to zero).
    // The average of all five numbers.
    // Note that your program must accept the five numbers in any order and cannot ask the user to enter the 
    // positive and non-positive numbers separately. You should start by calculating the sum and average of 
    // all five numbers. Be sure you get that working correctly and then move on to doing the calculations 
    // for the positive and non-positive numbers. You will need many variables to keep track of all the values, 
    // sums, and averages.
    
    // Don't forget that to calculate the average of a set of numbers you sum them all up then divide by the 
    // number of values you added together. For example, if your program gets 3 positive numbers and 2 
    // non-positive numbers, then you will divide the sum of the positive numbers by 3 to get the average 
    // and then divide the sum of the non-positive numbers by 2 to get the average of those numbers. 
    // This means you will have to keep track of how many positive numbers you read in and how many non-positive 
    // numbers you read in.
    
    // Also note that you will need to write a lot of very similar looking pieces of code. 
    // Think about how to solve the problem for one or two numbers and then go from there to calculating the 
    // statistics for all five numbers.
    
    // Finally, for sums, you should output just the number (e.g. 5 or 10) without any decimals 
    // (the sum of a set of integers is a sum!). However, for all averages, you must format the output to have 
    // two decimal places (even if they are both 0), and round if necessary.
    
    // The following represents a sample run of the program in which the user inputs on a single 
    // line “-1 1 -2 2 -3” (without quotes).
    
    // When only 1 positive number in five numbers, you need to use ‘number’ instead of ‘numbers’ in the 
    // corresponding output text. Same rule for 1 non-positive number.
    
    // Test case 1:
    
    // Enter five whole numbers: -1 1 -2 2 -3
    
    // The sum of the 2 positive numbers: 3
    
    // The sum of the 3 non-positive numbers: -6
    
    // The sum of the 5 numbers: -3
    
    // The average of the 2 positive numbers: 1.50
    
    // The average of the 3 non-positive numbers: -2.00
    
    // The average of the 5 numbers: -0.60
    
    // Test case 2
    
    // Enter five whole numbers: 0 0 0 0 0
    
    // The sum of the 0 positive numbers: 0
    
    // The sum of the 5 non-positive numbers: 0
    
    // The sum of the 5 numbers: 0
    
    // The average of the 0 positive numbers: 0.00
    
    // The average of the 5 non-positive numbers: 0.00
    
    // The average of the 5 numbers: 0.00
    
    
    
    // It is ‘number’ not ‘numbers’ if only one positive input.
    
    // Test case 3
    
    // Enter five whole numbers: 1 -1 -2 -3 -4
    
    // The sum of the 1 positive number: 1
    
    // The sum of the 4 non-positive numbers: -10
    
    // The sum of the 5 numbers: -9
    
    // The average of the 1 positive number: 1.00
    
    // The average of the 4 non-positive numbers: -2.50
    
    // The average of the 5 numbers: -1.80

    // =================
    // CODE STARTS HERE:
    // =================

    // public static void main(String[] args) {

    //     Scanner input = new Scanner(System.in);

    //     // Variables for sums
    //     int sumAll = 0;
    //     int sumPositive = 0;
    //     int sumNonPositive = 0;

    //     // Counters
    //     int countPositive = 0;
    //     int countNonPositive = 0;

    //     // Input
    //     System.out.print("Enter five whole numbers: ");

    //     for (int i = 0; i < 5; i++) {
    //         int num = input.nextInt();

    //         // Sum of all numbers
    //         sumAll += num;

    //         // Check positive vs non-positive
    //         if (num > 0) {
    //             sumPositive += num;
    //             countPositive++;
    //         } else {
    //             sumNonPositive += num;
    //             countNonPositive++;
    //         }
    //     }

    //     // Averages
    //     double avgAll = sumAll / 5.0;
    //     double avgPositive = (countPositive > 0)
    //             ? sumPositive / (double) countPositive
    //             : 0.0;
    //     double avgNonPositive = (countNonPositive > 0)
    //             ? sumNonPositive / (double) countNonPositive
    //             : 0.0;

    //     // Singular or plural text
    //     String posWord = (countPositive == 1) ? "number" : "numbers";
    //     String nonPosWord = (countNonPositive == 1) ? "number" : "numbers";

    //     // Output
    //     System.out.println();
    //     System.out.println("The sum of the " + countPositive + " positive " + posWord + ": " + sumPositive);
    //     System.out.println("The sum of the " + countNonPositive + " non-positive " + nonPosWord + ": " + sumNonPositive);
    //     System.out.println("The sum of the 5 numbers: " + sumAll);

    //     System.out.printf("%nThe average of the %d positive %s: %.2f%n",
    //             countPositive, posWord, avgPositive);
    //     System.out.printf("The average of the %d non-positive %s: %.2f%n",
    //             countNonPositive, nonPosWord, avgNonPositive);
    //     System.out.printf("The average of the 5 numbers: %.2f%n", avgAll);

    //     input.close();
    // }

        

        
    
    
    // ======================================================================================
    
    // Problem 3:
    // Write a program to read three doubles from the user and output the minimal double of the three.
    
    // Example output:
    // Enter three doubles: -1.5 5.5 10.0
    // The minimal number is : -1.5


    // =================
    // CODE STARTS HERE:
    // =================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        double numOne = input.nextDouble();
        double numTwo = input.nextDouble();
        double numThree = input.nextDouble();

        // Compute min value
        double min = Math.min(numOne, Math.min(numTwo, numThree));

        // Output
        System.out.println("The minimum value is: " + min);

        input.close();

    }
    
}
