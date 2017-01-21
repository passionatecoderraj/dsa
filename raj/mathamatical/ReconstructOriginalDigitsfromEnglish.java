/**
 * 
 */
package com.raj.mathamatical;

/**
 * @author Raj
 *
 *
 *         Given a non-empty string containing an out-of-order English
 *         representation of digits 0-9, output the digits in ascending order.
 * 
 *         Note: Input contains only lowercase English letters. Input is
 *         guaranteed to be valid and can be transformed to its original digits.
 *         That means invalid inputs such as "abc" or "zerone" are not
 *         permitted. Input length is less than 50,000.
 * 
 *         https://discuss.leetcode.com/topic/63386/one-pass-o-n-java-solution-
 *         simple-and-clear
 * 
 * 
 */
public class ReconstructOriginalDigitsfromEnglish {

	/*
	 * The idea is:
	 * 
	 * for zero, it's the only word has letter 'z',
	 * 
	 * for two, it's the only word has letter 'w',
	 * 
	 * ...... so we only need to count the unique letter of each word, Coz the
	 * input is always valid.
	 */
	public static String originalDigits(String str) {
		int count[] = new int[10];
		for (char ch : str.toCharArray()) {
			// unique
			if (ch == 'z')
				count[0]++;
			// 1-2-4-0
			// one,two,four,zero
			if (ch == 'o')
				count[1]++;
			// unique
			if (ch == 'w')
				count[2]++;
			// 3-8
			// three,eight
			if (ch == 'h')
				count[3]++;
			// unique
			if (ch == 'u')
				count[4]++;
			// 5-4
			// five,four
			if (ch == 'f')
				count[5]++;
			// unique
			if (ch == 'x')
				count[6]++;
			// 7-6
			// six,seven
			if (ch == 's')
				count[7]++;
			// unique
			if (ch == 'g')
				count[8]++;
			// 9-5-6-8
			// nine,five,six,eight
			if (ch == 'i')
				count[9]++;
		}
		count[3] -= count[8];
		count[5] -= count[4];
		count[7] -= count[6];
		count[9] -= (count[5] + count[6] + count[8]);
		count[1] -= (count[0] + count[2] + count[4]);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				sb.append(i);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String res = "";
		res = originalDigits("owoztneoer");
		System.out.println(res);
		res = originalDigits("fviefuro");
		System.out.println(res);

	}

}
