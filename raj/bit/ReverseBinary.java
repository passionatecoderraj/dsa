/**
 * 
 */
package com.raj.bit;

/**
 * @author Raj
 *
 */
public class ReverseBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseBinary obj = new ReverseBinary();
		int result = -1, n = 30;
		result = obj.reverseBinary(n);
		System.out.println(result);
	}

	public int reverseBinary(int n) {
		int res = 0;
		while (n > 0) {
			res = res << 1;
			res = res | (n & 1);
			n = n >> 1;
		}
		return res;
	}

}
