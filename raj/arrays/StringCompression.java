/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringCompression obj = new StringCompression();
		String result = null;
		String str = "aaacccbbde";

		result = obj.compressString(str);
		System.out.println(result);

	}

	private String compressString(String str) {
		if (str == null || str.length() <= 1)
			return str;

		StringBuffer sb = new StringBuffer();
		int n = str.length();
		char cur = 0, pre = str.charAt(0);
		int count = 1;
		for (int i = 1; i < n; i++) {
			cur = str.charAt(i);
			if (cur == pre) {
				count++;
			} else {
				sb.append(pre);
				if (count > 1)
					sb.append(count);
				pre = cur;
				count = 1;
			}
		}
		sb.append(pre);
		if (count > 1)
			sb.append(count);

		return sb.toString();
	}

}
