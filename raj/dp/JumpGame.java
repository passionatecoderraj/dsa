/**
 * 
 */
package com.raj.dp;

/**
 * @author Raj
 *
 */

public class JumpGame {

	public boolean canJump(int[] a) {
		int lastPos = a.length - 1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (i + a[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

		boolean result = false;
		JumpGame obj = new JumpGame();
		result = obj.canJump(a);
		System.out.println(result);
		int b[] = { 3, 2, 1, 0, 4 };
		result = obj.canJump(b);
		System.out.println(result);

	}

}
