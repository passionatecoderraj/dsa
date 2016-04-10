/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Raj
 *
 */

/*
 * http://www.ideserve.co.in/learn/anagram-grouping-in-a-sequence-using-trie
 * 
 * Given a sequence of words, print all anagrams together, For example, if given
 * word sequence is ["god","act","tic","tac","dog","cat"] then output of the
 * program should be - god, dog act, tac, cat tic
 * 
 * 
 */
public class PrintAllAnagramsTogether {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintAllAnagramsTogether obj = new PrintAllAnagramsTogether();

		String[] words = { "god", "act", "tic", "tac", "dog", "cat" };

		// Time : O(n.mlogm)
		// n= number of words, m = avg. length of word
		obj.printAllAnagramsTogether(words);
	}

	TrieNodeForAnagram root = new TrieNodeForAnagram(' ');
	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

	public void printAllAnagramsTogether(String[] words) {
		for (int i = 0; i < words.length; i++) {
			insertWordInTrie(i, words[i].toCharArray());
		}
		for (String key : map.keySet()) {
			List<Integer> list = map.get(key);
			for (Integer id : list) {
				System.out.print(words[id] + " ");
			}
			System.out.println();
		}
	}

	public void insertWordInTrie(int indexOfAnagram, char[] a) {
		Arrays.sort(a);

		TrieNodeForAnagram cur, temp = null, nn;
		cur = root;
		char ch;
		for (int i = 0; i < a.length; i++) {
			ch = a[i];
			temp = cur.getNode(ch);
			if (null == temp) {
				nn = new TrieNodeForAnagram(ch);
				cur.child[ch - 'a'] = nn;
				cur = nn;
			} else {
				cur = temp;
			}
		}
		cur.end_of_word = true;
		cur.anagramIndices.add(indexOfAnagram);
		map.put(Arrays.toString(a), cur.anagramIndices);
	}

	class TrieNodeForAnagram {
		char data;
		TrieNodeForAnagram child[];
		boolean end_of_word;
		List<Integer> anagramIndices;

		public TrieNodeForAnagram(char data) {
			super();
			this.data = data;
			child = new TrieNodeForAnagram[26];
			end_of_word = false;
			anagramIndices = new ArrayList<>();
		}

		public TrieNodeForAnagram getNode(char ch) {
			if (child != null)
				return child[ch - 'a'];
			return null;
		}

	}

}
