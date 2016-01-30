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
/*
 * Suppose there is a circle. There are n petrol pumps on that circle. You are
 * given two sets of data. 1. The amount of petrol that every petrol pump has.
 * 2. Distance from that petrol pump to the next petrol pump. Calculate the
 * first point from where a truck will be able to complete the circle (The truck
 * will stop at each petrol pump and it has infinite capacity).
 */
public class PetrolPump {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PetrolPump obj = new PetrolPump();
		int result = -1;
		int a[][] = { { 4, 6 }, { 6, 5 }, { 7, 3 }, { 4, 5 } };
		int n = a.length;
		// Time : O(n), Space : O(n)
		result = obj.indexToStartForPetrolPumpUsingQueue(a, n);
		System.out.println(result);

	}

	public int indexToStartForPetrolPumpUsingQueue(int[][] a, int n) {

		Deque<Integer> q = new ArrayDeque<Integer>();
		int cur_petrol = a[0][0] - a[0][1];
		q.addLast(0);
		int start = 0, end = 1;
		while (start != end || cur_petrol < 0) {
			while (start != end && cur_petrol < 0) {
				cur_petrol -= (a[start][0] - a[start][1]);
				start = (start + 1) % n;
				if (start == 0)
					return -1;
			}
			cur_petrol += (a[end][0] - a[end][1]);
			end = (end + 1) % n;

		}
		return start;
	}

}
