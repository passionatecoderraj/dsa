package com.raj.arrays;

/*
 * @Author Raj
 * All right numbers should be greater than current to be a leader
 * and right most number is always a leader.
 * 
 */
import com.interivew.graph.CommonUtil;

public class LeadersInArray {

	public static void main(String[] args) {
		int a[] = { 16, 17, 4, 3, 5, 2 };
		int n = a.length;
		LeadersInArray obj = new LeadersInArray();
		// Time : O(n2), Space: O(1)
		obj.leadersInArrayBruteForce(a, n);
		// Time : O(n), Space: O(1) ; traverse from reverse
		obj.leadersInArray(a, n);

	}

	public void leadersInArray(int[] a, int n) {
		if (n <= 0)
			return;

		int maxFromRight = a[n - 1];
		System.out.print(maxFromRight + " ");

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] > maxFromRight) {
				System.out.print(a[i] + " ");
				maxFromRight = a[i];
			}
		}
		System.out.println();
	}

	public void leadersInArrayBruteForce(int[] a, int n) {
		boolean isNotLeader;
		for (int i = 0; i < n; i++) {
			isNotLeader = false;
			for (int j = n - 1; j > i && !isNotLeader; j--) {
				if (a[i] > a[j]) {

				} else {
					isNotLeader = true;
				}
			}
			if (!isNotLeader) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.println();
	}

}
