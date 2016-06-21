/**
 * 
 */
package com.raj.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 */
public class FourElementsSumToK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FourElementsSumToK obj = new FourElementsSumToK();
		int a[] = { 10, 2, 3, 4, 5, 9, 7, 8 };
		int n = a.length, k = 23;
		// Time : O(n3), Space : O(1)
		// obj.find4NumbersSumToK(a, n, k);
		obj.find4NumbersSumToKWithtoutSortingOptimized(a, n, k);
		// Time : O(n2logn), Space : O(n2)
		// obj.find4NumbersSumToKOptimized(a, n, k);
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
				es[count++] = new Elem(a[i] + a[j], i, j);
			}
		}
		Map<Integer, Elem> map = new HashMap<>();
		for (Elem e : es) {
			int reminder = k - e.value;
			if (map.containsKey(reminder)) {
				if (noCommonIndex(e, map.get(reminder))) {
					System.out.println("1st=" + a[e.first] + ", 2nd=" + a[e.second] + ", 3rd="
							+ a[map.get(reminder).first] + ", 4th=" + a[map.get(reminder).second] + ", sum=" + k);
					return;
				}
			} else {
				map.put(e.value, e);
			}
		}

	}

	// Time : O(n2logn) , Space : O(n2)
	public void find4NumbersSumToKUsingSorting(int[] a, int n, int k) {
		if (n < 4)
			return;
		Elem[] es = new Elem[(n * (n - 1)) / 2];

		int count = 0;
		// make n(n-1)/2 pairs
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				es[count++] = new Elem(a[i] + a[j], i, j);
			}
		}

		Arrays.sort(es, sortByVal);
		int l = 0, r = count - 1, sum;
		while (l < r) {
			sum = es[l].value + es[r].value;
			if (sum == k && noCommonIndex(es[l], es[r])) {
				System.out.println("1st=" + a[es[l].first] + ", 2nd=" + a[es[l].second] + ", 3rd=" + a[es[r].first]
						+ ", 4th=" + a[es[r].second] + ", sum=" + k);
				l++;
				r--;
			} else if (sum > k) {
				r--;
			} else {
				l++;
			}
		}
	}

	public boolean noCommonIndex(Elem e1, Elem e2) {
		if (e1.first == e2.first || e1.first == e2.second || e1.second == e2.first || e1.second == e2.second) {
			return false;
		}
		return true;
	}

	public static Comparator<Elem> sortByVal = new Comparator<Elem>() {
		public int compare(Elem o1, Elem o2) {
			return o1.value - o2.value;
		}
	};

	public void find4NumbersSumToK(int[] a, int n, int k) {
		Arrays.sort(a);
		int l, r, sum;
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				l = j + 1;
				r = n - 1;
				while (l < r) {
					sum = a[i] + a[j] + a[l] + a[r];
					if (sum == k) {
						System.out.println(
								"1st=" + a[i] + ", 2nd=" + a[j] + ", 3rd=" + a[l] + ", 4th=" + a[r] + ", sum=" + k);
						l++;
						r--;
						break;
					} else if (sum > k) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
	}

}

class Elem {
	int value;
	int first;
	int second;

	public Elem(int value, int first, int second) {
		super();
		this.value = value;
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "Elem [value=" + value + ", first=" + first + ", second=" + second + "]";
	}

}
