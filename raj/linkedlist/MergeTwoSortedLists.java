/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(10);
		obj.insert(20);
		obj.insert(40);
		obj.insert(50);
		obj.insert(60);
		obj.insert(70);
		obj.print();

		SingleLinkedList<Integer> obj2 = new SingleLinkedList<Integer>();
		obj2.insert(4);
		obj2.insert(5);
		obj2.insert(60);
		obj2.insert(70);
		obj2.insert(80);
		obj2.print();
		MergeTwoSortedLists ob = new MergeTwoSortedLists();

		ListNode<Integer> result3 = ob.merge(obj.root, obj2.root);
		new SingleLinkedList<Integer>().print(result3);

		// SingleLinkedList<Integer> result = ob.mergeIteratively(obj.root,
		// obj2.root);
		// result.print();
	}

	public ListNode<Integer> merge(ListNode<Integer> r1, ListNode<Integer> r2) {
		if (r1 == null)
			return r2;
		if (r2 == null)
			return r1;
		if (r1.data <= r2.data) {
			r1.next = merge(r1.next, r2);
			return r1;
		} else {
			r2.next = merge(r1, r2.next);
			return r2;
		}
	}

	public SingleLinkedList<Integer> mergeIteratively(ListNode<Integer> t1, ListNode<Integer> t2) {
		SingleLinkedList<Integer> result = new SingleLinkedList<Integer>();

		while (t1 != null && t2 != null) {
			if (t1.data <= t2.data) {
				result.insert(t1.data);
				t1 = t1.next;
			} else {
				result.insert(t2.data);
				t2 = t2.next;
			}
		}

		while (t1 != null) {
			result.insert(t1.data);
			t1 = t1.next;
		}
		while (t2 != null) {
			result.insert(t2.data);
			t2 = t2.next;
		}

		return result;
	}

}
