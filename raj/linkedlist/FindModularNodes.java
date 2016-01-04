/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class FindModularNodes {

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

		FindModularNodes ob = new FindModularNodes();
		int k = 3;
		ListNode<Integer> result;
		// find the last element from beginning whose n%k ==0
		// if n=19,and k = 3, then find 18th node
		result = ob.findModularKnodeFromStart(obj.root, k);
		System.out.println(result);
		// find the last element from end whose n%k ==0
		// if n=19,and k = 3, then find 16th node
		result = ob.findModularKnodeFromEnd(obj.root, k);
		System.out.println(result);

	}

	public ListNode<Integer> findModularKnodeFromEnd(ListNode<Integer> root, int k) {
		if (k <= 0)
			return null;

		ListNode<Integer> temp = root, modularNode = null;
		for (int i = 1; i < k; i++) {
			if (temp != null)
				temp = temp.next;
		}

		if (temp == null) {
			return null;
		}
		while (temp != null) {
			temp = temp.next;
			if (modularNode == null) {
				modularNode = root;
			} else
				modularNode = modularNode.next;
		}
		return modularNode;
	}

	public ListNode<Integer> findModularKnodeFromStart(ListNode<Integer> root, int k) {
		if (k <= 0)
			return null;
		ListNode<Integer> temp = root, modularNode = null;
		int count = 1;
		while (temp != null) {
			if (count % k == 0) {
				modularNode = temp;
			}
			temp = temp.next;
			count++;
		}
		return modularNode;
	}

	public ListNode<Integer> findModularKnodeFromEnd(SingleLinkedList<Integer> obj, int k) {
		int n = obj.length();
		if (k == 0 || n == 0)
			return null;
		ListNode<Integer> temp = obj.root, modularNode = null;
		int count = 1;
		while (temp != null) {
			if (count % k == 0) {
				modularNode = temp;
			}
			temp = temp.next;
			count++;
		}
		return modularNode;
	}

}
