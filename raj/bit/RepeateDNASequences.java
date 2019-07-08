/**
 * 
 */
package com.raj.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj
 *
 */
public class RepeateDNASequences {

	/*
	 * The key to solve this problem is that each of the 4 nucleotides can be stored
	 * in 2 bits. So the 10-letter-long sequence can be converted to 20-bits-long
	 * integer. The following is a Java solution. You may use an example to manually
	 * execute the program and see how it works.
	 * 
	 * Now let's analyze the space cost. Since in Java, each character takes 2
	 * bytes. For the previous solution using string, a 10-character substring takes
	 * 20 byte. For using the integer, which takes only 4 bytes. So the new solution
	 * saves the memory by 1/5.
	 * 
	 */
	// explanation :
	// https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-manipulation/9
	public static List<String> findRepeatedDnaSequences2(String s) {
		List<String> result = new ArrayList<String>();

		int len = s.length();
		if (len < 10) {
			return result;
		}
		// these are all 2 bits
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		Set<Integer> hash_codes = new HashSet<Integer>();
		Map<Integer, String> hash_to_str = new HashMap<>();

		int _20bits_set = (1 << 20) - 1;
		int hash = 0;
		for (int i = 0; i < len; i++) {
			// each ACGT fit 2 bits, so left shift 2
			hash = (hash << 2) + map.get(s.charAt(i));

			if (i >= 9) {
				// here hash might go beyond 20 bits
				// make length of hash to be 20
				hash = hash & _20bits_set;

				if (!hash_codes.contains(hash)) {
					hash_codes.add(hash);

				} else if (!hash_to_str.containsKey(hash)) {
					String str = s.substring(i - 9, i + 1);
					hash_to_str.put(hash, str);
				}

			}

		}
		result.addAll(hash_to_str.values());
		return result;
	}

	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		Set<String> set = new HashSet<>();
		Set<String> result_set = new HashSet<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String str = s.substring(i, i + 10);
			if (set.contains(str)) {
				result_set.add(str);
			}
			set.add(str);
		}
		result.addAll(result_set);
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> result = null;
		result = findRepeatedDnaSequences2(s);
		System.out.println(result);
	}

}
