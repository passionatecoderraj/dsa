package com.raj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Raj
 * 
 *         Given a string containing only digits, restore it by returning all
 *         possible valid IP address combinations.
 * 
 *         Example:
 * 
 *         Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 *
 */
public class RestoreIpAddress {

	public List<String> restoreIpAddresses(String s) {

		List<String> result = new ArrayList<String>();

		if (null == s || s.length() < 4 && s.length() > 12) {
			return result;
		}

		int n = s.length();
		for (int i = 0; i < 3 && i < n - 3; i++) {
			for (int j = i + 1; j <= i + 3 && j < n - 2; j++) {
				for (int k = j + 1; k <= j + 3 && k < n - 1; k++) {
					String n1 = s.substring(0, i + 1);
					String n2 = s.substring(i + 1, j + 1);
					String n3 = s.substring(j + 1, k + 1);
					String n4 = s.substring(k + 1);

					if (n4.length() < 4 && valid(n1) && valid(n2) && valid(n3) && valid(n4)) {
						result.add(n1 + "." + n2 + "." + n3 + "." + n4);
					}
				}
			}
		}

		return result;
	}

	private boolean valid(String s) {
		if (s.length() > 1 && s.charAt(0) == '0')
			return false;
		int num = Integer.parseInt(s);
		return num >= 0 && num <= 255;
	}

	public List<String> restoreIpAddresses2(String s) {

		List<String> result = new ArrayList<String>();

		if (null == s || s.length() < 4 && s.length() > 12) {
			return result;
		}

		int n = s.length();
		for (int i = 1; i < 4 && i < n - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < n; k++) {
					String n1 = s.substring(0, i);
					String n2 = s.substring(i, j);
					String n3 = s.substring(j, k);
					String n4 = s.substring(k);
					if (valid2(n1) && valid2(n2) && valid2(n3) && valid2(n4)) {
						result.add(n1 + "." + n2 + "." + n3 + "." + n4);
					}
				}
			}
		}

		return result;
	}

	private boolean valid2(String s) {
		if (s.length() > 1 && s.charAt(0) == '0')
			return false;
		int num = Integer.parseInt(s);
		return num >= 0 && num <= 255;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses3(String s) {

		List<String> result = new ArrayList<String>();

		if (null == s || s.length() < 4 && s.length() > 12) {
			return result;
		}

		for (int a = 1; a <= 3; a++) {
			for (int b = 1; b <= 3; b++) {
				for (int c = 1; c <= 3; c++) {
					for (int d = 1; d <= 3; d++) {
						if (a + b + c + d == s.length()) {
							String n1 = s.substring(0, a);
							String n2 = s.substring(a, a + b);
							String n3 = s.substring(a + b, a + b + c);
							String n4 = s.substring(a + b + c);
							if (isValid(n1) && isValid(n2) && isValid(n3) && isValid(n4)) {
								result.add(n1 + "." + n2 + "." + n3 + "." + n4);
							}
						}
					}
				}
			}
		}

		return result;
	}

	private boolean isValid(String a) {
		if (a.length() > 1 && a.charAt(0) == '0')
			return false;
		int num = Integer.parseInt(a);
		return num >= 0 && num <= 255;
	}

	public static void main(String[] args) {
		RestoreIpAddress obj = new RestoreIpAddress();

		String s = "25525511135";
		List<String> result = null;
		result = obj.restoreIpAddresses(s);
		System.out.println(result);
		s = "1231231231234";
		result = obj.restoreIpAddresses(s);
		System.out.println(result);
	}
}
