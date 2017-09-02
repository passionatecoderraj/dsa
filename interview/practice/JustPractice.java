package com.interview.practice;

import java.util.Stack;

public class JustPractice {

	public int maxAreaOfHistogram(int a[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = -1, area;
		int i = 0;
		while (i < a.length) {
			if (stack.isEmpty() || a[i] >= a[stack.peek()]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					area = a[top] * i;
				} else {
					area = a[top] * (i - stack.peek() - 1);
				}
				maxArea = Math.max(area, maxArea);
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty()) {
				area = a[top] * i;
			} else {
				area = a[top] * (i - stack.peek() - 1);
			}
			maxArea = Math.max(area, maxArea);
		}
		System.out.println(maxArea);
		return maxArea;
	}

	class HashMap<K, V> {
		class Entry<K, V> {
			private K key;
			private V value;
			Entry<K, V> next;

			public Entry(K key, V value) {
				super();
				this.key = key;
				this.value = value;
				this.next = null;
			}
		}

		private int size;
		private Entry[] entries;

		HashMap() {
			this.size = 10;
			entries = new Entry[10];
		}

		public void insert(K key, V value) {
			int hash = hashCode(key);
			Entry<K, V> entry = new Entry<K, V>(key, value);
			if (entries[hash] == null) {
				entries[hash] = entry;
			} else {
				entry.next = entries[hash];
				entries[hash] = entry;
			}
		}

		public V get(K key) {
			int hash = hashCode(key);
			if (entries[hash] == null) {
				return null;
			}
			Entry<K, V> cur = entries[hash];
			while (cur != null) {
				if (cur.key == key)
					return cur.value;
				cur = cur.next;
			}
			return null;
		}

		public int hashCode(K key) {
			return key.hashCode() % size;
		}
	}

	public static void main(String args[]) {
		JustPractice obj = new JustPractice();
		int a[] = { 6, 2, 5, 4, 5, 1, 6 };
		obj.maxAreaOfHistogram(a);
	}

	
}

class TernarySearchTree {
	class TSTNode {
		char data;
		boolean end_of_word;
		TSTNode left, right, eq;

		public TSTNode(char data) {
			super();
			this.data = data;
			left = null;
			right = null;
			eq = null;
		}
	}

	TSTNode root = null;

	public TSTNode insert(TSTNode root, String word, int pos) {
		if (null == root) {
			root = new TSTNode(word.charAt(pos));

			if (pos == word.length() - 1) {
				root.end_of_word = true;
			} else {
				root.eq = insert(root.eq, word, pos + 1);
			}
		}
		if (root.data > word.charAt(pos)) {
			root.left = insert(root.left, word, pos);
		} else if (root.data < word.charAt(pos)) {
			root.right = insert(root.right, word, pos);
		} else {
			if (pos == word.length() - 1) {
				root.end_of_word = true;
			} else {
				root.eq = insert(root.eq, word, pos + 1);
			}
		}
		return root;
	}
}
