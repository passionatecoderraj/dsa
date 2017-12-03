package com.raj.arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Raj
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes2 {

    // Time : O(n), Space : O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        // flip at most k zero
        int q = -1;
        for (int left = 0, i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left = q + 1;
                q = i;
            }

            maxCount = Math.max(maxCount, i - left + 1);
        }
        return maxCount;
    }

    // Time : O(n), Space : O(k)
    public int findMaxConsecutiveOnes2(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        int maxCount = 0;
        // flip at most k zero
        int k = 1;
        for (int left = 0, i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                q.offer(i);
            }
            if (q.size() > k) {
                left = q.poll() + 1;
            }
            maxCount = Math.max(maxCount, i - left + 1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int a[] = {1, 0, 0, 1, 1, 0, 0, 1 };
        MaxConsecutiveOnes2 obj = new MaxConsecutiveOnes2();
        int result = -1;
        result = obj.findMaxConsecutiveOnes(a);
        System.out.println(result);
    }

}
