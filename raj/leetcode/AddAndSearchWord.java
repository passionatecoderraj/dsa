package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
	TrieNode3 root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TrieNode3(' ');
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		TrieNode3 temp = root;
		for (char ch : word.toCharArray()) {
			if (!temp.children.containsKey(ch)) {
				temp.children.put(ch, new TrieNode3(ch));
			}
			temp = temp.children.get(ch);
		}
		temp.end = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return util(root, 0, word);
	}

	boolean util(TrieNode3 temp, int i, String word) {
		if (i == word.length()) {
			return temp.end;
		}
		char ch = word.charAt(i);
		if (ch == '.' && !temp.children.containsKey(ch)) {
			for (char cur : temp.children.keySet()) {
				if (util(temp.children.get(cur), i + 1, word))
					return true;
			}
		}
		if (!temp.children.containsKey(ch))
			return false;
		return util(temp.children.get(ch), i + 1, word);
	}
}


public class AddAndSearchWord {

	public static void main(String... args) {
		WordDictionary w1 = new WordDictionary();
		w1.addWord("bad");
		w1.addWord("dad");
		w1.addWord("mad");
		System.out.println(w1.search("pad"));
		System.out.println(w1.search("bad"));
		System.out.println(w1.search(".ad"));
		System.out.println(w1.search("b.."));

		WordDictionary w2 = new WordDictionary();
		w2.addWord("a");
		w2.addWord("a");

		System.out.println(w2.search("."));
		System.out.println(w2.search("a"));
		System.out.println(w2.search("aa"));
		System.out.println(w2.search(".a"));
	}
}

class TrieNode3 {
	char ch;
	boolean end;
	Map<Character, TrieNode3> children = new HashMap<>();

	TrieNode3(char ch) {
		this.ch = ch;
		this.end = false;
	}
}

