/**
 * 
 */
package com.raj.leetcode;

/**
 * @author Raj
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Note:
N is a positive integer and will not exceed 15.
 */
public class BeautifulArrangement {

	// Time : O(k), k = no. of permutations, Space : O(N)
	// https://leetcode.com/problems/beautiful-arrangement/discuss/99707/Java-Solution-Backtracking
	// https://leetcode.com/problems/beautiful-arrangement/solution/
	public int countArrangement2(int N) {
		return util(1, N, new boolean[N + 1]);
	}

	private int util(int pos, int N, boolean[] visited) {
		if (pos == visited.length) {
			return 1;
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
				visited[i] = true;
				count += util(pos + 1, N, visited);
				visited[i] = false;
			}
		}

		return count;
	}

	// Time : O(k), k = no. of permutations, Space : O(N)
	public int countArrangement(int N) {
		int t[] = new int[N + 1];
		for (int i = 1; i <= N; i++)
			t[i] = i;
		return util(1, N, t);
	}

	private int util(int pos, int N, int[] t) {
		if (pos == t.length) {
			return 1;
		}
		int count = 0;
		for (int i = pos; i <= N; i++) {
			swap(t, pos, i);
			if (t[pos] % pos == 0 || pos % t[pos] == 0) {
				count += util(pos + 1, N, t);
			}
			swap(t, pos, i);
		}
		return count;
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		BeautifulArrangement obj = new BeautifulArrangement();

		int res = -1;
		res = obj.countArrangement(4);
		System.out.println(res);
	}
}
