/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */

public class AddTwoNumbersRepresentedByLinkedLists {

	// method 2 for adding negative numbers
	public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		boolean is_L1_Positive = l1.data > 0;
		boolean is_L2_Positive = l2.data > 0;
		ListNode<Integer> res = null;
		if (is_L1_Positive && is_L2_Positive) {
			res = add(reverse(l1), reverse(l2));
			return reverse(res);
		} else if (!is_L1_Positive & !is_L2_Positive) {
			res = add(reverse(l1), reverse(l2));
			res = reverse(res);
			res.data = -res.data;
			return res;
		}
		

		return reverse(res);
	}

	public ListNode<Integer> add(ListNode<Integer> l1, ListNode<Integer> l2) {
		int c = 0;
		ListNode<Integer> dummy = new ListNode<Integer>();
		ListNode<Integer> cur = dummy;
		while (l1 != null || l2 != null) {
			int v1 = (null == l1) ? 0 : l1.data;
			int v2 = (null == l2) ? 0 : l2.data;
			int sum = v1 + v2 + c;
			int val = sum % 10;
			c = sum / 10;
			cur.next = new ListNode<>(val);
			cur = cur.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (c > 0) {
			cur.next = new ListNode<>(c);
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> l1 = new SingleLinkedList<Integer>();
		l1.insert(7);
		l1.insert(4);
		l1.insert(3);

		SingleLinkedList<Integer> l2 = new SingleLinkedList<Integer>();
		l2.insert(6);
		l2.insert(5);
		l2.insert(4);

		AddTwoNumbersRepresentedByLinkedLists obj = new AddTwoNumbersRepresentedByLinkedLists();
		ListNode<Integer> result = null;
		result = obj.addTwoNumbers(l2.root, l1.root);
		new SingleLinkedList<Integer>().print(result);

		result = obj.addTwoNumbers(l2.root, l1.root);
		new SingleLinkedList<Integer>().print(result);
	}

	// Time : O(n)
	public ListNode<Integer> reverse(ListNode<Integer> root) {

		ListNode<Integer> cur, next, prev;
		cur = root;
		prev = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

}
