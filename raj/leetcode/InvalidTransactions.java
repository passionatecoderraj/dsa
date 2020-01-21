package com.raj.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * A transaction is possibly invalid if:

the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.

Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.

 

Example 1:

Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
Example 2:

Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]
Example 3:

Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]
 

Constraints:

transactions.length <= 1000
Each transactions[i] takes the form "{name},{time},{amount},{city}"
Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
Each {time} consist of digits, and represent an integer between 0 and 1000.
Each {amount} consist of digits, and represent an integer between 0 and 2000.


 *
 */

public class InvalidTransactions {

	// Time : O(n2), Space : O(n)
	public List<String> invalidTransactions(String[] tx) {
		List<String> list = new ArrayList<>();

		class Node {
			int index;
			String name;
			int time;
			int amount;
			String city;

			public Node(int index, String name, int time, int amount, String city) {
				this.index = index;
				this.name = name;
				this.time = time;
				this.amount = amount;
				this.city = city;
			}

			@Override
			public String toString() {
				return "Node [index=" + index + ", name=" + name + ", time=" + time + ", amount=" + amount + ", city="
						+ city + "]";
			}

		}
		int n = tx.length;
		Node[] a = new Node[n];
		for (int i = 0; i < tx.length; i++) {
			String s[] = tx[i].split(",");
			a[i] = new Node(i, s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), s[3]);
		}

		boolean res[] = new boolean[tx.length];

		for (int i = 0; i < n; i++) {
			if (a[i].amount > 1000) {
				res[i] = true;
			}
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(a[i].time - a[j].time) <= 60 && a[i].name.equals(a[j].name)
						&& !a[i].city.equals(a[j].city)) {
					res[i] = true;
					res[j] = true;
				}
			}
		}
		for (int i = 0; i < res.length; i++) {
			if (res[i])
				list.add(tx[i]);
		}
		return list;
	}

	public static void main(String args[]) {
		InvalidTransactions obj = new InvalidTransactions();
		String a[] = { "alex,676,260,bangkok", "bob,656,1366,bangkok", "alex,393,616,bangkok", "bob,820,990,amsterdam",
				"alex,596,1390,amsterdam" };
		System.out.println(obj.invalidTransactions(a));
	}

}