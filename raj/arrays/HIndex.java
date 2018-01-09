/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 *         Given an array of citations (each citation is a non-negative integer)
 *         of a researcher, write a function to compute the researcher's
 *         h-index.
 * 
 *         According to the definition of h-index on Wikipedia:
 *         "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * 
 *         For example, given citations = [3, 0, 6, 1, 5], which means the
 *         researcher has 5 papers in total and each of them had received 3, 0,
 *         6, 1, 5 citations respectively. Since the researcher has 3 papers
 *         with at least 3 citations each and the remaining two with no more
 *         than 3 citations each, his h-index is 3.
 * 
 *         Note: If there are several possible values for h, the maximum one is
 *         taken as the h-index.
 * 
 *         Credits: Special thanks to @jianchao.li.fighter for adding this
 *         problem and creating all test cases.
 * 
 * 
 */
public class HIndex {

	// Time : O(n), Space : O(n)
	public int hIndex(int[] citations) {
		int n = citations.length;
		int t[] = new int[n + 1];
		for (int val : citations) {
			if (val >= n)
				t[n]++;
			else
				t[val]++;
		}
		int sum = 0;
		for (int i = n; i >= 0; i--) {
			sum += t[i];
			if (sum >= i)
				return i;
		}
		return 0;
	}

	// Time : O(nlogn)
	public int hIndex2(int[] a) {
		Arrays.sort(a);
		int l = 0, r = a.length - 1;
		while (l < r) {
			swap(a, l++, r--);
		}
		int i = 0;
		while (i < a.length && a[i] > i)
			i++;
		return i;
	}

	void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		HIndex obj = new HIndex();
		int a[] = { 3, 0, 6, 1, 5 };
		int result = -1;
		result = obj.hIndex(a);
		System.out.println(result);

		result = obj.hIndex(new int[] { 2, 3, 4, 3, 4, 5 });
		System.out.println(result);
	}

}
