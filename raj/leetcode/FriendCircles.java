/**
 * 
 */
package com.raj.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.raj.graph.DisjointSet;

/**
 * @author Raj
 *
 *There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircles {

	// Time : O(n2), Space : O(n)
	// using DFS
	public int findCircleNum(int[][] a) {
		boolean[] visited = new boolean[a.length];
		int circles = 0;
		for (int me = 0; me < a.length; me++) {
			if (!visited[me]) {
				dfs(me, a, visited);
				circles++;
			}
		}
		return circles;
	}

	private void dfs(int me, int[][] a, boolean[] visited) {
		for (int friend = 0; friend < a.length; friend++) {
			if (a[me][friend] == 1 && !visited[friend]) {
				visited[friend] = true;
				dfs(friend, a, visited);
			}
		}

	}

	// Time : O(n2), Space : O(n)
	// using BFS
	public int findCircleNum2(int[][] a) {
		boolean[] visited = new boolean[a.length];
		int circles = 0;
		Queue<Integer> q = new LinkedList<>();

		for (int me = 0; me < a.length; me++) {
			if (!visited[me]) {
				q.offer(me);
				circles++;
				while (!q.isEmpty()) {
					int node = q.poll();
					visited[node] = true;
					for (int friend = 0; friend < a.length; friend++) {
						if (a[node][friend] == 1 && !visited[friend]) {
							q.offer(friend);
						}
					}
				}
			}
		}
		return circles;
	}

	// Time : O(n2logN), Space : O(n)
	// using Union-Find
	public int findCircleNum3(int[][] a) {
		DisjointSet ds = new DisjointSet();

		for (int i = 0; i < a.length; i++)
			ds.makeSet(i);

		int circles = a.length;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i][j] == 1) {
					long p1 = ds.findSet(i);
					long p2 = ds.findSet(j);
					if (p1 != p2) {
						ds.union(p1, p2);
						circles--;
					}
				}
			}
		}
		return circles;
	}

	public static void main(String[] args) {
		FriendCircles obj = new FriendCircles();
		int result = -1;

		int a[][] = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		result = obj.findCircleNum(a);
		System.out.println(result);

		int[][] b = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		result = obj.findCircleNum(b);
		System.out.println(result);

	}

}
