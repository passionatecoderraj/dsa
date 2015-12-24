package com.raj.dp.lis;

import java.util.Arrays;
import java.util.Comparator;

import com.interivew.graph.CommonUtil;

public class WeightedJobSelectionWithMaxProfit {

	public static void main(String[] args) {
		// ActivityJob a[] = {
		// new ActivityJob(0, 1, 2, 50),
		// new ActivityJob(1, 3, 5, 20),
		// new ActivityJob(2, 6, 19, 100),
		// new ActivityJob(3, 2, 100, 200) };
		ActivityJob a[] = { new ActivityJob(0, 4, 6, 5), new ActivityJob(1, 2, 5, 6), new ActivityJob(2, 7, 9, 2),
				new ActivityJob(3, 1, 3, 5), new ActivityJob(4, 5, 8, 11), new ActivityJob(5, 6, 7, 4) };
		WeightedJobSelectionWithMaxProfit obj = new WeightedJobSelectionWithMaxProfit();
		int result = -1;
		// O(n2)
		result = obj.weightedJobSelectionWithMaxProfit(a);
		System.out.println(result);
//		result = obj.weightedJobSelectionWithMaxProfitOnlogn(a);
//		System.out.println(result);

	}

	private static Comparator<ActivityJob> customSorter = new Comparator<ActivityJob>() {
		@Override
		public int compare(ActivityJob o1, ActivityJob o2) {
			return o1.finish - o2.finish;
		}

	};

	public int weightedJobSelectionWithMaxProfit(ActivityJob[] a) {
		int n = a.length, max = -1;
		if (n <= 0)
			return max;

		Arrays.sort(a, customSorter);
		// CommonUtil.printArray(a);

		int t[] = new int[n];

		for (int i = 0; i < n; i++) {
			t[i] = a[i].profit;
			for (int j = 0; j < i; j++) {
				if (a[i].start >= a[j].finish) {
					t[i] = Math.max(t[i], a[j].profit + a[i].profit);
					max = Math.max(t[i], max);
				}
			}
		}

		CommonUtil.printArray(t);
		return max;
	}

}

class ActivityJob {
	int id;
	int start;
	int finish;
	int profit;

	public ActivityJob(int id, int start, int finish, int profit) {
		super();
		this.id = id;
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}

	public ActivityJob(int id, int start, int finish) {
		super();
		this.id = id;
		this.start = start;
		this.finish = finish;
	}

	@Override
	public String toString() {
		return "ActivityJob [id=" + id + ", start=" + start + ", finish=" + finish + ", profit=" + profit + "]";
	}

}