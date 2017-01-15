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
		int a[][] = { { 6, 4 }, { 3, 6 }, { 7, 3 } };
		int n = a.length;
		// Time : O(n), Space : O(1)
		result = obj.indexToStartForPetrolPump(a, n);
		System.out.println(result);

		result = obj.petrolPump(a, n);
		System.out.println(result);

	}

	public int petrolPump(int a[][], int n) {
		// cp = current petrol, d = distance
		int cp = 0, d = 0, front = 0, rear = (front + 1) % n;
		cp = a[0][0];
		d = a[0][1];

		while (true) {
			if (cp < d) {
				front++;
				if (front == n)
					return -1;

				cp = a[front][0];
				d = a[front][1];
				rear = (front + 1) % n;
				continue;
			}

			if (front == rear) {
				return front;
			}

			cp += a[rear][0];
			d += a[rear][1];
			rear = (rear + 1) % n;
		}
	}

	public int indexToStartForPetrolPump(int[][] a, int n) {
		int cur_petrol = a[0][0] - a[0][1];
		int front = 0, rear = 1;
		while (front != rear || cur_petrol < 0) {
			while (cur_petrol < 0 && front != rear) {
				cur_petrol -= a[front][0] - a[front][1];
				front++;
				if (front == n)
					return -1;
			}
			cur_petrol += a[rear][0] - a[rear][1];
			rear = (rear + 1) % n;
		}
		return front;
	}
}
