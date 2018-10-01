package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Raj
 *
 *Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.

 */

class MagicDictionaryUsingMap {

	Map<String, List<int[]>> map;

	public MagicDictionaryUsingMap() {
		map = new HashMap<>();
	}

	// Time : O(n*k), space : O(n*k) , k = avg. length of each word, n= no.of words
	public void buildDict(String[] words) {
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				String sub = word.substring(0, i) + word.substring(i + 1);
				if (!map.containsKey(sub)) {
					map.put(sub, new ArrayList<>());
				}
				map.get(sub).add(new int[] { i, word.charAt(i) });
			}
		}
	}

	// https://leetcode.com/problems/implement-magic-dictionary/discuss/107446/Easy-14-lines-Java-solution-HashMap
	// Time : Average case is O(k), worse case : O(k2)
	public boolean search(String word) {
		for (int i = 0; i < word.length(); i++) {
			String sub = word.substring(0, i) + word.substring(i + 1);
			if (map.containsKey(sub)) {
				for (int[] pair : map.get(sub)) {
					if (pair[0] == i && pair[1] != word.charAt(i)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}

class MagicDictionaryUsingTrie {
	com.raj.patternmatching.Trie trie;

	/** Initialize your data structure here. */
	public MagicDictionaryUsingTrie() {
		trie = new com.raj.patternmatching.Trie();
	}

	// Time : O(n*k), space : O(n*k) , k = avg. length of each word, n= no.of words
	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (String word : dict) {
			trie.insert(word);
		}
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word after
	 * modifying exactly one character
	 */
	// Time : O(26*k*k), space : O(1) , k = avg. length of each word
	public boolean search(String word) {
		char a[] = word.toCharArray();
		for (int i = 0; i < a.length; i++) {

			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch == a[i])
					continue;
				char temp = a[i];
				a[i] = ch;
				String str = new String(a);

				if (trie.search(str)) {
					return true;
				}
				a[i] = temp;
			}
		}
		return false;
	}

}

public class MagicDictionary {

	public static void main(String[] args) {
		MagicDictionaryUsingMap obj = new MagicDictionaryUsingMap();

		boolean result = false;

		String words[] = { "hello", "hhllo", "leetcode" };
		obj.buildDict(words);

		result = obj.search("hello"); // Output: False
		System.out.println(result);
		result = obj.search("hhllo"); // Output: True
		System.out.println(result);
		result = obj.search("hell"); // Output: False
		System.out.println(result);
		result = obj.search("leetcoded"); // Output: False
		System.out.println(result);

	}

}
