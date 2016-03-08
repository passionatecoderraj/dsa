package com.raj.matrix;

public class PrintUniqueRowsInMatrix {
	public static void main(String args[]) throws Exception {

		int a[][] = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0 } };
		int m = a.length, n = a[0].length;
		// Time : O(m*m*n)
		// printUniqueRows(a, m, n);

		printUniqueRowsUsingTrie(a, m, n);
	}

	public static void printUniqueRowsUsingTrie(int[][] a, int m, int n) {
		TrieForMatrix trie = new TrieForMatrix();
		for (int i = 0; i < m; i++) {
			if (trie.insertKthRowOfMatrix(a, m, n, i))
				printKthRowOfMatrix(a, m, n, i);
		}
		// int b[] = new int[n + 1];
		// trie.printRootToLeavePaths(0, trie.root, b);
	}

	// Time : O(m*m*n), Space : O(1)
	public static void printUniqueRows(int[][] a, int m, int n) {
		printKthRowOfMatrix(a, m, n, 0);
		boolean curRowDuplicate = false;
		for (int i = 1; i < m; i++) {
			curRowDuplicate = false;
			for (int k = 0; k < i && !curRowDuplicate; k++) {
				if (areBothRowsDuplicate(a, m, n, i, k))
					curRowDuplicate = true;
			}
			if (!curRowDuplicate)
				printKthRowOfMatrix(a, m, n, i);
		}
	}

	public static boolean areBothRowsDuplicate(int a[][], int m, int n, int k1, int k2) {
		for (int j = 0; j < n; j++) {
			if (a[k1][j] != a[k2][j])
				return false;
		}
		return true;
	}

	public static void printKthRowOfMatrix(int a[][], int m, int n, int k) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[k][i] + " ");
		}
		System.out.println();
	}

}
