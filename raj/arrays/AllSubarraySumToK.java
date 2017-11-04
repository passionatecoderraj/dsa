/**
 *
 */
package com.raj.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Raj
 * 
 * 
 */
public class AllSubarraySumToK {

	
	/*
	 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/
	/*
     * The HashMap stores the sum of all elements before index i as key, and i as value. For each i, check not only the current sum but also (currentSum - previousSum) to see if there is any that equals k, and update max length.
     */
    // Time : O(n), Space : O(n)
    public int maxSubArrayLen(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum=0,maxLen=0;
        map.put(0, -1);
        for(int i=0;i<a.length;i++){
            sum = sum+a[i];
             if(map.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;
    }
    
    
    public int largestSubarrayWithEqual0s1s(int a[]) {
    	 for (int i = 0; i < a.length; i++) {
 			if (a[i] == 0)
 				a[i] = -1;
 		}
         Map<Integer, Integer> map = new HashMap<>();
         int sum=0,maxLen=0;
         map.put(0, -1);
         for(int i=0;i<a.length;i++){
             sum = sum+a[i];
              if(map.containsKey(sum)){
                 maxLen = Math.max(maxLen, i-map.get(sum));
             }
             if(!map.containsKey(sum)){
                 map.put(sum, i);
             }
         }
         return maxLen;
	}
    
    /*
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum
     * equals to k.
     */
    // Time : O(n), Space : O(n)
    public int subarraySum(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int element : a) {
            sum += element;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
	/*
	 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

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
	// https://leetcode.com/articles/continous-subarray-sum/
	// Time : O(n), Space : O(n)
	public boolean checkSubarraySum_MultipleOfK(int[] a, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			// need to add this scenario to cover scenario "some of continuous
			// numbers can be 0" for ex: {2,3,-5}, k=0
			if (k != 0) {
				sum %= k;
			}
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1) {
					return true;
				}
			} else {
				map.put(sum, i);
			}
		}
		return false;
	}

	/*
	 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
	 */

	// Time : O(n), Space : O(n)
		public int findPairs(int[] a, int k) {
			int count = 0;
			Map<Integer, Integer> map = new HashMap<>();
			for (int i : a) {
				map.compute(i, (key, val) -> {
					if (null == val) {
						val = 0;
					}
					return 1 + val;
				});
			}

			for (Entry<Integer, Integer> e : map.entrySet()) {
				if (k == 0) {
					if (e.getValue() >= 2) {
						count++;
					}
				} else {
					if (map.containsKey(e.getKey() + k)) {
						count++;
					}
				}
			}
			return count;
		}
	public static void main(String[] args) {

		AllSubarraySumToK obj = new AllSubarraySumToK();
		int a[] = { 23, 2, 4, 6, 7 };
		boolean result = false;
		result = obj.checkSubarraySum_MultipleOfK(a, 6);
		System.out.println(result);

		int b[] = { 23, 2, 6, 4, 7 };
		result = obj.checkSubarraySum_MultipleOfK(b, 6);
		System.out.println(result);
	}

}
