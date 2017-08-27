/**
 *
 */
package com.raj.mathamatical;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 * 
 *         Given two integers representing the numerator and denominator of a
 *         fraction, return the fraction in string format. If the fractional
 *         part is repeating, enclose the repeating part in parentheses.
 * 
 *         For example, Given numerator = 1, denominator = 2, return "0.5".
 * 
 *         Given numerator = 2, denominator = 1, return "2".
 * 
 *         Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractiontoRecurringDecimal {

	// Time :O(mn), Space :O(m+n)
	public static String fractionToDecimal(int a, int b) {
		StringBuilder sb = new StringBuilder();

		// zero numerator
		if (0 == a) {
			sb.append(a);
			return sb.toString();
		}
		// determine the sign
		if (a < 0 || b < 0) {
			sb.append('-');
		}

		// remove sign of operands
		a = Math.abs(a);
		b = Math.abs(b);

		sb.append(a / b);

		// in case no fractional part
		if (a % b == 0) {
			return sb.toString();
		}
		sb.append('.');

		Map<Integer, Integer> map = new HashMap<>();

		// simulate the division process
		for (int r = a % b; r > 0; r %= b) {

			// meet a known remainder
			// so we reach the end of the repeating part
			if (map.containsKey(r)) {
				sb.insert(map.get(r), "(");
				sb.append(")");
				break;
			}
			// the remainder is first seen
			// remember the current position for it
			map.put(r, sb.length());
			r *= 10;
			// append the quotient digit
			sb.append(r / b);
		}
		return sb.toString();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = null;
		result = fractionToDecimal(1, 2);
		System.out.println(result);
		result = fractionToDecimal(2, 1);
		System.out.println(result);
		result = fractionToDecimal(2, 3);
		System.out.println(result);
		result = fractionToDecimal(22, 3);
		System.out.println(result);
		result = fractionToDecimal(9, 100);
		System.out.println(result);
	}

}
