/**
* 
*/
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class MinLengthOfUnsortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		int n = a.length, result = -1;

		MinLengthOfUnsortedArray obj = new MinLengthOfUnsortedArray();
		result = obj.minLengthOfUnsortedArray(a, n);
		System.out.println(result);
	}

	public int minLengthOfUnsortedArray(int[] a, int n) {
		int len = -1;
		int l = 0, h = n - 1;
		while (l < h && a[l] < a[l + 1]) {
			l++;
		}
		while (l < h && a[h] > a[h - 1]) {
			h--;
		}
		if (l == h) {
			len = 0;
		} else {
			int i = 0, j = n - 1;
			Pair minmax = findMinMax(a, l, h);
			while (a[i] < minmax.min)
				i++;
			while (a[j] > minmax.max)
				j--;
			len = j - i + 1;
		}
		return len;
	}

	public Pair findMinMax(int[] a, int l, int h) {
		int min, max;
		int n = h - l + 1;
		if (n % 2 == 0) {
			if (a[l] > a[l + 1]) {
				min = a[l + 1];
				max = a[l];
			} else {
				min = a[l];
				max = a[l + 1];
			}
			l = l + 2;
		} else {
			min = a[l];
			max = a[l];
			l = l + 1;
		}
		while (l < h - 2) {
			if (a[l] > a[l + 1]) {
				if (a[l] > max) {
					max = a[l];
				}
				if (a[l + 1] < min) {
					min = a[l + 1];
				}
			} else {
				if (a[l + 1] > max) {
					max = a[l + 1];
				}
				if (a[l] < min) {
					min = a[l];
				}
			}
			l += 2;
		}
		return new Pair(max, min);
	}

}
