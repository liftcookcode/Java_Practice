package Leetcode;

public class ZigZag {
    
    public String convert(String s, int numRows) {
        
        // Step 1: Handle edge cases
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Step 2: Create a StringBuilder for every row
        // if rows = 4 -> rows[0] - rows[3]
        // Initially all null
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Step 3: Start from the first Row (0)
        int currentRow = 0;
        // Step 4: Direction Variable
        // Tells us to move upward or downward
        boolean goingDown = false;

        // Step 5: Traverse every Character
        for (char c : s.toCharArray()) {
            // Step 6: Put Character into Current Row
            rows[currentRow].append(c);

            // Step 7: Change Direction at Top or Bottom
            // Whenever you reach top row or bottom row, you reverse direction
            // EX: 1 -> 2 -> 3 -> 2 -> 1 -> 2 -> ...
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Step 8: Move to Next Row
            // If moving down proceed, else if moving upward proceed 
            currentRow += goingDown ? 1 : -1;
        }

        // Strings in java are immutable
        // StringBuilder modifies the exisiting object and appends characters more efficiently
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }


    public static void main(String[] args) {

        ZigZag solution = new ZigZag();

        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("PAYPALISHIRING", 4));

    }
}
