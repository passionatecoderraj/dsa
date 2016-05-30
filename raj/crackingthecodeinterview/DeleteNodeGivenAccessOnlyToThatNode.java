package com.raj.crackingthecodeinterview;

import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.ListNode;

/*
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
ex: 
input :c (remove c from the list a->b->c->d->e)
result : a->b->c->d->e

 */
public class DeleteNodeGivenAccessOnlyToThatNode {

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

		obj.print();
		DeleteNodeGivenAccessOnlyToThatNode ob = new DeleteNodeGivenAccessOnlyToThatNode();
		ob.deleteNodeGivenAccessOnlyToThatNode(obj.root.next.next);
		obj.print();
	}

	public void deleteNodeGivenAccessOnlyToThatNode(ListNode<Integer> node) {
		if (null == node || node.next == null)
			return;
		node.data = node.next.data;
		node.next = node.next.next;
	}

}