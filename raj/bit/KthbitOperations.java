/**
 * 
 */
package com.raj.bit;

/**
 * @author Raj
 *
 */

public class KthbitOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KthbitOperations obj = new KthbitOperations();
		obj.checkWhetherKthBitIsSet(21, 3);
		obj.setKthBit(17, 3);
		obj.unSetKthBit(21, 3);
		obj.toggleKthBit(17, 3);
	}

	public boolean checkWhetherKthBitIsSet(int n, int k) {
		System.out.println(Integer.toBinaryString(n) + " k=" + k);
		boolean result = (n & (1 << (k - 1))) > 0;
		System.out.println(result);
		return result;
	}

	public int setKthBit(int n, int k) {
		System.out.println(Integer.toBinaryString(n) + " k=" + k);
		n = (n | (1 << (k - 1)));
		System.out.println(Integer.toBinaryString(n));
		return n;
	}

	public int unSetKthBit(int n, int k) {
		System.out.println(Integer.toBinaryString(n) + " k=" + k);
		n = (n & ~(1 << (k - 1)));
		System.out.println(Integer.toBinaryString(n));
		return n;
	}

	public int toggleKthBit(int n, int k) {
		System.out.println(Integer.toBinaryString(n) + " k=" + k);
		n = (n ^ (1 << (k - 1)));
		System.out.println(Integer.toBinaryString(n));
		return n;
	}

}
