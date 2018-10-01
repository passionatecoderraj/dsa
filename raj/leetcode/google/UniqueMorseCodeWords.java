/**
 * 
 */
package com.raj.leetcode.google;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Raj
 *
 *         International Morse Code defines a standard encoding where each
 *         letter is mapped to a series of dots and dashes, as follows: "a" maps
 *         to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * 
 *         For convenience, the full table for the 26 letters of the English
 *         alphabet is given below:
 * 
 *         [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *         Now, given a list of words, each word can be written as a
 *         concatenation of the Morse code of each letter. For example, "cab"
 *         can be written as "-.-.-....-", (which is the concatenation "-.-." +
 *         "-..." + ".-"). We'll call such a concatenation, the transformation
 *         of a word.
 * 
 *         Return the number of different transformations among all words we
 *         have.
 * 
 *         Example: Input: words = ["gin", "zen", "gig", "msg"] Output: 2
 *         Explanation: The transformation of each word is: "gin" -> "--...-."
 *         "zen" -> "--...-." "gig" -> "--...--." "msg" -> "--...--."
 * 
 *         There are 2 different transformations, "--...-." and "--...--.".
 */
public class UniqueMorseCodeWords {

	String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
			"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

	public int uniqueMorseRepresentations(String[] words) {
		Set<String> set = new HashSet<>();
		for (String word : words) {
			StringBuilder sb = new StringBuilder();
			for (char ch : word.toCharArray()) {
				sb.append(morse[ch - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}

	public static void main(String[] args) {
		UniqueMorseCodeWords obj = new UniqueMorseCodeWords();

		
		int result = -1;
		String words[] = { "gin", "zen", "gig", "msg" };

		result = obj.uniqueMorseRepresentations(words);
		System.out.println(result);
	}

}
