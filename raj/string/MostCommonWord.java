package com.raj.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 

Note:

1 <= paragraph.length <= 1000.
1 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
Different words in paragraph are always separated by a space.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
 


 *
 */
public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (String word : banned)
			set.add(word);
		int max = 0;
		String res = "";
		for (String word : paragraph.toLowerCase().replaceAll("\\pP", "").split("\\s")) {
			if (set.contains(word))
				continue;
			map.compute(word, (key, value) -> {
				if (null == value) {
					value = 0;
				}
				return value + 1;
			});
			if (map.get(word) > max) {
				max = map.get(word);
				res = word;
			}
		}

		return res;
	}

	public List<String> mostCommonWord2(String paragraph, String[] banned) {
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (String word : banned)
			set.add(word);
		int max = 0;
		List<String> res = new ArrayList<>();
		for (String word : paragraph.toLowerCase().replaceAll("\\pP", "").split("\\s")) {
			if (set.contains(word))
				continue;
			map.compute(word, (key, value) -> {
				if (null == value) {
					value = 0;
				}
				return value + 1;
			});
			max = Math.max(max, map.get(word));
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max)
				res.add(entry.getKey());
		}

		return res;
	}

	public static void main(String... args) {
		MostCommonWord obj = new MostCommonWord();
		String paragraph = "Bob hit the ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };
		String res = obj.mostCommonWord(paragraph, banned);
		System.out.println(res);
		System.out.println(obj.mostCommonWord2(paragraph, banned));
	}
}