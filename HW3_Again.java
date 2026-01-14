import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class HW3_Again {

// Problem 1:
// Write a program that deals with inflation, which is essentially the rising cost of general goods over time. 
// That is, the price of goods, such as a packet of peanuts, goes up as time goes by. So, 
// you will write a program to gauge the expected cost of an item in a specified number of years. 
// The program asks for the cost of the item, the number of years, and the rate of inflation. 
// The output is the estimated cost of the item after that number of years, using the given inflation rate.
// The user enters the inflation rate as a percentage, for example 4.5. 
// You will have to convert the percentage to a fraction (like 0.045), 
// and then use a loop to estimate the item's price adjusted for inflation.
// Note that this is similar to computing compound interest on a credit card account or a mortgage.
// Also note that you must check each of the values provided by the user to make sure that they are reasonable.
// Finally, you have to print out the price with exactly two places after the decimal (for the cents) after your 
// calculations are done.

// To adjust the price for inflation, you need to increase the price by the inflation rate each year. 
// For example, if you have an item that is initially $10, with inflation rate of 10%, the adjusted prices will be:

// After 1 year: $10.00 ∗ (1 + 0.10) = $11.00
// After 2 years: $11.00 ∗ (1 + 0.10) = $12.10
// After 3 years: $12.10 ∗ (1 + 0.10) = $13.31
//     …

// In other words, to calculate the price after another year, you have to use the value from the current year, 
// NOT the original price. To do this, you must use a loop. An example of what your program should output:

// Enter the current price of the item: $10

// Enter the number of year 
// Enter the inflation rate as a percentage: 10

// After 3 years, the price will be $13.31

// Please use if statement and System.exit(0) to sanitize inputs (not do-while loop), if the 
// price or the number of years or the inflation rate is negative.


// =================
// CODE STARTS HERE:
// =================

public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    // Ask for price of the item
    System.out.print("What is the price of the item?: ");
    double currentPrice = input.nextDouble();

    if (currentPrice < 0) {
        System.out.println("Item price cannot be negative!");
        System.exit(0);

    }

    // Ask for the amount of years for inflation
    System.out.print("Enter the number of years: ");
    int years = input.nextInt();

    if (years < 0) {
        System.out.println("Years cannot be negative!");
        System.exit(0);
    }

    // Ask user for inflation rate
    System.out.print("What is the interest rate?:");
    double inflation = input.nextDouble();

    if (inflation < 0) {
        System.out.println("Interest rate cannot be negative!");
        System.exit(0);
    }

    // Change the inflation rate to a deciaml
    double rate = inflation / 100;

    // Find the future price
    double futurePrice = currentPrice;
    for (int i = 0; i < years; i++){
        futurePrice *= (1 + rate);   
    }

    // Have output be two deciaml places

    DecimalFormat df = new DecimalFormat("0.00");

    // Output
    System.out.println("After " + years + " years, the price will be $" + df.format(futurePrice));



}



//	Problem 2:
// Write a program that plays a guessing game with the user. Specifically, 
// your program should randomly pick a whole number between 1 and 100, inclusive. 
// Then, ask the user for a guess. You should detect and tell the user if the guess is not a valid guess. 
// Otherwise, tell the user their guess was too high or too low. The program should continue to prompt the user 
// for new guesses until they get the correct number, telling them each time if the guess was too high or too low or invalid.
//
// Here are a couple development/debugging strategies for this “target” variable:
//
// Print out the random number, to make sure your program is acting correctly – remember to 
// remove/comment this before submitting.
// Temporarily set the “target” variable to a fixed number, so you can test to see how your program responds 
// in different testing situations.
// Here’s a sample run of a working version of the program:
//
// Enter your guess (between 1 and 100): 50
//
// Too high!
//
// Enter your guess (between 1 and 100): 0
//
// Invalid guess, try again!
//
// Enter your guess (between 1 and 100): 101
//
// Invalid guess, try again!
//
// Enter your guess (between 1 and 100): 25
//
// Too high!
//
// Enter your guess (between 1 and 100): 12
//
// Too high!
//
// Enter your guess (between 1 and 100): 6
//
// Too high!
//
// Enter your guess (between 1 and 100): 3
//
// Too low!
//
// Enter your guess (between 1 and 100): 4
//
// Too low!
//
// Enter your guess (between 1 and 100): 5
//
// You win!


public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    // Generates a random number 1-100
    int target = rand.nextInt(100);

    int guess = 0;

    // Loop until user guess correctly

    while(guess != target) {
        System.out.println("Enter a guess 1-100: ");
        if (!input.hasNextInt()) {
            // Not a number
            System.out.println("Incorrect guess, enter another number: ");
            input.next();
            continue;
        }


        guess = input.nextInt();

        // Check to see if guess is between 1 - 100
        if (guess < target) {
            System.out.print("Guess is too low!");
        } else if (guess > target) {
            System.out.print("Guess is too high!");
        } else {
            System.out.println("CORRECT!");
        }
    }


}
    
}
