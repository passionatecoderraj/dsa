/**
 * 
 */
package com.raj.string;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class FindFirstNonRepeatingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFirstNonRepeatingCharacter obj = new FindFirstNonRepeatingCharacter();

		String str = "geeksforgeeks";
		char result;

		// Time : O(n)
		result = obj.findFirstNonRepeatingCharacter(str.toCharArray(), str.length());
		System.out.println(result);

	}

	public char findFirstNonRepeatingCharacter(char[] a, int n) {
		int count[] = new int[256];
		for (int i = 0; i < n; i++) {
			count[a[i]]++;
		}

		CommonUtil.printArray(count);
		for (int i = 0; i < 256; i++) {
			if (count[i] == 1)
				return (char) i;
		}

		return 0;
	}

}
