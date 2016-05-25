/**
 * 
 */
package com.interivew.sei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Raj
 *
 *This class is used to print unique elements of array in stable order
 */
public class DeDup {

	private static int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 
			45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
			19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12,
			13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,
			3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 
			7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {
		DeDup obj = new DeDup();
		int a[] = new int[randomIntegers.length];
		System.arraycopy(randomIntegers, 0, a, 0, 
				randomIntegers.length);
		obj.printArray(a);
		System.arraycopy(randomIntegers, 0, a, 0,
				randomIntegers.length);
		obj.removeDuplicatesUsingSorting(a);
		System.arraycopy(randomIntegers, 0, a, 0, 
				randomIntegers.length);
		obj.removeDuplicatesUsingHashing(a);
		System.arraycopy(randomIntegers, 0, a, 0,
				randomIntegers.length);
		obj.removeDuplicatesUsingBruteForce(a);
	}

	// method1
	// Running Time : O(n2) , Space : O(1)
	public void removeDuplicatesUsingBruteForce(int a[]) {
		if (null == a || 0 == a.length)
			return;
		int n = a.length, removed;
		for (int i = 0; i < n; i++) {
			removed = 0;
			for (int j = i + 1, k = i + 1; j < n; j++) {
				if (a[i] != a[j]) {
					a[k++] = a[j];
				} else {
					removed++;
				}
			}
			n = n - removed;
		}
		print(a, 0, n);
	}

	// method2
	// Running Time : O(nlogn) , Space : O(n)
	public void removeDuplicatesUsingSorting(int a[]) {
		if (null == a || 0 == a.length)
			return;
		class Element {
			int index;
			int value;

			public Element(int index, int value) {
				this.index = index;
				this.value = value;
			}
		}
		Element[] elements = new Element[a.length];
		for (int i = 0; i < a.length; i++) {
			elements[i] = new Element(i, a[i]);
		}
		Arrays.sort(elements, new Comparator<Element>() {
			public int compare(Element e1, Element e2) {
				return e1.value - e2.value;
			}
		});

		for (int i = 1; i < elements.length; i++) {
			if (elements[i].value == elements[i - 1].value) {
				elements[i].index = Math.min(elements[i].index, 
						elements[i - 1].index);
				elements[i - 1].value = Integer.MAX_VALUE;
				elements[i - 1].index = Integer.MAX_VALUE;
			}
		}

		Arrays.sort(elements, new Comparator<Element>() {
			public int compare(Element e1, Element e2) {
				return e1.index - e2.index;
			}
		});

		for (int i = 0; i < elements.length; i++) {
			a[i] = elements[i].value;
		}
		printArrayWithoutInfinity(a);
	}

	// method3
	// Running Time : O(n) , Space : O(n)
	public void removeDuplicatesUsingHashing(int a[]) {
		if (null == a || 0 == a.length)
			return;
		Set<Integer> set = new LinkedHashSet<>();
		for (int i : a) {
			set.add(i);
		}
		print(set);
	}

	
	
	/*
	 * Utility method to print elements of array 
	 * 	from index 'start' to index 'end'
	 */
	private void print(int[] a, int start, int end) {
		for (int i = start; i < end; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	/*
	 * Utility method to print elements of Set
	 */
	private void print(Set<Integer> set) {
		for (int i : set) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/*
	 * Utility method to print elements of array
	 */
	private void printArray(int a[]) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/*
	 * Utility method to print elements of array without infinity
	 */
	private void printArrayWithoutInfinity(int a[]) {
		for (int i : a) {
			if (i != Integer.MAX_VALUE) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
