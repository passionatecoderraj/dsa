/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 * 
 */
public class FindFrequentCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFrequentCharacter obj = new FindFrequentCharacter();

		String str = "Connections";

		char result;
		// Time : O(n)
		result = obj.findFrequentCharacer(str.toCharArray(), str.length());
		System.out.println(result);
	}

	public char findFrequentCharacer(char[] a, int n) {
		int count[] = new int[256];
		for (int i = 0; i < n; i++) {
			count[a[i]]++;
		}
		int max = 0;
		char frequentChar = 0;

		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				max = count[i];
				frequentChar = (char) i;
			}
		}

		return frequentChar;
	}

}
