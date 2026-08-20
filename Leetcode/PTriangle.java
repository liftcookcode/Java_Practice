// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

package Leetcode;
import java.util.*;

public class PTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i ++) {
            List<Integer> row = new ArrayList<>();  

            // First number in every row is 1
            row.add(1);

            // Calculate the numbers between the first and last 1
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1) + triangle.get(i-1).get(j);
                row.add(value);
            }

            // Every row with more than one element ends with 1
            if (i > 0) {
                row.add(1);
            }
            
            triangle.add(row);
   
        }

        return triangle;
    }

    public static void main(String[] args) {

        int numRows = 5;

        List<List<Integer>> triangle = generate(numRows);

        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }

    
}
