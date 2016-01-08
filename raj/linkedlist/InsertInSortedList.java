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
		ListNode<Integer> result, result2;
		result = ob.insertNodeInSortedList(obj, 35);
		obj.print();

		CircularLinkedList<Integer> obj2 = new CircularLinkedList<Integer>();
		obj2.insert(10);
		obj2.insert(20);
		obj2.insert(30);
		obj2.insert(40);
		obj2.insert(50);
		obj2.print();
		result2 = ob.insertNodeInSortedCircularList(obj2, 9);
		result2 = ob.insertNodeInSortedCircularList(obj2, 60);
		result2 = ob.insertNodeInSortedCircularList(obj2, 45);
		obj2.print();

	}

	public ListNode<Integer> insertNodeInSortedCircularList(CircularLinkedList<Integer> obj, int data) {
		ListNode<Integer> newNode = new ListNode<Integer>(data);
		if (obj.root == null) {
			obj.root = newNode;
			newNode.next = newNode;
		} else if (obj.root.data > newNode.data) {
			ListNode<Integer> temp = obj.root;
			while (temp.next != obj.root) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = obj.root;
			obj.root = newNode;
		} else {
			ListNode<Integer> temp = obj.root;
			ListNode<Integer> prev = null;

			while (temp.next != obj.root && newNode.data > temp.data) {
				prev = temp;
				temp = temp.next;
			}
			if (temp.next == obj.root) {
				newNode.next = obj.root;
				temp.next = newNode;
			} else {
				prev.next = newNode;
				newNode.next = temp;
			}
		}
		return newNode;
	}

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

}
