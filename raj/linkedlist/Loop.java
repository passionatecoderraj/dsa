/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class Loop {

	public boolean hasLoop(SingleLinkedList<Integer> list) {
		ListNode<Integer> slow, fast;
		slow = fast = list.root;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public ListNode<Integer> beginingOfLoop(SingleLinkedList<Integer> list) {
		ListNode<Integer> slow, fast;
		slow = fast = list.root;
		boolean loopExists = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExists = true;
				break;
			}
		}
		if (loopExists) {
			slow = list.root;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}

	public int loopLength(SingleLinkedList<Integer> list) {
		ListNode<Integer> slow, fast;
		slow = fast = list.root;
		boolean loopExists = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExists = true;
				break;
			}
		}
		if (loopExists) {
			int len = 1;
			while (fast.next != slow) {
				fast = fast.next;
				len++;
			}
			return len;
		}
		return 0;
	}

	public void removeLoop(SingleLinkedList<Integer> list) {
		ListNode<Integer> fast, slow;
		slow = fast = list.root;
		boolean loopExists = false;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExists = true;
				break;
			}
		}
		if (loopExists) {
			slow = list.root;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> obj = new SingleLinkedList<Integer>();
		obj.insert(10);
		obj.insert(20);
		obj.insert(30);
		ListNode<Integer> node4 = obj.insert(40);
		obj.insert(50);
		obj.insert(60);
		obj.insert(70);
		obj.insert(80);
		ListNode<Integer> node9 = obj.insert(90);
		node9.next = node4;
		// obj.print();
		boolean result = false;
		ListNode<Integer> resultNode = null;
		int resultLength = -1;
		Loop ob = new Loop();
		result = ob.hasLoop(obj);
		System.out.println(result);
		resultNode = ob.beginingOfLoop(obj);
		System.out.println(resultNode);
		resultLength = ob.loopLength(obj);
		System.out.println(resultLength);
		ob.removeLoop(obj);
		obj.print();
	}

}
