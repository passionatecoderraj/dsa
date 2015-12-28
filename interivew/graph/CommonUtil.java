/**
 * 
 */
package com.interivew.graph;

/**
 * @author Raj
 *
 */
public class CommonUtil {

	public static void printArray(Object[] a) {
		int n = a.length;
		if (n > 0) {
			for (Object i : a)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	public static void printArray(char[] a) {
		int n = a.length;
		if (n > 0) {
			for (char i : a)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	public static void printArray(int[] a) {
		int n = a.length;
		if (n > 0) {
			for (int i : a)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	public static void print2DArray(int[][] t, int m, int n, int start) {
		for (int i = start; i <= m; i++) {
			for (int j = start; j <= n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void print2DArray(Object[][] t, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void print2DArray(int[][] t, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void print2DArray(boolean[][] t, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
	}
}
