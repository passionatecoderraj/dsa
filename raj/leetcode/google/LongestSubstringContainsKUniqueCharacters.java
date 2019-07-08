/**
 * 
 */
package com.raj.leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 *         Given a string, find the longest substring that contains only two
 *         unique characters. For example, given "abcbbbbcccbdddadacb", the
 *         longest substring that contains 2 unique character is "bcbbbbcccb"
 */
public class LongestSubstringContainsKUniqueCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		return lengthOfLongestSubstringKDistinct(s, 2);
	}

	private int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = 0;
        if(0 ==k) return res;
		Map<Character,Integer> map = new HashMap<>();

		for (int l = 0, r = 0; r < s.length(); r++) {
			char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
			while (l < r && map.size()>k) {
                char left = s.charAt(l++);
				map.put(left,map.getOrDefault(left,0)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
			}
		    res = Math.max(res, r - l + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		LongestSubstringContainsKUniqueCharacters obj = new LongestSubstringContainsKUniqueCharacters();

		String str = "eceba";
		System.out.println(str);
		int result;

		// Time : O(n)
		int k = 2;
		result = obj.lengthOfLongestSubstringTwoDistinct(str);
		System.out.println(result);

		result = obj.lengthOfLongestSubstringTwoDistinct("ccaabbb");
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
