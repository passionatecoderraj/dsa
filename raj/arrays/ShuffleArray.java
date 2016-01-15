/**
 * 
 */
package com.raj.arrays;

import com.interivew.graph.CommonUtil;

/**
 * @author Raj
 *
 */
public class ShuffleArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShuffleArray obj = new ShuffleArray();
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = a.length;
		// Time :O(n)
		// Fisher-Yates Shuffle Modern Algorithm
		CommonUtil.printArray(a);
		obj.shuffle(a, n);
		CommonUtil.printArray(a);

	}

	public void shuffle(int[] a, int n) {
		int rand, curSize = n;
		for (int i = n - 1; i > 0; i--) {
			// instead of curSize you can use (i+1) for optimized logic
			rand = (int) (Math.random() * curSize);
			curSize--;
			CommonUtil.swap(a, rand, i);
		}
	}

}
