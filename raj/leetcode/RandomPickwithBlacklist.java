package com.raj.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author Raj
 * 
 *         Given an array w of positive integers, where w[i] describes the
 *         weight of index i, write a function pickIndex which randomly picks an
 *         index in proportion to its weight.
 * 
 *         Note:
 * 
 *         1 <= w.length <= 10000 1 <= w[i] <= 10^5 pickIndex will be called at
 *         most 10000 times. Example 1:
 * 
 *         Input: ["Solution","pickIndex"] [[[1]],[]] Output: [null,0] Example
 *         2:
 * 
 *         Input:
 *         ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 *         [[[1,3]],[],[],[],[],[]] Output: [null,0,1,1,1,0] Explanation of
 *         Input Syntax:
 * 
 *         The input is two lists: the subroutines called and their arguments.
 *         Solution's constructor has one argument, the array w. pickIndex has
 *         no arguments. Arguments are always wrapped with a list, even if there
 *         aren't any.
 * 
 * 
 */
public class RandomPickwithBlacklist {

	Random random;
	Map<Integer, Integer> map;
	int whitelist_len;

	// https://leetcode.com/problems/random-pick-with-blacklist/solution/
	// https://leetcode.com/problems/random-pick-with-blacklist/discuss/144624/Java-O(B)-O(1)-HashMap
	// Time : O(B), Space : O(B), B=blacklist.length
	public RandomPickwithBlacklist(int n, int[] blacklist) {
		random = new Random();
		map = new HashMap<>();
		this.whitelist_len = n - blacklist.length;
		Set<Integer> set = new HashSet<>();
		for (int w = whitelist_len; w < n; w++)
			set.add(w);
		for (int b : blacklist)
			set.remove(b);
		Iterator<Integer> it = set.iterator();
		for (int b : blacklist) {
			if (b < whitelist_len) {
				map.put(b, it.next());
			}
		}
	}

	// Time : O(logn)
	public int pick() {
		int key = random.nextInt(whitelist_len);
		return map.containsKey(key) ? map.get(key) : key;

	}

	public static void main(String... args) {
		RandomPickwithBlacklist obj = new RandomPickwithBlacklist(10, new int[] { 9, 5, 3, 8 });
		System.out.println(obj.pick());
		System.out.println(obj.pick());
	}
}