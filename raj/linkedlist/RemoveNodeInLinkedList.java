/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class RemoveNodeInLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();

		list.insert(12);
		list.insert(12);
		list.insert(21);
		list.insert(12);
		list.insert(41);
		list.insert(43);
		list.insert(21);

		RemoveNodeInLinkedList obj = new RemoveNodeInLinkedList();

		int val = 12;

		// Time :O(n)
		list.print();
		list.root = obj.removeNodesInList(list.root, val);
		list.print();

	}

	public ListNode<Integer> removeNodesInList(ListNode<Integer> root, int data) {

		if (root == null)
			return root;
		ListNode<Integer> cur, head;
	
		head = new ListNode<Integer>(0);
		head.next = root;
		
		cur = head;
		while (cur.next != null) {
			if (cur.next.data == data)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return head.next;
	}

}
