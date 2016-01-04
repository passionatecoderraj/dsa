/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class InsertInSortedList {

	// Time : O(n)
	public ListNode<Integer> insertNodeInSortedList(SingleLinkedList<Integer> obj, int data) {
		ListNode<Integer> newNode = new ListNode<Integer>(data);
		if (obj.root == null) {
			obj.root = newNode;
		} else if (obj.root.data > newNode.data) {
			newNode.next = obj.root;
			obj.root = newNode;
		} else {
			ListNode<Integer> temp = obj.root;
			ListNode<Integer> prev = null;

			while (temp != null && newNode.data > temp.data) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = newNode;
			newNode.next = temp;
		}
		return newNode;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(10);
		obj.insert(20);
		obj.insert(30);
		obj.insert(40);
		obj.insert(50);
		obj.print();

		InsertInSortedList ob = new InsertInSortedList();
		ListNode<Integer> result;
		result = ob.insertNodeInSortedList(obj, 30);
		obj.print();
	}

}
