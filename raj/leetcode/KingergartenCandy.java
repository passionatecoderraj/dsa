package com.raj.leetcode;

import java.util.Arrays;

public class KingergartenCandy {

	public static void main(String[] args) {
		KingergartenCandy obj = new KingergartenCandy();
		int[] a = { 1, 2, 2 };
		int result = 0;
		result = obj.candy(a);
		System.out.println(result);
		result = obj.candy2(a);
		System.out.println(result);

		int b[] = { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 };
		result = obj.candy(b);
		System.out.println(result);
		result = obj.candy2(b);
		System.out.println(result);

	}

	public int candy2(int[] score) {
		if (score == null || score.length == 0) {
			return 0;
		}

		int[] candies = new int[score.length];
		Arrays.fill(candies, 1);

		int left, right;
		int result = 0;
		for (int i = 0; i < score.length; i++) {
			left = right = candies[i];
			if (i > 0 && score[i] > score[i - 1]) {
				left = candies[i - 1] + 1;
			}
			if (i < score.length - 1 && score[i] > score[i + 1]) {
				right = candies[i + 1] + 1;
			}
			candies[i] = Math.max(left, right);
			result += candies[i];
		}
		System.out.println(Arrays.toString(candies));
		return result;
	}

	public int candy(int[] score) {
		if (score == null || score.length == 0) {
			return 0;
		}

		int[] candies = new int[score.length];
		candies[0] = 1;

		// from let to right
		for (int i = 1; i < score.length; i++) {
			if (score[i] > score[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				// if not ascending, assign 1
				candies[i] = 1;
			}
		}
		System.out.println(Arrays.toString(candies));

		int result = candies[score.length - 1];
		System.out.print(result + " ");
		// from right to left
		for (int i = score.length - 2; i >= 0; i--) {
			int cur = 1;
			if (score[i] > score[i + 1]) {
				cur = candies[i + 1] + 1;
			}

			result += Math.max(cur, candies[i]);
			candies[i] = cur;
			System.out.print(result + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(candies));

		return result;
	}
}
