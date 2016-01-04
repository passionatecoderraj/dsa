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
		obj.insert(80);
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
		MergeTwoSortedLists ob = new MergeTwoSortedLists();
		
		ListNode<Integer> result2 = ob.merge(obj.root, obj2.root);
		new SingleLinkedList<Integer>().print(result2);
	
		
		SingleLinkedList<Integer> result = ob.mergeIteratively(obj.root, obj2.root);
		result.print();
	}

	private ListNode<Integer> merge(ListNode<Integer> t1, ListNode<Integer> t2) {
		ListNode<Integer> result = null;

		if (t1 == null && t2 == null) {
			return result;
		}

		else if (t1 != null && t2 != null) {
			if (t1.data <= t2.data) {
				result = new ListNode<Integer>(t1.data);
				result.next = merge(t1.next, t2);
			} else {
				result = new ListNode<Integer>(t2.data);
				result.next = merge(t1, t2.next);
			}
		} else if (t1 != null) {
			result = new ListNode<Integer>(t1.data);
			result.next = merge(t1.next, t2);
		} else if (t2 != null) {
			result = new ListNode<Integer>(t2.data);
			result.next = merge(t1, t2.next);
		}
		return result;
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
