package com.raj.bit;

/**
 * http://www.geeksforgeeks.org/next-power-of-2/
 * 
 * Write a function that, for a given no n, finds a number p which is greater
 * than or equal to n and is a power of 2.
 * 
 * if n is 4 , return 4
 * 
 * if n is 5 return 8
 */
public class NextPowerOf2 {

	public int nextPowerOf2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}

	public static void main(String args[]) {
		NextPowerOf2 np = new NextPowerOf2();
		System.out.println(np.nextPowerOf2(5));
	}
}