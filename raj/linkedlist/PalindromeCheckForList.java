/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class PalindromeCheckForList {

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
		obj.insert(14);
		obj.insert(13);
		obj.insert(12);
		obj.insert(11);

		boolean result = false;
		PalindromeCheckForList ob = new PalindromeCheckForList();
		result = ob.isPalindrome(obj.root);
		System.out.println(result);
	}

	public boolean isPalindrome(ListNode<Integer> root) {

		
		if (root.next == null)
			return true;

		ListNode<Integer> slow, fast, root1, root2, pre = null, extraNode = null;
		root1 = root2 = null;
		slow = fast = root;
		while (fast.next != null && fast.next.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		root1 = root;
		root2 = slow.next;
		if (fast.next == null) {
			extraNode = slow;
			pre.next = null;
		} else {
			slow.next = null;
		}
		root2 = reverse(root2);
		boolean isPalindrome = isSame(root1, root2);
		root2 = reverse(root2);
		if (extraNode != null) {
			pre.next = extraNode;
		} else {
			slow.next = root2;
		}
		return isPalindrome;
	}

	public boolean isSame(ListNode<Integer> t1, ListNode<Integer> t2) {
		while (t1 != null && t2 != null) {
			if (t1.data != t2.data)
				return false;
			t1 = t1.next;
			t2 = t2.next;
		}

		if (t1 != null || t2 != null)
			return false;

		return true;
	}

	public ListNode<Integer> reverse(ListNode<Integer> root) {
		ListNode<Integer> cur = root, prev = null, next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

}
