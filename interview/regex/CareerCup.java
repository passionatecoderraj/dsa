/**
 * 
 */
package com.interview.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 *
 */
public class CareerCup {

	public static String reverseSetence(String str) {
		StringBuilder sb = new StringBuilder(str);
		Pattern p = Pattern.compile("[a-zA-Z0-9]+");
		Matcher m = p.matcher(str);
		while (m.find()) {
			reverse(sb, m.start(), m.end() - 1);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	static void callFun() {
		List<Integer> l1 = new ArrayList<>();
		l1.add(10);
		l1.add(30);
		l1.add(40);
		l1.add(90);
		l1.add(13);
		l1.add(12);
		l1.add(17);

		List<Integer> l2 = new ArrayList<>();
		l2.add(20);
		l2.add(32);
		l2.add(43);
		l2.add(89);
		l2.add(13);
		l2.add(11);
		l2.add(15);
		findKSmallestElementsFromTwoLists(l1, l2, 4);
	}

	// Time : O((m+n)*logk), Space : O(logk)
	public static void findKSmallestElementsFromTwoLists(List<Integer> list1, List<Integer> list2, final int k) {

		final PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}

		});

		for (int i : list1) {
			if (pq.size() < k) {
				pq.offer(i);
			} else {
				if (i < pq.peek()) {
					pq.poll();
					pq.offer(i);
				}
			}
		}

