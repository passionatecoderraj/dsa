/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 */

public class _22UglyNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int result = -1, n = 5;
		_22UglyNumbers obj = new _22UglyNumbers();
		result = obj.getUglyInBruteForce(n);
		System.out.println(result);
	}

	private int getUglyInBruteForce(int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int min(int i, int j, int k) {
		return Math.min(Math.min(i, j), k);
	}

}
