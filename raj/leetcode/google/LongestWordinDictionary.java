package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author Raj
 * 
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
 *
 */
public class LongestWordinDictionary {

	// https://leetcode.com/problems/longest-word-in-dictionary/discuss/109113/Java-Solution-with-Trie-+-BFS
	public String longestWord(String[] words) {

		Trie trie = new Trie();
		for (String word : words)
			trie.insert(word);

		Queue<TrieNode> q = new LinkedList<>();
		String res = "";
		q.offer(trie.root);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				TrieNode temp = q.poll();
				for (TrieNode child : temp.children.values()) {
					if (child.endOfWord) {
						if (child.word.length() > res.length()) {
							res = child.word;
						} else {
							res = res.compareTo(child.word) > 0 ? child.word : res;
						}
						q.offer(child);
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		LongestWordinDictionary obj = new LongestWordinDictionary();
		String result = null;

		String words[] = { "w", "wo", "wor", "worl", "world" };

		result = obj.longestWord(words);
		System.out.println(result);

		String words2[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		result = obj.longestWord(words2);
		System.out.println(result);

	}

}

class Trie {

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
		temp.word = str;
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

}

class TrieNode {
	public char data;
	public boolean endOfWord;
	public Map<Character, TrieNode> children = new HashMap<>();
	public String word;

	public TrieNode(char data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TrieNode [data=" + data + ", endOfWord=" + endOfWord + ", children=" + children + "]";
	}

}
