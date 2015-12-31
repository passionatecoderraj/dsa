/**
 * 
 */
package com.raj.arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Raj
 *
 */
public class NextGreaterElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NextGreaterElement obj = new NextGreaterElement();
		int a[] = { 4, 15, 2, 9, 20, 11, 13 };
		int n = a.length;

		// Time : O(n2), Space : O(1)
		obj.nextGreaterElementBruteForce(a, n);
		// Time : O(n), Space : O(n)
		obj.nextGreaterElementUsingStack(a, n);

	}

	public void nextGreaterElementUsingStack(int[] a, int n) {
		if (n <= 0)
			return;
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(a[0]);

		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && a[i] > stack.peek()) {
				System.out.println("NGE for " + stack.pop() + " is :" + a[i]);
			}
			stack.push(a[i]);
		}
		while (!stack.isEmpty()) {
			System.out.println("NGE for " + stack.pop() + " is : null");
		}
	}

	public void nextGreaterElementBruteForce(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			boolean isFound = false;
			for (int j = i + 1; j < n && !isFound; j++) {
				if (a[j] > a[i]) {
					System.out.println("NGE for " + a[i] + " is :" + a[j]);
					isFound = true;
				}
			}
			if (!isFound) {
				System.out.println("NGE for " + a[i] + " is : null");
			}
		}
	}

}
