package com.raj.leetcode;

import java.util.Arrays;
/**
 * 
 * @author Raj
 * 
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 *
 */
public class SquaresOfASortedArray {
	// Time : O(n), Space : O(1)
	public int[] sortedSquares(int[] a) {
		int l = 0, r = a.length - 1;
		int t[] = new int[a.length];
		int i = a.length - 1;
		while (l <= r) {
			if (Math.abs(a[l]) >= Math.abs(a[r])) {
				t[i--] = a[l] * a[l++];
			} else if (Math.abs(a[l]) < Math.abs(a[r])) {
				t[i--] = a[r] * a[r--];
			}
		}
		return t;
	}

	public static void main(String[] args) {

		SquaresOfASortedArray obj = new SquaresOfASortedArray();
		int res[] = null;
		res = obj.sortedSquares(new int[] { -4, -1, 0, 3, 10 });
		System.out.println(Arrays.toString(res));
	}
}