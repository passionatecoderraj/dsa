/**
 * 
 */
package com.raj.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Raj
 *
 */
public class MaxOfAllSubarraysOfSizeK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxOfAllSubarraysOfSizeK obj = new MaxOfAllSubarraysOfSizeK();
		int a[] = { 12, 1, 78, 90, 57, 89, 56 };
		int n = a.length, k = 3;

		obj.maxOfAllSubarraysOfSizeK(a, n, k);
	}

	public void maxOfAllSubarraysOfSizeK(int[] a, int n, int k) {
		if (k > n || n <= 0)
			return;
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int i;
		for (i = 0; i < k; i++) {
			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}

		for (; i < n; i++) {
			System.out.print(a[dq.peekFirst()] + " ");

			while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.print(a[dq.peekFirst()] + " ");
		System.out.println();
	}

}
