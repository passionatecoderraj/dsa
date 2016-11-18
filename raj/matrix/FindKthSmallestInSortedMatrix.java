package com.raj.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author Raj
 * 
 *         Kth smallest element in a row-wise and column-wise sorted 2D array
 */
public class FindKthSmallestInSortedMatrix {
	public int findKthSmallest(int[][] a, int m, int n, int k) {
		class HeapNode {
			int r;
			int c;
			int key;

			public HeapNode(int r, int c, int key) {
				super();
				this.r = r;
				this.c = c;
				this.key = key;
			}

		}
		PriorityQueue<HeapNode> pq = new PriorityQueue<>(new Comparator<HeapNode>() {

			@Override
			public int compare(HeapNode o1, HeapNode o2) {

				return o1.key - o2.key;
			}
		});

		for (int i = 0; i < n; i++) {
			pq.add(new HeapNode(0, i, a[0][i]));
		}
		HeapNode temp = null;
		for (int i = 0; i < k; i++) {
			temp = pq.poll();
			int next = temp.r >= n - 1 ? Integer.MAX_VALUE : a[temp.r + 1][temp.c];
			pq.add(new HeapNode(temp.r + 1, temp.c, next));
		}
		return temp.key;
	}

	public static void main(String args[]) throws Exception {

		int a[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		int m = a.length, n = a[0].length;

		FindKthSmallestInSortedMatrix obj = new FindKthSmallestInSortedMatrix();

		int res = -1, k = 1;

		// Time : O(m+n), if m==n , then Time :O(n)
		res = obj.findKthSmallest(a, m, n, k);
		System.out.println(res);
	}

	@Override
	public String toString() {
		return "FindKthSmallestInSortedMatrix [toString()=" + super.toString() + "]";
	}

}