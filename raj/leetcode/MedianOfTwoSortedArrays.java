/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class MedianOfTwoSortedArrays {

	/*
	 * 1. find median in normal array
	 * 2. find median in two sorted arrays 
	 * 3. observe that you need only middle numbers so divide them to two halves such that two equal parts are available
	 * 4. so, if you can divide 2 arrays vertically such that both are equal half, then having those middle 4 elements good enough to calculate median
	 * 5. if x1<=y2 and y1 <= x2 it means except these remaining values can be ignored.
	 * 6. note that maxX, minX, maxY, minY are enough to solve the problem
	 * 7. If size is odd, answer is in first half so, answer so max(maxX,maxY)
	 * 8. If size is odd, answer is (max of first half + min of 2nd half)/2
	 * 
	 * Important:
	 * 1. remember that considering 2 elements from array X means, considering indices [2] and [1] (cur and previous)
	 */
	// https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
	public double findMedianSortedArrays(int X[], int Y[]) {
		if (X.length > Y.length)
			return findMedianSortedArrays(Y, X);
		int l = 0, r = X.length;
		while (l <= r) {
			int partitionX = (l + r) >> 1;
			int partitionY = ((X.length + Y.length + 1) / 2) - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : X[partitionX - 1];
			int minRightX = (partitionX == X.length) ? Integer.MAX_VALUE : X[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : Y[partitionY - 1];
			int minRightY = (partitionY == Y.length) ? Integer.MAX_VALUE : Y[partitionY];
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((X.length + Y.length) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			}

			if (maxLeftX > minRightY) {
				r = partitionX - 1;
			} else {
				l = partitionX + 1;
			}

		}
		return -1;
	}

	public double findMedianSortedArrays2(int a[], int b[]) {
		int m = a.length, n = b.length;
		/* A[0, 1, 2, ..., n-1, n] */
		/* A[0, 1, 2, ..., m-1, m] */

		// not using k as index because, finding kth element with 0th index is
		// not clean
		int k = (m + n - 1) / 2;
		double v = (double) findKth(a, 0, m - 1, b, 0, n - 1, k);
		System.out.println("k=" + k + ",v=" + v);
		if ((m + n) % 2 == 0) {
			int k2 = k + 1;
			double v2 = (double) findKth(a, 0, m - 1, b, 0, n - 1, k2);
			System.out.println("k2=" + k2 + ",v2=" + v2);
			v = (v + v2) / 2;
		}

		return v;
	}

	// find the kth element int the two sorted arrays
	// let us say: A[aMid] <= B[bMid], x: mid len of a, y: mid len of b, then
	// wen can know
	//
	// (1) there will be at least (x + 1 + y) elements before bMid
	// (2) there will be at least (m - x - 1 + n - y) = m + n - (x + y +1)
	// elements after aMid
	// therefore
	// if k <= x + y + 1, find the kth element in a and b, but unconsidering
	// bMid and its suffix
	// if k > x + y + 1, find the k - (x + 1) th element in a and b, but
	// unconsidering aMid and its prefix
	// https://discuss.leetcode.com/topic/5728/share-one-divide-and-conquer-o-log-m-n-method-with-clear-description/12
	public int findKth(int A[], int aL, int aR, int B[], int bL, int bR, int k) {
		if (aL > aR)
			return B[bL + k];
		if (bL > bR)
			return A[aL + k];

		int aMid = (aL + aR) / 2;
		int bMid = (bL + bR) / 2;

		if (k <= (aMid - aL) + (bMid - bL)) {
			if (A[aMid] <= B[bMid]) {
				return findKth(A, aL, aR, B, bL, bMid - 1, k);
			} else {
				return findKth(A, aL, aMid - 1, B, bL, bR, k);
			}
		} else {
			if (A[aMid] <= B[bMid]) {
				return findKth(A, aMid + 1, aR, B, bL, bR, k - (aMid - aL) - 1);
			} else {
				return findKth(A, aL, aR, B, bMid + 1, bR, k - (bMid - bL) - 1);
			}
		}
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		int a[] = { 1, 3};
		int b[] = { 2, 4,6 };
		int result = -1;
		result = obj.medianOfTwoSortedArrays(a, b, 0, a.length - 1, 0, b.length - 1);
		System.out.println(result);
		double res = obj.findMedianSortedArrays(a, b);
		System.out.println(res);

		res = obj.findMedianSortedArrays(a, b);
		System.out.println(res);

	}

	public int medianOfTwoSortedArrays(int[] a1, int[] a2, int l1, int r1, int l2, int r2) {
		int m1, m2, n;
		n = r1 - l1 + 1;
		if (n <= 0) {
			return -1;
		} else if (n == 1) {
			return (a1[n - 1] + a2[n - 1]) / 2;
		} else if (n == 2) {
			int l = Math.max(a1[l1], a2[l2]);
			int m = Math.min(a1[r1], a2[r2]);
			return (l + m) / 2;
		} else {
			m1 = median(a1, l1, r1);
			m2 = median(a2, l2, r2);

			if (m1 < m2) {
				int k = n / 2;
				return medianOfTwoSortedArrays(a1, a2, l1 + k, r1, l2, r2 - k);
			} else if (m1 > m2) {
				int k = n / 2;
				return medianOfTwoSortedArrays(a1, a2, l1, r1 - k, l2 + k, r2);

			} else {
				return m1;
			}
		}
	}

	public int median(int[] a, int start, int end) {

		int n = end - start + 1;
		int k = start + n / 2;

		if (n % 2 != 0) {
			return a[k];
		} else {
			return (a[k] + a[k - 1]) / 2;
		}

	}

}
