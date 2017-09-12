/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 */
public class SquareRoot {

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

		result = obj.squareRoot(0.36);
		System.out.println(result);
	}

	public double sqrt(int n) {
		double g = 1.0;
		while (Math.abs(g * g - n) > 0.0000000001) {
			g = (g + (n / g)) / 2;
		}
		return g;
	}

}
