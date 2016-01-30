/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class Gcd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gcd obj = new Gcd();
		int result = -1;
		int l = 468, m = 24;

		// Time :O(rows*cols), Space : O(rows*cols)
		result = obj.gcd(l, m);
		System.out.println(result);

	}

	public int gcd(int l, int m) {
		int a, b;
		if (l > m) {
			a = l;
			b = m;
		} else {
			a = m;
			b = l;
		}
		
		int r;
		while (a % b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return b;
	}

}
