package com.raj.arrays;

import com.interivew.graph.CommonUtil;

public class FindTwoRepeatingNumbers {

	public static void main(String[] args) {
		FindTwoRepeatingNumbers obj = new FindTwoRepeatingNumbers();
		int a[] = { 4, 2, 4, 5, 2, 3, 1 };
		int n = a.length;
		// assuming number are ranging from 0...n-1
		obj.findTwoRepeatingNumbers(a, n);

		// using sign change
		int b[] = { 4, 2, 4, 5, 2, 3, 1 };
		obj.findTwoRepeatingNumbersUsingSignChange(b, b.length);

		// TODO: using bit wise operator

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
