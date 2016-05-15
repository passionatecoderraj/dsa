/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 */
/*
 * http://www.programcreek.com/2015/04/leetcode-power-of-four-java/
 * 
 * Power of Four
 * 
 * Power of Three
 * 
 * Power of Two
 * 
 * This program generically checks whehter x is power of n
 * 
 */
public class IsXPowerOfN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsXPowerOfN obj = new IsXPowerOfN();
		boolean result = false;
		result = obj.isXPowerOfNIteratively(64, 3);
		System.out.println(result);

		result = obj.isXPowerOfN(64, 3);
		System.out.println(result);

	}

	public boolean isXPowerOfNIteratively(int x, int n) {
		while (x > 0) {
			if (x == 1)
				return true;
			if (x % n != 0) {
				return false;
			} else {
				x = x / n;
			}
		}
		return false;
	}

	public boolean isXPowerOfN(int x, int n) {
		int pow = (int) (Math.log10(x) / Math.log10(n));
		if (Math.pow(n, pow) == x)
			return true;
		return false;
	}

}
