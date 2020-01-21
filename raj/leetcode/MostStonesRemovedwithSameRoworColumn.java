/**
 * 
 */
package com.raj.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 * 
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0
 

Note:

1 <= stones.length <= 1000
0 <= stones[i][j] < 10000
 * 
 */
class UnionFind {

	Map<String, String> map = new HashMap<>();
	int size = 0;

	void make(String key) {
		map.put(key, key);
		size++;
	}

	String find(String key) {
		if (!map.get(key).equals(key)) {
			map.put(key, find(map.get(key)));
		}
		return map.get(key);
	}

	void union(String key1, String key2) {
		String p1 = find(key1), p2 = find(key2);
		if (!p1.equals(p2)) {
			map.put(p1, p2);
			size--;
		}
	}
}

public class MostStonesRemovedwithSameRoworColumn {

	// Time : O(n2), Space : O(n)
	public int removeStones(int[][] stones) {
		UnionFind uf = new UnionFind();
		for (int[] stone : stones) {
			uf.make(stone[0] + " " + stone[1]);
		}
		for (int i = 0; i < stones.length; i++) {
			String k1 = uf.find(stones[i][0] + " " + stones[i][1]);
			for (int j = i + 1; j < stones.length; j++) {
				if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
					String k2 = uf.find(stones[j][0] + " " + stones[j][1]);
					uf.union(k1, k2);
				}
			}
		}
		return stones.length - uf.size;
	}

	public static void main(String[] args) {
		MostStonesRemovedwithSameRoworColumn obj = new MostStonesRemovedwithSameRoworColumn();
		int result = -1;
		int a[][] = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };

		// Time :O(rows*cols), Space : O(rows*cols)
		result = obj.removeStones(a);
		System.out.println(result);

		result = obj.removeStones(new int[][] { { 0, 0 }, { 0, 2 }, { 1, 1 }, { 2, 0 }, { 2, 2 } });
		System.out.println(result);
	}
}
