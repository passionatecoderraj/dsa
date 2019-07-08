package com.raj.leetcode;

import com.interview.graph.CommonUtil;

/**
 * 
 * @author Raj
 * 
 * There are G people in a gang, and a list of various crimes they could commit.

The i-th crime generates a profit[i] and requires group[i] gang members to participate.

If a gang member participates in one crime, that member can't participate in another crime.

Let's call a profitable scheme any subset of these crimes that generates at least P profit, and the total number of gang members participating in that subset of crimes is at most G.

How many schemes can be chosen?  Since the answer may be very large, return it modulo 10^9 + 7.

 

Example 1:

Input: G = 5, P = 3, group = [2,2], profit = [2,3]
Output: 2
Explanation: 
To make a profit of at least 3, the gang could either commit crimes 0 and 1, or just crime 1.
In total, there are 2 schemes.
Example 2:

Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
Output: 7
Explanation: 
To make a profit of at least 5, the gang could commit any crimes, as long as they commit one.
There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
 

Note:

1 <= G <= 100
0 <= P <= 100
1 <= group[i] <= 100
0 <= profit[i] <= 100
1 <= group.length = profit.length <= 100
 
 */
public class ProfitableSchemes {

	/*
	 * https://leetcode.com/problems/profitable-schemes/discuss/154617/C++JavaPython-DP
	 * 
	 * dp[i][j] means the count of schemes with i profit and j members
	 */
	// Time : O( G * P * N), Space : O (P*G)
	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
		int t[][] = new int[P + 1][G + 1];
		int mod = (int) 1e9 + 7;
		t[0][0] = 1;
		for (int k = 0; k < profit.length; k++) {
			int p = profit[k], g = group[k];
			for (int i = P; i >= 0; i--) {
				for (int j = G; j >= g; j--) {
					/*
					 * No. of ways to make profit for j-g gang members 
					 */
					t[i][j] = (t[i][j] + t[Math.max(0, i - p)][j - g]) % mod;
				}CommonUtil.print2DArray(t, P+1, G+1);System.out.println();
			}
		}
		
		int res = 0;
		for (int n : t[P]) {
			res = (res + n) % mod;
		}
		return res;
	}

	public static void main(String[] args) {
		ProfitableSchemes obj = new ProfitableSchemes();

		int result = -1;
		result = obj.profitableSchemes(5, 3, new int[] { 2, 2 }, new int[] { 2, 3 });
		System.out.println(result);
		result = obj.profitableSchemes(10, 5, new int[] { 2, 3, 5 }, new int[] { 6, 7, 8 });
		System.out.println(result);
	}

}
