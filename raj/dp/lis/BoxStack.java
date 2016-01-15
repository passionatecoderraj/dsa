package com.raj.dp.lis;

import java.util.Arrays;
import java.util.Comparator;

import com.interivew.graph.CommonUtil;

public class BoxStack {

	public static void main(String[] args) {
		BoxStack obj = new BoxStack();
		Box[] a = { new Box(1, 2, 4), new Box(2, 3, 5) };

		// {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32};
		int result = -1;
		result = obj.maxStackHeight(a);
		System.out.println(result);
		result = obj.maxHeightFromBoxStacking(a, a.length);
		System.out.println(result);
	}

	public static Comparator<Box> customSorter = new Comparator<Box>() {
		@Override
		public int compare(Box e1, Box e2) {
			return (int) (e2.l * e2.w - e1.l * e1.w);
		}
	};

	public int getMax(Box obj) {
		int max = obj.l > obj.h ? obj.l : obj.h;
		return max = max > obj.w ? max : obj.w;
	}

	public int getMin(Box obj) {
		int min = obj.l < obj.h ? obj.l : obj.h;
		return min = min < obj.w ? min : obj.w;
	}

	public int getOther(Box obj, int max, int min) {
		if (obj.l != max && obj.l != min) {
			return obj.l;
		}
		if (obj.w != max && obj.w != min) {
			return obj.w;
		}
		return obj.h;
	}

	public int maxStackHeight(Box[] a) {
		Box[] b = new Box[a.length * 3];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			Box obj = a[i];
			int max = getMax(obj), min = getMin(obj);
			int other = getOther(obj, max, min);

			b[k++] = new Box(max, min, other);
			b[k++] = new Box(other, min, max);
			b[k++] = new Box(max, other, min);
		}
		
		Arrays.sort(b, customSorter);
		int n = b.length;
		int[] maxHt = new int[n];
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			maxHt[i] = b[i].h;
			result[i] = i;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (b[i].l < b[j].l && b[i].w < b[j].w) {
					int ht = b[i].h + maxHt[j];
					if (ht > maxHt[i]) {
						maxHt[i] = ht;
						result[i] = j;
					}
				}
			}
		}
		return maxHt[n - 1];
	}

	public int maxHeightFromBoxStacking(Box[] b, int n) {
		Box[] a = getBoxesOfAllPossibleSizes(b, n);
		CommonUtil.printArray(a);

		Arrays.sort(a, new Comparator<Box>() {
			public int compare(Box b1, Box b2) {
				return (b2.l * b2.w) - (b1.l * b1.w);
			}
		});
		int m = a.length;
		int t[] = new int[m];
		for (int i = 0; i < m; i++) {
			t[i] = a[i].h;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i].l > a[j].l && a[i].w > a[j].w) {
					t[i] = Math.max(t[j] + a[i].h, t[i]);
				}
			}
		}
		return t[n - 1];
	}

	private Box[] getBoxesOfAllPossibleSizes(Box[] b, int n) {
		Box[] a = new Box[n * 3];
		int j = 0;
		for (int i = 0; i < n; i++) {
			a[j++] = new Box(b[i].w, b[i].l, b[i].h);
			a[j++] = new Box(b[i].w, b[i].h, b[i].l);
			a[j++] = new Box(b[i].h, b[i].l, b[i].w);
		}
		return a;
	}
}

class Box {
	int l;
	int w;
	int h;

	public Box(int l, int w, int h) {
		super();
		this.l = l;
		this.w = w;
		this.h = h;
	}

	@Override
	public String toString() {
		return "Box [l=" + l + ", w=" + w + ", h=" + h + "]";
	}

}