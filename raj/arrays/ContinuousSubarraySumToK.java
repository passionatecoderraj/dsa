/**
 *
 */
package com.raj.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj 
 * 
 *  Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinuousSubarraySumToK {

    // https://leetcode.com/articles/continous-subarray-sum/
    // Time : O(n), Space : O(n)
    public boolean checkSubarraySum(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int reminder = 0;
        for (int i = 0; i < a.length; i++) {
            reminder += a[i];
            // need to add this scenario to cover scenario "some of continuous numbers can be 0" for ex: {2,3,-5}, k=0
            // when k is '0', multiple of k are all zeroes
            if (k != 0) {
                reminder %= k;
            }
            if (map.containsKey(reminder)) {
                if (i - map.get(reminder) > 1) {
                    return true;
                }
            } else {
                map.put(reminder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ContinuousSubarraySumToK obj = new ContinuousSubarraySumToK();
        int a[] = {23, 2, 4, 6, 7 };
        boolean result = false;
        result = obj.checkSubarraySum(a, 6);
        System.out.println(result);

        int b[] = {23, 2, 6, 4, 7 };
        result = obj.checkSubarraySum(b, 6);
        System.out.println(result);
    }

}
