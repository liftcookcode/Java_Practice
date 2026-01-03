
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BU_Final_Q1 {

    // Question 1: Add all the positive integers in a file

    public static void main(String[] args) {
        int sum = 0;


        try {
            Scanner input = new Scanner(new File("numbers.tet"));


            While(input.hasNext()) {
                if (input.hasNextInt()) {
                    int num = input.nextInt();
                    if (num > 0) {
                        sum += num;
                    }
                } else {
                    input.next();
                }
            }

            input.close();
            System.out.println("Sum of positive integers:" + sum);
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

   

    



}
