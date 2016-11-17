package com.raj.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.interivew.graph.CommonUtil;

public class RestoreIpAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();

		if (s == null || s.length() < 4) {
			return result;
		}

		restoreHelper(s, 0, 1, "", result);

		return result;
	}

	private void restoreHelper(String s, int start, int segment, String curr, List<String> result) {
		if (start >= s.length()) {
			return;
		}

		if (segment == 4) {
			if (isValid(s.substring(start))) {
				result.add(curr + "." + s.substring(start));
			}
			return;
		}

		for (int i = 1; i < 4 && start + i < s.length(); i++) {
			String temp = s.substring(start, start + i);
			if (isValid(temp)) {
				if (segment == 1) {
					restoreHelper(s, start + i, segment + 1, temp, result);
				} else {
					restoreHelper(s, start + i, segment + 1, curr + "." + temp, result);
				}
			}
		}
	}

	private boolean isValid(String str) {
		if (str == null || str.length() > 3) {
			return false;
		}

		int num = Integer.parseInt(str);
		if (str.charAt(0) == '0' && str.length() > 1) {
			return false;
		}

		if (num >= 0 && num <= 255) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		RestoreIpAddress obj = new RestoreIpAddress();

		String s = "25525511135";
		List<String> result = null;
		result = obj.restoreIpAddresses(s);
		System.out.println(result);
	}
}