		for (int i : list2) {
			if (pq.size() < k) {
				pq.offer(i);
			} else {
				if (i < pq.peek()) {
					pq.poll();
					pq.offer(i);
				}
			}
		}
		System.out.println(pq);
	}

	public static void reverse(StringBuilder sb, int l, int r) {
		while (l < r) {
			swap(sb, l++, r--);
		}
	}

	public static void swap(StringBuilder sb, int i, int j) {
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
	}

	/*
	 * Given a series of number form a binary tree find the minimum weight
	 * binary tree. The weight of the node is depth * value of the element +
	 * weight of the left tree + weight of the right tree.
	 * 
	 * Weight of the root node is the weight of the tree . Find the minimum
	 * weight binary tree out of all possible binary trees that are possible.
	 */

	/*
	 * With input as a integer, write an algorithm to convert that to string
	 * without using any built in functions. It is a signed number.
	 * 
	 * Equivalent to String.valueOf(-123); //java
	 * 
	 * https://www.careercup.com/question?id=5165056955252736
	 */

	public static String signedIntegerToStringWithoutUsingBuiltInFunctions(int n) {
		String str = "";
		boolean isNegative = false;

		if (n < 0)
			isNegative = true;

		n = Math.abs(n);
		while (n > 0) {
			str = n % 10 + str;
			n = n / 10;
		}
		if (isNegative)
			str = "-" + str;
		System.out.println(str);
		return str;
	}

	// Given an api which returns an array of chemical names and an array of
	// chemical symbols, display the chemical names with their symbol surrounded
	// by square brackets:
	// Chemicals array: ['Amazon', 'Microsoft', 'Google']
	// Symbols: ['I', 'Am', 'cro', 'Na', 'le', 'abc']
	// output:[Am]azon, Mi[cro]soft, Goog[le] (If the chemical string matches
	// more than one symbol, then choose the one with longest length. (ex.
	// 'Microsoft' matches 'i' and 'cro'))
	// https://careercup.com/question?id=5651181343866880
	public static void replace() {
		String[] symbols = { "I", "Am", "cro", "Na", "le", "abc" };
		String[] arr = { "Amazon", "Microsoft", "Google" };
		for (int i = 0; i < arr.length; i++) {
			String name = arr[i];
			String selectedSymbol = "";
			for (String symbol : symbols) {
				if (name.contains(symbol)) {
					if (symbol.length() > selectedSymbol.length())
						selectedSymbol = symbol;
				}
			}
			if (selectedSymbol.length() > 0) {
				arr[i] = name.replace(selectedSymbol, "[" + selectedSymbol + "]");
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	// calculate height of a tree, when all leaves of tree are cirucalr DLL
	// https://careercup.com/question?id=5745376419119104s
	public int height(BinaryTreeNode<Integer> root) {
		if (null == root) {
			return 0;
		}
		if (isLeaf(root)) {
			return 1;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	private boolean isLeaf(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> left = root.left;
		if (null == left)
			return false;
		return left.right == root;
	}

	static int minLen = Integer.MAX_VALUE;

	public static void numberofBlocks(char a[], int k, int count, boolean[] visited) {
		int index = getNextBlock(a);
		if (-1 == index) {
			minLen = Math.min(count, minLen);
			return;
		}
		for (int i = 0; i < k; i++) {
			int j = index - k + 1;
			if (j >= 0) {
				char[] temp = new char[k];
				int cnt = 0;
				for (int idx = j, b = 0; idx < Math.min(k + j, a.length); idx++) {
					temp[b++] = a[idx];
					a[idx] = '-';
					if (!visited[idx]) {
						cnt++;
						visited[idx] = true;
					}
				}
				numberofBlocks(a, k, count + cnt, visited);
				for (int idx = j, b = 0; idx < Math.min(k + j, a.length); idx++) {
					a[idx] = temp[b++];
				}

			}
		}
	}

	static int getNextBlock(char a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == '*')
				return i;
		}
		return -1;
	}

	static void printCombos(String s1, String s2, String cur, Set<String> ans) {
		if (s1 == "" && s2 == "") {
			ans.add(cur);
			return;
		}
		if (s1 == "") {
			ans.add(cur + s2);
			return;
		}
		if (s2 == "") {
			ans.add(cur + s1);
			return;
		}
		for (int i = 0; i <= s2.length(); i++) {
			String toAdd = s2.substring(0, i);
			printCombos(s1.substring(1, s1.length() - 1), s2.substring(i, s2.length() - i), cur + toAdd + s1.charAt(0),
					ans);
		}
	}

	public static int getCount(int n) {
		if (0 == n)
			return 0;
		if (1 == n)
			return 1;
		int sqrt = (int) Math.sqrt(n);
		return 1 + getCount(Math.abs(n - sqrt * sqrt));
	}

	public static List<Integer> findUncommonElements(Integer a1[], Integer a2[]) {
		if (null == a1 && null == a2) {
			return null;
		}
		if (null == a1 || a1.length == 0)
			return Arrays.asList(a2);
		if (null == a2 || a2.length == 0)
			return Arrays.asList(a1);

		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> countMap = new LinkedHashMap<>();
		for (int i : a2) {
			countMap.compute(i, (key, value) -> {
				if (null == value)
					return 1;
				return value + 1;
			});
		}

		for (int i : a1) {
			if (countMap.containsKey(i)) {
				countMap.remove(i);
			} else {
				result.add(i);
			}
		}
		for (int key : countMap.keySet()) {
			for (int i = 0; i < countMap.get(key); i++) {
				result.add(key);
			}
		}
		return result;
	}

	public void findTopKFrequentUsers(String file, int k) {
		if (file == null || file.length() == 0)
			return;
		String[] users = file.split(",");
		Map<String, Integer> countMap = new HashMap<>();
		for (String user : users) {
			countMap.compute(user, (key, value) -> {
				if (null == value)
					return value;
				return value + 1;
			});
		}
		class Element {
			String user;
			int value;

			public Element(String user, int value) {
				super();
				this.user = user;
				this.value = value;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + value;
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Element other = (Element) obj;
				if (value != other.value)
					return false;
				return true;
			}
		}
		PriorityQueue<Element> pq = new PriorityQueue<>(Collections.reverseOrder());

	}

	public static void main(String[] args) {
		// reverseSetence("Prithviraj Kumar Dasari. $Hello");
		// signedIntegerToStringWithoutUsingBuiltInFunctions(-123);
		// char a[] = { '-', '-', '-', '*', '-', '*', '-', '*', '-', '*', '-',
		// '-' };
		// boolean[] visited = new boolean[a.length];
		// numberofBlocks(a, 2, 0, visited);
		// System.out.println(minLen);
		//
		// Set<String> ans = new HashSet<>();
		// printCombos("hey", "sam", "", ans);
		// System.out.println(ans);

		// int res = -1;
		// res = getCount(81);
		// System.out.println(res);
		//
		Integer a1[] = { 1, 2, 3, 1, 5 };
		Integer a2[] = { 3, 4, 5, 6, 7 };
		// findUncommonElements(a1, a2);

		String file = "user1,user4,user2,user1,user3,user1,user2,user3";
		int k = 2;

		callFun();
	}

	// Time :O(n), Space :O(1)
	public static int maxNumberOf1s(String str) {
		if (null == str || str.isEmpty() || !str.contains("1")) {
			return 0;
		}
		int count = 0;
		int curCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				if (curCount == 0) {
					curCount = 1;
				} else {
					curCount++;
				}
				count = Math.max(curCount, count);
			} else {
				curCount = 0;
			}
		}

		return count;
	}
}
