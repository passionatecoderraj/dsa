/**
 * 
 */
package com.raj.string;

import com.raj.nodes.TrieNode;

/**
 * @author Raj
 *
 */
public class Trie {

	public TrieNode root;

	public Trie() {
		this.root = new TrieNode(' ');
	}

	public void insertInTrie(String str) {
		TrieNode node = root, temp;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			temp = node.getNode(ch);
			if (temp == null) {
				TrieNode newNode = new TrieNode(ch);
				node.child[ch] = newNode;
				node = newNode;
			} else {
				node = temp;
			}
		}
		node.is_end_of_string = true;
	}

	public boolean search(String s) {
		TrieNode node = root, temp;
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
		TrieNode node = root, temp;
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
		Trie obj = new Trie();
		obj.insertInTrie("raj");
		obj.insertInTrie("kumar");
		obj.insertInTrie("dasari");
		obj.insertInTrie("raja");
		obj.insertInTrie("kana");
		obj.insertInTrie("rajaji");
		obj.insertInTrie("kanasu");

		boolean result;
		result = obj.search("raj");
		System.out.println(result);
		result = obj.search("rajaj");
		System.out.println(result);
		result = obj.hasPrefix("rajaj");
		System.out.println(result);

		char c[] = new char[100];
		obj.printRootToLeavePaths(0, obj.root, c);

	}

	public void printRootToLeavePaths(int level, TrieNode node, char[] ch) {
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

	private boolean isLeaf(TrieNode node) {
		for (int i = 0; i < node.child.length; i++) {
			if (node.child[i] != null)
				return false;
		}
		return true;
	}

}
