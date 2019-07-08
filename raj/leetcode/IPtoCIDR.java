/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 *
 *Given a start IP address ip and a number of ips we need to cover n, return a representation of the range as a list (of smallest possible length) of CIDR blocks.

A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example: "123.45.67.89/20". That prefix length "20" represents the number of common prefix bits in the specified range.

Example 1:
Input: ip = "255.0.0.7", n = 10
Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
Explanation:
The initial ip address, when converted to binary, looks like this (spaces added for clarity):
255.0.0.7 -> 11111111 00000000 00000000 00000111
The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
ie. just this one address.

The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the given address:
255.0.0.8 -> 11111111 00000000 00000000 00001000
Addresses with common prefix of 29 bits are:
11111111 00000000 00000000 00001000
11111111 00000000 00000000 00001001
11111111 00000000 00000000 00001010
11111111 00000000 00000000 00001011
11111111 00000000 00000000 00001100
11111111 00000000 00000000 00001101
11111111 00000000 00000000 00001110
11111111 00000000 00000000 00001111

The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the given address,
ie. just 11111111 00000000 00000000 00010000.

In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .

There were other representations, such as:
["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
but our answer was the shortest possible.

Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100 
that are outside the specified range.
Note:
ip will be a valid IPv4 address.
Every implied address ip + x (for x < n) will be a valid IPv4 address.
n will be an integer in the range [1, 1000].

 */
public class IPtoCIDR {

	// https://leetcode.com/problems/ip-to-cidr/discuss/151348/Java-Solution-with-Very-Detailed-Explanation-8ms
	public List<String> ipToCIDR(String ip, int n) {
		// convert base 256 number to base 10
		int cur = toInt(ip);
		List<String> res = new ArrayList<>();
		while (n > 0) {
			int maxBits = Integer.numberOfTrailingZeros(cur);
			int bits = 0;
			int count = 1;
			while (count < n && bits < maxBits) {
				count <<= 1;
				++bits;
			}
			if (count > n) {
				count >>= 1;
				--bits;
			}
			// convert base 10 number back to base 256 by taking 8 bits each time, then form a result
			res.add(toString(cur, 32 - bits));
			n -= count;
			cur += (count);
		}
		return res;
	}

	private String toString(int number, int range) {
		// convert every 8 into an integer
		final int WORD_SIZE = 8;
		StringBuilder sb = new StringBuilder();
		for (int i = 3; i >= 0; --i) {
			sb.append(Integer.toString(((number >> (i * WORD_SIZE)) & 255)));
			sb.append(".");
		}
		sb.setLength(sb.length() - 1);
		sb.append("/");
		sb.append(Integer.toString(range));
		return sb.toString();
	}

	private int toInt(String ip) {
		String[] sep = ip.split("\\.");
		int sum = 0;
		for (int i = 0; i < sep.length; ++i) {
			sum = sum*256 + Integer.parseInt(sep[i]);
		}
		return sum;
	}

	public static void main(String[] args) {
		IPtoCIDR obj = new IPtoCIDR();
		List<String> res = null;
		res = obj.ipToCIDR("255.0.0.10", 3);
		System.out.println(res);

	}

}
