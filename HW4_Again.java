import java.util.*;

public class HW4_Again {


// PROBLEM 1
//	
//	Write a program that can print a banner with rotated letters, such that they can be read from top to bottom. Specifically, 
//	each letter in the message should be printed using multiple lines composed of * symbols. The code to print each letter should 
//	go into a separate method just for that letter (no parameters, no return value). Don’t worry, you don’t need to make 26 
//	different methods, just 8: the seven letters in the message “Hello World” (D, E, H, L, O, R, and W) and a space. 
//	In your main method, you should ask the user to type a message. Then, loop through each character in the message and, 
//	for each character, if you have a corresponding method, call the method to print out the letter to the screen, 
//	ignoring any other characters. To help get you started, here is an example method for the letter D:


// =================
// CODE STARTS HERE:
// =================

// public static void main(String[] args) {
// 	Scanner input = new Scanner(System.in);

// 	System.out.print("Enter a message: ");
// 	String message = input.nextLine();

// 	for (int i = 0; i < message.length(); i++) {
// 		char ch = Character.toUpperCase(message.charAt(i));

// 		switch (ch) {
// 			case 'D': d(); break;

// 			case 'E': e(); break;

// 			case 'H': h(); break;

// 			case 'L': l(); break;

// 			case 'O': o(); break;

// 			case 'R': r(); break;

// 			case 'W': w(); break;

// 			case ' ': blank(); break;
			
// 			default: break; 
// 	}

// 	input.close();
// }
// }

// // Letter D 

// public static void d() {
// 	System.out.printf("%n");
//         System.out.printf("*******%n");
//         System.out.printf("*      *%n");
//         System.out.printf("*       *%n");
//         System.out.printf("*       *%n");
//         System.out.printf("*      *%n");
//         System.out.printf("*******%n");
//         System.out.printf("%n");
// }
// // Letter E
	
// public static void e() {
// 	System.out.printf("%n");
// 	System.out.printf("*******%n");
// 	System.out.printf("*%n");
// 	System.out.printf("******%n");
// 	System.out.printf("*%n");
// 	System.out.printf("*******%n");
// 	System.out.printf("%n");
// }

// // Letter H

// public static void h() {
// 	System.out.printf("%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("*******%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("%n");
// }

// // Letter L

// public static void l() {
// 	System.out.printf("%n");
// 	System.out.printf("*%n");
// 	System.out.printf("*%n");
// 	System.out.printf("*%n");
// 	System.out.printf("*%n");
// 	System.out.printf("*******%n");
// 	System.out.printf("%n");
// }

// // Letter O

// public static void o() {
// 	System.out.printf("%n");
// 	System.out.printf(" ***** %n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf(" ***** %n");
// 	System.out.printf("%n");
// }

// // Letter R

// public static void r() {
// 	System.out.printf("%n");
// 	System.out.printf("******%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("******%n");
// 	System.out.printf("*   *%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("%n");
// }

// // Letter W

// public static void w() {
// 	System.out.printf("%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("*     *%n");
// 	System.out.printf("*  *  *%n");
// 	System.out.printf("* * * *%n");
// 	System.out.printf("**   **%n");
// 	System.out.printf("%n");
// }

// // Space 

// public static void blank() {
// 	System.out.printf("%n%n");
// }



	// Problem 2
//	
//	Write a program that calculates the average of a stream of non-negative numbers. The user can enter as many non-negative 
//	numbers as they want, and they will indicate that they are finished by entering a negative number. For this program, 
//	zero counts as a number that goes into the average. Of course, the negative number should not be part of the average 
//	(and, for this program, the average of 0 numbers is 0). You must use a method to read in the numbers, keep track of 
//	the running sum and count, compute the average, and return the average to the main() method. Note that you must use a 
//	loop to do this, as you don't know how many numbers the user will enter ahead of time.
//
//	The main() method must print the average (which was returned from your method) using two decimal places, 
//	and then ask the user if they want to repeat the entire process. The user should be allowed to repeat the process as many 
//	times as they wish. This means you will have a loop in your main() method that instructs the user what to do, 
//	calls your average method, reports the result, and finally asks the user if they want to calculate another average for a 
//	different set of numbers. Please use input.next() to get string input instead of using input.nextLine().
//
//	Importantly, your program will not function correctly if is more than one Scanner object looking to the keyboard. 
//	Thus, since both main() and your averaging method need to get input from the keyboard, you will have to declare and 
//	initialize a Scanner variable in main(), then pass Scanner as an argument to the averaging method (for example, 
//			public static void Method(Scanner input){}). Furthermore, note that your method that reads in the numbers 
//	and computes the average must have no System.out.println() statements – all output must happen in main().


// =================
// CODE STARTS HERE:
// =================





    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            // Call the method to calculate average
            double average = calculateAverage(input);

            // Print the result with two decimal places
            System.out.printf("The average is: %.2f%n", average);

            // Ask user if they want to repeat
            System.out.print("Do you want to calculate another average? (yes/no): ");
            choice = input.next();

        } while (choice.equalsIgnoreCase("yes"));

        input.close();
    }

    // Method to read numbers and compute average
    public static double calculateAverage(Scanner input) {
        double sum = 0.0;
        int count = 0;
        double number;

        // Read numbers until a negative number is entered
        while (true) {
            System.out.print("Enter a non-negative number (negative to stop): ");
            number = input.nextDouble();

            if (number < 0) {
                break;
            }

            sum += number;
            count++;
        }

        // If no numbers were entered, average is 0
        if (count == 0) {
            return 0.0;
        }

        return sum / count;
    }






}
