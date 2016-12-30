/**
 * 
 */
package com.raj.patternmatching;

import com.raj.nodes.TrieNode2;

/**
 * @author Raj
 *
 */
public class TrieUsingArray {

	public TrieNode2 root;

	public TrieUsingArray() {
		this.root = new TrieNode2(' ');
	}

	public void insertInTrie(String str) {
		TrieNode2 node = root, temp;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			temp = node.getNode(ch);
			if (temp == null) {
				TrieNode2 newNode = new TrieNode2(ch);
				node.child[ch] = newNode;
				node = newNode;
			} else {
				node = temp;
			}
		}
		node.is_end_of_string = true;
	}

	public boolean search(String s) {
		TrieNode2 node = root, temp;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			temp = node.getNode(s.charAt(i));
			if (temp == null)
				return false;
			node = temp;
		}
		return node.is_end_of_string == true;
	}

	public boolean hasPrefix(String s) {
		TrieNode2 node = root, temp;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			temp = node.getNode(s.charAt(i));
			if (temp == null)
				return false;
			node = temp;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TrieUsingArray obj = new TrieUsingArray();
		obj.insertInTrie("raj");
		obj.insertInTrie("kumar");
		obj.insertInTrie("dasari");
		obj.insertInTrie("raja");
		obj.insertInTrie("kana");
		obj.insertInTrie("rajaji");
		obj.insertInTrie("kanasu");

		boolean result;
		// result = obj.search("raj");
		// System.out.println(result);
		// result = obj.search("rajaj");
		// System.out.println(result);
		// result = obj.hasPrefix("rajaj");
		// System.out.println(result);

		char c[] = new char[100];
		// obj.printRootToLeavePaths(0, obj.root, c);

		obj.searchStringsStartsWith("k");
	}

	public void searchStringsStartsWith(String str) {
		TrieNode2 node = root, temp;
		for (int i = 0; i < str.length(); i++) {
			temp = node.getNode(str.charAt(i));
			if (null == temp)
				return;
			node = temp;
		}

		char c[] = new char[100];
		int i = 0;
		for (i = 0; i < str.length() - 1; i++) {
			c[i] = str.charAt(i);
		}
		printRootToLeavePath(i, node, c);
	}

	public void printRootToLeavePath(int level, TrieNode2 node, char[] ch) {
		if (node == null)
			return;
		ch[level] = node.data;
		if (node.is_end_of_string) {
			printArray(ch, 0, level);
			System.out.println();
		}
		if (isLeaf(node)) {
			return;
		}

		for (int i = 0; i < node.child.length; i++) {
			printRootToLeavePath(level + 1, node.child[i], ch);
		}
	}

	public void printArray(char a[], int l, int r) {
		for (int i = l; i <= r; i++) {
			System.out.print(a[i]);
		}
	}

	public void printRootToLeavePaths(int level, TrieNode2 node, char[] ch) {
		if (node == null)
			return;
		if (isLeaf(node)) {
			ch[level] = node.data;
			for (int i = 1; i <= level; i++) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}
		ch[level] = node.data;
		for (int i = 0; i < node.child.length; i++) {
			printRootToLeavePaths(level + 1, node.child[i], ch);
		}
	}

	private boolean isLeaf(TrieNode2 node) {
		for (int i = 0; i < node.child.length; i++) {
			if (node.child[i] != null)
				return false;
		}
		return true;
	}

}
