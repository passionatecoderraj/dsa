package com.raj.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Raj
 * 
 * Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.
 */

/* 
 * 
If f is more frequently than WordFilter, use method 1.
If space complexity is concerned, use method 2.
If the input string array might change frequently, use method 3.
 *
 */
class WordFilter1 {
	Map<String, Integer> map = new HashMap<>();

	/*
	 * word : raj {#=0, #j=0, #aj=0, #raj=0, r#=0, r#j=0, r#aj=0, r#raj=0,
	 * ra#=0, ra#j=0, ra#aj=0, ra#raj=0, raj#=0, raj#j=0, raj#aj=0, raj#raj=0}
	 * 
	 */
	// Time : O(n*l*l) ,Space : O(n*l*l)
	// n : No. of words, l : max length of each word
	public WordFilter1(String[] words) {
		for (int wt = 0; wt < words.length; wt++) {
			for (int i = 0; i <= 10 && i <= words[wt].length(); i++) {
				for (int j = 0; j <= 10 && j <= words[wt].length(); j++) {
					map.put(words[wt].substring(0, i) + "#" + words[wt].substring(words[wt].length() - j), wt);
				}
			}
		}
		System.out.println(map);
	}

	// Time : O(1)
	public int f(String prefix, String suffix) {
		return (map.containsKey(prefix + "#" + suffix)) ? map.get(prefix + "#" + suffix) : -1;
	}
}

class WordFilter2 {

	Map<String, List<Integer>> mapPrefix = new HashMap<>();
	Map<String, List<Integer>> mapSuffix = new HashMap<>();

	/*
	 * prefix : {=[0], r=[0], ra=[0], raj=[0]} suffix : {=[0], j=[0], aj=[0],
	 * raj=[0]}
	 */
	// Time : O(n*l) ,Space : O(n*l)
	// n : No. of words, l : max length of each word
	public WordFilter2(String[] words) {
		for (int wt = 0; wt < words.length; wt++) {
			for (int i = 0; i <= 10 && i <= words[wt].length(); i++) {
				String s = words[wt].substring(0, i);
				if (!mapPrefix.containsKey(s))
					mapPrefix.put(s, new ArrayList<>());
				mapPrefix.get(s).add(wt);
			}
			for (int i = 0; i <= 10 && i <= words[wt].length(); i++) {
				String s = words[wt].substring(words[wt].length() - i);
				if (!mapSuffix.containsKey(s))
					mapSuffix.put(s, new ArrayList<>());
				mapSuffix.get(s).add(wt);
			}
		}
		 System.out.println(mapPrefix);
		 System.out.println(mapSuffix);

	}

	// Time : O(n)
	public int f(String prefix, String suffix) {
		if (!mapPrefix.containsKey(prefix) || !mapSuffix.containsKey(suffix))
			return -1;
		List<Integer> p = mapPrefix.get(prefix);
		List<Integer> s = mapSuffix.get(suffix);
		int i = p.size() - 1, j = s.size() - 1;
		while (i >= 0 && j >= 0) {
			if (p.get(i) < s.get(j))
				j--;
			else if (p.get(i) > s.get(j))
				i--;
			else
				return p.get(i);
		}
		return -1;
	}
}

class WordFilter3 {
	String[] input;

	// Time:O(1), Space : O(1)
	public WordFilter3(String[] words) {
		input = words;
	}

	// Time : O(n*l)
	public int f(String prefix, String suffix) {
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i].startsWith(prefix) && input[i].endsWith(suffix))
				return i;
		}
		return -1;
	}
}

public class PrefixAndSuffixSearch {

	public static void main(String[] args) {
		String[] words = { "raj" };

		WordFilter1 obj1 = new WordFilter1(words);
		int res = -1;
		res = obj1.f("r", "raj");
		System.out.println(res);
		res = obj1.f("j", "");
		System.out.println(res);

		WordFilter2 obj2 = new WordFilter2(words);
		res = obj2.f("r", "raj");
		System.out.println(res);
		res = obj2.f("j", "");
		System.out.println(res);

		WordFilter3 obj3 = new WordFilter3(words);
		res = obj3.f("r", "raj");
		System.out.println(res);
		res = obj3.f("j", "");
		System.out.println(res);
	}

}
