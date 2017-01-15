package com.raj.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.raj.dp.matrix.WordBreak;

/**
 * 
 * @author Raj
 *
 *         Given a list of words (without duplicates), please write a program
 *         that returns all concatenated words in the given list of words.
 * 
 *         A concatenated word is defined as a string that is comprised entirely
 *         of at least two shorter words in the given array.
 * 
 *         Example: Input:
 *         ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat"
 *         ,"ratcatdogcat"]
 * 
 *         Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 *         Explanation: "catsdogcats" can be concatenated by "cats", "dog" and
 *         "cats"; "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 *         "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 */
public class ConcatenatedWords {

	public static List<String> findAllConcatenatedWordsInADict(String words[]) {
		List<String> result = new ArrayList<>();
		Set<String> dict = new HashSet<>();
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		for (int i = 0; i < words.length; i++) {
			if (WordBreak.wordBreak(words[i], dict)) {
				result.add(words[i]);
			}
			dict.add(words[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		String words[] = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		List<String> res = null;
		res = findAllConcatenatedWordsInADict(words);
		System.out.println(res);
	}

}
