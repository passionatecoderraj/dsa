package com.raj.leetcode.google;

import java.util.Arrays;

/**
 * 
 * @author Raj
 * 
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
 *
 */
public class Candy {

	// https://leetcode.com/problems/candy/discuss/42770/One-pass-constant-space-Java-solution
	// Time : O(n), Space : O(1)
	public int candy(int[] a) {
		int countDown = 0, result = 1, prev = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] >= a[i - 1]) {
				if (countDown > 0) {
					result += countDown * (countDown + 1) / 2;
					if (countDown >= prev)
						result += (countDown - prev + 1);
					countDown = 0;
					prev = 1;
				}
				prev = a[i] > a[i - 1] ? prev + 1 : 1;
				result += prev;
			} else {
				countDown++;
			}
		}
		if (countDown > 0) {
			result += countDown * (countDown + 1) / 2;
			if (countDown >= prev)
				result += (countDown - prev + 1);
		}
		return result;
	}

	// https://leetcode.com/problems/candy/discuss/42774/Very-Simple-Java-Solution-with-detail-explanation
	// Time : O(n), Space : O(n)
	public int candy2(int[] a) {
		int[] t = new int[a.length];
		Arrays.fill(t, 1);
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				t[i] = t[i - 1] + 1;
			}
		}
		int sum = t[a.length - 1];

		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i] > a[i + 1]) {
				if (t[i] < 1 + t[i + 1]) {
					t[i] = 1 + t[i + 1];
				}
			}
			sum += t[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		Candy obj = new Candy();
		int[] a = { 1, 2, 2 };
		int result = 0;
		result = obj.candy(a);
		System.out.println(result);

		int b[] = { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 };
		result = obj.candy(b);
		System.out.println(result);

		int c[] = { 1, 2, 87, 87, 87, 2, 1 };
		result = obj.candy(c);
		System.out.println(result);

	}

}
