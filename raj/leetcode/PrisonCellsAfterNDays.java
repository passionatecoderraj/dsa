/**
 * 
 */
package com.raj.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;;

/**
 * @author Raj
 *
 *There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

 

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
 

Note:

cells.length == 8
cells[i] is in {0, 1}
1 <= N <= 10^9
 */

public class PrisonCellsAfterNDays {

	/*
	 * 1> The transformations form a cycle. 
	 * 2>The original array that is passed in, is not a part of that cycle.
	 * 
	 * https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14
	 * https://leetcode.com/problems/prison-cells-after-n-days/discuss/266854/Java:-easy-to-understand
	 * 
	 */
	public int[] prisonAfterNDays(int[] cells, int N) {
		/*
		 * count = number of steps to repeat same pattern
		 * 
		 */
		int count = 0;
		boolean hasCycle = false;
		int[] next;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			next = next(cells);
			if (!set.add(Arrays.toString(next))) {
				hasCycle = true;
				break;
			}
			cells = next;
			count++;
		}
		if (hasCycle) {
			N %= count;
			while (N-- > 0) {
				cells = next(cells);
			}
		}
		return cells;
	}

	// Brute force but will fail due to TLE
	public int[] prisonAfterNDays3(int[] cells, int N) {
		int next[] = cells;
		while (N-- > 0) {
			next = next(next);
		}
		return next;
	}

	private int[] next(int a[]) {
		int res[] = new int[a.length];
		for (int i = 1; i < a.length - 1; i++) {
			res[i] = a[i - 1] == a[i + 1] ? 1 : 0;
		}
		return res;
	}

	public static void main(String[] args) {
		PrisonCellsAfterNDays obj = new PrisonCellsAfterNDays();

		int[] res = null;
		int a[] = { 0, 1, 0, 1, 1, 0, 0, 1 };
		int N = 7;
		res = obj.prisonAfterNDays(a, 23);
		System.out.println(Arrays.toString(res));

		int b[] = { 1, 0, 0, 1, 0, 0, 1, 0 };
		N = 1000000000;
		res = obj.prisonAfterNDays(b, N);
		System.out.println(Arrays.toString(res));

	}

}
