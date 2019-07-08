/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

 */
public class SquareRoot {

	// https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation
	// Time :O(logn), Space : O(1)
	public int mySqrt(int x) {
		if (x == 0)
			return 0;
		int start = 1, end = x;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
				return mid;
			else if (mid > x / mid)// Keep checking the left part
				end = mid;
			else
				start = mid + 1;// Keep checking the right part
		}
		return start;
	}

	public double squareRoot(double n) {
		double l, r, m;
		if (n > 1) {
			l = 1;
			r = n;
		} else {
			l = n;
			r = 1;
		}
		while (l <= r) {
			m = l + (r - l) / 2;
			double diff = m * m - n;
			if (Math.abs(diff) <= 0.00001) {
				return m;
			}
			if (diff < 0) {
				l = m;
			} else {
				r = m;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SquareRoot obj = new SquareRoot();
		double result = -1;
		int n = 2;

		// Time :O(n)
		result = obj.sqrt(n);
		System.out.println(result);

		result = obj.squareRoot(25);
		System.out.println(result);

		result = obj.squareRoot(0.0036);
		System.out.println(result);
		
		int res = obj.mySqrt(25);
		System.out.println(res);

	}

	public double sqrt(int n) {
		double g = 1.0;
		while (Math.abs(g * g - n) > 0.0000000001) {
			g = (g + (n / g)) / 2;
		}
		return g;
	}

}
