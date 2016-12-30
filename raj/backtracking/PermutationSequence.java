package com.raj.backtracking;

/**
 * 
 * @author Raj
 * 
 *         Find all possible combinations of k numbers that add up to a number
 *         n, given that only numbers from 1 to 9 can be used and each
 *         combination should be a unique set of numbers.
 * 
 * 
 *         Input : k = 3, n = 9
 * 
 *         Output : [[1,2,6], [1,3,5], [2,3,4]]
 * 
 */
public class PermutationSequence {

	private void permute(int n, int k) {

		int a[] = new int[n];
		a[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + 1;
		}
		permuteUtil(a, 0);
	}

	private void permuteUtil(int res[], int i) {
		if (i == res.length) {
			for (int k : res) {
				System.out.print(k + " ");
			}
			System.out.println();
			return;
		}
		for (int j = i; j < res.length; j++) {
			swap(res, i, j);
			permuteUtil(res, i + 1);
			swap(res, i, j);
		}
	}

	void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String args[]) {
		PermutationSequence obj = new PermutationSequence();
		// wrong solution(it seems)
		obj.permute(3, 4);

	}

}