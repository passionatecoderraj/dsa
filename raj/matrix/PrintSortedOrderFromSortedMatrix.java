package com.raj.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrintSortedOrderFromSortedMatrix {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 10, 20, 30, 40 }, 
				{ 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, 
				{ 32, 33, 39, 50 }, };
		int m = a.length, n = a[0].length;

		PrintSortedOrderFromSortedMatrix obj = new PrintSortedOrderFromSortedMatrix();

		// Time : O(m*n*logm), Space : O(m)
		obj.print(a, m, n);
	}

	// Time : O(m*n*logm)
	public void print(int[][] a, int m, int n) {
		// assuming m <n
		printKSortedarrays(a, m, n);
	}

	// Time : O(m*n*logm)
	public void printKSortedarrays(int a[][], int m, int n) {
		class Node {
			int key;
			int listNum;

			public Node(int key, int listNum) {
				super();
				this.key = key;
				this.listNum = listNum;
			}
		}
		int ptrs[] = new int[m];
		PriorityQueue<Node> pq = new PriorityQueue<>(m, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.key - o2.key;
			}
		});

		for (int i = 0; i < m; i++) {
			Node node = new Node(a[i][ptrs[i]], i);
			pq.offer(node);
		}
		for (int i = 0; i < m * n; i++) {
			Node node = pq.poll();
			System.out.print(node.key + " ");
			int r = node.listNum;
			ptrs[r]++;
			if (ptrs[r] < a[r].length) {
				Node nd = new Node(a[r][ptrs[r]], r);
				pq.offer(nd);
			}
		}
		System.out.println();
	}

}
