/**
 * 
 */
package com.raj.linkedlist;

import com.interview.graph.CommonUtil;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */

/*
 * http://algorithms.tutorialhorizon.com/swap-kth-node-from-the-front-with-the-
 * kth-node-from-the-end/
 */

public class SwapKthNodeFromStartAndEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(11);
		obj.insert(12);
		obj.insert(13);
		obj.insert(14);
		obj.insert(15);
		obj.insert(16);
		obj.insert(17);
		obj.insert(18);
		obj.insert(19);
		// obj.insert(20);
		// obj.insert(21);
		// obj.insert(22);
		// obj.insert(23);
		// obj.insert(24);
		// obj.insert(25);
		// obj.insert(26);
		// obj.insert(27);

		SwapKthNodeFromStartAndEnd ob = new SwapKthNodeFromStartAndEnd();
		obj.print();

		int k = 3;
		// Time : O(n)
		obj.root = ob.swapKthFromStartAndEnd(obj.root, obj.length(), k);
		obj.print();

	}

	public ListNode<Integer> swapKthFromStartAndEnd(ListNode<Integer> root, int n, int k) {
		if (k > n)
			return root;
		ListNode<Integer> start = root, last = root;
		for (int i = 1; i < k; i++) {
			start = start.next;
		}

		for (int i = 1; i < n - k + 1; i++) {
			last = last.next;
		}
		if (start != last)
			CommonUtil.swap(start, last);
		return root;
	}

}
