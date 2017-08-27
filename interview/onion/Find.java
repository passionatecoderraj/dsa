package com.interview.onion;

import java.util.Arrays;

public class Find {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = -1;
		String blocks[] = { "5", "-2", "4", "Z", "X", "9", "+", "+" };
		res = find(blocks, blocks.length);
		System.out.println(res);
	}

	private static int find(String blocks[], int n) {
		if (null == blocks || blocks.length == 0 || n <= 0)
			return 0;
		int sum = 0, cur;

		int t[] = new int[n];
		Arrays.fill(t, Integer.MIN_VALUE);
		for (int i = 0; i < n; i++) {
			String block = blocks[i];
			if (null == block || block.isEmpty())
				continue;
			cur = Integer.MIN_VALUE;
			if (isInteger(block)) {
				cur = Integer.parseInt(block);
			} else if (block.charAt(0) == '+') {
				int j = i - 1;
				int a = getPrevOf(t, j);
				int lSum = Integer.MIN_VALUE;
				if (a != Integer.MIN_VALUE) {
					lSum = a;
					j = j - 1;
				}
				int b = getPrevOf(t, j);

				if (b != Integer.MIN_VALUE) {
					lSum += b;
				}
				if (lSum != Integer.MIN_VALUE) {
					cur = lSum;
				}

			} else if (block.charAt(0) == 'Z') {
				if (i > 0) {
					t[i - 1] = Integer.MIN_VALUE;
				}

			} else if (block.charAt(0) == 'X') {
				int b = getPrevOf(t, i - 1);

				if (b != Integer.MIN_VALUE) {
					cur = 2 * b;
				}

			}

			t[i] = cur;
		}

		for (int i = 0; i < n; i++) {
			if (t[i] != Integer.MIN_VALUE) {
				sum += t[i];
			}
		}
		System.out.println(Arrays.toString(t));
		return sum;
	}

	private static int getPrevOf(int t[], int j) {
		while (j >= 0 && t[j] == Integer.MIN_VALUE) {
			j--;
		}
		return j >= 0 ? t[j] : Integer.MIN_VALUE;

	}

	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}
}
