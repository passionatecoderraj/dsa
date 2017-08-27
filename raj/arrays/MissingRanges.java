/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 *
 *         Given a sorted integer array where the range of elements are in the
 *         inclusive range [lower, upper], return its missing ranges.
 * 
 *         For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 *         return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {

	private static List<String> missingRanges(int[] a, int lower, int upper) {
		List<String> result = new ArrayList<>();
		if (a.length <= 0) {
			result.add(createRange(lower, upper));
			return result;
		}
		if (a[0] > lower) {
			result.add(createRange(lower, a[0] - 1));
		}

		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1])
				continue;
			if (a[i] > 1 + a[i - 1]) {
				result.add(createRange(a[i - 1] + 1, a[i] - 1));
			}
		}
		if (a[a.length - 1] < upper) {
			result.add(createRange(a[a.length - 1] + 1, upper));
		}
		return result;
	}

	private static String createRange(int from, int to) {
		return from == to ? Integer.toString(from) : from + "->" + to;
	}

	public static void main(String[] args) {
		List<String> result = null;
		int a[] = { 0, 1, 3, 50, 75 };
		result = missingRanges(a, 0, 99);
		System.out.println(result);

		int a2[] = { -2147483648, 2147483647 };
		result = missingRanges(a2, -2147483648, 2147483647);
		System.out.println(result);
	}

}
