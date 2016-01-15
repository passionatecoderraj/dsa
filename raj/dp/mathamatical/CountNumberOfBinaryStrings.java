package com.raj.dp.mathamatical;

public class CountNumberOfBinaryStrings {

	public static void main(String[] args) {
		CountNumberOfBinaryStrings obj = new CountNumberOfBinaryStrings();
		int result = -1, n = 4;
		result = obj.countBinaryStrings(n);
		System.out.println(result);
		result = obj.countBinaryStringsWithoutStoring(n);
		System.out.println(result);
	}

	public int countBinaryStringsWithoutStoring(int n) {
		int a = 1, b = 1, temp = a + b;
		for (int i = 1; i <= n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}

	public int countBinaryStrings(int n) {
		int a[] = new int[n];
		int b[] = new int[n];
		a[0] = 1;
		b[0] = 1;

		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}

		return a[n - 1] + b[n - 1];
	}

}
