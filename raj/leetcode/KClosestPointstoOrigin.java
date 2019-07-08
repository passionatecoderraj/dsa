/**
 * 
 */
package com.raj.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;;

/**
 * @author Raj
 *
 *We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

 */

public class KClosestPointstoOrigin {

	// Time : Theta(n), Space: O(1)
	public int[][] kClosest(int[][] points, int K) {
		int[][] res = new int[K][2];

		int p = 0, r = points.length - 1;
		K--;
		while (p <= r) {
			int q = randomPartition(points, p, r);
			if (q > K) {
				r = q - 1;
			} else if (q < K) {
				p = q + 1;
			} else {
				for (int i = 0; i <= K; i++) {
					res[i] = points[i];
				}
				break;
			}
		}
		return res;
	}

	private int randomPartition(int[][] points, int p, int r) {
		Random random = new Random();
		int partition_index = random.nextInt(r - p + 1) + p;
		swap(points, partition_index, r);

		return partition(points, p, r);
	}

	private int partition(int[][] points, int p, int r) {
		int key_distance = distance(points[r]);
		int j = p;
		for (int i = p; i < r; i++) {
			if (distance(points[i]) <= key_distance) {
				swap(points, i, j++);
			}
		}
		swap(points, j, r);
		return j;
	}

	private void swap(int[][] points, int i, int j) {
		int temp[] = points[i];
		points[i] = points[j];
		points[j] = temp;
	}

	private int distance(int[] x) {
		return x[0] * x[0] + x[1] * x[1];
	}

	// Time : O(nlogk), Space : O(k)
	public int[][] kClosest2(int[][] points, int K) {
		int[][] res = new int[K][2];
		if (points.length <= K)
			return points;
		PriorityQueue<int[]> pq = new PriorityQueue<>(K, (p1, p2) -> {
			return (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]);
		});

		for (int[] point : points) {
			pq.offer(point);
			if (pq.size() > K) {
				pq.poll();
			}
		}
		while (K-- > 0) {
			res[K] = pq.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		KClosestPointstoOrigin obj = new KClosestPointstoOrigin();

		int a[][] = { { 1, 3 }, { -2, 2 } };
		int K = 1;
		int[][] res = null;
		res = obj.kClosest(a, K);
		for (int p[] : res)
			System.out.print(Arrays.toString(p) + " , ");
		System.out.println();

		K = 2;
		int b[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		res = obj.kClosest(b, K);
		for (int p[] : res)
			System.out.print(Arrays.toString(p) + " , ");
		System.out.println();

	}

}
