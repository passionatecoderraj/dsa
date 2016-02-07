/**
 * 
 */
package com.raj.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 *         Given a string, find the longest substring that contains only two
 *         unique characters. For example, given "abcbbbbcccbdddadacb", the
 *         longest substring that contains 2 unique character is "bcbbbbcccb"
 */
public class FindLongestSubstringContains2UniqueCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindLongestSubstringContains2UniqueCharacters obj = new FindLongestSubstringContains2UniqueCharacters();

		String str = "abcbbbbcccbdddadacb";
		System.out.println(str);
		String result;

		// Time : O(n)
		int k = 2;
		result = obj.findLongestSubstringContainsKCharacters(str, str.length(), k);
		System.out.println(result);

	}

	public String findLongestSubstringContainsKCharacters(String str, int n, int k) {
		int l = 0;

		int longSubStringLen = 0;
		String longestSubstring = null;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char ch;
		for (int i = 0; i < n; i++) {
			ch = str.charAt(i);
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);

			if (map.size() == k + 1) {
				if (i - l > longSubStringLen) {
					longSubStringLen = i - l;
					longestSubstring = str.substring(l, i);
				}
				while (map.size() > k) {
					char left = str.charAt(l);
					int count = map.get(left);
					if (count > 1)
						map.put(left, count - 1);
					else
						map.remove(left);
					l++;
				}
			}
		}

		if (map.size() == k && longSubStringLen == 0)
			return str;
		return longestSubstring;
	}

}
