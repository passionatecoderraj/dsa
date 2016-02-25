/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindMinDistancebetween2Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindMinDistancebetween2Numbers obj = new FindMinDistancebetween2Numbers();
		int a[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		int n = a.length, result = -1, x = 5, y = 8;

		// Time : O(n2)
		result = obj.findMinDistanceBruteForce(a, n, x, y);
		System.out.println(result);

		// Time : O(n)
		result = obj.findMinDistance(a, n, x, y);
		System.out.println(result);

		result = obj.minDistanceBetweenTwoNumber(a, n, x, y);
		System.out.println(result);

		result = obj.minDistanceBetweenTwoNumber2(a, n, x, y);
		System.out.println(result);

	}

	public int minDistanceBetweenTwoNumber2(int a[], int n, int x, int y) {
		int minDistance = Integer.MAX_VALUE;
		if (n <= 0)
			return minDistance;

		int lastFoundIndex = -1;

		for (int i = 0; i < n; i++) {
			if (a[i] == x || a[i] == y) {
				if (lastFoundIndex != -1 && a[i] != a[lastFoundIndex]) {
					minDistance = Math.min(minDistance, i - lastFoundIndex);
				}
				lastFoundIndex = i;
			}
		}

		return minDistance;
	}

	public int minDistanceBetweenTwoNumber(int a[], int n, int x, int y) {
		int minDistance = Integer.MAX_VALUE;
		if (n <= 0)
			return minDistance;

		int lastFound = -1, lastFoundIndex = -1;

		for (int i = 0; i < n; i++) {
			if (a[i] == x || a[i] == y) {
				if (lastFound == -1) {
					lastFound = a[i];
					lastFoundIndex = i;
				} else if (lastFound != a[i]) {
					minDistance = Integer.min(i - lastFoundIndex, minDistance);
					lastFound = a[i];
					lastFoundIndex = i;
				} else {
					lastFoundIndex = i;
				}
			}
		}

		return minDistance;
	}

	public int findMinDistance(int[] a, int n, int x, int y) {
		int prevIndex = -1;
		int minDistance = Integer.MAX_VALUE;
		int minX = -1, minY = -1;

		for (int i = 0; i < n; i++) {
			if (a[i] == x || a[i] == y) {
				if (prevIndex == -1)
					prevIndex = i;
				else {
					if (a[prevIndex] != a[i]) {
						if (minDistance > i - prevIndex) {
							minDistance = i - prevIndex;
							minX = prevIndex;
							minY = i;
						}
					}
					prevIndex = i;
				}
			}
		}
		System.out.println("minX=" + minX + ", minY=" + minY + " : minDistance=" + minDistance);

		return minDistance;
	}

	public int findMinDistanceBruteForce(int a[], int n, int x, int y) {
		int minDistance = Integer.MAX_VALUE;
		int minX = -1, minY = -1;
		for (int i = 0; i < n; i++) {
			if (a[i] == x || a[i] == y) {
				int other = a[i] == x ? y : x;
				for (int j = i + 1; j < n; j++) {
					if (a[j] == other) {
						if (minDistance > j - i) {
							minDistance = j - i;
							minX = i;
							minY = j;
						}
					}
				}
			}

		}
		System.out.println("minX=" + minX + ", minY=" + minY + " : minDistance=" + minDistance);
		return minDistance;
	}

}
