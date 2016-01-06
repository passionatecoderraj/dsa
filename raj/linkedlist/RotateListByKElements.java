/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class RotateListByKElements {

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
		obj.print();
		int k = 4;
		RotateListByKElements ob = new RotateListByKElements();
		// using reverse mechanism, O(n) but may be complicated
		obj.root = ob.rotate(obj.root, k);
		obj.print();
		obj.root = ob.rotateWithoutReverse(obj.root, k);
		obj.print();
	}

	public ListNode<Integer> rotateWithoutReverse(ListNode<Integer> root, int k) {
		if (k <= 0)
			return root;

		ListNode<Integer> temp = root, newRoot = null, temp2;
		for (int i = 1; i < k; i++) {
			if (temp != null)
				temp = temp.next;
		}
		if (temp == null)
			return root;

		newRoot = temp.next;
		temp.next = null;
		temp2 = newRoot;

		while (temp2.next != null) {
			temp2 = temp2.next;
		}
		temp2.next = root;

		return newRoot;
	}

	public ListNode<Integer> rotate(ListNode<Integer> root, int k) {
		if (k <= 0)
			return root;
		ListNode<Integer> temp = root, root2 = null;
		ListNode<Integer> prevFirst = root;
		for (int i = 1; i < k; i++) {
			if (temp != null)
				temp = temp.next;
		}
		if (temp == null)
			return root;

		root2 = temp.next;
		temp.next = null;
		root = reverse(root);
		root2 = reverse(root2);
		prevFirst.next = root2;

		return reverse(root);
	}

	public ListNode<Integer> reverse(ListNode<Integer> root) {
		ListNode<Integer> cur = root, prev = null, next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

}
