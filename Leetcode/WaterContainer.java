// You are given an integer array height of length n. There are n vertical lines drawn such that 
// the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains 
// the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

package Leetcode;

public class WaterContainer {

    public int maxArea(int[] height) {
        // Create a pointer left
        // Starts at index 0
        int left = 0;
        // Pointer right
        // Starts at last index
        int right = height.length - 1;
        // Stores the largest area found so far
        // Initially 0 becuase no container has been checked
        int maxArea = 0;

        while (left < right) {
            // Caculates the distance between two lines
            // EX: 
            // left = 1, right = 8 -> width = 8 - 1 = 7
            int width = right - left;
            // The water level is determined by the shorter of two lines
            // EX:
            // Height[left] = 8
            // Height[right] = 7
            // Water level = min(8,7) = 7
            // Width = 7
            // Area = 7 * 7 = 49
            int currentArea = Math.min(height[left], height[right]) * width;
            // Compare the current area with the best area found so far
            // Store the largest one
            // EX:
            // maxArea = 40
            // currentArea = 49
            // maxArea now becomes 49
            maxArea = Math.max(maxArea, currentArea);

            // Move the shorter line instead of taller
            // Because every time you move the pointer the width always decreases (because the pointer get closer together)
            // The only way to make the area larger is to find a taller shorter wall
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        WaterContainer sol = new WaterContainer();

        int[] height1 = {1,8,6,2,4,3,9,7};
        System.out.println("Test 1: " + sol.maxArea(height1));

        int[] height2 = {3,5,7};
        System.out.println("\nTest 2: " + sol.maxArea(height2));

        int[] height3 = {5,2}; 
        System.out.println("\nTest 3: " + sol.maxArea(height3));
    }
    
}
