/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Raj
 * 
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs {
	
	/*
	 * 
	 * 	Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.

		Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
		
		Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.
		
		Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.

	 */
	// https://leetcode.com/problems/palindrome-pairs/discuss/79199/150-ms-45-lines-JAVA-solution
	// O(n*k*k), Space :O(n) n=no.of words, k=avg length of each word, 
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ret = new ArrayList<>();
		if (words == null || words.length < 2)
			return ret;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);
		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i]);
			for (int j = 0; j <= words[i].length(); j++) { // notice it should be "j <= words[i].length()"
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if (isPalindrome(str1)) {
					String str2rvs = new StringBuilder(str2).reverse().toString();
					// if (map.containsKey(str2rvs) && map.get(str2rvs) != i && !str1.isEmpty()) {
					if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(str2rvs));
						list.add(i);
						ret.add(list);
						// System.out.printf("isPal(str1): %s\n", list.toString());
					}
				}
				if (isPalindrome(str2)) {
					String str1rvs = new StringBuilder(str1).reverse().toString();
					// this is to address the case 2 above 
					// check "str.length() != 0" to avoid duplicates
					// if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
					if (map.containsKey(str1rvs) && map.get(str1rvs) != i && !str2.isEmpty()) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(str1rvs));
						ret.add(list);
						// System.out.printf("isPal(str2): %s\n", list.toString());
					}
				}
			}
		}
		return ret;
	}

	private boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left <= right) {
			if (str.charAt(left++) != str.charAt(right--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePairs obj = new PalindromePairs();
		// String a[] = { "abcd", "dcba", "lls", "s", "sssll" };
		String a[] = { "ba", "ab" };
		List<List<Integer>> res = null;
		res = obj.palindromePairs(a);
		System.out.println(res);

	}

}
