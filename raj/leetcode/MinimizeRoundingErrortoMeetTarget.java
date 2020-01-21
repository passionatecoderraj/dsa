/**
 * 
 */
package com.raj.leetcode;

import java.util.PriorityQueue;

/**
 * @author Raj
 *
 *         Given an array of prices [p1,p2...,pn] and a target, round each price
 *         pi to Roundi(pi) so that the rounded array
 *         [Round1(p1),Round2(p2)...,Roundn(pn)] sums to the given target. Each
 *         operation Roundi(pi) could be either Floor(pi) or Ceil(pi).
 * 
 *         Return the string "-1" if the rounded array is impossible to sum to
 *         target. Otherwise, return the smallest rounding error, which is
 *         defined as Σ |Roundi(pi) - (pi)| for i from 1 to n, as a string with
 *         three places after the decimal.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: prices = ["0.700","2.800","4.900"], target = 8 Output: "1.000"
 *         Explanation: Use Floor, Ceil and Ceil operations to get (0.7 - 0) +
 *         (3 - 2.8) + (5 - 4.9) = 0.7 + 0.2 + 0.1 = 1.0 . Example 2:
 * 
 *         Input: prices = ["1.500","2.500","3.500"], target = 10 Output: "-1"
 *         Explanation: It is impossible to meet the target.
 * 
 * 
 *         Note:
 * 
 *         1 <= prices.length <= 500. Each string of prices prices[i] represents
 *         a real number which is between 0 and 1000 and has exactly 3 decimal
 *         places. target is between 0 and 1000000.
 * 
 */
public class MinimizeRoundingErrortoMeetTarget {

	/*
	 * 1) Range - target must be in the range of floorSum to ceilSum otherwise return -1
	 * 
	 * 2) for each value assume floor is the best value and add it to the result
	 * 
	 * 3) Order of adding these elements should be to minimize rounding error.
	 * since we need to identify ceilings then we need to sort element values by ceilings closer to the target
	 *  
	 * 4) start incrementing floorSum until target become floorSum
	 * 
	 * 5) since lower value of ceilDiff is considered deduct the relevant floorDiff
	 * 
	 * 
	 */
	public String minimizeError(String[] prices, int target) {
		Double res = 0.0;
		class Node {
			Double floorDiff;
			Double CeilDiff;

			public Node(Double lowVal, Double highVal) {
				this.floorDiff = lowVal;
				this.CeilDiff = highVal;
			}
		}
		PriorityQueue<Node> diffHeap = new PriorityQueue<>(
				(n1, n2) -> Double.valueOf(n1.CeilDiff).compareTo(Double.valueOf(n2.CeilDiff)));
		int floorSum = 0;
		int ceilSum = 0;
		for (int i = 0; i < prices.length; i++) {
			String s = prices[i];
			float f = Float.valueOf(s);
			double low = Math.floor(f);
			double high = Math.ceil(f);

			if (low != high) {
				// sort elements by closer to the ceiling
				diffHeap.offer(new Node(f - low, high - f));
			}
			// find result
			res += f - low;
			// remove the floor
			floorSum += low;
			ceilSum += high;
		}

		if (!(floorSum <= target && target <= ceilSum))
			return "-1";
		// now adding, remaining target should help us reach the target
		// while (floorSum++<target) {
		for (int i=floorSum;i<target;i++) {
			/*
			 * res previously has "f-low", diffHeap we added, (high - f) - (f - low) here
			 * res +=diffHeap.poll()
			 * 
			 * ==> "f-low" + (high - f) - (f - low) ==> high-f <-- desired value
			 */
			Node n = diffHeap.poll();
			res += n.CeilDiff - n.floorDiff;
		}

		return String.format("%.3f", res);
	}
	
	// https://leetcode.com/problems/minimize-rounding-error-to-meet-target/discuss/337606/Clean-Java-Solution-using-PriorityQueue
	/*
	 * 1) Range - {sumOfFloorsOf(prices),
	 * sumOfFloorsOf(prices)+NoOfElements(prices)} if target is not in this range,
	 * then return -1
	 * 
	 * 2) otherwise, after finding sumOfFloorsOf(prices), start adding ceiling of
	 * elements one by one to meet target.
	 * 
	 * 3) Order of adding these elements should be to minimize rounding error.
	 * 
	 * 4) Since we are adding all ceilings, to minimize rounding error closer the
	 * element is to the ceiling the lesser the rounding error
	 * 
	 */
	public String minimizeError2(String[] prices, int target) {
		float res = 0;
		PriorityQueue<Double> diffHeap = new PriorityQueue<>();

		for (String s : prices) {
			float f = Float.valueOf(s);
			double low = Math.floor(f);
			double high = Math.ceil(f);

			if (low != high) {
				// sort elements by closer to the ceiling
				diffHeap.offer((high - f) - (f - low));
			}
			// find result
			res += f - low;
			// remove the floor
			target -= low;
		}

		if (target < 0 || target > diffHeap.size())
			return "-1";
		// now adding, remainging target should help us reach the target
		while (target-- > 0) {
			/*
			 * res previously has "f-low", diffHeap we added, (high - f) - (f - low) here
			 * res +=diffHeap.poll()
			 * 
			 * ==> "f-low" + (high - f) - (f - low) ==> high-f <-- desired value
			 */
			res += diffHeap.poll();
		}

		System.out.println(res);
		return String.format("%.3f", res);
	}


	public static void main(String[] args) {
		MinimizeRoundingErrortoMeetTarget obj = new MinimizeRoundingErrortoMeetTarget();
		String result = "";

//		result = obj.minimizeError(new String[] { "0.700", "2.800", "4.900" }, 8);
//		System.out.println(result);
//
//		result = obj.minimizeError(new String[] { "1.500", "2.500", "3.500" }, 10);
//		System.out.println(result);
//		
		result = obj.minimizeError(new String[] { "2.000","2.000","2.000","2.000","2.000" }, 11);
		System.out.println(result);

	}
}
