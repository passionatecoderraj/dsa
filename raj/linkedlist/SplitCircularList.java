/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class SplitCircularList<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularLinkedList<Integer> obj = new CircularLinkedList<Integer>();
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

		// splits at 4 for 7 numbers(1 number extra in 1st list)
		// splits at 3 for 6 numbers

		obj.print();
		SplitCircularList<Integer> ob = new SplitCircularList<Integer>();
		ob.splitCLL(obj.root);
	}

	public void splitCLL(ListNode<Integer> root) {
		ListNode<Integer> slow, fast, root2 = null;
		// if there is only one element second list is not possible. checking
		// for that here
		if (root.next != root) {
			fast = slow = root;
			while (fast.next != root && fast.next.next != root) {
				slow = slow.next;
				fast = fast.next.next;
			}

			root2 = slow.next;
			if (fast.next.next == root) {
				fast = fast.next;
			}

			slow.next = root;
			fast.next = root2;
		}

		new CircularLinkedList<Integer>().print(root);
		new CircularLinkedList<Integer>().print(root2);
	}

}
