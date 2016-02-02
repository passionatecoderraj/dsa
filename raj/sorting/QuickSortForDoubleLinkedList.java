/**
 * 
 */
package com.raj.sorting;

import com.interivew.graph.CommonUtil;
import com.raj.linkedlist.DoubleLinkedList;
import com.raj.nodes.DLLNode;

/**
 * @author Raj
 *
 */
public class QuickSortForDoubleLinkedList {

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

		QuickSortForDoubleLinkedList ob = new QuickSortForDoubleLinkedList();
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
			// new DoubleLinkedList<Integer>().print(root);
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
				CommonUtil.swap(i, j);
				j = j.next;
			}
			i = i.next;
		}
		CommonUtil.swap(j, lastNode);
		return j;
	}

}
