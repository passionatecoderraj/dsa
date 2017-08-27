/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 *
 */
public class ZigzagIterator {

	private int k;
	private int ptrs[];
	private int cur = -1;
	private int a[][];

	ZigzagIterator(int a[][]) {
		this.a = a;
		k = a.length;
		ptrs = new int[k];
	}

	public int next() {
		int list = getNextAvailable();
		if (list != -1) {
			cur = list;
			return a[cur][ptrs[cur]++];
		}
		return -1;
	}

	/*
	 * Same code as hasNext() but returning index
	 */
	private int getNextAvailable() {
		int i = (cur + 1) % k;
		while (i != cur) {
			if (ptrs[i] < a[i].length)
				return i;
			i = (i + 1) % k;
		}
		return -1;
	}

	public boolean hasNext() {
		return getNextAvailable() != -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] a = new int[5][];
		a[0] = new int[] { 1, 5, 8, 9 };
		a[1] = new int[] { 2, 3, 7, 10 };
		a[2] = new int[] { 4, 6 };
		a[3] = new int[] { 9, 14, 16, 19 };
		a[4] = new int[] { 2, 4, 6 };
		ZigzagIterator obj = new ZigzagIterator(a);
		for (int i = 0; i < 100; i++) {
			System.out.print(obj.next() + " ");
		}

	}

}
