// You are a product manager and currently leading a team to develop a new product. Unfortunately, 
// the latest version of your product fails the quality check. Since each version is developed based on the 
// previous version, all the versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the 
// following ones to be bad.

// You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function 
// to find the first bad version. You should minimize the number of calls to the API.

 
// Example 1:

// Input: n = 5, bad = 4
// Output: 4
// Explanation:
// call isBadVersion(3) -> false
// call isBadVersion(5) -> true
// call isBadVersion(4) -> true
// Then 4 is the first bad version.




package Leetcode;
import java.util.*;

public class FirstBadVersion {

    static int badVersion = 4;

    static boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public static int firstBadVersion1(int n) {
        int left = 1;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // Mid could be the first bad version
                right = mid;
            } else {
                // mid is good, so first bad case must be after middle
                left = mid + 1;
            }
        }

        return left;
    }
    

    public static void main(String[] args) {

        int n = 5;
        int result = firstBadVersion1(n);

        System.out.println("First Bad Version: " + result);
    }
}
