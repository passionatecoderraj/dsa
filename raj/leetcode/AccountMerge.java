/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj Suppose you have N integers from 1 to N. We define a beautiful
 *         arrangement as an array that is constructed by these N numbers
 *         successfully if one of the following is true for the ith position (1
 *         <= i <= N) in this array:
 * 
 *         The number at the ith position is divisible by i. i is divisible by
 *         the number at the ith position. Now given N, how many beautiful
 *         arrangements can you construct?
 * 
 *         Example 1: Input: 2 Output: 2 Explanation:
 * 
 *         The first beautiful arrangement is [1, 2]:
 * 
 *         Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * 
 *         Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * 
 *         The second beautiful arrangement is [2, 1]:
 * 
 *         Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * 
 *         Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 *         Note: N is a positive integer and will not exceed 15.
 */
public class AccountMerge {

	// https://leetcode.com/problems/accounts-merge/solution/
	// https://leetcode.com/problems/accounts-merge/discuss/109158/Java-Solution-(Build-graph-+-DFS-search)

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, List<String>> edges = new HashMap<>();
		Map<String, String> email_to_name_map = new HashMap<>();
		for (List<String> acc : accounts) {
			String uname = acc.get(0);
			for (int i = 1; i < acc.size(); i++) {
				// insert in email to name map
				email_to_name_map.put(acc.get(i), uname);
				if (1 == i)
					continue;

				String email = acc.get(i);
				/*
				 * each account is a small graph of adj nodes so, create adj list from first
				 * node to everything else
				 */
				edges.compute(acc.get(1), (k, v) -> {
					if (null == v)
						v = new ArrayList<>();
					v.add(email);
					return v;
				});

				edges.compute(email, (k, v) -> {
					if (null == v)
						v = new ArrayList<>();
					v.add(acc.get(1));
					return v;
				});
			}
		}
		Set<String> visited = new HashSet<>();
		List<List<String>> res = new ArrayList<>();

		for (String email : email_to_name_map.keySet()) {
			if (!visited.contains(email)) {
				List<String> cur = new ArrayList<>();
				cur.add(email);
				visited.add(email);
				dfs(email, edges, visited, cur);
				Collections.sort(cur);
				cur.add(0, email_to_name_map.get(email));
				res.add(cur);
			}
		}

		return res;
	}

	private void dfs(String email, Map<String, List<String>> edges, Set<String> visited, List<String> cur) {
		if (edges.containsKey(email)) {
			for (String adj : edges.get(email)) {
				if (!visited.contains(adj)) {
					cur.add(adj);
					visited.add(adj);
					dfs(adj, edges, visited, cur);
				}
			}
		}

	}

	public static void main(String[] args) {
		AccountMerge obj = new AccountMerge();

		List<List<String>> res = null;
		List<List<String>> accounts = new ArrayList<>();
		accounts.add(Arrays.asList(new String[] { "John", "johnsmith@mail.com", "john00@mail.com" }));
		accounts.add(Arrays.asList(new String[] { "John", "johnnybravo@mail.com" }));
		accounts.add(Arrays.asList(new String[] { "John", "johnsmith@mail.com", "john_newyork@mail.com" }));
		accounts.add(Arrays.asList(new String[] { "Mary", "mary@mail.com" }));
		res = obj.accountsMerge(accounts);
		System.out.println(res);

	}
}
