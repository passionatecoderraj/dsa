/**
 * 
 */
package com.raj.arrays;

/**
 * @author Raj
 *
 */
public class FindMissingAndRepeating {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindMissingAndRepeating obj = new FindMissingAndRepeating();
		int a[] = { 1, 3, 4, 5, 5, 6, 2 };
		int n = a.length;
		obj.findMissingAndRepeating(a, n);
	}

	public void findMissingAndRepeating(int[] a, int n) {
		int index;
		for (int i = 0; i < n; i++) {
			index = Math.abs(a[i]) - 1;
			if (a[index] < 0) {
				System.out.println("Repeating : " + (index + 1));
			} else {
				a[index] = -a[index];
			}
		}
		for (int i = 0; i < n; i++) {
			if (a[i] >= 0) {
				System.out.println("Missing : " + (i + 1));
			}
		}
	}

}
