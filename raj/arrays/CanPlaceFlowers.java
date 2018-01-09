/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 *       Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlowers {

	public boolean canPlaceFlowers(int[] a, int n) {
		if (n == 0)
			return true;
		int count = 0;
		for (int i = 0; i < a.length;) {
			if (a[i] == 0 && (i == 0 || a[i - 1] == 0) && (i == a.length - 1 || a[i + 1] == 0)) {
				a[i] = 1;
				if (++count == n)
					return true;
				i += 2;
			} else {
				i++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CanPlaceFlowers obj = new CanPlaceFlowers();
		int a[] = { 1, 0, 0, 0, 1 };
		boolean result = false;
		result = obj.canPlaceFlowers(a, 1);
		System.out.println(result);

		result = obj.canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1);
		System.out.println(result);

	}

}
