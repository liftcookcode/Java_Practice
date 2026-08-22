
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

package Leetcode;

public class SingleNumber {

    public static int singleNum(int[] nums) {
        int result = 0;

        for (int num: nums) {
            // ^ -> XOR
            // EX: booleans
            // b1 = true, b2 = false -> | b1 ^ b1 = false | b1 ^ b2 = true |
            result ^= num;
        }
        return result;
    }
    
    public static void main(String[] args) {

        int[] nums = {4,1,2,1,2};

        int result = singleNum(nums);

        System.out.println("Single number: " + result);
    }
}
