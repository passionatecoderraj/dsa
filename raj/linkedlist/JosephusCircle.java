/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class JosephusCircle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.insert(i);
		}
		int result = -1, m = 2;
		// 'm' must be greater than 1
		JosephusCircle obj = new JosephusCircle();
		result = obj.getJosephusPosition(list.root, m);
		System.out.println(result);
	}

	public int getJosephusPosition(ListNode<Integer> root, int m) {
		
		ListNode<Integer> node = root;
		int count = 1;
		while (node.next != node) {
			while (node.next != node && count < m - 1) {
				node = node.next;
				count++;
			}
			if (node.next != node) {
				node.next = node.next.next;
				node = node.next;
			}
			count = 1;
		}

		return node.data;
	}

}
