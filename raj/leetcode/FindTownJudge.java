package com.raj.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Raj
 * 
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
 * 
 */
public class FindTownJudge {

	// Time : O(N+a.length), Space : O(N)
	public int findJudge(int N, int[][] a) {
		int degree[] = new int[N + 1];
		for (int t[] : a) {
			degree[t[0]]--;
			degree[t[1]]++;
		}
		// Since town judge trusts nobody, can we say that the point who has no
		// out-degree and in-degree == N - 1 is the judge?
		for (int i = 1; i <= N; i++) {
			if (degree[i] == N - 1)
				return i;
		}
		return -1;
	}
	
	// similar to find celebrity
	public int findJudge2(int N, int[][] a) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] t : a) {
			map.compute(t[0], (k, v) -> {
				if (null == v)
					v = new HashSet<>();
				v.add(t[1]);
				return v;
			});
		}
		int l = 1, r = N;
		while (l < r) {
			if (trusts(map, l, r)) {
				l++;
			} else {
				r--;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (i == l)
				continue;
			if (!trusts(map, i, l) || trusts(map, l, i)) {
				return -1;
			}
		}
		return l;
	}

	private boolean trusts(Map<Integer, Set<Integer>> map, int l, int r) {
		return map.containsKey(l) && map.get(l).contains(r);
	}

	public static void main(String[] args) {
		FindTownJudge obj = new FindTownJudge();
		int[][] a = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		int N = 4;
		int res = -1;
		res = obj.findJudge(N, a);

		System.out.println(res);

		int[][] b = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
		int N1 = 3;
		res = obj.findJudge(N1, b);
		System.out.println(res);

	}

}
