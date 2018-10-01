/**
 * 
 */
package com.raj.leetcode.google;

/**
 * @author Raj 
 * 
 * 
Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 *
 */
public class MaxChunksToMakeSorted {

	//https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation
	// Time :O(n), Space:O(1)
	public int maxChunksToSorted(int[] a) {
		if (a.length == 0)
			return 0;

		int maxSoFar = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			maxSoFar = Math.max(a[i], maxSoFar);
			if (maxSoFar == i) {
				count++;
			}
		}
		return count;
	}

	// Time :O(n), Space:O(n)
	public int maxChunksToSorted2(int[] a) {
		if (a.length == 0)
			return 0;
		int maxSoFar[] = new int[a.length];
		maxSoFar[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			maxSoFar[i] = Math.max(a[i], maxSoFar[i - 1]);
		}
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (maxSoFar[i] == i) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		MaxChunksToMakeSorted obj = new MaxChunksToMakeSorted();
		int res = -1;
		int[] a = { 0, 2, 1, 4, 3, 5, 7, 6 };
		res = obj.maxChunksToSorted(a);
		System.out.println(res);

		res = obj.maxChunksToSorted(new int[] { 4, 3, 2, 1, 0 });
		System.out.println(res);

	}

}
