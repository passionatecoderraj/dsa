package com.raj.arrays;

public class FindTwoRepeatingNumbers {

	public static void main(String[] args) {
		FindTwoRepeatingNumbers obj = new FindTwoRepeatingNumbers();
		int a[] = { 1, 6, 2, 0, 1, 0, 6, 6 };
		int n = a.length;
		// assuming number are ranging from 0...n-1
		obj.findTwoRepeatingNumbers(a, n);

		// using sign change
		int b[] = { 1, 3, 2, 2, 1 };
		obj.findTwoRepeatingNumbersUsingSignChange(b, b.length);

		// TODO: using bit wise operator

	}

	public void findTwoRepeatingNumbersUsingSignChange(int[] a, int n) {
		int j;
		for (int i = 0; i < n; i++) {
			j = Math.abs(a[i]);
			if (a[j] < 0) {
				System.out.println("Repeated : " + j);
			} else {
				a[j] = -a[j];
			}
		}
	}

	public void findTwoRepeatingNumbers(int[] a, int n) {

		for (int i = 0; i < n; i++) {
			a[a[i] % n] += n;
		}
		for (int i = 0; i < n; i++) {
			if (a[i] / n > 1) {
				System.out.println("Repeated : " + i);
			}
		}
	}

}
