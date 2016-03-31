/**
 * 
 */
package com.raj.linkedlist;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class RemoveDuplicatesInSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.insert(10);
		list.insert(10);
		list.insert(10);
		list.insert(20);
		list.insert(40);
		list.insert(50);
		list.insert(50);
		list.insert(60);
		list.insert(70);
		list.insert(80);
		list.insert(80);
		list.print();
		RemoveDuplicatesInSortedList obj = new RemoveDuplicatesInSortedList();

		// Time :O(n)
		obj.removeDuplicatesInSortedLinkedList(list.root);
		list.print();

		CircularLinkedList<Integer> clist = new CircularLinkedList<Integer>();
		clist.insert(10);
		clist.insert(10);
		clist.insert(10);
		clist.insert(20);
		clist.insert(40);
		clist.insert(50);
		clist.insert(50);
		clist.insert(60);
		clist.insert(70);
		clist.insert(80);
		clist.insert(80);
		clist.print();

		// Time :O(n)
		obj.removeDuplicatesInSortedCircularList(clist.root);
		clist.print();
	}

	public void removeDuplicatesInSortedLinkedList(ListNode<Integer> root) {
		if (null == root || root.next == null)
			return;
		ListNode<Integer> prev = root;
		ListNode<Integer> cur = root.next;
		while (cur != null) {
			if (prev.data == cur.data) {
				prev.next = cur.next;
				cur = cur.next;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
	}

	public void removeDuplicatesInSortedCircularList(ListNode<Integer> root) {
		if (root == null || root.next == root)
			return;
		ListNode<Integer> prev = root;
		ListNode<Integer> cur = root.next;
		while (cur != root) {
			if (prev.data == cur.data) {
				prev.next = cur.next;
				cur = cur.next;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}

	}

}
