/**
 * 
 */
package com.raj.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Raj
 *
 *
 *         Given a sequence of words, check whether it forms a valid word
 *         square.
 * 
 *         A sequence of words forms a valid word square if the kth row and
 *         column read the exact same string, where 0 ≤ k < max(numRows,
 *         numColumns).
 * 
 *         Note:
 * 
 *         The number of words given is at least 1 and does not exceed 500. Word
 *         length will be at least 1 and does not exceed 500. Each word contains
 *         only lowercase English alphabet a-z. Example 1:
 * 
 *         Input: [ "abcd", "bnrt", "crmy", "dtye" ]
 * 
 *         Output: true
 * 
 *         Explanation: The first row and first column both read "abcd". The
 *         second row and second column both read "bnrt". The third row and
 *         third column both read "crmy". The fourth row and fourth column both
 *         read "dtye".
 * 
 *         Therefore, it is a valid word square.
 */

public class ValidWordSquares {

	public boolean validWordSqure(List<String> words) {
		if (null == words || words.size() == 0)
			return true;
		for (String word : words) {
			if (word.length() != words.size())
				return false;
		}

		for (int i = 0; i < words.size(); i++) {
			String rowWord = words.get(i);
			for (int j = i; j < rowWord.length(); j++) {
				String colWord = words.get(j);
				if (colWord.charAt(i) != rowWord.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidWordSquares obj = new ValidWordSquares();
		List<String> words = new ArrayList<>();
		words.add("abcd");
		words.add("bnrt");
		words.add("crmy");
		words.add("dtye");

		boolean result = false;
		result = obj.validWordSqure(words);
		System.out.println(result);

		words.clear();
		words.add("ball");
		words.add("area");
		words.add("read");
		words.add("lady");

		result = obj.validWordSqure(words);
		System.out.println(result);
	}

}
