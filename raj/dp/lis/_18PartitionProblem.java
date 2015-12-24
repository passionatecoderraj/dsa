/**
 * 
 */
package com.raj.dp.lis;

import com.raj.dp.ks._02SubsetSum;

/**
 * @author Raj
 *
 */
public class _18PartitionProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 3, 1, 1, 2, 2, 1 };

		boolean result = false;
		_18PartitionProblem obj = new _18PartitionProblem();
		result = obj.is2PartitionsPossible(a);
		System.out.println(result);
	}

	private boolean is2PartitionsPossible(int[] a) {
		int l = a.length;
		int sum = 0;
		for (int i = 0; i < l; i++) {
			sum += a[i];
		}
		if (sum % 2 != 0)
			return false;
		return new _02SubsetSum().isSubsetSumPresent(a, sum / 2);
	}

}
