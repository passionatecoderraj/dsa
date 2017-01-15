/**
 * 
 */
package com.raj.arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Raj
 *
 */
public class FindThirdMax {

	// Time : O(n), Space : O(1)
	public static int thirdMax(int a[]) {
		if (null == a || a.length == 0)
			return -1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			if (!set.contains(i)) {
				pq.offer(i);
				set.add(i);
				if (pq.size() > 3) {
					set.remove(pq.poll());
				}
			}
		}
		if (pq.size() < 3) {
			while (pq.size() > 1)
				pq.poll();
		}
		return pq.peek();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 12, 13, 1, 10, 34, 1 };
		int n = a.length;
		FindThirdMax obj = new FindThirdMax();
		// Time : O(nlogn) but two traversals

	}

}
