/**
 * 
 */
package com.raj.patternmatching;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.List;

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

	public void insert(String str) {
		TrieNode temp = root;
		for (char ch : str.toCharArray()) {
			if (temp.children.containsKey(ch)) {
				temp = temp.children.get(ch);
			} else {
				TrieNode node = new TrieNode(ch);
				temp.children.put(ch, node);
				temp = node;
			}
		}
		temp.endOfWord = true;
	}

	public boolean delete(String str) {
		return delete(root, str, 0);
	}

	private boolean delete(TrieNode root, String str, int index) {
		if (index > str.length())
			return false;

		if (index == str.length()) {
			if (!root.endOfWord)
				return false;
			root.endOfWord = false;

			return root.children.size() == 0;
		}

		char ch = str.charAt(index);
		TrieNode node = root.children.get(ch);
		if (null == node) {
			return false;
		}

		boolean shouldCurNodeBeDeleted = delete(node, str, index + 1);
		if (shouldCurNodeBeDeleted) {
			root.children.remove(ch);

			if (root.endOfWord)
				return false;
			return root.children.size() == 0;
		}
		return false;
	}

	public boolean search(String s) {
		TrieNode temp = root;
		for (char ch : s.toCharArray()) {
			if (!temp.children.containsKey(ch))
				return false;
			temp = temp.children.get(ch);
		}
		return temp.endOfWord == true;
	}

	public boolean hasPrefix(String str) {
		TrieNode temp = root;
		for (int i = 0; i < str.length(); i++) {
			temp = temp.children.get(str.charAt(i));
			if (null == temp)
				return false;
		}
		return true;
	}

	public List<String> allStringWithsGivenPrefix(String str) {
		List<String> res = new ArrayList<>();

		TrieNode temp = root;
		for (int i = 0; i < str.length(); i++) {
			temp = temp.children.get(str.charAt(i));
			if (null == temp)
				return res;
		}

		allStringWithsGivenPrefix(temp, res, new StringBuilder(str));
		return res;
	}

	private void allStringWithsGivenPrefix(TrieNode root, List<String> res, StringBuilder sb) {

		if (root.endOfWord == true) {
			res.add(sb.toString());
		}
		for (char ch : root.children.keySet()) {
			sb.append(ch);
			allStringWithsGivenPrefix(root.children.get(ch), res, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public void printRootToLeavePaths(int level, TrieNode root, char[] c) {
		if (level > 0) {
			c[level] = root.data;
			// leaf
			if (root.children.size() == 0) {
				for (int i = 1; i <= level; i++) {
					System.out.print(c[i]);
				}
				System.out.println();
			}
		}
		for (char key : root.children.keySet()) {
			printRootToLeavePaths(level + 1, root.children.get(key), c);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.insert("raj");
		obj.insert("kumar");
		obj.insert("dasari");
		obj.insert("raja");
		obj.insert("kana");
		obj.insert("rajaji");
		obj.insert("kanasu");

		boolean result;
		result = obj.search("rajd");
		System.out.println(result);
		// result = obj.search("rajaj");
		// System.out.println(result);
		// result = obj.hasPrefix("rajaj");
		// System.out.println(result);
	//	obj.delete("rajaji");
		char c[] = new char[100];
		obj.printRootToLeavePaths(0, obj.root, c);
		List<String> res = null;
		res = obj.allStringWithsGivenPrefix("ra");
		System.out.println(res);
		System.out.println(obj.hasPrefix("kan"));

	}

}
