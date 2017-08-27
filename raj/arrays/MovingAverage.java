package com.raj.arrays;

public class MovingAverage {

	double a[];
	double sum;
	int index = -1;
	int count = 0;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		a = new double[size];
	}

	// Time : O(1)
	public double next(int val) {
		index = (index + 1) % a.length;

		if (++count < a.length) {
			a[index] = val;
			sum += a[index];
			return sum / count;
		}
		sum -= a[index];
		a[index] = val;
		sum += a[index];
		return sum / a.length;
	}

	public static void main(String args[]) {
		MovingAverage obj = new MovingAverage(3);
		double res = 0;
		res = obj.next(1);
		System.out.println(res);
		res = obj.next(10);
		System.out.println(res);
		res = obj.next(3);
		System.out.println(res);
		res = obj.next(5);
		System.out.println(res);

	}
}