/**
 * 
 */
package com.interivew.graph;

import java.util.Set;

import com.raj.nodes.BinaryTreeNode;
import com.raj.nodes.ListNode;

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

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void swap(char a[], int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void printArray(Set<Integer> set) {
		for (int i : set) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void printArray(int[] a, int start, int n) {
		for (int i = start; i - start < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void swap(ListNode<Integer> a, ListNode<Integer> b) {
		a.data = a.data ^ b.data;
		b.data = a.data ^ b.data;
		a.data = a.data ^ b.data;
	}

	public static BinaryTreeNode<Integer> swapLeftRight(BinaryTreeNode<Integer> cur) {
		BinaryTreeNode<Integer> temp = cur.left;
		cur.left = cur.right;
		cur.right = temp;
		return cur;
	}

}
