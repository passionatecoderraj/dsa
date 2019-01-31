/**
 * 
 */
package com.raj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Raj
 *
 */
public class FourSum {

	// Time : O(n2logn) , Space : O(n2)
	// incomplete solution
	public List<List<Integer>> find4NumbersSumToKUsingSorting(int[] a, int k) {
		int n = a.length;
		Elem[] es = new Elem[(n * (n - 1)) / 2];
		List<List<Integer>> res = new ArrayList<>();

		int total = 0;
		// make n(n-1)/2 pairs
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				es[total++] = new Elem(a[i] + a[j], a[i], a[j], i, j);
			}
		}
		Set<String> visited = new HashSet<>();
		Arrays.sort(es, (e1, e2) -> e1.value - e2.value);
		int l = 0, r = total - 1, sum;
		while (l < r) {
			sum = es[l].value + es[r].value;
			int[] list = { es[l].firstIndex, es[l].secondIndex, es[r].firstIndex, es[r].secondIndex };
			Arrays.sort(list);
			StringBuilder key = new StringBuilder();
			for (int i = 0; i < list.length; i++) {
				key.append(list[i]);
				if (i != list.length - 1)
					key.append(",");
			}
			if (sum == k && noCommonIndex(es[l], es[r]) && !visited.contains(key.toString())) {
				List<Integer> rs = new ArrayList<>();
				rs.add(es[l].firstValue);
				rs.add(es[l].secondValue);
				rs.add(es[r].firstValue);
				rs.add(es[r].secondValue);
				res.add(rs);
				visited.add(key.toString());
				l++;
				r--;
			} else if (sum > k) {
				r--;
			} else {
				l++;
			}
		}
		return res;
	}

	// Time : O(n3), : Space :O(1)
	public List<List<Integer>> find4NumbersSumToK(int[] a, int k) {
		List<List<Integer>> res = new ArrayList<>();
		int n = a.length;
		Arrays.sort(a);
		int l, r, sum;
		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && a[i] == a[i - 1])
				continue;
			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && a[j] == a[j - 1])
					continue;
				l = j + 1;
				r = n - 1;
				while (l < r) {
					sum = a[i] + a[j] + a[l] + a[r];
					if (sum == k) {
						List<Integer> rs = new ArrayList<>();
						rs.add(a[i]);
						rs.add(a[j]);
						rs.add(a[l]);
						rs.add(a[r]);
						res.add(rs);
						while (l < r && a[l] == a[l + 1])
							l++;
						while (l < r && a[r] == a[r - 1])
							r--;
						l++;
					} else if (sum > k) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FourSum obj = new FourSum();
		int a[] = { 10, 2, 3, 4, 5, 9, 7, 8 };
		int k = 23;
		List<List<Integer>> res = null;
		res = obj.find4NumbersSumToK(a, k);
		System.out.println(res);

		res = obj.find4NumbersSumToKUsingSorting(a, k);
		System.out.println(res);

	}

	// Time : O(n2), Space :O(n2)
	public void find4NumbersSumToKWithtoutSortingOptimized(int[] a, int n, int k) {
		if (n < 4)
			return;
		Elem[] es = new Elem[(n * (n - 1)) / 2];

		int count = 0;
		// make n(n-1)/2 pairs
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				es[count++] = new Elem(a[i] + a[j], a[i], a[j], i, j);
			}
		}
		Map<Integer, Elem> map = new HashMap<>();
		for (Elem e : es) {
			int reminder = k - e.value;
			if (map.containsKey(reminder)) {
				if (noCommonIndex(e, map.get(reminder))) {
					System.out.println("1st=" + a[e.firstIndex] + ", 2nd=" + a[e.secondIndex] + ", 3rd="
							+ a[map.get(reminder).firstIndex] + ", 4th=" + a[map.get(reminder).secondIndex] + ", sum="
							+ k);
					return;
				}
			} else {
				map.put(e.value, e);
			}
		}

	}

	public boolean noCommonIndex(Elem e1, Elem e2) {
		return e1.firstIndex != e2.firstIndex && e1.firstIndex != e2.secondIndex && e1.secondIndex != e2.firstIndex
				&& e1.secondIndex != e2.secondIndex;
	}

	public static Comparator<Elem> sortByVal = new Comparator<Elem>() {
		public int compare(Elem o1, Elem o2) {
			return o1.value - o2.value;
		}
	};

}

class Elem {
	int value;
	int firstValue;
	int secondValue;
	int firstIndex;
	int secondIndex;

	public Elem(int value, int firstValue, int secondValue, int firstIndex, int secondIndex) {
		this.value = value;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.firstIndex = firstIndex;
		this.secondIndex = secondIndex;
	}

	@Override
	public String toString() {
		return "Elem [value=" + value + ", firstValue=" + firstValue + ", secondValue=" + secondValue + ", firstIndex="
				+ firstIndex + ", secondIndex=" + secondIndex + "]";
	}

}
