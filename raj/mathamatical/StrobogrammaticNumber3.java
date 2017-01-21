/**
 * 
 */
package com.raj.mathamatical;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 *
 *
 *         A strobogrammatic number is a number that looks the same when rotated
 *         180 degrees (looked at upside down).
 * 
 *         Write a function to count the total strobogrammatic numbers that
 *         exist in the range of low <= num <= high.
 * 
 *         For example,Given low = "50", high = "100", return 3. Because 69, 88,
 *         and 96 are three strobogrammatic numbers.
 * 
 *         Note:Because the range might be a large number, the low and high
 *         numbers are represented as string.
 */
public class StrobogrammaticNumber3 {

	public static int strobogrammaticNumbersInRange(String low, String high) {
		int[] count = new int[1];
		for (int i = low.length(); i <= high.length(); i++) {
			char a[] = new char[i];
			helper(0, i - 1, a, low, high, count);
		}
		return count[0];
	}

	public static void helper(int l, int r, char[] a, String low, String high, int[] count) {
		if (l > r) {
			if (inRange(a, low, high))
				count[0]++;
			return;
		}
		if (l == r) {
			a[l] = '0';
			if (inRange(a, low, high))
				count[0]++;
			a[l] = '1';
			if (inRange(a, low, high))
				count[0]++;
			a[l] = '8';
			if (inRange(a, low, high))
				count[0]++;
		}
		if (l != 0) {
			a[l] = '0';
			a[r] = '0';
			helper(l + 1, r - 1, a, low, high, count);
		}
		a[l] = '1';
		a[r] = '1';
		helper(l + 1, r - 1, a, low, high, count);
		a[l] = '6';
		a[r] = '9';
		helper(l + 1, r - 1, a, low, high, count);
		a[l] = '8';
		a[r] = '8';
		helper(l + 1, r - 1, a, low, high, count);
		a[l] = '9';
		a[r] = '6';
		helper(l + 1, r - 1, a, low, high, count);
	}

	private static boolean inRange(char a[], String low, String high) {
		String num = new String(a);
		// we can use compare method to replace but this method is useful in
		// other programs
		// if (num.length() == low.length() && num.compareTo(low) > 0) {
		// if (num.length() == high.length() && num.compareTo(high) < 0) {
		return greaterOrEqual(num, low) && greaterOrEqual(high, num);
	}

	// it takes extra space to preserve
	public static int strobogrammaticNumbersInRange2(String low, String high) {
		List<String> result = new ArrayList<>();
		for (int i = low.length(); i <= high.length(); i++) {
			result.addAll(StrobogrammaticNumber2.strobogrammaticNumbersOfSizeN(i));
		}
		int count = 0;
		for (String num : result) {

			// we can use compare method to replace but this method is useful in
			// other programs

			// if (num.length() == low.length() && num.compareTo(low) > 0) {
			if (num.length() == low.length() && greaterOrEqual(num, low)) {
				System.out.println(num);
				count++;
			}

			// we can use compare method to replace but this method is useful in
			// other programs

			// if (num.length() == high.length() && num.compareTo(high) < 0) {
			if (num.length() == high.length() && greaterOrEqual(high, num)) {
				System.out.println(num);
				count++;
			}
		}
		return count;
	}

	private static boolean greaterOrEqual(String s, String t) {
		if (s.length() != t.length())
			return s.length() > t.length();
		int i = 0;
		while (i < s.length() && s.charAt(i) == t.charAt(i)) {
			i++;
		}
		return i == s.length() ? true : s.charAt(i) >= t.charAt(i);
	}

	public static void main(String[] args) {
		int res = -1;
		res = strobogrammaticNumbersInRange("50", "100");
		System.out.println(res);
	}

}
