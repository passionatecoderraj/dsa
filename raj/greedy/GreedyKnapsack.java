package com.raj.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GreedyKnapsack {

	public static Comparator<Knapsack> customComparator = new Comparator<Knapsack>() {
		@Override
		public int compare(Knapsack e1, Knapsack e2) {
			double delta = e2.profitweight - e1.profitweight;
			if (delta > 0)
				return 1;
			if (delta < 0)
				return -1;
			return 0;
		}
	};

	public double greedyKnapsack(List<Knapsack> kss, int m) {
		for (int i = 0; i < kss.size(); i++) {
			double p = (double) kss.get(i).profit / kss.get(i).weight;
			// p = Math.round(p * 10);
			// p = p / 10;
			kss.get(i).profitweight = p;
		}

		Collections.sort(kss, customComparator);
		System.out.println(kss);

		double profit = 0;

		for (int i = 0; i < kss.size(); i++) {
			if (m > 0 && kss.get(i).weight <= m) {
				m = m - kss.get(i).weight;
				profit = profit + kss.get(i).profit;
			} else {
				if (m > 0 && kss.get(i).weight > m) {
					double p = kss.get(i).profitweight * m;
					profit = profit + p;
					break;
				}
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		// Knapsack k1 = new Knapsack(25, 18);
		// Knapsack k2 = new Knapsack(24, 15);
		// Knapsack k3 = new Knapsack(15, 10);

		int wt[] = { 7, 8, 9, 11, 12 };
		int profits[] = { 13, 15, 16, 23, 24 };
		Knapsack k1 = new Knapsack(13, 7);
		Knapsack k2 = new Knapsack(15, 8);
		Knapsack k3 = new Knapsack(16, 9);
		Knapsack k4 = new Knapsack(23, 11);
		Knapsack k5 = new Knapsack(24, 12);

		List<Knapsack> kss = new ArrayList<Knapsack>();
		kss.add(k1);
		kss.add(k2);
		kss.add(k3);
		kss.add(k4);
		kss.add(k5);

		GreedyKnapsack obj = new GreedyKnapsack();
		System.out.println(obj.greedyKnapsack(kss, 26));
	}
}

class Knapsack {
	int weight;
	int profit;
	double profitweight;

	public Knapsack(int profit, int weight) {
		super();
		this.weight = weight;
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Knapsack [weight=" + weight + ", profit=" + profit + ", profitweight=" + profitweight + "]";
	}

}