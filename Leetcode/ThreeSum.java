// Given an integer array nums of length n and an integer target, find three integers at
//  distinct indices in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

package Leetcode;
import java.util.Arrays;
public class ThreeSum {

    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array
        // if curr sum is too small, move left pointer to increase sum
        // if curr sum is too large, move right pointer to decrease sum
        Arrays.sort(nums);  
        // Step 2: Store the size
        int n = nums.length;
        // Step 3: Initialize the closet sum
        int closetSum = nums[0] + nums[1] + nums[2];
        // Step 4: Fix one element
        // For every fixed num, we'll find the best two remaining nums
        for (int i = 0; i < n - 2; i++) {
            // Step 5: Initialize the two pointers
            int left = i + 1;
            int right = n - 1;
            // Step 6: Continue while pointers don't cross
            while (left < right) {
                // Step 7: Calculate the current sum
                int currentSum = nums[i] + nums[left] + nums[right];

                // Step 8: Check currentSum and target
                // Update the closest sum
                if (Math.abs(currentSum - target) < Math.abs(closetSum - target)) {
                    closetSum = currentSum;
                }
                // Step 9: Find exact match
                if (currentSum == target) {
                    return currentSum;
                // Sum too small
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closetSum;

    }

    public static void main(String[] args) {

        ThreeSum solution = new ThreeSum();


          // Test Case 1
          int[] nums1 = {-1, 2, 1, -4};
          int target1 = 1;
          System.out.println("Test 1:");
          System.out.println("Input: " + Arrays.toString(nums1));
          System.out.println("Target: " + target1);
          System.out.println("Closest Sum: " + solution.threeSumClosest(nums1, target1));
          System.out.println();
  
          // Test Case 2
          int[] nums2 = {0, 0, 0};
          int target2 = 1;
          System.out.println("Test 2:");
          System.out.println("Input: " + Arrays.toString(nums2));
          System.out.println("Target: " + target2);
          System.out.println("Closest Sum: " + solution.threeSumClosest(nums2, target2));
          System.out.println();
    }
    
    
}
