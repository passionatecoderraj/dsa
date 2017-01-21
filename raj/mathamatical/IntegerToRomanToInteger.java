/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 */
public class IntegerToRomanToInteger {

	/**
	 * @param args
	 */
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

	public int romanToInteger(String str) {
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

	public String integerToRoman(int n) {
		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[n / 1000] + C[(n % 1000) / 100] + X[(n % 100) / 10] + I[n % 10];
	}

}
