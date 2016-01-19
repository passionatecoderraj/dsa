/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class ReverseInPairs {

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

		ReverseInPairs ob = new ReverseInPairs();
		obj.print();
		// Time : O(n)
		ob.reverseInPairs(obj);
		obj.print();
		// Time : O(n)
		ob.reverseInPairsRecursively(obj.root);
		obj.print();
	}

	public void reverseInPairsRecursively(ListNode<Integer> root) {
		if (root != null && root.next != null) {
			swap(root, root.next);
			reverseInPairsRecursively(root.next.next);
		}
	}

	public void reverseInPairs(SingleLinkedList<Integer> obj) {
		ListNode<Integer> fast = obj.root;
		while (fast != null && fast.next != null) {
			swap(fast, fast.next);
			fast = fast.next.next;
		}
	}

	public void swap(ListNode<Integer> a, ListNode<Integer> b) {
		a.data = a.data ^ b.data;
		b.data = a.data ^ b.data;
		a.data = a.data ^ b.data;
	}
}
