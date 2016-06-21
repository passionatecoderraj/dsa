/**
 * 
 */
package com.raj.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Raj
 *
 */
/*
 * Find the n’th term in Look-and-say (Or Count and Say) Sequence. The
 * look-and-say sequence is the sequence of below integers:
 * 
 * 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, …
 */
public class LookAndSaySequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LookAndSaySequence obj = new LookAndSaySequence();
		String result = null;
		int n = 5;
		result = obj.lookAndSaySequence(n);
		System.out.println(result);
		result = obj.lookAndSaySequence("abcca");
		System.out.println(result);
	}

	// input abcca, output 2a1b2c
	public String lookAndSaySequence(String st) {
		Map<Character, Integer> countMap = new HashMap<>();
		for (char ch : st.toCharArray()) {
			countMap.compute(ch, (key, value) -> {
				if (value == null)
					return 1;
				return value + 1;
			});
		}
		StringBuilder sb = new StringBuilder();
		Iterator<Character> it = countMap.keySet().iterator();
		while (it.hasNext()) {
			char ch = it.next();
			sb.append(countMap.get(ch));
			sb.append(ch);
			it.remove();
		}
		return sb.toString();
	}

	public String lookAndSaySequence(int n) {
		String[] str = new String[n];
		str[0] = "1";
		int count = 0;
		char prev, ch;
		String cur;
		StringBuilder sb;
		for (int i = 1; i < n; i++) {
			cur = str[i - 1];
			sb = new StringBuilder();

			count = 1;
			prev = cur.charAt(0);
			for (int j = 1; j < cur.length(); j++) {
				ch = cur.charAt(j);
				if (ch == prev) {
					count++;
				} else {
					sb.append(count);
					sb.append(prev);
					prev = ch;
					count = 1;
				}
			}
			sb.append(count);
			sb.append(prev);
			str[i] = sb.toString();
		}
		return str[n - 1];
	}

}
