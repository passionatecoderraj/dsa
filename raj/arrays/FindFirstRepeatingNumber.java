/**
 * 
 */
package com.raj.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 * 
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

	}

	public int findFirstRepeatingNumber(int[] a, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
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
