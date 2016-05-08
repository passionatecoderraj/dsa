/**
 * 
 */
package com.raj.bit;

/**
 * @author Raj
 *
 */

/*
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 */

/*
 * http://www.geeksforgeeks.org/find-the-element-that-appears-once/
 * https://www.careercup.com/question?id=15066700
 * 
 */
public class FindNumberOccuringOnceOtherOccuringThreeTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindNumberOccuringOnceOtherOccuringThreeTimes obj = new FindNumberOccuringOnceOtherOccuringThreeTimes();
		int result = -1;
		int a[] = { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3 };

		// Time :O(n), Time :O(1)
		result = obj.singleNumber(a, a.length);
		System.out.println(result);

		// Time :O(n), Time :O(1)
		result = obj.singleNumberByCounting1sAtEachDigit(a, a.length);
		System.out.println(result);

	}

	public int singleNumberByCounting1sAtEachDigit(int[] a, int n) {
		int sum, x, k, result = 0;
		for (int i = 0; i < 32; i++) {
			sum = 0;
			x = (1 << i);
			for (int j = 0; j < n; j++) {
				k = a[j] & x;
				if (k > 0) {
					sum++;
				}
			}
			if (sum % 3 != 0) {
				result |= x;
			}
		}
		return result;
	}

	public int singleNumber(int[] a, int n) {
		int ones = 0, twos = 0;
		int common_bit_mask;
		for (int i = 0; i < n; i++) {
			twos |= (ones & a[i]);
			ones ^= a[i];
			/*
			 * The common bits are those bits which appear third time So these
			 * bits should not be there in both 'ones' and 'twos'.
			 * common_bit_mask contains all these bits as 0, so that the bits
			 * can be removed from 'ones' and 'twos'
			 */
			common_bit_mask = ~(ones & twos);
			ones &= common_bit_mask;
			twos &= common_bit_mask;
		}
		return ones;
	}

}
