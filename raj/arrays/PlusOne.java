package com.raj.arrays;

import java.util.Arrays;

public class PlusOne {
	public static int[] plusOne(int[] a) {

		int carry = 1;
		for (int i = a.length - 1; i >= 0; i--) {
			int val = carry + a[i];
			a[i] = val % 10;
			carry = val / 10;
		}
		if (carry == 1) {
			int b[] = new int[a.length + 1];
			b[0] = 1;
			for (int i = 0; i < a.length; i++) {
				b[i + 1] = a[i];
			}
			a = b;
		}
		return a;
	}

	public static void main(String args[]) {
		int a[] = { 9, 9 };
		int res[] = plusOne(a);
		System.out.println(Arrays.toString(res));
	}
}