package com.raj.leetcode.google;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author Raj
 * 
 * 
There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 
 

Note:

1 <= K <= N <= 10000, where N = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10^-5 of the correct answer will be considered correct.

 */
public class MinimumcostToHireKWorkers {

	/*
	 * quality is more of quantity than what it says
	 * 
	 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/141768/Detailed-explanation-O(NlogN)
	 * 
	 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/142108/Java-PriorityQueue-With-Clear-Explanation-O(n-logn)
	 */
	// Time : O(nlogn), Space : O(n)
	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
		// calculate rate and save how much min quantity they want to work
		class Node {
			// rate per one quantity of unit
			double rate;
			int quantiy;

			public Node(double rate, int quantiy) {
				this.rate = rate;
				this.quantiy = quantiy;
			}

		}
		Node[] t = new Node[quality.length];
		for (int i = 0; i < quality.length; i++) {
			t[i] = new Node((1.0* wage[i]) / quality[i], quality[i]);
		}
		Arrays.sort(t, (n1, n2) -> Double.compare(n1.rate, n2.rate));
		double res = Integer.MAX_VALUE;
		int quantity = 0;
		// max heap since we need min cost
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
		/*
		 * If p1 does need q1 work at the rate of r1, p2 does q2 work at the rate of r2 and p3 does q3 work at the rate of r3.
Choosing min cost to hire 3 workers = max(r1,r2,r3)*(q1+q2+q3)
Because, to get minimum wage they need to atleast q1/q2/q3 work at rate of them or higher than that.

Choosing min cost to hire 2 workers = minimum of { max(r1,r2)*(q1+q2), max(r2,r3)*(q2+q3), max(r1,r3)*(q1+q3)}

Instead, sort them by rate 
(q1,r1)(q2,r2)(q3,r3)
Consider the rate from Kth position, because it's Kth highest. Then, get the quantities of first 'K' workers to get cost. 
From K+1 the element, pop the highest quantity.

		 */
		for (int i = 0; i < t.length; i++) {
			pq.offer(t[i].quantiy);
			quantity += t[i].quantiy;
			if (pq.size()>=K) {
				res = Math.min(res, quantity*t[i].rate);
				quantity -= pq.poll();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MinimumcostToHireKWorkers obj = new MinimumcostToHireKWorkers();
		double result = -1;
		int[] quality = { 10, 20, 5 }, wage = { 70, 50, 30 };
		int K = 2;
		result = obj.mincostToHireWorkers(quality, wage, K);
		System.out.println(result);

		int[] quality2 = { 3, 1, 10, 10, 1 }, wage2 = { 4, 8, 2, 2, 7 };
		int K2 = 3;
		result = obj.mincostToHireWorkers(quality2, wage2, K2);
		System.out.println(result);

	}

}
