/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 *         Fixed Point in an array is an index i such that arr[i] is equal to i.
 *         Note that integers in array can be negative.
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

		int count[] = new int[26];
		int index;
		for (int i = 0; i < n; i++) {
			index = Character.getNumericValue(a[i]) - 10;
			count[index]++;
		}

		CommonUtil.printArray(count);
		for (int i = 0; i < n; i++) {
			index = Character.getNumericValue(a[i]);
			if (count[i] == 1)
				return a[i];
		}

		return 0;
	}

}
