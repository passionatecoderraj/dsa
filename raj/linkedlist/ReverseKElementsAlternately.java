/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class ReverseKElementsAlternately {

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

		ReverseKElementsAlternately ob = new ReverseKElementsAlternately();
		obj.print();

		int k = 3;
		// Time : O(n)
		obj.root = ob.reverseAlternateKElements(obj.root, k, true);
		obj.print();

	}

	public ListNode<Integer> reverseAlternateKElements(ListNode<Integer> root, int k, boolean rev) {
		ListNode<Integer> cur = root, prev = null, next;
		int count = 1;
		if (rev) {
			while (cur != null && count <= k) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
				count++;
			}
		} else {
			while (cur != null && count <= k) {
				prev = cur;
				cur = cur.next;
				count++;
			}
		}

		if (cur != null) {
			if (rev)
				root.next = reverseAlternateKElements(cur, k, !rev);
			else
				prev.next = reverseAlternateKElements(cur, k, !rev);
		}
		if (rev)
			return prev;
		else
			return root;
	}

}
