/**
 *
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Raj
 * 
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

Buildings  Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

 */
public class SkylineProblem {

	// Time : O(nlong), Space : O(n)
	public List<int[]> getSkyline(int[][] a) {

		class Point {
			int x;
			int height;
			int isEnd;

			public Point(int x, int height, int end) {
				this.x = x;
				this.height = height;
				this.isEnd = end;
			}

			@Override
			public String toString() {
				return "(" + x + ", " + height + ", " + isEnd + ")";
			}

		}

		List<Point> list = new ArrayList<>();
		// for all start and end of building put them into List of BuildingPoint
		Arrays.stream(a).forEach(v -> {
			list.add(new Point(v[0], v[2], 0));
			list.add(new Point(v[1], v[2], 1));
		});

		Collections.sort(list, (b1, b2) -> {
			// first compare by x.
			// If they are same then use this logic
			if (b1.x == b2.x) {
				// if two ends are compared then lower height building should be picked first
				if (b1.isEnd == 1 && b2.isEnd == 1)
					return b1.height - b2.height;
				// if two starts are compared then higher height building should be picked first
				else if (b1.isEnd == 0 && b2.isEnd == 0)
					return b2.height - b1.height;
				// if one start and end is compared then start should appear before end
				return b1.isEnd - b2.isEnd;

			}
			return b1.x - b2.x;
		});
		List<int[]> result = new ArrayList<>();
		// using TreeMap because it gives log time performance.
		/*
		 * We should not use TreeSet also because. When there are duplicates, and when
		 * we are removing elements from TreeSet it deletes all duplicates. Instead if
		 * we use map we can reduce count one by one
		 */
		TreeMap<Integer, Integer> pq = new TreeMap<>();
		pq.put(0, 1);
		int prevMaxHeight, curMaxHeight;
		for (Point bp : list) {
			prevMaxHeight = pq.lastKey();
			if (bp.isEnd == 0) {
				// if it is start of building then add the height to map. If height already
				// exists then increment
				// the value
				pq.compute(bp.height, (k, v) -> {
					if (null == v) {
						v = 0;
					}
					return v + 1;
				});

			} else {
				// if it is end of building then decrement or remove the height from map.
				pq.compute(bp.height, (k, v) -> {
					if (1 == v) {
						return null;
					}
					return v - 1;
				});
			}
			curMaxHeight = pq.lastKey();
			// if height changes from previous height then this building x becomes critcal
			// x.
			if (prevMaxHeight != curMaxHeight) {
				result.add(new int[] { bp.x, curMaxHeight });
			}
		}
		return result;

	}

	// Time : O(nlong), Space : O(n)
	public List<int[]> getSkyline2(int[][] a) {
		List<BuildingPoint> list = new ArrayList<>();
		// for all start and end of building put them into List of BuildingPoint
		Arrays.stream(a).forEach(v -> {
			list.add(new BuildingPoint(v[0], v[2], true));
			list.add(new BuildingPoint(v[1], v[2], false));
		});

		Collections.sort(list, (b1, b2) -> {
			// first compare by x.
			// If they are same then use this logic
			// if two starts are compared then higher height building should be picked first
			// if two ends are compared then lower height building should be picked first
			// if one start and end is compared then start should appear before end
			if (b1.x == b2.x) {
				return (b1.isStart ? -b1.height : b1.height) - (b2.isStart ? -b2.height : b2.height);
			}
			return b1.x - b2.x;
		});
		List<int[]> result = new ArrayList<>();
		// using TreeMap because it gives log time performance.
		/*
		 * We should not use TreeSet also because. When there are duplicates, and when
		 * we are removing elements from TreeSet it deletes all duplicates. Instead if
		 * we use map we can reduce count one by one
		 */
		TreeMap<Integer, Integer> pq = new TreeMap<>();
		pq.put(0, 1);
		int prevMaxHeight, curMaxHeight;
		for (BuildingPoint bp : list) {
			prevMaxHeight = pq.lastKey();
			if (bp.isStart) {
				// if it is start of building then add the height to map. If height already
				// exists then increment
				// the value
				pq.compute(bp.height, (k, v) -> {
					if (null == v) {
						v = 0;
					}
					return v + 1;
				});

			} else {
				// if it is end of building then decrement or remove the height from map.
				pq.compute(bp.height, (k, v) -> {
					if (1 == v) {
						return null;
					}
					return v - 1;
				});
			}
			curMaxHeight = pq.lastKey();
			// if height changes from previous height then this building x becomes critcal
			// x.
			if (prevMaxHeight != curMaxHeight) {
				result.add(new int[] { bp.x, curMaxHeight });
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// each of these are x1, x2 and height
		// int[][] buildings = {{1, 3, 4 }, {3, 4, 4 }, {2, 6, 2 }, {8, 11, 4 }, {7, 9,
		// 3 }, {10, 11, 2 } };
		// int[][] buildings = {{1, 3, 3 }, {2, 4, 4 }, {5, 8, 2 }, {6, 7, 4 }, {8, 9, 4
		// } };
		int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 } };
		SkylineProblem obj = new SkylineProblem();
		List<int[]> res = null;

		res = obj.getSkyline(buildings);
		res.forEach(k -> System.out.print(Arrays.toString(k)));
		System.out.println();

		res = obj.getSkyline(new int[][] { { 0, 2, 3 }, { 2, 5, 3 } });
		res.forEach(k -> System.out.print(Arrays.toString(k)));
		System.out.println();

	}

	class BuildingPoint {
		int x;
		int height;
		boolean isStart;

		public BuildingPoint() {
		}

		public BuildingPoint(int x, int height, boolean isStart) {
			this.x = x;
			this.height = height;
			this.isStart = isStart;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + height + ", " + isStart + ")";
		}

	}

}
