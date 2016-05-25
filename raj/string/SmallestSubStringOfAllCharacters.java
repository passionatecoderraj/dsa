/**
 * 
 */
package com.raj.string;

import java.util.HashMap;
import java.util.Map;

// https://www.pramp.com/question/wqNo9joKG6IJm67B6z34
/*
 * Given an array with unique characters arr and a string str, find the smallest substring of str containing all characters of arr.

Example:
arr: [x,y,z], str: xyyzyzyx
result: zyx
 */
/**
 * @author Raj
 *
 */
public class SmallestSubStringOfAllCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SmallestSubStringOfAllCharacters obj = new SmallestSubStringOfAllCharacters();
		String result = null;
		char[] a = { 'x', 'y', 'z' };
		String str = "xyyzyzyx";
		result = obj.smallestSubStringOfAllCharacters(a, str);
		System.out.println(result);

	}

	public String smallestSubStringOfAllCharacters(char[] a, String str) {
		String substring = null;
		int l = 0, r = 0;
		Map<Character, Integer> countMap = new HashMap<>();
		int totalCharacters = 0;
		int minLength = Integer.MAX_VALUE;
		char ch;
		while (true) {
			if (totalCharacters < a.length) {
				if (r == str.length())
					break;

				ch = str.charAt(r);
				if (countMap.containsKey(ch)) {
					countMap.put(ch, countMap.get(ch) + 1);
				} else {
					countMap.put(ch, 1);
					totalCharacters++;
				}
				r++;
			} else {
				if (r - l < minLength) {
					substring = str.substring(l, r);
					minLength = substring.length();
				}

				ch = str.charAt(l);
				countMap.put(ch, countMap.get(ch) - 1);
				if (countMap.get(str.charAt(l)) == 0) {
					totalCharacters--;
					countMap.remove(ch);
				}
				l++;
			}
		}
		return substring;
	}

	public String smallestSubStringOfAllCharacters2(char[] a, String str) {
		String substring = null;
		int l = 0, r = 0;
		Map<Character, Integer> countMap = new HashMap<>();
		int totalCharacters = 0;
		int minLength = Integer.MAX_VALUE;
		char ch;
		for (r = 0; r < a.length; r++) {
			ch = str.charAt(r);
			if (countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			} else {
				countMap.put(ch, 1);
			}
			if (countMap.size() > a.length) {
				
			}
		}
		while (true) {
			if (totalCharacters < a.length) {
				if (r == str.length())
					break;

				ch = str.charAt(r);
				if (countMap.containsKey(ch)) {
					countMap.put(ch, countMap.get(ch) + 1);
				} else {
					countMap.put(ch, 1);
					totalCharacters++;
				}
				r++;
			} else {
				if (r - l < minLength) {
					substring = str.substring(l, r);
					minLength = substring.length();
				}

				ch = str.charAt(l);
				countMap.put(ch, countMap.get(ch) - 1);
				if (countMap.get(str.charAt(l)) == 0) {
					totalCharacters--;
					countMap.remove(ch);
				}
				l++;
			}
		}
		return substring;
	}

}
