package com.raj.dp;

public class FloorAndCeilingInSortedArray {

	public static void main(String[] args) {

		FloorAndCeilingInSortedArray obj = new FloorAndCeilingInSortedArray();

		int index = -1, result = -1;
		int a[] = { 1, 2, 8, 10, 10, 12, 19 };
		int x = 20;
		result = obj.celingOfArrayTcOn(a, 0, a.length - 1, x);
		System.out.println(result);
		result = obj.celingOfArrayTcOlogn(a, x);
		System.out.println(result);
		// result = obj.floorOfArrayTcOn(a, 0, a.length - 1, x);
		// System.out.println(result);
		//
		int b[] = { 19, 12, 10, 10, 8, 2, 1 };
		result = obj.floorOfDecreasingArrayTcOn(b, 0, b.length - 1, x);
		System.out.println(result);
		result = obj.floorOfDecreasingArrayTcOlogn(b, x);
		System.out.println(result);

	}

	public int celingOfArrayTcOn(int[] a, int l, int h, int x) {

		if (x <= a[l])
			return a[l];
		if (x > a[h])
			return -1;
		for (int i = l; i < h; i++) {
			if (x > a[i] && x <= a[i + 1])
				return a[i + 1];
		}
		return -1;
	}

	public int celingOfArrayTcOlogn(int input[], int x) {
		int low = 0;
		int high = input.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (input[middle] == x || (input[middle] > x && (middle == 0 || input[middle - 1] < x))) {
				return input[middle];
			} else if (input[middle] < x) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return -1;
	}

	public int floorOfDecreasingArrayTcOlogn(int input[], int x) {
		int low = 0;
		int high = input.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (input[middle] == x || (input[middle] < x && (middle == 0 || input[middle - 1] > x))) {
				return input[middle];
			} else if (input[middle] > x) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return -1;
	}

	public int floorOfDecreasingArrayTcOn(int[] a, int l, int h, int x) {
		if (x >= a[l]) {
			return a[l];
		} else if (x < a[h]) {
			return -1;
		}
		for (int i = l; i < h; i++) {
			if (x < a[i] && x >= a[i + 1]) {
				return a[i + 1];
			}
		}
		return -1;
	}

	/*
	 * public int celingOfDecreasingArrayTcOn(int[] a, int l, int h, int x) { if
	 * (x < a[h]) { return a[h]; } if (x > a[l]) { return -1; } for (int i = h;
	 * i > l; i--) { if (x >= a[i] && x < a[i - 1]) return a[i - 1]; } return
	 * -1; }
	 * 
	 * public int floorOfArrayTcOn(int[] a, int l, int h, int x) {
	 * 
	 * if (x > a[h]) return a[h]; for (int i = h; i > l; i--) { if (x <= a[i] &&
	 * x > a[i - 1]) { return a[i - 1]; } } return -1; }
	 */

}
