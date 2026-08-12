// Given a sorted array of distinct integers and a target value, return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

package Leetcode;

public class searchInsertItem {
    
    public int searchInsert(int[] nums, int target) {

        // left varibale, start at index 0  
        int left = 0;
        // right variable, start at last index of array
        int right = nums.length - 1;

        // While true keep searching
        while (left <= right) {
            // finds the middle index
            int mid = left + (right - left) / 2;

            // check is the middle element is the targt
            if (nums[mid] == target) {
                return mid;
                // if middle value is smaller than target, target has to be to the right
            } else if (nums[mid] < target) {
                left = mid + 1;
                // value is greater than
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
    
    public static void main(String[] args) {

        searchInsertItem solution = new searchInsertItem();

        int[] nums = {1, 3, 5, 6};

        System.out.println(solution.searchInsert(nums, 5));

        System.out.println(solution.searchInsert(nums, 2));

        System.out.println(solution.searchInsert(nums, 7));

        System.out.println(solution.searchInsert(nums, 0));
    }
}
