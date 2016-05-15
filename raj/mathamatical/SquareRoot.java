/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 */
public class SquareRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SquareRoot obj = new SquareRoot();
		double result = -1;
		int n = 2;

		// Time :O(n)
		result = obj.sqrt(n);
		System.out.println(result);
	}

	public double sqrt(int n) {
		double g = 1.0;
		while (Math.abs(g * g - n) > 0.0000000001) {
			g = (g + (n/ g)) / 2;
		}
		return g;
	}

}
