package com.raj.design;

public class HitCounter {
	int times[];
	int hits[];

	/** Initialize your data structure here. */
	public HitCounter() {
		times = new int[300];
		hits = new int[300];
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		int index = timestamp % 300;
		if (times[index] != timestamp) {
			times[index] = timestamp;
			hits[index] = 1;
		} else {
			hits[index]++;
		}
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int count = 0;
		for (int i = 0; i < hits.length; i++) {
			if (timestamp - times[i] < 300) {
				count += hits[i];
			}
		}
		return count;
	}

	public static void main(String... args) {
		HitCounter counter = new HitCounter();
		int result = -1;
		// hit at timestamp 1.
		counter.hit(1);

		// hit at timestamp 2.
		counter.hit(2);

		// hit at timestamp 3.
		counter.hit(3);

		// get hits at timestamp 4, should return 3.
		result = counter.getHits(4);
		System.out.println(result);

		// hit at timestamp 300.
		counter.hit(300);

		// get hits at timestamp 300, should return 4.
		result = counter.getHits(300);
		System.out.println(result);

		// get hits at timestamp 301, should return 3.
		result = counter.getHits(301);
		System.out.println(result);
	}
}
