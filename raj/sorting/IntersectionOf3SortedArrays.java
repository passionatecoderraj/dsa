/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class IntersectionOf3SortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 5, 10, 20, 40, 80 };
		int b[] = { 6, 7, 20, 80, 100 };
		int c[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
		IntersectionOf3SortedArrays obj = new IntersectionOf3SortedArrays();

		// Time : O(m+n+o), Space : O(m+n or n+o or o+m)
		obj.intersection(a, b, c);

		// Time : O(m+n+o), Space : O(1)
		// in single traversal
		obj.intersectionWithoutExtraSpace(a, b, c);

	}

	public void intersectionWithoutExtraSpace(int[] a, int[] b, int[] c) {
		int n1 = a.length, n2 = b.length, n3 = c.length;
		int i, j, k;
		i = j = k = 0;

		while (i < n1 && j < n2 && k < n3) {
			if (a[i] == b[j] && b[j] == c[k]) {
				System.out.print(a[i] + " ");
				i++;
				j++;
				k++;

			}
			// a[i]
			else if (a[i] < b[j]) {
				i++;
			} else if (b[j] < c[k]) {
				j++;
			} else {
				// we reach here when a[i]>b[j] && b[j] > c[k]
				// it means c[k] is the smallest
				k++;
			}
		}
		System.out.println();
	}

	public void intersection(int[] a, int[] b, int[] c) {
		int res[] = intersectionOfTwoArrays(c, intersectionOfTwoArrays(a, b));
		CommonUtil.printArray(res);
	}

	public int[] intersectionOfTwoArrays(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;

		int k = Math.max(m, n);
		int res[] = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = -1;
		}
		int i, j;
		i = j = 0;

		int l = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				res[l++] = a[i];
				i++;
				j++;

			}
		}

		// removing all other elements and creating new array
		int result[] = new int[l];
		System.arraycopy(res, 0, result, 0, l);
		
		return result;
	}

}
