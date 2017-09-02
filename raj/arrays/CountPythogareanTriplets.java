/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class CountPythogareanTriplets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountPythogareanTriplets obj = new CountPythogareanTriplets();
		int result = -1;
		int a[] = { 3, 1, 4, 6, 5 };
		int n = a.length;
		// Time :O(n3), Space : O(1)
		// BruteForce
		result = obj.countPythogareanTripletsBruteForce(a, n);
		System.out.println(result);

		int b[] = { 3, 1, 4, 6, 5 };
		// Time :O(n2), Space : O(1)
		result = obj.countPythogareanTriplets(b, b.length);
		System.out.println(result);

		int c[] = { 3, 1, 4, 6, 5 };
		// Time :O(n2), Space : O(1)
		result = obj.countPythogareanTripletsMethod2(c, c.length);
		System.out.println(result);

	}

	public int countPythogareanTripletsMethod2(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			a[i] = a[i] * a[i];
		}
		Arrays.sort(a);
		CommonUtil.printArray(a);
		int l, r;
		int sum;
		for (int i = n - 1; i >= 2; i--) {
			l = 0;
			r = i - 1;
			while (l < r) {
				sum = a[l] + a[r];
				if (sum > a[i]) {
					r--;
				} else if (sum < a[i]) {
					l++;
				} else {
					System.out.println("a=" + Math.sqrt(a[l]) + ",b=" + Math.sqrt(a[r]) + ",c=" + Math.sqrt(a[i]));
					count++;
					l++;
					r--;
				}
			}
		}
		return count;
	}

	public int countPythogareanTriplets(int[] a, int n) {
		int count = 0, k;

		for (int i = 0; i < n; i++) {
			a[i] = a[i] * a[i];
		}
		Arrays.sort(a);

		for (int i = 0; i < n - 2; i++) {
			k = i + 2;
			for (int j = i + 1; j < n - 1; j++) {
				while (k < n && a[i] + a[j] == a[k]) {
					if (j != k) {
						System.out.println("a=" + Math.sqrt(a[i]) + ",b=" + Math.sqrt(a[j]) + ",c=" + Math.sqrt(a[k]));
						count++;
					}
					k++;
				}
			}
		}
		return count;
	}

	public int countPythogareanTripletsBruteForce(int[] a, int n) {
		int count = 0;
		Arrays.sort(a);
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (a[i] + a[j] > a[k] && isPythogarean(a[i], a[j], a[k])) {

						System.out.println("a=" + a[i] + ",b=" + a[j] + ",c=" + a[k]);
						count++;
					}
				}
			}
		}
		return count;
	}

	public boolean isPythogarean(int a, int b, int c) {
		return (a * a) + (b * b) == (c * c);
	}

}
