/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class CircularLinkedList<T> {
	ListNode<T> root;

	public void insert(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		if (root == null) {
			root = newNode;
		} else {
			ListNode<T> temp = root;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void print() {
		ListNode<T> temp = root;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Time : O(n)
	public int length() {
		int len = 0;
		ListNode<T> temp = root;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		return len++;
	}

	// Time : O(n)
	public void insertAtPosition(T data, int pos) {
		int n = length();
		if (pos <= 0 || pos > n + 1) {
			System.out.println("Not possible to insert at asked position");
			return;
		}

		ListNode<T> newNode = new ListNode<T>(data);

		if (pos == 1) {
			newNode.next = root;
			root = newNode;
		} else {
			ListNode<T> temp = root;
			int count = 1;
			while (count < pos - 1) {
				temp = temp.next;
				count++;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	// Time : O(n)
	public void deleteAtPosition(int pos) {
		int n = length();
		if (pos <= 0 || pos > n) {
			System.out.println("Not possible to delete at asked position");
			return;
		}

		if (pos == 1) {
			ListNode<T> temp = root.next;
			root = root.next;
			temp = null;
		} else {
			ListNode<T> prev = root;
			int count = 1;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			ListNode<T> temp = prev.next;
			if (temp != null) {
				prev.next = temp.next;
			}
			temp = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularLinkedList<Integer> obj = new CircularLinkedList<Integer>();
		obj.insert(10);
		obj.insert(20);
		obj.insert(30);
		obj.insert(40);
		obj.insert(50);
		obj.insertAtPosition(35, 4);
		obj.insertAtPosition(5, 1);
		obj.print();
		obj.deleteAtPosition(5);
		obj.print();

	}

}
