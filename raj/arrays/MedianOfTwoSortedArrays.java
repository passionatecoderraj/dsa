/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class MedianOfTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		int a1[] = { 1, 12, 15, 26, 38 };
		int a2[] = { 2, 13, 17, 30, 45 };
		int result = -1;
		result = obj.medianOfTwoSortedArrays(a1, a2);
		System.out.println(result);
		result = obj.median(a1, 0, a2.length - 1);
		System.out.println(result);
	}

	public int medianOfTwoSortedArrays(int[] a1, int[] a2) {
		int m1, m2, l1, l2, r1, r2, d1, d2;
		l1 = l2 = 0;
		r1 = r2 = a1.length - 1;
		d1 = r1 - l1 + 1;
		d2 = r2 - l2 + 1;

		while (d1 > 2 && d2 > 2) {
			m1 = median(a1, l1, r1);
			m2 = median(a2, l2, r2);
			if (m1 == m2) {
				return m1;
			} else if (m1 > m2) {
				r1 = m1;
				l2 = m2;
			} else {
				l1 = m1;
				r2 = m2;
			}
		}
		
		
		return 0;
	}

	public int median(int[] a, int start, int end) {
		int n = end - start + 1;

		if (n % 2 != 0) {
			return a[n / 2];
		} else {
			int k = n / 2;
			return (a[k] + a[k - 1]) / 2;
		}

	}

}
