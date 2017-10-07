package com.raj.dp;
/**
 * 
 * @author Raj
 *
 *Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
Note: Length of the array will not exceed 10,000.


 */
public class LongestContinuousIncreasingSubsequence {

    // Time : O(n), Space : O(1)
    public int findLengthOfLCIS(int[] a) {
        if (null == a || 0 == a.length) {
            return 0;
        }
        int max = 1, cur = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence obj = new LongestContinuousIncreasingSubsequence();
        int result = -1;

        int a[] = {1, 2, 5, 8, 0 };
        result = obj.findLengthOfLCIS(a);
        System.out.println(result);

        int b[] = {2, 2, 2, 2, 2 };
        result = obj.findLengthOfLCIS(b);
        System.out.println(result);
    }

}
