// Given two sorted arrays nums1 and nums2 of size m and n respectively, 
// return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).


package Leetcode;

public class FindMedianSortedArray {

    public double findMedianSortedArray(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {

            return findMedianSortedArray(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;


        while (low <= high) {

            int partitionX = (low / high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            // int maxLeftX;
            // if (partitionX == 0) {
            //     maxLeftX = Integer.MIN_VALUE;
            // } else {
            //     maxLeftX = nums1[partitionX - 1];
            // }
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            // int minRightX;
            // if (partitionX == m) {
            //     minRightX = Integer.MAX_VALUE;
            // } else {
            //     minRightX = nums1[partitionX];
            // }

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            // int maxLeftY;
            // if (partitionY == 0) {
            //     maxLeftY = Integer.MIN_VALUE;
            // } else {
            //     maxLeftY = nums2[partitionY - 1];   
            // }
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            // int minRightY;
            // if (partitionY == n) {
            //     minRightY = Integer.MAX_VALUE;
            // } else {
            //     minRightY = numss[partitionY];
            // }

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if ((m + n) % 2 == 0) {
                    return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2.0;
                }

                return (double) Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX  > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
         }

         throw new IllegalArgumentException(" Input arrays are not sorted");
    }


    
}
