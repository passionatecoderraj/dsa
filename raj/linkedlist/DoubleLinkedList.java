/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.DLLNode;

/**
 * @author Raj
 *
 */
public class DoubleLinkedList<T> {
	public DLLNode<T> root;

	public void insert(T data) {
		DLLNode<T> newNode = new DLLNode<T>(data);
		if (null == root) {
			root = newNode;
		} else {
			DLLNode<T> temp = root;
			while (temp.next != null) {
				temp = temp.next;
			}
			newNode.prev = temp;
			temp.next = newNode;
		}
	}

	public void print(DLLNode<T> temp) {
		if (temp == null) {
			System.out.println("Empty");
			return;
		}
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void print() {
		DLLNode<T> temp = root;
		if (temp == null) {
			System.out.println("Empty");
			return;
		}

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void printFromEnd() {
		DLLNode<T> temp = root;
		while (temp.next != null) {
			temp = temp.next;
		}

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.println();
	}

	// Time : O(n)
	public int length() {
		int len = 0;
		DLLNode<T> temp = root;
		while (temp != null) {
			temp = temp.next;
			len++;
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

		DLLNode<T> newNode = new DLLNode<T>(data);

		if (pos == 1) {
			newNode.next = root;
			root = newNode;
		} else {
			DLLNode<T> prev = root;
			int count = 1;

			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			newNode.next = prev.next;
			prev.next = newNode;
			newNode.prev = prev;
			if (newNode.next != null) {
				newNode.next.prev = newNode;
			}
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
			if (root.next != null)
				root.next.prev = null;
			root = root.next;
		} else {
			DLLNode<T> prev = root;
			int count = 1;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			DLLNode<T> temp = prev.next;
			if (temp != null) {
				prev.next = temp.next;
				if (prev.next != null) {
					prev.next.prev = prev;
				}
			}
			temp = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleLinkedList<Integer> obj = new DoubleLinkedList<Integer>();
		obj.insert(10);
		obj.insert(20);
		obj.insert(30);
		obj.insert(40);
		obj.insert(50);
		obj.insertAtPosition(35, 4);
		obj.insertAtPosition(5, 1);
		obj.deleteAtPosition(5);
		obj.print();
		obj.printFromEnd();
	}

}
