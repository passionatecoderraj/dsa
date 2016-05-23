/**
 * 
 */
package com.raj.bit;

/**
 * @author Raj
 *
 */
/*
 * 
 * http://www.programcreek.com/2014/07/leetcode-power-of-two-java/
 * 
 * is x power of 2 using bit manipulations
 */
public class IsXPowerOf2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsXPowerOf2 obj = new IsXPowerOf2();
		boolean result = false;

		result = obj.isXPowerOf2(64);
		System.out.println(result);
		result = obj.isX2PowerOf2(94);
		System.out.println(result);

	}

	// Time : O(n); n=no.of bits
	// but it can do better in best/average case
	public boolean isXPowerOf2(int x) {
		if (x <= 0)
			return false;
		while (x > 2) {
			int temp1 = x >> 1;
			int temp2 = temp1 << 1;

			if (temp2 - x != 0)
				return false;
			x = x >> 1;
		}
		return true;
	}

	// Time : O(n); n=no.of bits
	public boolean isX2PowerOf2(int x) {
		if (x <= 0)
			return false;
		int count = 0;
		while (x > 0) {
			count += (x & 1);
			x = x >> 1;
		}
		return count == 1;
	}
}
