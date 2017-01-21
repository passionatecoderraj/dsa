/**
 * 
 */
package com.raj.mathamatical;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 *
 *         A strobogrammatic number is a number that looks the same when rotated
 *         180 degrees (looked at upside down).
 * 
 *         Write a function to determine if a number is strobogrammatic. The
 *         number is represented as a string.
 * 
 *         For example, the numbers "69", "88", and "818" are all
 *         strobogrammatic.
 */
public class StrobogrammaticNumber {

	public static boolean isStrobogrammatic(String number) {
		if (null == number || number.isEmpty())
			return true;

		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

		int l = 0, r = number.length() - 1;
		while (l <= r) {
			if (map.get(number.charAt(l++)) != number.charAt(r--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		boolean res = false;
		res = isStrobogrammatic("1961");
		System.out.println(res);
		res = isStrobogrammatic("14");
		System.out.println(res);

	}

}
