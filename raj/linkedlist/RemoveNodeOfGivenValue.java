/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class RemoveNodeOfGivenValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.insert(12);
		list.insert(11);
		list.insert(12);
		list.insert(21);
		list.insert(41);
		list.insert(43);
		list.insert(21);

		RemoveNodeOfGivenValue obj = new RemoveNodeOfGivenValue();

		list.print();
		list.root = obj.removeNodeOfGivenValue(list.root, 12);
		list.print();

	}

	private ListNode<Integer> removeNodeOfGivenValue(ListNode<Integer> root, int data) {
		ListNode<Integer> prev = new ListNode<Integer>(0);

		ListNode<Integer> cur = root, head;
		head = prev;
		while (cur != null) {
			if (cur.data == data) {
				prev.next = cur.next;
			} else {
				prev.next = cur;
			}
			prev = cur;
			cur = cur.next;
		}
		return head.next;
	}

}
