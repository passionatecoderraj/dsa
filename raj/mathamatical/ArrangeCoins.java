/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *         You have a total of n coins that you want to form in a staircase
 *         shape, where every k-th row must have exactly k coins.
 * 
 *         Given n, find the total number of full staircase rows that can be
 *         formed.
 * 
 *         n is a non-negative integer and fits within the range of a 32-bit
 *         signed integer.
 * 
 *         Example 1:
 * 
 *         n = 5
 *
 *         Because the 3rd row is incomplete, we return 2.
 * 
 *         https://leetcode.com/problems/arranging-coins/
 */
public class ArrangeCoins {

	// Time :O(n)
	public int arrangeCoinsOlogn(int n) {
		// to prevent int overflow
		long nLong = (long) n;
		long left = 1, right = nLong;
		long mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			long tot = (mid * (mid + 1)) / 2;
			if (tot > nLong) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int) left - 1;
	}

	// Time :O(n)
	public int arrangeCoinsOn(int n) {
		int i = 1;
		while (n - i >= 0) {
			n = n - i++;
		}
		return i - 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrangeCoins obj = new ArrangeCoins();
		int result = -1;
		result = obj.arrangeCoinsOn(230);
		System.out.println(result);
		result = obj.arrangeCoinsOlogn(230);
		System.out.println(result);
	}

}
