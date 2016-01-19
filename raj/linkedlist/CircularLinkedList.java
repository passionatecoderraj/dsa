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
	public ListNode<T> root;

	public void insert(T data) {
		ListNode<T> newNode = new ListNode<T>(data);
		if (root == null) {
			newNode.next = newNode;
			root = newNode;
		} else {
			ListNode<T> temp = root;
			while (temp.next != root) {
				temp = temp.next;
			}
			newNode.next = root;
			temp.next = newNode;
		}
	}

	public void print() {
		ListNode<T> temp = root;
		if (temp == null) {
			System.out.println("Empty");
			return;
		}

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			if (temp == root)
				break;
		}
		System.out.println();
	}

	public void print(ListNode<T> curRoot) {
		ListNode<T> temp = curRoot;

		if (temp == null) {
			System.out.println("Empty");
			return;
		}

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			if (temp == curRoot)
				break;
		}
		System.out.println();
	}

	public void printUsingDoWhile() {
		ListNode<T> temp = root;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != root);

		System.out.println();
	}

	// Time : O(n)
	public ListNode<T> getLastNodeInCLL(ListNode<T> curRoot) {
		if (curRoot == null) {
			return null;
		}
		ListNode<T> temp = curRoot;
		while (temp.next != curRoot) {
			temp = temp.next;
		}
		return temp;
	}

	// Time : O(n)
	public int length() {
		int len = 0;
		ListNode<T> temp = root;
		while (temp != null) {
			len++;
			temp = temp.next;
			if (temp == root)
				break;
		}
		return len;
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
			ListNode<T> temp = root;
			while (temp.next != root) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = root;
			root = newNode;
		} else {
			int count = 1;
			ListNode<T> prev = root;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			newNode.next = prev.next;
			prev.next = newNode;
		}
	}

	// Time : O(n)
	public void deleteAtPosition(int pos) {
		int n = length();
		if (pos <= 0 || pos > n) {
			System.out.println("Not possible to delete at asked position");
			return;
		}

		if (n == 1) {
			root = null;
			return;
		}

		if (pos == 1) {
			ListNode<T> temp = root;
			while (temp.next != root) {
				temp = temp.next;
			}
			root = root.next;
			temp.next = root;
		} else {
			ListNode<T> prev = root;
			int count = 1;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			ListNode<T> toBeDeleted = prev.next;
			prev.next = toBeDeleted.next;
			toBeDeleted = null;
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
		obj.insertAtPosition(60, 8);
		obj.print();
		obj.deleteAtPosition(5);
		obj.print();
		obj.deleteAtPosition(1);
		obj.print();
		obj.deleteAtPosition(6);
		obj.print();

	}

}
