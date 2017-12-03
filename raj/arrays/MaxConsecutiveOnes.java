package com.raj.arrays;

/**
 * 
 * @author Raj
 *
 *Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    // Time : O(n), Space : O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int count, maxCount;
        count = maxCount = 0;
        for (int n : nums) {
            count = n == 0 ? 0 : count + 1;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int a[] = {1, 1, 0, 1, 1, 1 };
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        int result = -1;
        result = obj.findMaxConsecutiveOnes(a);
        System.out.println(result);
    }

}
