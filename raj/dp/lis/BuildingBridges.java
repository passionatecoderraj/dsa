package com.raj.dp.lis;

import java.util.Arrays;
import java.util.Comparator;

/*
 * http://stackoverflow.com/questions/19469485/longest-incresing-subsequence-to-solve-building-bridge
 */
public class BuildingBridges {

	static class Pair {
		int north;
		int south;

		public Pair(int north, int south) {
			super();
			this.north = north;
			this.south = south;
		}

		@Override
		public String toString() {
			return "(N=" + north + ", S=" + south + ")";
		}

	}

	// http://stackoverflow.com/questions/19469485/longest-incresing-subsequence-to-solve-building-bridge
	public static void main(String[] args) {
		BuildingBridges obj = new BuildingBridges();
		int result = -1;

		Pair[] a = { new Pair(7, 5), new Pair(4, 3), new Pair(3, 2), new Pair(6, 4), new Pair(2, 6), new Pair(1, 1),
				new Pair(5, 7) };
		result = obj.maxNumberOfBridges(a, a.length);
		System.out.println(result);

	}

	public int maxNumberOfBridges(Pair[] a, int n) {
		System.out.println(Arrays.toString(a));

		Arrays.sort(a, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.south - o2.south;
			}
		});

		int lis[] = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}

		int maxLen = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i].north > a[j].north) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
					maxLen = Math.max(lis[i], maxLen);
				}
			}
		}

		System.out.println(Arrays.toString(a));
		return maxLen;
	}

}
