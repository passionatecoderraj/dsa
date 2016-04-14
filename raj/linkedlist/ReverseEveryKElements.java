/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class ReverseEveryKElements {

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

		ReverseEveryKElements ob = new ReverseEveryKElements();
		obj.print();

		int k = 3;
		// Time : O(n)
		obj.root = ob.reverseKElementsRecursviely(obj.root, k);
		obj.print();

//		obj.root = ob.reverseKElementsIteratively(obj.root, k);
//		obj.print();

	}

	public ListNode<Integer> reverseKElementsIteratively(ListNode<Integer> root, int k) {
		ListNode<Integer> cur = root, prev = null, next, newRoot = null;
		ListNode<Integer> prevBlockFirstElementBeforeSwapping = null, flag = null;
		int count = 1;
		prevBlockFirstElementBeforeSwapping = root;
		while (cur != null) {
			flag = cur;
			while (cur != null && count <= k) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
				count++;
			}

			if (newRoot == null) {
				newRoot = prev;
			} else {
				prevBlockFirstElementBeforeSwapping.next = prev;
				prevBlockFirstElementBeforeSwapping = flag;
			}
			count = 1;
		}

		return newRoot;
	}

	public ListNode<Integer> reverseKElementsRecursviely(ListNode<Integer> root, int k) {
		ListNode<Integer> cur = root, prev = null, next;
		int count = 1;
		while (cur != null && count <= k) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}

		if (cur != null) {
			root.next = reverseKElementsRecursviely(cur, k);
		}
		return prev;
	}

}
