/**
 * 
 */
package com.raj.mathamatical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raj
 *
 *
 *         A strobogrammatic number is a number that looks the same when rotated
 *         180 degrees (looked at upside down).
 * 
 *         Find all strobogrammatic numbers that are of length = n.
 * 
 *         For example, Given n = 2, return ["11","69","88","96"].
 */
public class StrobogrammaticNumber2 {

	public static List<String> strobogrammaticNumbersOfSizeN(int n) {
		char a[] = new char[n];
		List<String> result = new ArrayList<>();
		helper(0, n - 1, a, result);
		return result;
	}

	private static void helper(int l, int r, char[] a, List<String> result) {
		if (l > r) {
			result.add(new String(a));
			return;
		}
		if (l == r) {
			a[l] = '0';
			result.add(new String(a));
			a[l] = '1';
			result.add(new String(a));
			a[l] = '8';
			result.add(new String(a));
			return;
		}
		if (l != 0) {
			a[l] = '0';
			a[r] = '0';
			helper(l + 1, r - 1, a, result);
		}
		a[l] = '1';
		a[r] = '1';
		helper(l + 1, r - 1, a, result);
		a[l] = '6';
		a[r] = '9';
		helper(l + 1, r - 1, a, result);
		a[l] = '8';
		a[r] = '8';
		helper(l + 1, r - 1, a, result);
		a[l] = '9';
		a[r] = '6';
		helper(l + 1, r - 1, a, result);
	}

	public static List<String> strobogrammaticNumbersOfSizeN2(int n) {
		return helper2(n, n);
	}

	private static List<String> helper2(int curLen, int n) {
		if (0 == curLen) {
			return new ArrayList<>(Arrays.asList(""));
		}
		if (1 == curLen) {
			return new ArrayList<>(Arrays.asList("0", "1", "8"));
		}
		List<String> list = helper2(curLen - 2, n);
		List<String> result = new ArrayList<>();
		for (String str : list) {
			if (curLen != n)
				result.add("0" + str + "0");
			result.add("1" + str + "1");
			result.add("6" + str + "6");
			result.add("8" + str + "8");
			result.add("9" + str + "9");
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> res = null;
		res = strobogrammaticNumbersOfSizeN(4);
		System.out.println(res);
		res = strobogrammaticNumbersOfSizeN(3);
		System.out.println(res);

	}

}
