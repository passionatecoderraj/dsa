package com.interview.practice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import com.interview.graph.BinaryMinHeap;
import com.interview.graph.CommonUtil;
import com.raj.linkedlist.CircularLinkedList;
import com.raj.nodes.ListNode;

public class PracticeImp {

	public char findFirstNonRepeatingCharacter(char[] a, int n) {

		int count[] = new int[26];
		int index;
		for (int i = 0; i < n; i++) {
			index = Character.getNumericValue(a[i]) - 10;
			count[index]++;
		}

		CommonUtil.printArray(count);
		for (int i = 0; i < 26; i++) {
			if (count[i] == 1)
				return a[i];
		}

		return 0;
	}

	public char findMostFrequentCharacter(char[] a, int n) {
		int t[] = new int[256];
		for (int i = 0; i < n; i++) {
			t[a[i]]++;
		}
		int maxCount = 0;
		char frequentChar = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] > maxCount) {
				maxCount = t[i];
				frequentChar = (char) i;
			}
		}
		return frequentChar;
	}

	// if string is aaacccbbde,then it should print a3c3b2de
	// if string is abc,then it should print abc
	public String compressString(String str, int n) {
		if (null == str || str.length() <= 1)
			return str;
		StringBuffer sb = new StringBuffer();

		char pre = str.charAt(0), cur;
		int count = 1;
		for (int i = 1; i < n; i++) {
			cur = str.charAt(i);
			if (cur == pre) {
				count++;
			} else {
				sb.append(pre);
				if (count > 1)
					sb.append(count);
				pre = cur;
				count = 1;
			}
		}
		sb.append(pre);
		if (count > 1)
			sb.append(count);
		return sb.toString();
	}

	public int rainWaterTrapped(int a[], int n) {
		if (n <= 1)
			return 0;
		int lMax[] = new int[n];
		int rMax[] = new int[n];

		int max_on_left = a[0];
		int max_on_right = a[n - 1];

		for (int i = 1; i < n; i++) {
			lMax[i] = max_on_left;
			max_on_left = Math.max(a[i], max_on_left);
		}

		for (int i = n - 2; i >= 0; i--) {
			rMax[i] = max_on_right;
			max_on_right = Math.max(a[i], max_on_right);
		}

		int t = 0;

		for (int i = 1; i < n - 1; i++) {
			if (a[i] < lMax[i] && a[i] < rMax[i]) {
				t += Math.min(lMax[i], rMax[i]) - a[i];
			}
		}
		return t;
	}

	public int maxProfitWith1Transactions(int a[], int n) {
		if (n <= 1)
			return 0;
		int min_so_far = a[0];
		int max_profit = 0;
		for (int i = 1; i < n; i++) {
			max_profit = Math.max(a[i] - min_so_far, max_profit);
			min_so_far = Math.min(min_so_far, a[i]);
		}
		return max_profit;
	}

	public int maxProfitWithAnyNumberOfTransactions(int a[], int n) {
		if (n <= 1)
			return 0;
		int profit = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1])
				profit += a[i] - a[i - 1];
		}
		return profit;
	}

	public int maxProfitWithKTransactions(int a[], int n, int k) {
		if (n <= 1)
			return 0;
		int t[][] = new int[k + 1][n];
		for (int i = 0; i < n; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= k; i++) {
			t[i][0] = 0;
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				int val = 0;
				for (int m = 0; m < j; m++) {
					val = Math.max(a[j] - a[m] + t[i - 1][m], val);
				}
				t[i][j] = Math.max(t[i - 1][j], val);
			}
		}
		return t[k][n - 1];
	}

	public int maxProfitWithKTransactionsUsingMaxDiff(int a[], int n, int k) {
		if (n <= 1)
			return 0;
		int t[][] = new int[k + 1][n];
		for (int i = 0; i < n; i++) {
			t[0][i] = 0;
		}
		for (int i = 0; i <= k; i++) {
			t[i][0] = 0;
		}
		int maxDiff;
		for (int i = 1; i <= k; i++) {
			maxDiff = t[i - 1][0] - a[0];
			for (int j = 1; j < n; j++) {
				t[i][j] = Math.max(t[i - 1][j], maxDiff + a[j]);
				maxDiff = Integer.max(maxDiff, t[i - 1][j] - a[j]);
			}
		}
		return t[k][n - 1];
	}

	// if 468 is given,it's reversed to 864
	public int reverseInteger(int n) {
		int rev = 0;
		while (n != 0) {
			rev = rev * 10 + (n % 10);
			n = n / 10;
		}
		return rev;
	}

	public int gcd(int a, int b) {
		return b != 0 ? gcd(b, a % b) : a;
	}

	public void calculateSpan(int[] a, int n) {
		if (n <= 0)
			return;

		int t[] = new int[n];
		Deque<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && a[i] >= a[stack.peekFirst()]) {
				stack.pop();
			}

			if (stack.isEmpty())
				t[i] = i + 1;
			else
				t[i] = i - stack.peekFirst();

			stack.push(i);
		}
	}

	// new size of array, after removing duplicates
	// Time : O(n2)
	public int removeDuplicatesInArray(int a[], int n) {
		int key, removed;
		for (int i = 0; i < n; i++) {
			key = a[i];
			removed = 0;
			for (int j = i + 1, k = i + 1; j < n; j++) {
				if (a[j] == key) {
					removed++;
				} else {
					a[k++] = a[j];
				}
			}
			n = n - removed;
		}
		return n;
	}

	// Time : O(nlogn)
	public int removeDuplicateInArrayUsingSorting(int a[], int n) {
		Arrays.sort(a);
		for (int i = 1; i < n; i++) {
			if (a[i] == a[i - 1])
				a[i - 1] = 0;
		}
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && a[l] != 0)
				l++;
			while (l < r && a[r] == 0)
				r--;
			if (l < r)
				CommonUtil.swap(a, l++, r--);
		}
		return l;
	}

	// Time : O(n)
	public void removeDuplicatesInSortedList(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return;
		while (root.next != null) {
			if (root.next.data == root.data)
				root.next = root.next.next;
			else
				root = root.next.next;
		}
	}

	// Time : O(n)
	public void removeDuplicatesInSortedCircularList(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return;
		ListNode<Integer> cur = root;

		while (cur.next != root) {
			if (cur.next.data == cur.data)
				cur.next = cur.next.next;
			else
				cur = cur.next.next;
		}
	}

	// Time : O(n2)
	public void removeDuplicatesInUnsortedList(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return;
		ListNode<Integer> cur1, cur2;
		cur1 = root;
		while (cur1 != null && cur1.next != null) {
			cur2 = cur1;
			while (cur2.next != null) {
				if (cur1.data == cur2.next.data)
					cur2.next = cur2.next.next;
				else
					cur2 = cur2.next;
			}
			cur1 = cur1.next;
		}
	}

	// Time : O(nlogn)
	public ListNode<Integer> removeDuplicatesInUnsortedListUsingSorting(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return root;
		root = new PracticeLinkedLists().mergeSort(root);
		removeDuplicatesInSortedList(root);
		return root;
	}

	// Time : O(n2)
	public void removeDuplicatesInUnsortedCircularList(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return;
		ListNode<Integer> cur1, cur2;
		cur1 = root;
		while (cur1 != null && cur1.next != root) {
			cur2 = cur1;
			while (cur2.next != root) {
				if (cur1.data == cur2.next.data)
					cur2.next = cur2.next.next;
				else
					cur2 = cur2.next;
			}
			cur1 = cur1.next;
		}
	}

	// Time : O(nlogn)
	public ListNode<Integer> removeDuplicatesInUnsortedCircularListUsingSorting(ListNode<Integer> root) {
		if (root == null || root.next == root)
			return root;
		ListNode<Integer> last;
		last = new CircularLinkedList<Integer>().getLastNodeInCLL(root);
		last.next = null;
		root = new PracticeLinkedLists().mergeSort(root);
		removeDuplicatesInSortedCircularList(root);
		last = new CircularLinkedList<Integer>().getLastNodeInCLL(root);
		last.next = root;
		return root;
	}

	public ListNode<Integer> removeAllNodesOfData(ListNode<Integer> root, int data) {
		if (root == null)
			return root;
		ListNode<Integer> cur, head;
		head = new ListNode<Integer>(0);
		head.next = root;
		cur = head;
		while (cur.next != null) {
			if (cur.next.data == data)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return head.next;
	}

	public int countIslands(int a[][], int m, int n) {

		int moves[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, 1 }, { -1, -1 }, { 1, 1 }, { -1, 1 } };
		int count = 0;

		boolean t[][] = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!t[i][j]) {
					dfs(a, m, n, t, i, j, moves);
					count++;
				}
			}
		}
		return count;
	}

	public void dfs(int[][] a, int m, int n, boolean[][] t, int x, int y, int[][] moves) {

		t[x][y] = true;
		int _x, _y;
		for (int i = 0; i < moves.length; i++) {
			_x = x + moves[i][0];
			_y = y + moves[i][1];
			if (isSafeToMoveInIsland(a, m, n, _x, _y)) {
				t[_x][_y] = true;
			}
		}
	}

	public boolean isSafeToMoveInIsland(int[][] a, int m, int n, int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n && a[x][y] == 1;
	}

	/*
	 * We have two sorted array. Without using additional memory we need to
	 * merge these two arrays(longer array is having more space for merging).
	 * Output should return through second arraY
	 */
	public void mergeTwoArraysWithoutExtraSpace(int longArr[], int longUsed, int shortArr[], int shortArrLen) {
		int longArrTail = longUsed - 1;
		int shortArrTail = shortArrLen - 1;
		while (shortArrTail >= 0 && longArrTail >= 0) {
			if (longArr[longArrTail] > shortArr[shortArrTail]) {
				longArr[longArrTail + shortArrTail + 1] = longArr[longArrTail];
				longArrTail--;
			} else {
				longArr[longArrTail + shortArrTail + 1] = shortArr[shortArrTail];
				shortArrTail--;
			}
		}

		while (shortArrTail >= 0) {
			longArr[shortArrTail] = shortArr[shortArrTail];
			shortArrTail--;
		}
	}

	// array is of k*n size
	// k sorted array and each array has length of n
	// O(nklogk), space : O(k)
	public int[] mergeKSortedArrays(int a[][], int n, int k) {
		int ptr[] = new int[k];
		// pointers of each array
		for (int i = 0; i < k; i++) {
			ptr[i] = 0;
		}
		BinaryMinHeap<HeapNode> heap = new BinaryMinHeap<>();
		for (int i = 0; i < k; i++) {
			if (ptr[i] < n) {
				HeapNode node = new HeapNode(a[i][ptr[i]], i);
				heap.add(a[i][ptr[i]], node);
			} else {
				HeapNode node = new HeapNode(Integer.MAX_VALUE, i);
				heap.add(Integer.MAX_VALUE, node);
			}
		}

		int res[] = new int[n * k];

		HeapNode temp;
		for (int i = 0; i < n * k; i++) {
			temp = heap.extractMin();
			res[i] = temp.value;
			ptr[temp.listNumber]++;
			if (ptr[temp.listNumber] < n) {
				HeapNode node = new HeapNode(a[temp.listNumber][ptr[temp.listNumber]], temp.listNumber);
				heap.add(a[temp.listNumber][ptr[temp.listNumber]], node);
			} else {
				HeapNode node = new HeapNode(Integer.MAX_VALUE, temp.listNumber);
				heap.add(Integer.MAX_VALUE, node);
			}
		}
		return res;
	}

	// Time : O(nk2), Space: it becomes more
	public int[] mergeKSortedArraysUsingMergeProcedure(int a[][], int n, int k) {
		if (k <= 0)
			return null;
		int[] p;
		p = a[0];
		for (int i = 1; i < k; i++) {
			p = merge(p, p.length, a[i], a[i].length);
		}

		return p;
	}

	public int[] merge(int a[], int m, int b[], int n) {
		int c[] = new int[m + n];
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		while (i < m) {
			c[k++] = a[i++];
		}

		while (j < n) {
			c[k++] = b[j++];
		}

		return c;
	}

}
