/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class SingleLinkedList<T> implements Cloneable {
	public ListNode<T> root;

	@SuppressWarnings("unchecked")
	public Object clone() {
		try {
			return (SingleLinkedList<T>) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ListNode<T> insert(T data) {
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
		return newNode;
	}

	public ListNode<T> getLastNode(ListNode<T> temp) {
		if(temp==null)
			return temp;
		while(temp.next!=null)
			temp = temp.next;
		return temp;
	}

	
	public void print(ListNode<T> temp) {
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
		ListNode<T> temp = root;
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

	// Time : O(n)
	public int length() {
		int len = 0;
		ListNode<T> temp = root;
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
			root = root.next;
		} else {
			ListNode<T> prev = root;
			int count = 1;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			ListNode<T> temp = prev.next;
			prev.next = temp.next;
		}
	}

	public int lengthRecursive(ListNode<T> node) {
		if (node == null)
			return 0;
		return 1 + lengthRecursive(node.next);
	}

	public boolean isEvenLength() {
		ListNode<T> fast = root;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
		}
		if (fast == null) {
			return true;
		}
		return false;
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
		obj.insertAtPosition(35, 4);
		obj.insertAtPosition(5, 1);
		obj.print();
		obj.deleteAtPosition(7);
		obj.print();
		System.out.println(obj.length());
		System.out.println(obj.lengthRecursive(obj.root));
		System.out.println(obj.isEvenLength());
	}

}
