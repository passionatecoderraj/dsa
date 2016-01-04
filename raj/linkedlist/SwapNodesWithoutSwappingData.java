/**
 * 
 */
package com.raj.linkedlist;

import com.raj.nodes.ListNode;

/**
 * @author Raj
 *
 */
public class SwapNodesWithoutSwappingData {

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
		int x = 12, y = 13;

		SwapNodesWithoutSwappingData ob = new SwapNodesWithoutSwappingData();
		ob.swapNodesWithoutSwappingData(obj, x, y);
		obj.print();
	}

	public void swapNodesWithoutSwappingData(SingleLinkedList<Integer> obj, int x, int y) {
		if (x == y) {
			return;
		}
		ListNode<Integer> tempX = obj.root, tempY = obj.root, prevX = null, prevY = null;
		boolean isXFound, isYFound;
		isXFound = isYFound = false;
		while (tempX != null) {
			if (tempX.data == x) {
				isXFound = true;
				break;
			}
			prevX = tempX;
			tempX = tempX.next;
		}
		if (!isXFound) {
			return;
		}

		tempY = obj.root;
		while (tempY != null) {
			if (tempY.data == y) {
				isYFound = true;
				break;
			}
			prevY = tempY;
			tempY = tempY.next;
		}

		if (!isYFound) {
			return;
		}

		// check if X if first element
		if (prevX == null)
			obj.root = tempY;
		else
			prevX.next = tempY;

		// check if Y if first elements
		if (prevY == null)
			obj.root = tempX;
		else
			prevY.next = tempX;

		// swap elements
		ListNode<Integer> temp = tempX.next;
		tempX.next = tempY.next;
		tempY.next = temp;
	}

}
