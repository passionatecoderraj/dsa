/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class ReverseCLL<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularLinkedList<Integer> obj = new CircularLinkedList<Integer>();
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

		obj.print();
		ReverseCLL<Integer> ob = new ReverseCLL<Integer>();
		ob.reverse(obj);
		obj.print();
	}

	public void reverse(CircularLinkedList<Integer> obj) {
		if (null == obj.root)
			return;

		ListNode<Integer> cur, prev, next;
		cur = obj.root;
		prev = null;
		while (cur.next != obj.root) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		cur.next = prev;
		obj.root.next = cur;
		obj.root = cur;
	}
}
