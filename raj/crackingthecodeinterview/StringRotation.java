package com.raj.crackingthecodeinterview;

/*
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring(ex: "waterbottle" is a rotation of "erbottlewat"
 */
public class StringRotation {

	public static void main(String args[]) {
		StringRotation obj = new StringRotation();
		String str1 = "waterbottle", str2 = "erbottlewat";
		boolean result = false;
		result = obj.checkIfS2IsRotationOfS1(str1, str2);
		System.out.println(result);
	}

	public boolean checkIfS2IsRotationOfS1(String s1, String s2) {
		if (null == s1 && null == s2)
			return true;
		if (null == s1 || null == s2)
			return false;
		if (s1.length() != s2.length())
			return false;

		String s1s1 = s1 + s1;
		System.out.println(s1s1);
		System.out.println(s2);

		return isSubstring(s1s1, s2);
	}

	public boolean isSubstring(String str, String str2) {
		return str.contains(str2);
	}

}