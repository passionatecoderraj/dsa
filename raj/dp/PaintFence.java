package com.raj.dp;

/**
 * 
 * @author Raj
 *
 *         There is a fence with n posts, each post can be painted with one of
 *         the k colors. You have to paint all the posts such that no more than
 *         two adjacent fence posts have the same color. Return the total number
 *         of ways you can paint the fence.
 * 
 * 
 */
public class PaintFence {

	// Time : O(n), Space : O(n)
	public static int numWaytoPaintFence(int n, int k) {
		if (n == 0 || k == 0)
			return 0;
		if (n == 1)
			return k;

		// same[i] means the ith post has the same color with the (i-1)th post.
		int[] same = new int[n];

		// diff[i] means the ith post has a diff color with the (i-1)th post.
		int[] diff = new int[n];
		same[0] = same[1] = k;
		diff[0] = k;
		diff[1] = k * (k - 1);
		for (int i = 2; i < n; ++i) {
			// the i-th in same should be equal the previous one in diff since
			// only two consecutive same are allowed
			same[i] = diff[i - 1];
			// the i-th in diff should be either different from its previous one
			// or from the one before the previous one
			diff[i] = (k - 1) * same[i - 1] + (k - 1) * diff[i - 1];
		}
		return same[n - 1] + diff[n - 1];
	}

	// Time :O(n), Space : O(1)
	public static int numWaytoPaintFenceConstantSpace(int n, int k) {
		int a = k, b = k * k, c = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return a;
		if (n == 2)
			return b;
		for (int i = 2; i < n; i++) {
			c = (k - 1) * (a + b);
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) {
		int result = -1;
		result = numWaytoPaintFenceConstantSpace(2, 3);
		System.out.println(result);
		result = numWaytoPaintFence(2, 3);
		System.out.println(result);
	}

}
