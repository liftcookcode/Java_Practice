// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
// The order of the elements may be changed. Then return the number of elements in nums which are not equal 
// to val.

// Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to 
// do the following things:

// Change the array nums such that the first k elements of nums contain the elements which are not equal to val. 
// The remaining elements of nums are not important as well as the size of nums.
// Return k.

package Leetcode;

public class removeItem {

    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,2,3};
        int val = 3;

        removeItem solution = new removeItem();

        int k = solution.removeElement(nums, val);

        System.out.print("k = " + k);

        System.out.println(" First " + k + " elements: ");

        for (int i = 0; i < k; i ++) {
            System.out.print(nums[i] + " ");
        }
    }
    
}
