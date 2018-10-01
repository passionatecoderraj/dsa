package com.raj.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Raj
 * 
 A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 * 
 */
public class OptimalAccountBalancing {

	//https://leetcode.com/problems/optimal-account-balancing/discuss/95355/11-liner-9ms-DFS-solution-(detailed-explanation)
	public int minTransfers(int[][] transactions) {
		// Negative debt means the person will need to get money back
        // Positive debt means the person will need to give money
        
		Map<Integer, Integer> personToDebt = new HashMap<>();
		for (int[] t : transactions) {
			personToDebt.put(t[0], personToDebt.getOrDefault(t[0], 0) - t[2]);
			personToDebt.put(t[1], personToDebt.getOrDefault(t[1], 0) + t[2]);
		}
	
		return dfs(0, new ArrayList<>(personToDebt.values()));
	}

	private int dfs(int start, List<Integer> debts) {
		while (start < debts.size() && debts.get(start) == 0)
			start++;
		if (start == debts.size())
			return 0;
		int trans = Integer.MAX_VALUE;
		for (int i = start + 1; i < debts.size(); i++) {
			if (debts.get(start) * debts.get(i) < 0) {
				debts.set(i, debts.get(i) + debts.get(start));
				trans = Math.min(trans, 1 + dfs(start + 1, debts));
				debts.set(i, debts.get(i) - debts.get(start));
			}
		}
		return trans;
	}

	public static void main(String... args) {
		OptimalAccountBalancing obj = new OptimalAccountBalancing();
		int res = -1;

		int[][] transactions = { { 0, 1, 10 }, { 2, 0, 5 } };
		res = obj.minTransfers(transactions);
		System.out.println(res);

		int[][] transactions2 = { { 0, 1, 10 }, { 1, 0, 1 }, { 1, 2, 5 }, { 2, 0, 5 } };
		res = obj.minTransfers(transactions2);
		System.out.println(res);

	}
}