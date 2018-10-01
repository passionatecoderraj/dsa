/**
 * 
 */
package com.raj.leetcode.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Raj
 *You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
 *
 */
public class NextGreaterElement {

	// Time :O(n), Space:O(n)
	public int[] nextGreaterElement(int[] a, int[] b) {
		int res[] = new int[a.length];
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int n : b) {
			while (!stack.isEmpty() && n > stack.peek()) {
				map.put(stack.pop(), n);
			}
			stack.push(n);
			map.put(n, -1);
		}

		for (int i = 0; i < a.length; i++) {
			res[i] = map.getOrDefault(a[i], -1);
		}
		return res;
	}

	public static void main(String[] args) {
		NextGreaterElement obj = new NextGreaterElement();
		int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };

		int[] res = null;
		res = obj.nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(res));

		int[] a = { 2, 4 }, b = { 1, 2, 3, 4 };
		res = obj.nextGreaterElement(a, b);
		System.out.println(Arrays.toString(res));

	}

}
