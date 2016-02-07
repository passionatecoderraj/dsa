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

		result = obj.gcd(l, m);
		System.out.println(result);
		
		result = obj.gcdd(l, m);
		System.out.println(result);

	}

	public int gcdd(int a, int b) {
		return b != 0 ? gcdd(b, a % b) : a;
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
