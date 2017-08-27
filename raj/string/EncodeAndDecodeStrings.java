/**
 * 
 */
package com.raj.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raj
 *
 *         Design an algorithm to encode a list of strings to a string. The
 *         encoded string is then sent over the network and is decoded back to
 *         the original list of strings.
 * 
 *         Machine 1 (sender) has the function:
 * 
 *         string encode(vector<string> strs) {
 * 
 *         // ... your code return encoded_string;
 * 
 *         }
 * 
 *         Machine 2 (receiver) has the function:
 * 
 *         vector <string> decode(string s) {
 * 
 *         //... your code return strs;
 * 
 *         }
 * 
 *         So Machine 1 does:
 * 
 *         string encoded_string = encode(strs);
 * 
 *         and Machine 2 does:
 * 
 *         vector<string> strs2 = decode(encoded_string);
 * 
 *         strs2 in Machine 2 should be the same as strs in Machine 1.
 * 
 *         Implement the encode and decode methods.
 * 
 *         Note: The string may contain any possible characters out of 256 valid
 *         ascii characters. Your algorithm should be generalized enough to work
 *         on any possible characters. Do not use class member/global/static
 *         variables to store states. Your encode and decode algorithms should
 *         be stateless. Do not rely on any library method such as eval or
 *         serialize methods. You should implement your own encode/decode
 *         algorithm..
 */
public class EncodeAndDecodeStrings {

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String st : strs) {
			// leetcode OJ is not handling nulls, so we don't have to add this condition
			sb.append(null == st ? 0 : st.length());
			sb.append("#");
			sb.append(st);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int len = ch - '0';
				i++;
				while (Character.isDigit(s.charAt(i))) {
					len = (len * 10) + s.charAt(i++) - '0';
				}
				i++; // '#' found
				res.add(s.substring(i, i + len));
				i = i + len;
			}
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EncodeAndDecodeStrings obj = new EncodeAndDecodeStrings();
		String result = null;
		List<String> res = null;
		List<String> a = new ArrayList<>();
		a.add("prithvi");
		a.add("raj");
		a.add("kumar");
		a.add("dasari");
		a.add("");

		result = obj.encode(a);
		System.out.println(result);

		res = obj.decode(result);
		System.out.println(res);

	}

}
