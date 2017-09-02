package com.interview.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import com.interview.graph.CommonUtil;
import com.raj.linkedlist.PalindromeCheckForList;
import com.raj.nodes.BinaryTreeNode;
import com.raj.nodes.LRUCacheDLLNode;
import com.raj.nodes.ListNode;
import com.raj.trees.binary.BinaryTree;

public class PracticeExcel {

	class BSTIterator {
		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();

		BSTIterator(BinaryTreeNode<Integer> root) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public BinaryTreeNode<Integer> next() {
			BinaryTreeNode<Integer> node = stack.pop();
			if (node.right != null) {
				BinaryTreeNode<Integer> temp = node.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}
			return node;
		}
	}

	public int minCoinsToMakeSum2(int[] a, int m) {
		int n = a.length;

		int t[] = new int[m + 1];
		Arrays.fill(t, Integer.MAX_VALUE - 1);
		t[0] = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= a[j]) {
					t[i] = Math.min(1 + t[i - a[j]], t[i]);
				}
			}
		}
		CommonUtil.printArray(t);
		return t[m];
	}

	// Time :O(m+n)
	public int compareVersionNumbers2(String str1, String str2) {
		String a[] = str1.split("\\.");
		String b[] = str2.split("\\.");
		int i = 0, j = 0, v1, v2;
		while (i < a.length || j < b.length) {
			v1 = i < a.length ? Integer.parseInt(a[i++]) : 0;
			v2 = j < b.length ? Integer.parseInt(b[j++]) : 0;
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
		}
		return 0;
	}

	// Time : O(n*logk), Space : O(k)
	public boolean checkForDuplicatesWithInKDistanceAndElementDiffWithInT(int[] a, int n, int k, int t) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			Integer floor = treeSet.floor(a[i]);
			Integer ceil = treeSet.floor(a[i]);
			if (floor != null && a[i] - floor <= t || ceil != null && ceil - a[i] <= t)
				return true;
			if (i >= k) {
				treeSet.remove(a[i - k]);
			}
		}
		return false;
	}

	int sum = 0;

	public void convertBSTtoBinaryTreeWithSumOfMaxKeys(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		convertBSTtoBinaryTreeWithSumOfMaxKeys(root.right);
		sum += root.data;
		root.data = sum;
		convertBSTtoBinaryTreeWithSumOfMaxKeys(root.left);
	}

	public int count1sInBinaryString(int n) {
		int count = 0;
		while (n > 0) {
			count += (n & 1);
			n = n >> 1;
		}
		return count;
	}

	/*
	 * find nth number in sequence
	 * 
	 * 1, 11, 21, 1211, 111221, ..
	 */
	public String countAndSay(int n) {
		if (n <= 0)
			return null;

		String st = "1";
		if (n == 1)
			return st;

		StringBuilder sb;
		for (int i = 1; i < n; i++) {
			sb = new StringBuilder();
			char prev = st.charAt(0), cur;
			int count = 1;
			for (int j = 1; j < st.length(); j++) {
				cur = st.charAt(j);
				if (cur == prev) {
					count++;
				} else {
					sb.append(count);
					sb.append(prev);
					prev = cur;
					count = 1;
				}
			}
			sb.append(count);
			sb.append(prev);
			st = sb.toString();
		}
		return st;
	}

	// input abcca, output 1a1a2c1a
	public String lookAndSay2(String st) {
		int count = 1;
		char prev = st.charAt(0), cur;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < st.length(); i++) {
			cur = st.charAt(i);
			if (cur == prev) {
				count++;
			} else {
				sb.append(count);
				sb.append(prev);
				prev = cur;
				count = 1;
			}
		}
		sb.append(count);
		sb.append(prev);
		return sb.toString();
	}

	// input abcca, output 2a1b2c

	public void countSort(int a[], int n, int m) {
		int count[] = new int[m];
		for (int i = 0; i < n; i++)
			count[a[i]]++;
		for (int i = 1; i < m; i++)
			count[i] = count[i] + count[i - 1];

		int res[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			res[count[a[i]] - 1] = a[i];
			count[a[i]]--;
		}
	}

	public ListNode<Integer> deleteNodeInLinkedList(ListNode<Integer> root, int data) {
		ListNode<Integer> head = new ListNode<>(0);
		head.next = root;
		ListNode<Integer> temp = head;
		while (temp.next != null) {
			if (temp.next.data == data) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return head.next;
	}

	public int findFirstMissingPositive(int a[]) {
		int left = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				CommonUtil.swap(a, i, left++);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < left; i++) {
			min = Math.min(a[i], min);
		}

		for (int i = 0; i < left; i++) {
			int index = Math.abs(a[i]) - min;
			if (index < left && a[index] > 0) {
				a[index] = -a[index];
			}
		}

		for (int i = 0; i < left; i++) {
			if (a[i] > 0)
				return i + 1;
		}
		return left;
	}

	class StackUsingQueue {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		public void pushOverload(int data) {
			if (q1.isEmpty()) {
				q1.offer(data);
			} else {
				while (!q1.isEmpty()) {
					q2.offer(q1.poll());
				}
				q1.offer(data);
				while (!q2.isEmpty()) {
					q1.offer(q2.poll());
				}
			}
		}

		public Integer popOverload(int data) {
			Integer top = null;
			if (q1.isEmpty())
				return top;
			while (!q1.isEmpty()) {
				top = q1.poll();
				if (!q1.isEmpty())
					q2.offer(top);
			}
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
			return top;
		}
	}

	// NUMBERS RANGING FROM 1 TO 3999
	public String integerToRoman(int n) {
		// I =1, X = 10, L=50, C = 100, D = 500, M=1000
		String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] M = { "", "M", "MM", "MMM" };
		return M[n / 1000] + C[(n % 1000) / 100] + X[(n % 100) / 10] + I[n % 10];
	}

	public int romanToInteger(String str) {
		char prev = ' ', cur;
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			cur = str.charAt(i);
			if (cur == 'M' && prev != 'C') {
				res += 1000;
			}
			if (cur == 'C' && prev != 'X') {
				res += 100;
			}
			if (cur == 'X' && prev != 'I') {
				res += 10;
			}

			if (cur == 'M' && prev == 'C') {
				res += 800;
			}
			if (cur == 'C' && prev == 'X') {
				res += 80;
			}
			if (cur == 'X' && prev == 'I') {
				res += 8;
			}

			if (cur == 'D' && prev != 'C') {
				res += 500;
			}
			if (cur == 'L' && prev != 'X') {
				res += 50;
			}
			if (cur == 'V' && prev != 'I') {
				res += 5;
			}

			if (cur == 'D' && prev == 'C') {
				res += 300;
			}
			if (cur == 'L' && prev == 'X') {
				res += 30;
			}
			if (cur == 'V' && prev == 'I') {
				res += 3;
			}

			if (cur == 'I') {
				res += 1;
			}
			prev = cur;
		}
		return res;
	}

	public int findKthLargest(int a[], int k) {
		int l = 0, r = a.length - 1;
		while (l < r) {
			int mid = partition(a, l, r);
			if (mid + 1 == k)
				return a[mid];
			if (mid + 1 > k)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return -1;
	}

	public int partition(int a[], int p, int r) {
		int key = a[r];
		int j;
		j = p;
		for (int i = p; i < r; i++) {
			if (a[i] >= key)
				CommonUtil.swap(a, j++, i);
		}
		CommonUtil.swap(a, j, r);
		return j;
	}

	// O(n + k*logn)
	public void findKLargestElementsMethod2(int a[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(a.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}

		});
		// O(n)
		for (int i = 0; i < a.length; i++) {
			pq.offer(a[i]);
		}

		// k*logn
		for (int i = 0; i < k; i++) {
			System.out.println(pq.poll());
		}
	}

	class LRUCache {
		private int capacity;
		private LRUCacheDLLNode<Integer, Integer> head, tail;
		private Map<Integer, LRUCacheDLLNode<Integer, Integer>> map;

		public LRUCache(int capacity) {
			super();
			this.capacity = capacity;
			map = new HashMap<Integer, LRUCacheDLLNode<Integer, Integer>>(capacity);
		}

		public void print(LRUCacheDLLNode<Integer, Integer> nn) {
			LRUCacheDLLNode<Integer, Integer> cur = nn;
			while (cur != null) {
				System.out.print(cur + " ");
				cur = cur.next;
			}
			System.out.println();
		}

		// sort of deque
		public void remove(LRUCacheDLLNode<Integer, Integer> nn) {
			if (nn.prev != null) {
				nn.prev.next = nn.next;
			} else {
				head = nn.next;
			}

			if (nn.next != null) {
				nn.next.prev = nn.prev;
			} else {
				tail = nn.prev;
			}
		}

		public void setHead(LRUCacheDLLNode<Integer, Integer> nn) {
			nn.next = head;
			nn.prev = null;
			if (head != null)
				head.prev = nn;
			head = nn;
			if (null == tail)
				tail = nn;
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				LRUCacheDLLNode<Integer, Integer> node = map.get(key);
				remove(node);
				setHead(node);
				return node.value;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				LRUCacheDLLNode<Integer, Integer> node = map.get(key);
				remove(node);
				setHead(node);
			} else {
				LRUCacheDLLNode<Integer, Integer> nn = new LRUCacheDLLNode<Integer, Integer>(key, value);

				if (map.size() >= capacity) {
					map.remove(tail.key);
					remove(tail);
				}
				setHead(nn);
				map.put(key, nn);
			}
		}
	}

	class Interval {
		int start;
		int end;
	}

	public void mergeIntervals(Interval[] a) {
		Arrays.sort(a, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		List<Interval> merged = new ArrayList<>();

		Interval prev = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i].start <= prev.end) {
				prev.end = Math.max(prev.end, a[i].end);
			} else {
				merged.add(prev);
				prev = a[i];
			}
		}
		merged.add(prev);
	}

	public ListNode<Integer> mergeKSortedLists(List<ListNode<Integer>> list) {
		class Node {
			int id;
			ListNode<Integer> node;

			public Node(int id, ListNode<Integer> node) {
				super();
				this.id = id;
				this.node = node;
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>(list.size(), new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.id - n2.id;
			}
		});

		for (ListNode<Integer> node : list) {
			if (node != null)
				pq.offer(new Node(node.data, node));
		}

		ListNode<Integer> head = null, cur = null;
		while (!pq.isEmpty()) {
			Node temp = pq.poll();
			if (head == null) {
				head = temp.node;
				cur = head;
			} else {
				cur.next = temp.node;
				cur = cur.next;
			}
			if (temp.node.next != null) {
				pq.offer(new Node(temp.node.next.data, temp.node.next));
			}
		}
		return head;
	}

	public boolean isPalindromeList(ListNode<Integer> head) {
		if (null == head || head.next == null)
			return true;
		ListNode<Integer> cur, fast, slow, prev = null, mid = null, head2;
		slow = fast = head;
		while (fast.next != null && fast.next.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// odd
		if (fast.next != null) {
			mid = slow;
			head2 = slow.next;
			prev.next = null;
		} else {
			head2 = slow.next;
		}

		new PalindromeCheckForList().reverse(head2);
		boolean isPalindrome = new PalindromeCheckForList().isSame(head, head2);
		new PalindromeCheckForList().reverse(head2);

		if (mid != null) {
			prev.next = mid;
		}

		return isPalindrome;
	}

	public boolean isPalindromeNumber(int n) {
		int res = 0, m = n;
		while (n > 0) {
			res = (res * 10) + (n % 10);
			n = n / 10;
		}
		return res == m;
	}

	public Set<String> allPossiblePalindromes(String str) {
		Set<String> set = new HashSet<>();
		int n = str.length();
		char a[] = str.toCharArray();
		boolean[][] t = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			t[i][i] = true;
			set.add(Character.toString(a[i]));
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2) {
					if (a[i] == a[j]) {
						t[i][j] = true;
					}
				} else {
					if (a[i] == a[j]) {
						t[i][j] = t[i][j] || t[i + 1][j - 1];
					}
				}
				if (t[i][j])
					set.add(str.substring(i, j + 1));
			}
		}
		return set;
	}

	public void findRootToLeafPathsSumEqualToK(BinaryTreeNode<Integer> root) {
		int a[] = new int[BinaryTree.height(root)];
		int k = 10;
		findRootToLeafPathsSumEqualToK(root, a, 0, k);
	}

	public void findRootToLeafPathsSumEqualToK(BinaryTreeNode<Integer> root, int[] a, int i, int k) {
		if (null == root)
			return;
		a[i] = root.data;
		k -= a[i];
		if (BinaryTree.isLeaf(root))
			if (k == 0)
				CommonUtil.printArray(a, 0, i);
		findRootToLeafPathsSumEqualToK(root.left, a, i + 1, k);
		findRootToLeafPathsSumEqualToK(root.right, a, i + 1, k);
	}

	public void permuations(char a[], int i) {
		if (i == a.length) {
			CommonUtil.printArray(a);
		}
		for (int j = i; j < a.length; j++) {
			CommonUtil.swap(a, i, j);
			permuations(a, i + 1);
			CommonUtil.swap(a, i, j);
		}
	}

	public void permuationsUnique(char a[], int i) {
		if (i == a.length) {
			CommonUtil.printArray(a);
		}
		for (int j = i; j < a.length; j++) {
			if (!containsDuplicate(a, i, j - 1, a[j])) {
				CommonUtil.swap(a, i, j);
				permuations(a, i + 1);
				CommonUtil.swap(a, i, j);
			}
		}
	}

	private boolean containsDuplicate(char[] a, int start, int end, int k) {
		for (int i = start; i <= end; i++) {
			if (a[i] == k)
				return true;
		}
		return false;
	}

	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		double k = pow(x, n / 2);
		if (n % 2 == 0) {
			return k * k;
		} else {
			if (n > 0)
				return k * k * x;
			else
				return (k * k) / x;
		}
	}

	public void reverseLinkedList(ListNode<Integer> root) {
		ListNode<Integer> cur = root, prev = null, next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
	}

	public void serializeBinaryTree(BinaryTreeNode<Integer> root, StringBuilder preOrder) {
		if (null == root)
			preOrder.append("#");
		preOrder.append(root.data);
		serializeBinaryTree(root.left, preOrder);
		serializeBinaryTree(root.right, preOrder);
	}

	int index = 0;

	public BinaryTreeNode<Integer> deSerializeBinaryTree(StringBuilder preOrder) {
		char ch = preOrder.charAt(index++);
		if (ch == '#')
			return null;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(Character.getNumericValue(ch));
		node.left = deSerializeBinaryTree(preOrder);
		node.right = deSerializeBinaryTree(preOrder);
		return null;
	}

	/*
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 */
	public int singleNumber(int a[]) {
		int x = 0;
		for (int i : a) {
			x ^= i;
		}
		return x;
	}

	/*
	 * Given an array of integers, every element appears three times except for
	 * one. Find that single one.
	 * 
	 */
	public int singleNumber2(int a[]) {
		int ones = 0, twos = 0, common_bit_mask = 0;

		for (int i : a) {
			twos |= (ones & i);
			ones ^= i;
			common_bit_mask = ~(ones & twos);
			ones &= common_bit_mask;
			twos &= common_bit_mask;
		}
		return ones;
	}

	/*
	 * Given an array of numbers nums, in which exactly two elements appear only
	 * once and all the other elements appear exactly twice. Find the two
	 * elements that appear only once.
	 * 
	 */
	public void twoNonRepeatningNumbers(int a[]) {
		int xor = 0;
		for (int i : a)
			xor ^= i;
		int set_bit, x = 0, y = 0;
		set_bit = xor & ~(xor - 1);
		int k;
		for (int i : a) {
			k = set_bit & i;
			if (k > 0)
				x ^= i;
			else
				y ^= i;
		}
		System.out.println("x=" + x + ",y=" + y);
	}

	public double sqrt(int n) {
		double g = 1.0;
		while (Math.abs(g * g - n) > 0.0000000001) {
			g = (g + (n / g)) / 2;
		}
		return g;
	}

	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		for (int n : nums) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				List<Integer> temp = new ArrayList<Integer>(list.get(i));
				temp.add(n);
				list.add(temp);
			}
		}
		return list;
	}

	public boolean isSymmetric(BinaryTreeNode<Integer> root) {
		if (null == root)
			return true;
		return areMirrors(root.left, root.right);
	}

	public boolean areMirrors(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}
		return root1.data == root2.data && areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left);
	}

	public void minPathSum(int a[][]) {
		int m = a.length, n = a[0].length;
		int t[] = new int[m];
		t[0] = a[0][0];
		for (int i = 1; i < m; i++) {
			for (int j = 0; j <= i; j++) {
				t[i] = Math.min(a[i][j], t[i]);
			}
		}
		CommonUtil.printArray(t);
	}

	// int a[][] = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };

	/*
	 * public int minimumTotal(int[][] triangle) { int[] total = new
	 * int[triangle.length]; int l = triangle.length - 1;
	 * 
	 * for (int i = 0; i < triangle[l].length; i++) { total[i] = triangle[l][i];
	 * }
	 * 
	 * // iterate from last second row for (int i = triangle.length - 2; i >= 0;
	 * i--) { for (int j = 0; j < triangle[i + 1].length - 1; j++) { total[j] =
	 * triangle[i][j] + Math.min(total[j], total[j + 1]); } }
	 * 
	 * return total[0]; }
	 */

	public boolean isAnagrams(char a[], char b[]) {
		int countA[] = new int[256];
		int countB[] = new int[256];

		for (char i : a) {
			countA[i]++;
		}

		for (char i : b) {
			countB[i]++;
		}

		for (int i = 0; i < 256; i++)
			if (countA[i] != countB[i])
				return false;
		return true;
	}

	/*
	 * For example, "Red rum, sir, is murder" is a palindrome, while
	 * "Programcreek is awesome" is not.
	 */
	public boolean isValidPalindrome(char[] a, int n) {
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && !isValidAlphabet(a[l])) {
				l++;
			}

			while (l < r && !isValidAlphabet(a[r])) {
				r--;
			}
			if (Character.toLowerCase(a[l++]) != Character.toLowerCase(a[r--]))
				return false;
		}
		return true;
	}

	private boolean isValidAlphabet(char ch) {
		return Character.isAlphabetic(ch);
	}

	private boolean isValidAlphabet2(char ch) {
		if (ch >= 'A' && ch <= 'Z')
			return true;
		if (ch >= 'a' && ch <= 'z')
			return true;
		if (ch - '0' >= 0 && ch - '0' <= 9)
			return true;
		return false;
	}

	public boolean validParanthesis(char a[]) {
		Stack<Character> stack = new Stack<>();
		for (char ch : a) {
			switch (ch) {
			case '[':
			case '{':
			case '(':
				stack.push(ch);
				break;
			case ']':
				if (stack.isEmpty() || stack.peek() != '[')
					return false;
				stack.pop();
			case '}':
				if (stack.isEmpty() || stack.peek() != '{')
					return false;
				stack.pop();
			case ')':
				if (stack.isEmpty() || stack.peek() != '(')
					return false;
				stack.pop();
			default:
				return false;

			}
		}
		return stack.isEmpty();
	}

	public boolean isBST(BinaryTreeNode<Integer> root, int min, int max) {
		if (null == root)
			return true;
		return root.data > min && root.data < max && isBST(root.left, min, root.data)
				&& isBST(root.right, root.data, max);
	}

	public void wiggleSort(int a[], int n) {
		for (int i = 1; i < n - 1; i += 2) {
			if (a[i] < a[i - 1])
				CommonUtil.swap(a, i, i - 1);
			if (a[i] < a[i + 1])
				CommonUtil.swap(a, i, i + 1);

		}
	}

	class ZigzagIterator {
		private int cur = -1;
		private int a[][];
		private int ptr[];

		public ZigzagIterator(int[][] a) {
			this.a = a;
			this.ptr = new int[a.length];
		}

		public int next() {
			if (hasNext()) {
				int r = getNext();
				cur = r;
				return a[r][ptr[r]++];
			}
			return -1;
		}

		public boolean hasNext() {
			return getNext() != -1;
		}

		private int getNext() {
			int temp = (cur + 1) % a.length;
			while (temp != cur) {
				if (ptr[temp] < a[temp].length)
					return temp;
				temp = (temp + 1) % a.length;

			}
			return -1;
		}
	}

	class MedianInStream {
		int n;
		PriorityQueue<Integer> maxHeap;
		PriorityQueue<Integer> minHeap;

		public MedianInStream() {
			super();
			maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
				public int compare(Integer i1, Integer i2) {
					return i2 - i1;
				}
			});
			minHeap = new PriorityQueue<>();
		}

		public double insertInStream(int data) {
			maxHeap.add(data);

			if (n % 2 != 0) {
				minHeap.add(maxHeap.poll());
			} else {
				if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
					int temp1 = minHeap.poll();
					int temp2 = maxHeap.poll();
					minHeap.offer(temp2);
					maxHeap.offer(temp1);
				}
			}
			n++;
			return median();
		}

		public double median() {
			if (maxHeap.isEmpty())
				return -1;
			if (n % 2 != 0)
				return maxHeap.peek();
			else {
				return (maxHeap.peek() + minHeap.peek()) / 2.0;
			}
		}

	}

	static class FindFirstNonRepeatingInStream {
		class DLLNode {
			char data;
			DLLNode next, prev;
		}

		DLLNode front = null, rear = null;
		DLLNode links[] = new DLLNode[256];
		boolean[] visited = new boolean[256];

		public void insertInStream(char ch) {
			if (visited[ch]) {
				remove(links[ch]);
				links[ch] = null;
			} else {
				visited[ch] = true;
				add(ch);
				links[ch] = rear;
			}
		}

		public void add(char ch) {
			DLLNode node = new DLLNode();
			node.data = ch;
			if (front == null) {
				front = node;
				rear = node;
			} else {
				rear.next = node;
				node.prev = rear;
				rear = rear.next;
			}
		}

		public void remove(DLLNode nn) {
			if (nn == null)
				return;
			if (nn.prev != null) {
				nn.prev.next = nn.next;
			} else {
				front = nn.next;
			}

			if (nn.next != null) {
				nn.next.prev = nn.prev;
			} else {
				rear = nn.prev;
			}
		}

		public char firstNonRepeatingCharacter() {
			return front == null ? 0 : front.data;
		}
	}

	public static void longestSubstringWithUniqueCharacters(String a) {
		if (null == a || a.length() == 0)
			return;
		Set<Character> visited = new HashSet<>();
		int l = 0, r = 0;
		String substring = "";
		char ch;
		while (r < a.length()) {
			ch = a.charAt(r);
			if (!visited.contains(ch)) {
				visited.add(ch);
				if (r - l + 1 > substring.length()) {
					substring = a.substring(l, r + 1);
				}
				r++;
			} else {
				visited.remove(a.charAt(l++));
			}
		}
		System.out.println(substring);
	}

	public static void longestSubstringWithKUniqueCharacters(String string, int k) {
		Map<Character, Integer> countMap = new HashMap<>();
		int l = 0, r = 0;
		char ch, leftch;
		String substring = "";
		while (r < string.length()) {
			ch = string.charAt(r);
			if (countMap.size() < k) {
				if (countMap.containsKey(ch)) {
					countMap.put(ch, countMap.get(ch) + 1);
				} else {
					countMap.put(ch, 1);
				}

			} else {
				if (countMap.containsKey(ch)) {
					countMap.put(ch, countMap.get(ch) + 1);
					if (r - l + 1 > substring.length()) {
						substring = string.substring(l, r + 1);
					}
				} else {
					while (countMap.size() >= k) {
						leftch = string.charAt(l++);
						if (countMap.get(leftch) == 1)
							countMap.remove(leftch);
						else
							countMap.put(leftch, countMap.get(leftch) - 1);
					}
					countMap.put(ch, 1);
					if (r - l + 1 > substring.length()) {
						substring = string.substring(l, r + 1);
					}
				}
			}
			r++;
		}
		System.out.println(substring);
	}

	public static void longestSubstringWithKUniqueCharacters2(String string, int k) {
		Map<Character, Integer> countMap = new HashMap<>();
		int l = 0, r = 0;
		char ch, leftch;
		String substring = "";
		while (r < string.length()) {
			ch = string.charAt(r);
			if (countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			} else {
				countMap.put(ch, 1);
			}

			if (countMap.size() > k) {
				if (r - l > substring.length()) {
					substring = string.substring(l, r);
				}

				while (countMap.size() > k) {
					leftch = string.charAt(l++);
					if (countMap.get(leftch) == 1)
						countMap.remove(leftch);
					else
						countMap.put(leftch, countMap.get(leftch) - 1);
				}
			}
			r++;
		}
		if (countMap.size() == k && substring.length() == 0)
			substring = string;
		System.out.println(substring);
	}

	public static void main(String args[]) {
		longestSubstringWithUniqueCharacters("pwwkew");
		longestSubstringWithKUniqueCharacters("ababababa", 2);
		longestSubstringWithKUniqueCharacters2("ababababa", 2);
	}

	class URLShortener {
		String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		public String idToShorturl(int id) {
			StringBuilder url = new StringBuilder();
			while (id > 0) {
				url.append(a.charAt(id % 62));
				id = id / 62;
			}
			return url.reverse().toString();
		}

		public int shortUrlToId(String url) {
			char ch;
			int id = 0;
			for (int i = 0; i < url.length(); i++) {
				ch = url.charAt(i);
				if (ch >= 'a' && ch <= 'z') {
					id = (id * 62) + (ch - 'a');
				} else if (ch >= 'A' && ch <= 'Z') {
					id = (id * 62) + (ch - 'A' + 26);
				} else if (ch >= '0' && ch <= '9') {
					id = (id * 62) + (ch - '0' + 52);

				}
			}
			return id;
		}

	}
}
