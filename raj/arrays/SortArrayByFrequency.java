/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;
import java.util.Comparator;

import com.interview.graph.CommonUtil;

/**
 * @author Raj
 *
 *         If frequency is same, then it must preserve the order
 */
public class SortArrayByFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortArrayByFrequency obj = new SortArrayByFrequency();
		int a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
		int n = a.length;
		obj.sortArrayByFrequency(a, n);
		CommonUtil.printArray(a);
	}

	public Comparator<Element> customSorterByVal = new Comparator<Element>() {
		public int compare(Element o1, Element o2) {
			return o2.val - o1.val;
		}
	};

	public Comparator<Element> customSorterByCountAndIndex = new Comparator<Element>() {
		public int compare(Element o1, Element o2) {
			if (o1.count == o2.count) {
				return o1.index - o2.index;
			}
			return o2.count - o1.count;
		}
	};

	public void sortArrayByFrequency(int[] a, int n) {
		if (n <= 0)
			return;
		Element[] elements = new Element[n];
		for (int i = 0; i < n; i++) {
			elements[i] = new Element(i, a[i], 1);
		}
		Arrays.sort(elements, customSorterByVal);

		for (int i = 1; i < n; i++) {
			if (elements[i].val == elements[i - 1].val) {
				elements[i].count = elements[i - 1].count + 1;
				elements[i].index = elements[i - 1].index;
				elements[i - 1].count = -1;
			}
		}
		CommonUtil.printArray(elements);
		Arrays.sort(elements, customSorterByCountAndIndex);
		CommonUtil.printArray(elements);
		
		int k = 0;
		for (int i = 0; i < n; i++) {
			Element ele = elements[i];
			if (ele.count != -1) {
				for (int j = 0; j < ele.count; j++) {
					a[k++] = ele.val;
				}
			}
		}
	}

}

class Element {
	int index;
	int val;
	int count;

	public Element(int index, int val, int count) {
		super();
		this.index = index;
		this.val = val;
		this.count = count;
	}

	@Override
	public String toString() {
		return "(index=" + index + ", val=" + val + ", count=" + count + ")";
	}

}
