/**
 * 
 */
package com.raj.mathamatical;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 */
public class IntegerToRomanToInteger {

	public String integerToRoman(int n) {
		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[n / 1000] + C[(n % 1000) / 100] + X[(n % 100) / 10] + I[n % 10];
	}

	/*
	 * The solution above is self-explained, but look redundant. For the case
	 * where 4, 40, 400, 9, 90, 900, we can see that if the first character is
	 * less than second, e.g. 4 is IV, we know that it must be in either the
	 * case above. Else, VI, we know that it is 5 + 1 = 6.
	 */
	public int romanToInteger(String str) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0;
		int n = str.length();
		for (int i = 0; i < n;) {
			if (i < n - 1 && map.get(str.charAt(i)) < map.get(str.charAt(i + 1))) {
				res += (map.get(str.charAt(i + 1)) - map.get(str.charAt(i)));
				i += 2;
			} else {
				res += map.get(str.charAt(i));
				i++;
			}
		}
		return res;
	}

	public int romanToInteger2(String str) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0;
		int n = str.length();
		for (int i = 0; i < n;) {
			if (i < n - 1 && str.charAt(i) == 'I' && str.charAt(i + 1) == 'V') {
				res += 4;
				i += 2;
			} else if (i < n - 1 && str.charAt(i) == 'I' && str.charAt(i + 1) == 'X') {
				res += 9;
				i += 2;
			} else if (i < n - 1 && str.charAt(i) == 'X' && str.charAt(i + 1) == 'L') {
				res += 40;
				i += 2;
			} else if (i < n - 1 && str.charAt(i) == 'X' && str.charAt(i + 1) == 'C') {
				res += 90;
				i += 2;
			} else if (i < n - 1 && str.charAt(i) == 'C' && str.charAt(i + 1) == 'D') {
				res += 400;
				i += 2;
			} else if (i < n - 1 && str.charAt(i) == 'C' && str.charAt(i + 1) == 'M') {
				res += 900;
				i += 2;
			} else {
				res += map.get(str.charAt(i));
				i++;
			}

		}

		return res;
	}

	public int romanToInteger3(String str) {
		int res = 0;
		char pre = ' ', cur;
		for (int i = 0; i < str.length(); i++) {
			cur = str.charAt(i);

			if (cur == 'M' && pre != 'C') {
				res += 1000;
			}
			if (cur == 'C' && pre != 'X') {
				res += 100;
			}
			if (cur == 'X' && pre != 'I') {
				res += 10;
			}
			if (cur == 'M' && pre == 'C') {
				res += 800;
			}
			if (cur == 'C' && pre == 'X') {
				res += 80;
			}
			if (cur == 'X' && pre == 'I') {
				res += 8;
			}

			if (cur == 'D' && pre != 'C') {
				res += 500;
			}
			if (cur == 'L' && pre != 'X') {
				res += 50;
			}
			if (cur == 'V' && pre != 'I') {
				res += 5;
			}

			if (cur == 'D' && pre == 'C') {
				res += 300;
			}
			if (cur == 'L' && pre == 'X') {
				res += 30;
			}
			if (cur == 'V' && pre == 'I') {
				res += 3;
			}

			if (cur == 'I') {
				res += 1;
			}

			pre = cur;

		}

		return res;
	}

	public static void main(String[] args) {
		IntegerToRomanToInteger obj = new IntegerToRomanToInteger();

		String result = null;
		int res = -1;

		// Time :O(n)
		result = obj.integerToRoman(2934);
		System.out.println(result);

		res = obj.romanToInteger(result);
		System.out.println(res);

	}

}
