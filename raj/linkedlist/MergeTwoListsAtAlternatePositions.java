/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */

/*
 * Merge a Linked list into another Linked List at Alternate Positions
 */

/*
 * Given two linked lists, merge one list into another at alter­nate posi­tions,
 * if sec­ond link list has extra nodes, print them as well
 * 
 */

/*
 * 5 -> 10 -> 15 -> 20 ->25 -> null
 * 
 * 3 -> 6 ->9 -> 12 ->15 ->18 ->21 -> null
 * 
 * Output : 5 -> 3 -> 10 -> 6 ->15 -> 9 -> 20 -> 12 -> 25 ->15 -> null Remaining
 * List : 18 -> 21 -> null
 */

/*
 * http://algorithms.tutorialhorizon.com/merge-a-linked-list-into-another-linked
 * -list-at-alternate-positions/
 */
public class MergeTwoListsAtAlternatePositions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(5);
		obj.insert(10);
		obj.insert(15);
		obj.insert(20);
		obj.insert(25);
		obj.print();

		SingleLinkedList<Integer> obj2 = new SingleLinkedList<Integer>();
		obj2.insert(3);
		obj2.insert(6);
		obj2.insert(9);
		obj2.insert(12);
		obj2.insert(15);
		obj2.insert(18);
		obj2.insert(21);
		obj2.print();
		MergeTwoListsAtAlternatePositions ob = new MergeTwoListsAtAlternatePositions();

		ListNode<Integer> result3 = ob.alterMergeIteratively(obj.root, obj2.root);
		new SingleLinkedList<Integer>().print(result3);

	}

	public ListNode<Integer> alterMergeIteratively(ListNode<Integer> r1, ListNode<Integer> r2) {
		ListNode<Integer> root = r1;
		ListNode<Integer> r1next = null, r2next = null, prer1 = null;
		while (r1 != null && r2 != null) {
			r1next = r1.next;
			r2next = r2.next;
			r1.next = r2;
			r2.next = r1next;
			prer1 = r1;
			r1 = r1next;
			r2 = r2next;
		}
		if (r2 != null) {
			if (prer1 != null)
				prer1.next = r2;
			else
				r1 = r2;
		}
		return root;
	}

	public ListNode<Integer> alterMergeRecursively(ListNode<Integer> r1, ListNode<Integer> r2) {
		if (null == r1)
			return r2;
		if (null == r2)
			return r1;
		r1.next = alterMergeRecursively(r2, r1.next);
		return r1;
	}

}
