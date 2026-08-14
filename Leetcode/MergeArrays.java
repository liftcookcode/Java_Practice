// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
// representing the number of elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements 
// that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.


package Leetcode;

import java.util.Arrays;

public class MergeArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // I and J point to last element in each arrays (I -> nums1, J -> nums2)
        int i = m - 1;
        int j = n - 1;
        // K points to largest element in the last position of nums1
        int k = m + n - 1;

        // Keep merging arrays while both arrays have elements to compare
        while (i >= 0 && j >= 0) {
            // Compare the two largest remaining elements
            // Compare last elements becasue both arrays are already sorted
            if (nums1[i] > nums2[j]) {
                // Put nums1 element at the end
                // if nums1 is larger, put into position k
                nums1[k] = nums1[i];
                // move backwards through array
                i--;
            // Otherwise use nums2
            } else {
                // Same logic as nums1 array
                nums1[k] = nums2[j];
                // move backward through array
                j--;
            }
            k--;
        }
        // Copy remaining nums2 elements
        while (j >= 0) {
            // Puts remaining nums2 elements into nums1
            nums1[k] = nums2[j];
            // Move both pointers backwards
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2,5,6};

        merge(nums1, 3, nums2, 3);

        System.out.println("Test 1: " + Arrays.toString(nums1));

        int[] nums3 = {1, 2, 3, 0, 0, 0};
        int[] nums4 = {4, 5, 6};

        merge(nums3, 3, nums4, 3);

        System.out.println("Test 2: " + Arrays.toString(nums3));
    }
    
}
