/**
 * 
 */
package com.raj.arrays;

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
		// Time : O(n), Space : O(1)
		result = obj.indexToStartForPetrolPump(a, n);
		System.out.println(result);

	}

	public int indexToStartForPetrolPump(int[][] a, int n) {
		int cur_petrol = a[0][0] - a[0][1];
		int front = 0, rear = 1;
		while (front != rear) {
			if (cur_petrol >= 0) {
				cur_petrol += a[rear][0] - a[rear][1];
				rear = (rear + 1) % n;
			} else {
				cur_petrol += a[front][0] - a[front][1];
				front++;
				if (front == n)
					return -1;
			}
		}
		return front;
	}
}
