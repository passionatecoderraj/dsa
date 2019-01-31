package com.raj.leetcode;

import java.util.Random;

/**
 * 
 * @author Raj
 * 
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.


 */
public class RandomPickWithWeight {

	/*
	 * if array is {2,5,3} -> it means A : {0,0,1,1,1,1,1,2,2,2} -> gives random number
	 * Other way to look is with prefix array : for {2,5,3} -> P {2,7,10} 
	 * 
	 * {2,7,10}->it means 
	 * 	(0) is repeated until 2(excluding 2), 
	 *  (1) is repeated until 7(excluding 7) 
	 *  (2) is repeated until 10(excluding 10)
	 * 
	 * so, whenever pick() is called, we generate random number with last number of prefix number(nothing but size of generated A)
	 * 
	 *  Now, we search for insert position of this random number with above rules
	 * 
	 */
	Random random;
	int prefixArr[];
	int lastIndex;

	// Time : O(n), Space : O(n)
	public RandomPickWithWeight(int[] a) {
		random = new Random();
		prefixArr = new int[a.length];
		if (a.length > 0) {
			prefixArr[0] = a[0];
			for (int i = 1; i < a.length; i++) {
				prefixArr[i] = prefixArr[i - 1] + a[i];
			}
			lastIndex = prefixArr[prefixArr.length - 1];
		}
	}

	// Time : O(logn)
	public int pickIndex() {
		if (prefixArr.length <= 0)
			return -1;

		int key = random.nextInt(lastIndex);
		
		int l = 0, r = prefixArr.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (key < prefixArr[m] && (m == 0 || key >= prefixArr[m - 1])) {
				return m;
			}
			if (prefixArr[m] <= key) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;

	}

	public static void main(String... args) {
		RandomPickWithWeight obj = new RandomPickWithWeight(new int[] { 2, 5, 3, 4 });
		System.out.println(obj.pickIndex());
		System.out.println(obj.pickIndex());
	}
}