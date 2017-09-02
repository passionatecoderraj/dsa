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
public class CheckIfArrayElementsAreConsecutive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CheckIfArrayElementsAreConsecutive obj = new CheckIfArrayElementsAreConsecutive();
		boolean result = false;
		int a[] = { 83, 78, 78, 81, 79, 82 };
		int b[] = { 83, 78, 78, 81, 79, 82 };
		int n = a.length;
		// Using sorting, brute force
		// Time : O(nlogn)
		result = obj.checkIfArrayElementsAreConsecutiveUsingSorting(b, b.length);
		System.out.println(result);

		// Time : O(n), Space : O(n)
		result = obj.checkIfArrayElementsAreConsecutive(a, n);
		System.out.println(result);

		// Time : O(n), Space : O(1)
		// it works only if all numbers are positive and array modifications are
		// allowed
		result = obj.checkIfArrayElementsAreConsecutiveWithoutExtraSpace(a, n);
		System.out.println(result);
		CommonUtil.printArray(a);
	}

	public boolean checkIfArrayElementsAreConsecutiveWithoutExtraSpace(int[] a, int n) {
		Pair minmax = findMinMaxUsingTournamentMethod(a, 0, n - 1);
		System.out.println(minmax);
		int len = minmax.max - minmax.min + 1;
		if (len != n)
			return false;

		int index, min = minmax.min;
		for (int i = 0; i < n; i++) {
			index = Math.abs(a[i]) - min;
			if (a[index] < 0) {
				return false;
			}
			a[index] = -a[index];
		}
		return true;
	}

	public boolean checkIfArrayElementsAreConsecutive(int[] a, int n) {
		Pair minmax = findMinMaxUsingTournamentMethod(a, 0, n - 1);
		System.out.println(minmax);
		int len = minmax.max - minmax.min + 1;
		if (len != n)
			return false;

		int index, min = minmax.min;
		boolean visited[] = new boolean[len];
		for (int i = 0; i < n; i++) {
			index = a[i] - min;
			if (visited[index]) {
				return false;
			}
			visited[index] = true;
		}
		return true;
	}

	private Pair findMinMaxUsingTournamentMethod(int a[], int start, int end) {
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
			leftmaxmin = findMinMaxUsingTournamentMethod(a, start, mid);
			rightmaxmin = findMinMaxUsingTournamentMethod(a, mid + 1, end);
		}
		max = leftmaxmin.max > rightmaxmin.max ? leftmaxmin.max : rightmaxmin.max;
		min = leftmaxmin.min < rightmaxmin.min ? leftmaxmin.min : rightmaxmin.min;
		return new Pair(max, min);
	}

	public boolean checkIfArrayElementsAreConsecutiveUsingSorting(int[] a, int n) {
		Arrays.sort(a);
		for (int i = 0; i < n - 1; i++) {
			if (a[i + 1] - a[i] != 1) {
				return false;
			}
		}
		return true;
	}

}
