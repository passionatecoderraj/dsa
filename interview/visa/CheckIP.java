package com.interview.visa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static String[] check_IP(String[] s) {
		final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
		final String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
		Pattern VALID_IPV4_PATTERN = Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
		Pattern VALID_IPV6_PATTERN = Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);

		String res[] = new String[s.length];
		for (int i = 0; i < s.length; i++) {
			String ipAddress = s[i];
			Matcher m1 = VALID_IPV4_PATTERN.matcher(ipAddress);
			Matcher m2 = VALID_IPV6_PATTERN.matcher(ipAddress);
			if (m1.matches()) {
				res[i] = "IPv4";
			} else if (m2.matches()) {
				res[i] = "IPv6";
			} else {
				res[i] = "Neither";
			}
		}
		return res;
	}
}
