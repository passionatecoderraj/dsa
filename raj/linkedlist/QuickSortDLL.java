/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.DLLNode;
import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class QuickSortDLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleLinkedList<Integer> obj = new DoubleLinkedList<Integer>();
		obj.insert(9);
		obj.insert(6);
		obj.insert(3);
		obj.insert(7);
		obj.insert(1);
		obj.insert(2);
		obj.insert(8);
		obj.insert(4);
		obj.insert(5);

		QuickSortDLL ob = new QuickSortDLL();
		obj.print();
		ob.quickSort(obj);
		obj.print();
	}

	public void quickSort(DoubleLinkedList<Integer> list) {
		DLLNode<Integer> lastNode = list.root;
		if (lastNode == null) {
			return;
		}
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		quickSort(list.root, lastNode);
	}

	public void quickSort(DLLNode<Integer> root, DLLNode<Integer> lastNode) {
		if (root != lastNode && lastNode != null && root != lastNode.next) {
			DLLNode<Integer> p = partition(root, lastNode);
	//		new DoubleLinkedList<Integer>().print(root);
			quickSort(root, p.prev);
			quickSort(p.next, lastNode);
		}
	}

	public DLLNode<Integer> partition(DLLNode<Integer> root, DLLNode<Integer> lastNode) {
		int key = lastNode.data;
		DLLNode<Integer> j = root;
		DLLNode<Integer> i = root;
		while (i != lastNode) {
			if (i.data <= key) {
				swap(i, j);
				j = j.next;
			}
			i = i.next;
		}
		swap(j, lastNode);
		return j;
	}

	public void swap(DLLNode<Integer> i, DLLNode<Integer> j) {
		int temp = i.data;
		i.data = j.data;
		j.data = temp;
	}

}
