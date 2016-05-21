package com.raj.bit;

import com.interivew.graph.CommonUtil;

public class FindTwoRepeatingNumbers {

	public static void main(String[] args) {
		FindTwoRepeatingNumbers obj = new FindTwoRepeatingNumbers();
		int a[] = { 4, 2, 4, 5, 2, 3, 1 };
		int n = a.length;
		// assuming number are ranging from 1...n-2
		obj.findTwoRepeatingNumbers(a, n);

		// using sign change
		int b[] = { 4, 2, 4, 5, 2, 3, 1 };
		obj.findTwoRepeatingNumbersUsingSignChange(b, b.length);

		int c[] = { 4, 2, 4, 5, 2, 3, 1 };
		obj.findTwoRepeatingNumbersUsingBitwise(c, c.length);

	}
	
	public void findTwoRepeatingNumbersUsingBitwise(int[] a, int n) {
		int xor = 0, x = 0, y = 0;
		int k;
		for (int i = 0; i < n; i++)
			xor ^= a[i];

		for (int i = 1; i <= n - 2; i++)
			xor ^= i;

		int set_bit = xor & ~(xor - 1);

		for (int i = 0; i < n; i++) {
			k = set_bit & a[i];
			if (k > 0)
				x ^= a[i];
			else
				y ^= a[i];
		}

		for (int i = 1; i <= n - 2; i++) {
			k = set_bit & i;
			if (k > 0)
				x ^= i;
			else
				y ^= i;
		}
		System.out.println("x=" + x + ",y=" + y);
	}

	public void findTwoRepeatingNumbersUsingSignChange(int[] a, int n) {
		int index;
		for (int i = 0; i < n; i++) {
			index = Math.abs(a[i]) - 1;
			if (a[index] < 0) {
				System.out.println("Repeated : " + (index + 1));
			} else {
				a[index] = -a[index];
			}
		}
	}

	public void findTwoRepeatingNumbers(int[] a, int n) {

		CommonUtil.printArray(a);
		for (int i = 0; i < n; i++) {
			a[(a[i] - 1) % n] += n;
		}
		CommonUtil.printArray(a);
		for (int i = 0; i < n; i++) {
			if (a[i] / n > 1) {
				System.out.println("Repeated : " + (i + 1));
			}
		}
	}

}
