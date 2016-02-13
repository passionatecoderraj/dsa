/**
 * 
 */
package com.raj.java;

/**
 * @author Raj
 *
 */
public class CheckForOverflow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckForOverflow obj = new CheckForOverflow();

		int result = -1;
		result = obj.addWhileCheckingOverflow(Integer.MAX_VALUE - 5, 4);
		System.out.println(result);

		result = obj.addWhileCheckingOverflow(Integer.MAX_VALUE - 5, 6);
		System.out.println(result);

		int res;
		res = obj.multiplyWhileCheckingOverflow(30, 40);
		System.out.println(res);

		res = obj.multiplyWhileCheckingOverflow(Integer.MAX_VALUE - 5, 6);
		System.out.println(res);

	}

	public int multiplyWhileCheckingOverflow(int a, int b) {
		long res = ((long) a) * ((long) b);
		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
			return -1;
		}
		return (int) res;
	}

	public int addWhileCheckingOverflow(int a, int b) {
		if (a > Integer.MAX_VALUE - b) {
			return -1;
		}
		return a+b;
	}

}
