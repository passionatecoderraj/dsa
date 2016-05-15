package com.raj.leetcode;

/*
 * Reverse Vowels of a String
 * 
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {

	public static void main(String args[]) {
		ReverseVowels s = new ReverseVowels();
		String str = s.reverseVowels("leetcode");
		System.out.println(str);
	}

	public String reverseVowels(String s) {
		StringBuilder sb = new StringBuilder(s);
		int l = 0, r = sb.length() - 1;
		while (l < r) {
			while (l < r && !isVowel(sb.charAt(l)))
				l++;
			while (l < r && !isVowel(sb.charAt(r)))
				r--;
			if (l != r)
				swap(sb, l++, r--);
		}
		return sb.toString();
	}

	public boolean isVowel(char ch) {
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			return true;
		default:
			return false;
		}
	}

	public void swap(StringBuilder sb, int i, int j) {
		char ch = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, ch);
	}

}