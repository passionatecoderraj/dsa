package com.raj.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WordNode {
	String word;
	int numSteps;

	public WordNode(String word, int numSteps) {
		this.word = word;
		this.numSteps = numSteps;
	}
}

public class Solution {
	/**
	 * @param start,
	 *            a string
	 * @param end,
	 *            a string
	 * @param dict,
	 *            a set of string
	 * @return an integer
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null && end == null)
			return 0;
		if (start.length() == 0 && end.length() == 0)
			return 0;
		assert (start.length() == end.length());
		if (dict == null || dict.size() == 0) {
			return 0;
		}

		int ladderLen = 1;
		dict.add(end); // add end to dict, important!
		Queue<String> q = new LinkedList<String>();
		Set<String> hash = new HashSet<String>();
		q.offer(start);
		hash.add(start);
		while (!q.isEmpty()) {
			ladderLen++;
			int qLen = q.size();
			for (int i = 0; i < qLen; i++) {
				String strTemp = q.poll();

				for (String nextWord : getNextWords(strTemp, dict)) {
					if (nextWord.equals(end))
						return ladderLen;
					// filter visited word in the dict
					if (hash.contains(nextWord))
						continue;
					q.offer(nextWord);
					hash.add(nextWord);
					System.out.println(nextWord);
				}
			}
		}

		return 0;
	}

	private Set<String> getNextWords(String curr, Set<String> dict) {
		Set<String> nextWords = new HashSet<String>();
		for (int i = 0; i < curr.length(); i++) {
			char[] chars = curr.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				chars[i] = c;
				String temp = new String(chars);
				if (dict.contains(temp)) {
					nextWords.add(temp);
				}
			}
		}

		return nextWords;
	}

	public static void main(String args[]) {
		Solution obj = new Solution();
		int result = -1;
		Set<String> set = new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");

		result = obj.ladderLength("hit", "cog", set);
		System.out.println(result);
	}
}