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
public class SwapEveryKthNode {

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
		obj.insert(20);
		obj.insert(21);
		obj.insert(22);
		obj.insert(23);
		obj.insert(24);
		obj.insert(25);
		obj.insert(26);
		obj.insert(27);

		SwapEveryKthNode ob = new SwapEveryKthNode();
		obj.print();

		int k = 4;
		// Time : O(n)
		obj.root = ob.swapEveryKthNode(obj.root, k);
		obj.print();

	}

	public ListNode<Integer> swapEveryKthNode(ListNode<Integer> root, int k) {
		ListNode<Integer> cur = root, prev = null;
		int count = 1;
		while (cur != null && count <= k) {
			prev = cur;
			cur = cur.next;
			if (++count > k)
				CommonUtil.swap(prev, root);
		}

		if (cur != null) {
			prev.next = swapEveryKthNode(cur, k);
		}
		return root;
	}

}
