package com.raj.dp;

/**
 * @author Raj
 *
 *         Given an integer array with all positive numbers and no duplicates,
 *         find the number of possible combinations that add up to a positive
 *         integer target.
 * 
 *         Example:
 * 
 *         nums = [1, 2, 3] target = 4
 * 
 *         The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1)
 *         (1, 3) (2, 1, 1) (2, 2) (3, 1)
 * 
 *         Note that different sequences are counted as different combinations.
 * 
 *         Therefore the output is 7.
 */
public class CombinationSum4 {

	// same as, number of ways to make sum with given coins with little
	// variation
	// Time :O(sum*n), Space :O(sum)
	public int combinationsSum4UsingDp(int a[], int sum) {
		if (null == a)
			return 0;
		int t[] = new int[sum + 1];
		t[0] = 1;
		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i >= a[j]) {
					t[i] += t[i - a[j]];
				}
			}
		}
		return t[sum];
	}

	public int combinationsSum4UsingRecursion(int[] a, int sum) {
		if (0 == sum)
			return 1;
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			if (sum - a[i] < 0)
				return res;
			res += combinationsSum4UsingRecursion(a, sum - a[i]);
		}
		return res;
	}

	public int combinationsSum4UsingRecursionMethod2(int[] a, int sum) {
		int count[] = new int[1];
		combinationsSum4Util(a, sum, count);
		return count[0];
	}

	public void combinationsSum4Util(int a[], int sum, int count[]) {
		if (0 == sum) {
			count[0]++;
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (sum - a[i] < 0)
				return;
			combinationsSum4Util(a, sum - a[i], count);
		}
	}

	public static void main(String args[]) {
		CombinationSum4 obj = new CombinationSum4();
		int a[] = { 1, 2, 3 };
		int res = obj.combinationsSum4UsingRecursion(a, 4);
		System.out.println(res);

		res = obj.combinationsSum4UsingDp(a, 4);
		System.out.println(res);
	}

}