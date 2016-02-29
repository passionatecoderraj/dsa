/**
 * 
 */
package com.raj.arrays;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj
 *
 * 
 */
/*
 * Given an array of integers, find the first repeating element in it. We need
 * to find the element that occurs more than once and whose index of first
 * occurrence is smallest.
 */
public class FindFirstRepeatingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFirstRepeatingNumber obj = new FindFirstRepeatingNumber();

		int[] a = { 10, 5, 3, 4, 3, 5, 6 };
		int n = a.length, result = -1;

		// Time : O(n), Space : O(n)
		result = obj.findFirstRepeatingNumber(a, n);
		System.out.println(result);

		// Time : O(n), Space : O(n)
		result = obj.findFirstRepeatingNumberUsingHashSet(a, n);
		System.out.println(result);

	}

	public int findFirstRepeatingNumberUsingHashSet(int[] a, int n) {
		Set<Integer> set = new HashSet<Integer>();
		int repeated = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (set.contains(a[i]))
				repeated = a[i];
			else
				set.add(a[i]);
		}

		return repeated;
	}

	public int findFirstRepeatingNumber(int[] a, int n) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}

		for (int i = 0; i < n; i++) {
			if (map.get(a[i]) > 1)
				return a[i];
		}
		return -1;
	}

}
