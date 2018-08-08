package com.interview.onion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class First {

	public static void main(String[] args) {
		List<String> str = new ArrayList<>();

	}

	public static List<String> reorderLines(int logFileSize, List<String> logLines) {

		List<String> strAlp = new ArrayList<String>();
		List<String> numberRows = new ArrayList<String>();
		List<String> result = new ArrayList<String>();

		if (null == logLines || logLines.isEmpty() || logFileSize != logLines.size()) {
			return result;
		}
		for (String str : logLines) {
			String[] part = str.split(" ", 2);
			if (Character.isDigit(part[1].charAt(0))) {
				numberRows.add(str);
			} else {
				strAlp.add(part[1].concat(" " + part[0]));
			}
		}

		Collections.sort(strAlp);
		for (String str : strAlp) {
			String[] part = { str.substring(0, str.lastIndexOf(" ")), str.substring(str.lastIndexOf(" ") + 1) };
			result.add(part[1].concat(" " + part[0]));
		}
		result.addAll(numberRows);
		return result;
	}

	public static List<String> mostCommonWord(String literatureText, List<String> wordsToExclude) {

		Set<String> banset = new HashSet<>();
		for (String word : wordsToExclude)
			banset.add(word);

		Map<String, Integer> count = new HashMap<>();

		int high = 0;

		for (String w : literatureText.split(" ")) {
			if (!banset.contains(w)) {
				if (count.containsKey(w)) {
					count.put(w, count.get(w) + 1);
				} else {
					count.put(w, 1);
				}
				if (count.get(w) > high) {
					high = count.get(w);
				}
			}
		}
		List<String> result = new ArrayList<>();
		for (String key : count.keySet()) {
			if (high == count.get(key)) {
				result.add(key);
			}
		}

		return result;
	}

	public static String mostCommonWord2(String literatureText, List<String> wordsToExclude) {

		Set<String> banset = new HashSet<>();
		for (String word : wordsToExclude)
			banset.add(word);

		literatureText += ".";
		Map<String, Integer> count = new HashMap<>();

		String ans = "";
		int ansfreq = 0;

		StringBuilder word = new StringBuilder();
		for (char c : literatureText.toCharArray()) {
			if (Character.isLetter(c)) {
				word.append(Character.toLowerCase(c));
			} else if (word.length() > 0) {
				String finalword = word.toString();
				if (!banset.contains(finalword)) {
					count.put(finalword, count.getOrDefault(finalword, 0) + 1);
					if (count.get(finalword) > ansfreq) {
						ans = finalword;
						ansfreq = count.get(finalword);
					}
				}
				word = new StringBuilder();
			}
		}

		return ans;
	}

}
