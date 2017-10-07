package com.raj.arrays;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 */
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int largestSubarrayWithEqual0s1s(int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = -1;
            }
        }
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        ContiguousArray obj = new ContiguousArray();
        int a[] = {1, 0, 0, 1, 0, 1, 1 };
        int result = -1;
        result = obj.largestSubarrayWithEqual0s1s(a);
        System.out.println(result);
        int b[] = {1, 1, 1, 1 };
        result = obj.largestSubarrayWithEqual0s1s(b);
        System.out.println(result);
        int c[] = {0, 0, 1, 1, 0 };
        result = obj.largestSubarrayWithEqual0s1s(c);
        System.out.println(result);

        int d[] = {1, 1, 1, 0, 1, 0, 0 };
        result = obj.largestSubarrayWithEqual0s1s(d);
        System.out.println(result);

    }

}
