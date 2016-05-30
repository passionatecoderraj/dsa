package com.raj.crackingthecodeinterview;

/*
 * Write a method to replace all spaces with %20
 * use only char array to solve in java
 *
 */
public class ReplaceSpaceInString {

	public static void main(String args[]) {
		ReplaceSpaceInString obj = new ReplaceSpaceInString();
		String str = "Mr John Smith    ";
		char a[] = str.toCharArray();
		System.out.println(String.valueOf(a));
		obj.replaceSpace(a);
		System.out.println(String.valueOf(a));
	}

	public void replaceSpace(char[] a) {
		final int lastCharIndex = getLastCharacter(a);
		if (lastCharIndex == -1)
			return;
		int countSpace = 0;
		for (int i = 0; i <= lastCharIndex; i++) {
			if (a[i] == ' ')
				countSpace++;
		}
		int newStringLength = lastCharIndex + 1 + (countSpace * 2);

		if (a.length < newStringLength)
			return;
		for (int i = lastCharIndex, j = newStringLength - 1; i >= 0; i--, j--) {
			if (a[i] == ' ') {
				a[j--] = '0';
				a[j--] = '2';
				a[j] = '%';
			} else {
				a[j] = a[i];
			}
		}
	}

	private int getLastCharacter(char[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != ' ')
				return i;
		}
		return -1;
	}

}