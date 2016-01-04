/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class KthNodeFromEnd {

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

		KthNodeFromEnd ob = new KthNodeFromEnd();
		int k = 3;
		ListNode<Integer> result;
		result = ob.kthNodeFromEnd(obj, k);
		System.out.println(result);
		result = ob.kthNodeFromEndInOneScan(obj, k);
		System.out.println(result);

	}

	// Time : O(n)
	public ListNode<Integer> kthNodeFromEnd(SingleLinkedList<Integer> obj, int k) {
		int n = obj.length();
		if (k <= 0 || k > n) {
			return null;
		}

		ListNode<Integer> temp = obj.root;
		for (int i = 1; i < n - k + 1; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// Time : O(n)
	public ListNode<Integer> kthNodeFromEndInOneScan(SingleLinkedList<Integer> obj, int k) {
		ListNode<Integer> fast = obj.root;
		ListNode<Integer> slow = null;
		for (int i = 1; i < k; i++) {
			if (fast != null)
				fast = fast.next;
		}
		while (fast != null) {
			if (slow == null) {
				slow = obj.root;
			} else {
				slow = slow.next;
			}
			fast = fast.next;
		}

		return slow;
	}

}
