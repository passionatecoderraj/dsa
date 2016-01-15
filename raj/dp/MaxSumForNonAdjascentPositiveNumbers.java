package com.raj.dp;

public class MaxSumForNonAdjascentPositiveNumbers {

	public static void main(String[] args) {
		// int a[] = { 2, 1, 2, 3, 1 };
		// int a[] = { 5, 5, 10, 40, 50, 35 };
		int a[] = { 2, 10, 13, 4, 2, 15, 10 };

		MaxSumForNonAdjascentPositiveNumbers obj = new MaxSumForNonAdjascentPositiveNumbers();
		int result = -1;
		// Time : O(n), Space : O(1)
		result = obj.maxSumForNonAdjascentPositiveNumbers(a);
		System.out.println(result);
	}

	public int maxSumForNonAdjascentPositiveNumbers(int[] a) {
		int n = a.length;
		if (n <= 0)
			return -1;
		int incl = a[0];
		int excl = 0, temp;
		for (int i = 1; i < n; i++) {
			temp = incl;
			incl = Math.max(excl + a[i], incl);
			excl = temp;
		}
		return incl;
	}

}
