/**
 * 
 */
package com.raj.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 * @author Raj
 *
 */

/*
 * Given a string, find its first non-repeating character
 * 
 * Using Single Traversal of String
 */

/*
 * http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-
 * character/
 */
public class FindFirstNonRepeatingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFirstNonRepeatingCharacter obj = new FindFirstNonRepeatingCharacter();

		// String str = "thomaoht";
		String str = "raja";
		char result;

		// Time : O(n), Space :O(1)
		// by traversing twice
		result = obj.findFirstNonRepeatingCharacter(str);
		System.out.println(result);

		// Time : O(n), Space :O(1)
		// by traversing once
		result = obj.findFirstNonRepeatingCharacterByTraversingOnce(str.toCharArray(), str.length());
		System.out.println(result);

		// Time : O(n), Space :O(1)
		// by traversing once
		result = obj.findFirstNonRepeatingCharacterByTraversingOnceWithoutSorting(str.toCharArray(), str.length());
		System.out.println(result);

	}

	// Time : O(n), Space :O(1)
	public char findFirstNonRepeatingCharacterByTraversingOnceWithoutSorting(char[] a, int n) {
		class Char {
			char ch;
			int index;
			int count;

			public Char(char ch, int index, int count) {
				super();
				this.ch = ch;
				this.index = index;
				this.count = count;
			}

			@Override
			public String toString() {
				return "Char [index=" + index + ", count=" + count + "]";
			}

		}
		Char[] count = new Char[256];
		for (int i = 0; i < count.length; i++)
			count[i] = new Char((char) i, Integer.MAX_VALUE, 0);

		for (int i = 0; i < n; i++) {
			count[a[i]].count++;
			count[a[i]].index = i;
		}

		Char result = null;
		for (int i = 0; i < count.length; i++) {
			if (count[i].count == 1) {
				if (result == null) {
					result = count[i];
				} else if (count[i].index < result.index) {
					result = count[i];
				}
			}
		}
		return result == null ? 0 : result.ch;
	}

	// Time : O(n), Space :O(1)
	public char findFirstNonRepeatingCharacterByTraversingOnce(char[] a, int n) {
		class Char {
			char ch;
			int index;
			int count;

			public Char(char ch, int index, int count) {
				super();
				this.ch = ch;
				this.index = index;
				this.count = count;
			}

			@Override
			public String toString() {
				return "Char [ch=" + ch + ", index=" + index + ", count=" + count + "]";
			}

		}
		Char[] count = new Char[256];
		for (int i = 0; i < count.length; i++)
			count[i] = new Char((char) i, Integer.MAX_VALUE, 0);

		for (int i = 0; i < n; i++) {
			count[a[i]].count++;
			count[a[i]].index = i;
		}

		Arrays.sort(count, new Comparator<Char>() {
			public int compare(Char c1, Char c2) {
				return c1.index - c2.index;
			}
		});

		for (int i = 0; i < count.length; i++) {
			if (count[i].count == 1) {
				return count[i].ch;
			}
		}
		return 0;
	}

	// Time : O(n), Space :O(1)
	public char findFirstNonRepeatingCharacter(String str) {
		char nonRepeated = ' ';
		if (null == str || str.isEmpty())
			return nonRepeated;
		int count[] = new int[256];
		for (char ch : str.toCharArray()) {
			count[ch]++;
		}

		for (char ch : str.toCharArray()) {
			if (count[ch] == 1) {
				return ch;
			}
		}

		return nonRepeated;
	}

}
