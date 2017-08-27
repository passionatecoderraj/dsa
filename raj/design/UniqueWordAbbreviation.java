/**
 * 
 */
package com.raj.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj
 *
 *         An abbreviation of a word follows the form <first letter>
 *         <number><last letter>. Below are some examples of word abbreviations:
 * 
 *         a) it --> it (no abbreviation)
 * 
 *         1 b) d|o|g --> d1g
 * 
 *         1 1 1 1---5----0----5--8
 * 
 *         c) i|nternationalizatio|n --> i18n
 * 
 *         1 1---5----0
 * 
 *         d) l|ocalizatio|n --> l10n
 * 
 *         Assume you have a dictionary and given a word, find whether its
 *         abbreviation is unique in the dictionary. A word's abbreviation is
 *         unique if no other word from the dictionary has the same
 *         abbreviation.
 * 
 *         Example: Given dictionary = [ "deer", "door", "cake", "card" ]
 * 
 *         isUnique("dear") -> false
 * 
 *         isUnique("cart") -> true
 * 
 *         isUnique("cane") -> false
 * 
 *         isUnique("make") -> true
 */
public class UniqueWordAbbreviation {

	Map<String, Set<String>> map;

	public UniqueWordAbbreviation(String[] dictionary) {
		map = new HashMap<>();
		for (String word : dictionary) {
			map.computeIfAbsent(getAbbreviation(word), key -> new HashSet<>()).add(word);
		}
	}

	private String getAbbreviation(String word) {
		if (word.length() <= 2)
			return word;
		return word.charAt(0) + Integer.toString((word.length() - 2)) + word.charAt(word.length() - 1);
	}

	public boolean isUnique(String word) {
		String abbr = getAbbreviation(word);
		if (!map.containsKey(abbr)) {
			return true;
		} else {
			return map.get(abbr).size() == 1 && map.get(abbr).contains(abbr);
		}
	}

	public static void main(String[] args) {
		String dictionary[] = { "deer", "door", "cake", "card" };
		UniqueWordAbbreviation obj = new UniqueWordAbbreviation(dictionary);

		boolean result = false;

		result = obj.isUnique("deer");
		System.out.println(result);

		result = obj.isUnique("card");
		System.out.println(result);

	}

}
