/**
 * 
 */
package com.raj.bit;

/**
 * @author Raj
 *
 */
public class Count1sInBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Count1sInBinary obj = new Count1sInBinary();
		int result = -1, n = 30;
		result = obj.count1sInBinary(n);
		System.out.println(result);
	}

	public int count1sInBinary(int n) {
		System.out.println(Integer.toBinaryString(n));
		int count = 0;
		int c = 0;
		while (n > 0) {
			c++;
			count += (n & 1);
			n = n >> 1;
		}
		System.out.println(c);
		return count;
	}

}
