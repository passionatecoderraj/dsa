package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 * 
 *         Let's call an array A a mountain if the following properties hold:
 * 
 *         A.length >= 3 There exists some 0 < i < A.length - 1 such that A[0] <
 *         A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] Given an
 *         array that is definitely a mountain, return any i such that A[0] <
 *         A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * 
 *         Example 1:
 * 
 *         Input: [0,1,0] Output: 1 Example 2:
 * 
 *         Input: [0,2,1,0] Output: 1 Note:
 * 
 *         3 <= A.length <= 10000 0 <= A[i] <= 10^6 A is a mountain, as defined
 *         above.
 *
 */
public class PeakIndexInMountainArray {

	// Time : O(logn), Space : O(1)
	public int peakIndexInMountainArray(int[] a) {
		if (a.length == 0)
			return -1;
		int l = 0, r = a.length - 1;
		while (r - l >= 2) {
			int m = l + (r - l) / 2;
			if (a[m] > a[m - 1] && a[m] > a[m + 1])
				return m;
			if (a[m] > a[m - 1]) {
				l = m;
			} else {
				r = m;
			}
		}
		return a[l] > a[r] ? l : r;
	}

	public static void main(String[] args) {
		PeakIndexInMountainArray obj = new PeakIndexInMountainArray();
		int result = -1;
		int a[] = { 0, 1, 0 };
		result = obj.peakIndexInMountainArray(a);
		System.out.println(result);

		int b[] = { 0, 2, 1, 0 };
		result = obj.peakIndexInMountainArray(b);
		System.out.println(result);
	}
}