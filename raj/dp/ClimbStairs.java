package com.raj.dp;

/**
 * 
 * @author Raj You are climbing a stair case. It takes n steps to reach to the
 *         top.
 * 
 *         Each time you can either climb 1 or 2 steps. In how many distinct
 *         ways can you climb to the top?
 * 
 *         Note: Given n will be a positive integer.
 * 
 * 
 *         Example 1:
 * 
 *         Input: 2 Output: 2 Explanation: There are two ways to climb to the
 *         top.
 * 
 *         1. 1 step + 1 step 2. 2 steps Example 2:
 * 
 *         Input: 3 Output: 3 Explanation: There are three ways to climb to the
 *         top.
 * 
 *         1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 */
public class ClimbStairs {

	// Time :O(n), Space:O(1)
	public int climbStairs(int n) {
		int a = 1, b = 2, c;
		for (int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return n < 3 ? n : b;
	}

	public int waysToReachNthStepWithMaxTwoSteps(int n) {
		int t[] = new int[n];
		// 1 way to reach step '1'(power of 2)
		t[0] = 1;
		// 2 way to reach step '2' - (1,1) (2)(power of 2)
		t[1] = 2;

		for (int i = 2; i < n; i++) {
			t[i] = t[i - 1] + t[i - 2];
		}

		return t[n - 1];
	}

	public int waysToReachNthStepWithMaxNSteps(int n, int maxSteps) {
		if (n < maxSteps) {
			return -1;
		}
		int t[] = new int[n];

		for (int i = 0; i < maxSteps; i++) {
			t[i] = (int) Math.pow(2, i);
		}

		for (int i = maxSteps; i < n; i++) {
			t[i] = 0;
			for (int j = 1; j <= maxSteps; j++) {
				t[i] += t[i - j];
			}
		}
		return t[n - 1];
	}

	public int waysToReachNthStepWithMaxThreeSteps(int n) {
		int t[] = new int[n];
		// 1 way to reach step '1' (power of 2)
		t[0] = 1;
		// 2 way to reach step '2' - (1,1) (2)(power of 2)
		t[1] = 2;
		// 3 way to reach step '3' - (1,1,1) (2,1) (1,2) (3)(power of 2)
		t[2] = 4;

		for (int i = 3; i < n; i++) {
			t[i] = t[i - 1] + t[i - 2] + t[i - 3];
		}

		return t[n - 1];
	}

	public static void main(String[] args) {
		ClimbStairs obj = new ClimbStairs();
		int result = -1;
		result = obj.waysToReachNthStepWithMaxTwoSteps(4);
		System.out.println(result);
		result = obj.waysToReachNthStepWithMaxThreeSteps(4);
		System.out.println(result);

		int maxSteps = 4;
		result = obj.waysToReachNthStepWithMaxNSteps(4, maxSteps);
		System.out.println(result);

		result = obj.climbStairs(4);
		System.out.println(result);

	}

}
