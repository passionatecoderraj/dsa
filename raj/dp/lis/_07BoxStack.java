package com.raj.dp.lis;

import java.util.Arrays;
import java.util.Comparator;

public class _07BoxStack {

	public static void main(String[] args) {
		_07BoxStack obj = new _07BoxStack();
		Box[] a = { new Box(1, 2, 4), new Box(3, 2, 5) };
		int result = -1;
		result = obj.maxStackHeight(a);
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