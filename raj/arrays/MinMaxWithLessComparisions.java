/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class MinMaxWithLessComparisions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1000, 11, 445, 1, 330, 3000 };
		Pair result = null;
		int n = a.length;
		MinMaxWithLessComparisions obj = new MinMaxWithLessComparisions();
		// number of comparisons 2+2(n-2) in worse case
		result = obj.maxAndMinWithMinimumComparisions(a, n);
		System.out.println(result);

		// Using tournament method
		// number of comparisons 3n/2-2 in worse case
		// https://www.quora.com/How-does-the-tournament-method-for-finding-the-maximum-and-minimum-element-in-an-array-consist-of-3n-2-2-comparisons
		result = obj.minMaxUsingTournamentMethod(a, 0, n - 1);
		System.out.println(result);

		// comparison in pairs
		/*
		 * If n is odd: 3*(n-1)/2 If n is even: 1 Initial comparison for
		 * initializing min and max, and 3(n-2)/2 comparisons for rest of the
		 * elements = 1 + 3*(n-2)/2 = 3n/2 -2
		 */
		result = obj.minMaxComparisionsinPairs(a, n);
		System.out.println(result);
	}

	public Pair minMaxComparisionsinPairs(int[] a, int n) {
		int max, min, i;
		if (n % 2 == 0) {
			if (a[0] > a[1]) {
				max = a[0];
				min = a[1];
			} else {
				max = a[1];
				min = a[0];
			}
			i = 2;
		} else {
			min = max = a[0];
			i = 1;
		}

		while (i < n - 1) {
			if (a[i] > a[i + 1]) {
				if (a[i] > max) {
					max = a[i];
				}
				if (a[i + 1] < min) {
					min = a[i + 1];
				}
			} else {
				if (a[i + 1] > max) {
					max = a[i + 1];
				}
				if (a[i] < min) {
					min = a[i];
				}
			}
			i += 2;
		}
		return new Pair(max, min);
	}

	public Pair minMaxUsingTournamentMethod(int[] a, int start, int end) {
		int n = end - start + 1;
		int max, min;
		Pair leftmaxmin, rightmaxmin;
		if (n == 1) {
			min = max = a[start];
			return new Pair(max, min);
		} else if (n == 2) {
			if (a[start] > a[end]) {
				max = a[start];
				min = a[end];
			} else {
				max = a[end];
				min = a[start];
			}
			return new Pair(max, min);
		} else {
			int mid = start + (end - start) / 2;
			leftmaxmin = minMaxUsingTournamentMethod(a, start, mid);
			rightmaxmin = minMaxUsingTournamentMethod(a, mid + 1, end);
		}
		max = leftmaxmin.max > rightmaxmin.max ? leftmaxmin.max : rightmaxmin.max;
		min = leftmaxmin.min < rightmaxmin.min ? leftmaxmin.min : rightmaxmin.min;
		return new Pair(max, min);
	}

	public Pair maxAndMinWithMinimumComparisions(int[] a, int n) {
		if (n <= 0)
			return null;

		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		if (n == 1) {
			return new Pair(a[0], a[0]);
		}

		if (a[0] > a[1]) {
			max = a[0];
			min = a[1];
		} else {
			max = a[1];
			min = a[0];
		}

		for (int i = 2; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
			} else if (a[i] < min) {
				min = a[i];
			}
		}
		return new Pair(max, min);
	}

}

class Pair {
	int max;
	int min;

	public Pair(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}

	@Override
	public String toString() {
		return "Pair [max=" + max + ", min=" + min + "]";
	}

}
