/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.DLLNode;

/**
 * @author Raj
 *
 */
public class ReverseDLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleLinkedList<Integer> obj = new DoubleLinkedList<Integer>();
		obj.insert(11);
		obj.insert(12);
		obj.insert(13);
		obj.insert(14);
		obj.insert(15);
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

		ReverseDLL ob = new ReverseDLL();
		obj.print();
		ob.reverse(obj);
		obj.print();
	}

	// Time : O(n)
	public void reverse(DoubleLinkedList<Integer> obj) {
		DLLNode<Integer> cur = obj.root	, next;

		if (cur == null) {
			return;
		}
		while (cur.next != null) {
			next = cur.next;
			cur.next = cur.prev;
			cur.prev = next;
			cur = next;
		}
		cur.next = cur.prev;
		cur.prev = null;

		obj.root = cur;
	}
}
