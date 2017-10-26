package com.raj.dp;

import java.util.Arrays;

/**
 * 
 * @author Raj
 *
 *Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */

public class NumberOfLongestIncreasingSubsequences {

    // Time : O(n2), Space : O(n)
    public int findNumberOfLIS(int[] a) {
        int[] t = new int[a.length];
        int[] count = new int[a.length];
        Arrays.fill(t, 1);
        Arrays.fill(count, 1);
        int maxLen = 1;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    if (t[j] + 1 > t[i]) {
                        t[i] = t[j] + 1;
                        count[i] = count[j];
                    } else if (t[i] == t[j] + 1) {
                        //// means have another way to reach the same max length increasing sequence
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, t[i]);
        }
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            if (t[i] == maxLen) {
                total += count[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequences obj = new NumberOfLongestIncreasingSubsequences();
        int result = -1;

        int a[] = {1, 3, 5, 4, 7 };
        result = obj.findNumberOfLIS(a);
        System.out.println(result);

        int b[] = {2, 2, 2, 2, 2 };
        result = obj.findNumberOfLIS(b);
        System.out.println(result);

        int c[] = {1, 3, 5, 4, 7,6,8 };
        result = obj.findNumberOfLIS(c);
        System.out.println(result);

    }

}
