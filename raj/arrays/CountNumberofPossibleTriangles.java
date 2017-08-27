./**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;

/**
 * @author Raj
 *
 */
public class CountNumberofPossibleTriangles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountNumberofPossibleTriangles obj = new CountNumberofPossibleTriangles();
		int result = -1;
		int a[] = { 21, 100, 200, 22, 10, 300, 101, };
		int n = a.length;
		// Time :O(n3), Space : O(1)
		// BruteForce
		result = obj.countNumberOfPossibleTrianglesBruteForce(a, n);
		System.out.println(result);

		int b[] = { 21, 100, 200, 22, 10, 300, 101, };
		// Time :O(n2), Space : O(1)
		result = obj.countNumberOfPossibleTriangles(b, b.length);
		System.out.println(result);

		int c[] = { 21, 100, 200, 22, 10, 300, 101, };
		// Time :O(n2), Space : O(1)
		result = obj.countNumberOfPossibleTrianglesWithSmallChange(c, c.length);
		System.out.println(result);

	}

	public int countNumberOfPossibleTrianglesWithSmallChange(int[] a, int n) {
		int count = 0, k;
		Arrays.sort(a);
		for (int i = 0; i < n - 2; i++) {
			k = i + 2;
			for (int j = i + 1; j < n - 1; j++) {
				while (k < n && a[i] + a[j] > a[k]) {
					if (k != j) {
						System.out.println("a=" + a[i] + ",b=" + a[j] + ",c=" + a[k]);
						count++;
					}
					k++;
				}
			}
		}
		return count;
	}

	public int countNumberOfPossibleTriangles(int[] a, int n) {
		int count = 0, k;
		Arrays.sort(a);
		for (int i = 0; i < n - 2; i++) {
			k = i + 2;
			for (int j = i + 1; j < n - 1; j++) {
				while (k < n && a[i] + a[j] > a[k]) {
					if (k != j)
						System.out.println("a=" + a[i] + ",b=" + a[j] + ",c=" + a[k]);
					k++;
				}
				count += k - j - 1;
			}
		}
		return count;
	}

	public int countNumberOfPossibleTrianglesBruteForce(int[] a, int n) {
		int count = 0;
		Arrays.sort(a);
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (a[i] + a[j] > a[k]) {
						System.out.println("a=" + a[i] + ",b=" + a[j] + ",c=" + a[k]);
						count++;
					}
				}
			}
		}
		return count;
	}

}
