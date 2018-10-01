package com.raj.leetcode.google;

import java.util.Arrays;

public class PlusOne {

	public int[] plusOne(int[] digits) {

		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;

		return newNumber;
	}

	public int[] plusOne2(int[] a) {

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
		PlusOne obj = new PlusOne();
		int a[] = { 9, 9 };
		int res[] = obj.plusOne(a);
		System.out.println(Arrays.toString(res));
	}
}