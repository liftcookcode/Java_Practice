// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

package Leetcode;
import java.util.*;


public class PTriangleRow {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // Start with the first value
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            // Add one at the end of the new row
            row.add(1);

            // Update from right to left so we don't overwrite
            // values needed for calculation
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
    

    public static void main(String[] args) {
        System.out.println(getRow(0)); // [1]
        System.out.println(getRow(1)); // [1, 1]
        System.out.println(getRow(2)); // [1, 2, 1]
        System.out.println(getRow(3)); // [1, 3, 3, 1]
        System.out.println(getRow(4)); // [1, 4, 6, 4, 1]
        System.out.println(getRow(5)); // [1, 5, 10, 10, 5, 1]
    }
}
