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

		MaxOfAllSubarraysOfSizeK obj = new MaxOfAllSubarraysOfSizeK();
		int a[] = { 12, 1, 78, 90, 57, 89, 56 };
		int n = a.length, k = 3;
		// Time : O(n), Space : O(k)
		obj.maxOfAllSubarraysOfSizeK(a, n, k);
	}

	public void maxOfAllSubarraysOfSizeK(int a[], int n, int k) {

		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		for (int i = k; i < n; i++) {
			System.out.print(a[dq.peekFirst()] + " ");
			while (!dq.isEmpty() && i - dq.peekFirst() >= k) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && a[i] >= a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.println(a[dq.peekFirst()] + " ");

	}
}
