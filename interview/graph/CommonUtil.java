/**
 * 
 */
package com.interview.graph;

import java.util.List;
import java.util.Set;

import com.raj.nodes.BinaryTreeNode;
import com.raj.nodes.DLLNode;
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

	public static void print2DArray(char[][] t, int m, int n) {
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
				System.out.print((t[i][j] ? "T" : "F") + " ");
			}
			System.out.println();
		}
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void swap(List<Integer> heap, int i, int j) {
		int temp = heap.get(i);
		replace(heap, i, heap.get(j));
		replace(heap, j, temp);
	}

	private static void replace(List<Integer> heap, int index, int value) {
		heap.remove(index);
		heap.add(index, value);
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

	public static void swap(DLLNode<Integer> i, DLLNode<Integer> j) {
		int temp = i.data;
		i.data = j.data;
		j.data = temp;
	}

	public static void swap(BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b) {
		a.data = a.data ^ b.data;
		b.data = a.data ^ b.data;
		a.data = a.data ^ b.data;

	}

	public static void swapLeftRight(DLLNode<Integer> cur) {
		DLLNode<Integer> temp = cur.next;
		cur.next = cur.prev;
		cur.prev = temp;
	}

	public static void swap(int[][] a, int x1, int y1, int x2, int y2) {
		int temp = a[x1][y1];
		a[x1][y1] = a[x2][y2];
		a[x2][y2] = temp;
	}
}
