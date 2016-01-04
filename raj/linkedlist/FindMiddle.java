/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class FindMiddle {
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

		// mid of 6 numbers is 4th one
		// mid of 5 numbers is 3rd one

		FindMiddle ob = new FindMiddle();
		ListNode<Integer> result;
		result = ob.findMiddle(obj);
		System.out.println(result);
		result = ob.findMiddleInSingleTraversal(obj);
		System.out.println(result);

	}

	// if list has either 7 or 6 elements, slow points to 4
	public ListNode<Integer> findMiddleInSingleTraversal(SingleLinkedList<Integer> obj) {
		ListNode<Integer> slow, fast;
		slow = fast = obj.root;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public ListNode<Integer> findMiddle(SingleLinkedList<Integer> obj) {
		int n = obj.length();
		if (n <= 0)
			return null;
		ListNode<Integer> temp = obj.root;

		for (int i = 0; i < n / 2; i++) {
			temp = temp.next;
		}

		return temp;
	}

}
