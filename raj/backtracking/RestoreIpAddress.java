package com.raj.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

	/**
	 * 
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s) {

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
		int num = Integer.parseInt(a);
		return num >= 0 && num <= 255;
	}

	public static void main(String[] args) {
		RestoreIpAddress obj = new RestoreIpAddress();

		String s = "25525511135";
		List<String> result = null;
		result = obj.restoreIpAddresses(s);
		System.out.println(result);
	}
}