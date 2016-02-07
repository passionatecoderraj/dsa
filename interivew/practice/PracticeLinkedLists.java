package com.interivew.practice;

import java.util.List;

import com.interivew.graph.BinaryMinHeap;
import com.interivew.graph.CommonUtil;
import com.raj.linkedlist.CircularLinkedList;
import com.raj.linkedlist.DoubleLinkedList;
import com.raj.linkedlist.PalindromeCheckForList;
import com.raj.linkedlist.SingleLinkedList;
import com.raj.nodes.DLLNode;
import com.raj.nodes.ListNode;

public class PracticeLinkedLists {

	// Single Linked Lists
	// 1) insert at position
	// 2) delete at position
	// 3) Even Odd Check - both variations

	public <T> void insertAtPosition(SingleLinkedList<T> list, T data, int pos) {
		int n = list.length();
		if (pos <= 0 || pos > n + 1) {
			System.out.println("Not possible to insert at asked position");
			return;
		}

		ListNode<T> newNode = new ListNode<T>(data);

		if (pos == 1) {
			newNode.next = list.root;
			list.root = newNode;
		} else {
			ListNode<T> temp = list.root;
			int count = 1;
			while (count < pos - 1) {
				temp = temp.next;
				count++;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	public <T> void deleteAtPosition(SingleLinkedList<T> list, int pos) {
		int n = list.length();
		if (pos <= 0 || pos > n) {
			System.out.println("Not possible to delete at asked position");
			return;
		}

		if (pos == 1) {
			list.root = list.root.next;
		} else {
			ListNode<T> prev = list.root;
			int count = 1;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			ListNode<T> temp = prev.next;
			if (temp != null) {
				prev.next = temp.next;
			}
			temp = null;
		}
	}

	// double linked Lists
	// 1) insert at position
	// 2) delete at position
	public <T> void insertAtPosition(DoubleLinkedList<T> list, T data, int pos) {
		int n = list.length();
		if (pos <= 0 || pos > n + 1) {
			System.out.println("Not possible to insert at asked position");
			return;
		}

		DLLNode<T> newNode = new DLLNode<T>(data);

		if (pos == 1) {
			newNode.next = list.root;
			list.root = newNode;
		} else {
			DLLNode<T> prev = list.root;
			int count = 1;

			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			newNode.next = prev.next;
			prev.next = newNode;
			newNode.prev = prev;
			if (newNode.next != null) {
				newNode.next.prev = newNode;
			}
		}
	}

	public <T> void deleteAtPosition(DoubleLinkedList<T> list, int pos) {
		int n = list.length();
		if (pos <= 0 || pos > n) {
			System.out.println("Not possible to delete at asked position");
			return;
		}

		if (pos == 1) {
			if (list.root.next != null)
				list.root.next.prev = null;
			list.root = list.root.next;
		} else {
			DLLNode<T> prev = list.root;
			int count = 1;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			DLLNode<T> temp = prev.next;
			prev.next = temp.next;
			if (temp.next != null) {
				temp.next.prev = prev;
			}
			temp = null;
		}
	}
	// circular linked Lists
	// 1) insert at position
	// 2) delete at position

	public <T> void printInCLL(ListNode<T> curRoot) {
		ListNode<T> temp = curRoot;

		if (temp == null) {
			System.out.println("Empty");
			return;
		}

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			if (temp == curRoot)
				break;
		}
		System.out.println();
	}

	// Time : O(n)
	public <T> int length(CircularLinkedList<T> list) {
		int len = 0;
		ListNode<T> temp = list.root;
		while (temp != null) {
			len++;
			temp = temp.next;
			if (temp == list.root)
				break;
		}
		return len;
	}

	// Time : O(n)
	public <T> void insertAtPosition(CircularLinkedList<T> list, T data, int pos) {
		int n = list.length();
		if (pos <= 0 || pos > n + 1) {
			System.out.println("Not possible to insert at asked position");
			return;
		}

		ListNode<T> newNode = new ListNode<T>(data);

		if (pos == 1) {
			if (list.root == null) {
				newNode.next = newNode;
				list.root = newNode;
				return;
			}

			ListNode<T> lastNode = list.getLastNodeInCLL(list.root);
			lastNode.next = newNode;
			newNode.next = list.root;
			list.root = newNode;
		} else {
			int count = 1;
			ListNode<T> prev = list.root;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			newNode.next = prev.next;
			prev.next = newNode;
		}
	}

	// Time : O(n)
	public <T> void deleteAtPosition(CircularLinkedList<T> list, int pos) {
		int n = list.length();
		if (pos <= 0 || pos > n) {
			System.out.println("Not possible to delete at asked position");
			return;
		}
		if (n == 1) {
			list.root = null;
			return;
		}
		if (pos == 1) {
			ListNode<T> lastNode = list.getLastNodeInCLL(list.root);
			lastNode.next = list.root.next;
			list.root = list.root.next;
		} else {
			ListNode<T> prev = list.root;
			int count = 1;
			while (count < pos - 1) {
				prev = prev.next;
				count++;
			}
			ListNode<T> toBeDeleted = prev.next;
			prev.next = toBeDeleted.next;
			toBeDeleted = null;
		}

	}

	// Time : O(n)
	public ListNode<Integer> kthNodeFromEnd(SingleLinkedList<Integer> obj, int k) {
		int n = obj.length();
		if (k <= 0 || k > n) {
			return null;
		}

		ListNode<Integer> temp = obj.root;
		for (int i = 1; i < n - k + 1; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// Time : O(n)
	public ListNode<Integer> kthNodeFromEndInOneScan(SingleLinkedList<Integer> obj, int k) {
		ListNode<Integer> fast = obj.root;
		ListNode<Integer> slow = obj.root;
		for (int i = 0; i < k; i++) {
			if (fast != null)
				fast = fast.next;
			else
				return null;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

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

	// 2(m+k+l*x) = m+k+l*y (LHS is slow, RHS is fast)
	// assume x =0 and y =1 , then m+k =l -> m = l-k
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

	// Time : O(n)
	public ListNode<Integer> insertNodeInSortedList(SingleLinkedList<Integer> obj, int data) {
		ListNode<Integer> newNode = new ListNode<Integer>(data);
		if (obj.root == null) {
			obj.root = newNode;
		} else if (obj.root.data > newNode.data) {
			newNode.next = obj.root;
			obj.root = newNode;
		} else {
			ListNode<Integer> temp = obj.root;
			ListNode<Integer> prev = null;

			while (temp != null && newNode.data >= temp.data) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = newNode;
			newNode.next = temp;
		}
		return newNode;
	}

	// Time : O(n)
	public ListNode<Integer> insertNodeInSortedCircularList(CircularLinkedList<Integer> obj, int data) {
		ListNode<Integer> newNode = new ListNode<Integer>(data);
		if (obj.root == null) {
			obj.root = newNode;
			newNode.next = newNode;
		} else if (obj.root.data > newNode.data) {
			ListNode<Integer> lastNode = obj.getLastNodeInCLL(obj.root);
			lastNode.next = newNode;
			newNode.next = obj.root;
			obj.root = newNode;
		} else {
			ListNode<Integer> temp = obj.root;
			ListNode<Integer> prev = null;

			while (temp.next != null && newNode.data >= temp.data) {
				prev = temp;
				temp = temp.next;
				if (temp == obj.root)
					break;
			}
			prev.next = newNode;
			newNode.next = temp;
		}
		return newNode;
	}

	// Time : O(n)
	public void reverse(SingleLinkedList<Integer> obj) {
		ListNode<Integer> cur, next, prev;
		cur = obj.root;
		prev = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		obj.root = prev;
	}

	// using recursion
	// Time : O(n)
	public ListNode<Integer> reverse(ListNode<Integer> root, ListNode<Integer> prev) {
		if (root == null) {
			return root;
		}
		ListNode<Integer> next = root.next;
		root.next = prev;
		if (next == null)
			return root;
		return reverse(next, root);
	}

	// Time : O(n)
	public void reverse(DoubleLinkedList<Integer> obj) {
		DLLNode<Integer> cur = obj.root, next;

		if (cur == null) {
			return;
		}
		while (cur.next != null) {
			next = cur.next;
			cur.next = cur.prev;
			cur.prev = next;
			cur = next;
		}
		cur.next = cur.prev;
		cur.prev = null;

		obj.root = cur;
	}

	// Time : O(n)
	public void reverse(CircularLinkedList<Integer> obj) {
		if (null == obj.root)
			return;

		ListNode<Integer> cur, prev, next;
		cur = obj.root;
		prev = null;
		while (cur.next != obj.root) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		cur.next = prev;
		obj.root.next = cur;
		obj.root = cur;
	}

	// Time : O(n)
	public ListNode<Integer> findIntersection(SingleLinkedList<Integer> list1, SingleLinkedList<Integer> list2) {
		int n1 = list1.length(), n2 = list2.length();
		int d = Math.abs(n1 - n2);
		ListNode<Integer> temp1, temp2;

		if (n1 > n2) {
			temp1 = list1.root;
			temp2 = list2.root;
		} else {
			temp1 = list2.root;
			temp2 = list1.root;
		}
		for (int i = 0; i < d; i++) {
			temp1 = temp1.next;
		}

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data)
				return temp1;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return null;
	}

	// if list has either 7 or 6 elements, slow points to 4
	// Time : O(n)
	public ListNode<Integer> findMiddleInSingleTraversal(SingleLinkedList<Integer> obj) {
		ListNode<Integer> slow, fast;
		slow = fast = obj.root;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public SingleLinkedList<Integer> mergeIteratively(ListNode<Integer> t1, ListNode<Integer> t2) {
		SingleLinkedList<Integer> result = new SingleLinkedList<Integer>();

		while (t1 != null && t2 != null) {
			if (t1.data <= t2.data) {
				result.insert(t1.data);
				t1 = t1.next;
			} else {
				result.insert(t2.data);
				t2 = t2.next;
			}
		}

		while (t1 != null) {
			result.insert(t1.data);
			t1 = t1.next;
		}
		while (t2 != null) {
			result.insert(t2.data);
			t2 = t2.next;
		}

		return result;
	}

	public ListNode<Integer> merge(ListNode<Integer> r1, ListNode<Integer> r2) {
		if (r1 == null)
			return r2;
		if (r2 == null)
			return r1;
		if (r1.data <= r2.data) {
			r1.next = merge(r1.next, r2);
			return r1;
		} else {
			r2.next = merge(r1, r2.next);
			return r2;
		}
	}

	public ListNode<Integer> mergeSort(ListNode<Integer> root) {
		if (null == root || root.next == null)
			return root;
		ListNode<Integer> head1 = root, head2;
		ListNode<Integer> slow, fast;
		slow = fast = root;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		head2 = slow.next;
		slow.next = null;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		return merge(head1, head2);
	}

	public DLLNode<Integer> merge(DLLNode<Integer> head1, DLLNode<Integer> head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if (head1.data <= head2.data) {
			head1.next = merge(head1.next, head2);
			head1.next.prev = head1;
			head1.prev = null;
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
			head2.next.prev = head2;
			head2.prev = null;
			return head2;
		}
	}

	public DLLNode<Integer> mergeSort(DLLNode<Integer> root) {
		if (null == root || root.next == null)
			return root;
		DLLNode<Integer> head1 = root, head2;
		DLLNode<Integer> slow, fast;
		slow = fast = root;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		head2 = slow.next;
		head2.prev = null;
		slow.next = null;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		return merge(head1, head2);
	}

	public void reverseInPairsRecursively(ListNode<Integer> root) {
		if (root != null && root.next != null) {
			CommonUtil.swap(root, root.next);
			reverseInPairsRecursively(root.next.next);
		}
	}

	public void reverseInPairs(SingleLinkedList<Integer> obj) {
		ListNode<Integer> fast = obj.root;
		while (fast != null && fast.next != null) {
			CommonUtil.swap(fast, fast.next);
			fast = fast.next.next;
		}
	}

	public ListNode<Integer> reverseKElementsRecursviely(ListNode<Integer> root, int k) {
		ListNode<Integer> cur = root, prev = null, next;
		int count = 0;
		while (cur != null && count < k) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}

		if (cur != null) {
			root.next = reverseKElementsRecursviely(cur, k);
		}
		return prev;
	}

	public boolean isPalindrome(ListNode<Integer> root) {
		if (root == null || root.next == null)
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
		root2 = new PalindromeCheckForList().reverse(root2);
		boolean isPalindrome = new PalindromeCheckForList().isSame(root1, root2);
		root2 = new PalindromeCheckForList().reverse(root2);
		if (extraNode != null) {
			pre.next = extraNode;
		} else {
			slow.next = root2;
		}
		return isPalindrome;
	}

	public int getJosephusPosition(ListNode<Integer> root, int m) {
		ListNode<Integer> node = root;
		while (node.next != node) {
			for (int i = 1; i < m - 1; i++) {
				node = node.next;
			}
			node.next = node.next.next;
			node = node.next;
		}

		return node.data;
	}

	// find the last element from beginning whose n%k ==0
	// if n=19,and k = 3, then find 18th node
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

	// find the last element from end whose n%k ==0
	// if n=19,and k = 3, then find 16th node
	public ListNode<Integer> findModularKnodeFromEnd(ListNode<Integer> root, int k) {
		if (k <= 0)
			return null;

		ListNode<Integer> temp = root, modularNode = root;
		for (int i = 0; i < k; i++) {
			if (temp != null)
				temp = temp.next;
			else
				return null;
		}

		while (temp != null) {
			temp = temp.next;
			modularNode = modularNode.next;
		}
		return modularNode;
	}

	public ListNode<Integer> rotateWithoutReverse(ListNode<Integer> root, int k) {
		if (k <= 0)
			return root;

		ListNode<Integer> temp = root, newRoot = null, temp2;
		for (int i = 1; i < k; i++) {
			if (temp != null)
				temp = temp.next;
		}
		if (temp == null)
			return root;

		newRoot = temp.next;
		temp.next = null;
		temp2 = newRoot;

		while (temp2.next != null) {
			temp2 = temp2.next;
		}
		temp2.next = root;

		return newRoot;
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

		// swapping previous elements next
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

		// swapping next of current elements next
		ListNode<Integer> temp = tempX.next;
		tempX.next = tempY.next;
		tempY.next = temp;
	}

	// First List: 7->5->9->4->6 // represents number 64957
	// Second List: 8->4 // represents number 48
	public ListNode<Integer> addTwoNumbers(ListNode<Integer> temp1, ListNode<Integer> temp2) {
		SingleLinkedList<Integer> result = new SingleLinkedList<Integer>();

		int carry = 0, sum = 0, val1 = 0, val2 = 0;
		while (temp1 != null || temp2 != null) {
			val1 = (temp1 != null) ? temp1.data : 0;
			val2 = (temp2 != null) ? temp2.data : 0;
			sum = val1 + val2 + carry;
			carry = sum >= 10 ? 1 : 0;
			sum = sum % 10;
			result.insert(sum);

			if (temp1 != null)
				temp1 = temp1.next;
			if (temp2 != null)
				temp2 = temp2.next;
		}

		if (carry > 0) {
			result.insert(1);
		}

		return result.root;
	}

	// Time : O(n)
	public void removeDuplicatesInSortedList(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return;
		while (root.next != null) {
			if (root.next.data == root.data)
				root.next = root.next.next;
			else
				root = root.next.next;
		}
	}

	// Time : O(n)
	public void removeDuplicatesInSortedCircularList(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return;
		ListNode<Integer> cur = root;

		while (cur.next != root) {
			if (cur.next.data == cur.data)
				cur.next = cur.next.next;
			else
				cur = cur.next.next;
		}
	}

	// Time : O(n2)
	public void removeDuplicatesInUnsortedList(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return;
		ListNode<Integer> cur1, cur2;
		cur1 = root;
		while (cur1 != null && cur1.next != null) {
			cur2 = cur1;
			while (cur2.next != null) {
				if (cur1.data == cur2.next.data)
					cur2.next = cur2.next.next;
				else
					cur2 = cur2.next;
			}
			cur1 = cur1.next;
		}
	}

	// Time : O(nlogn)
	public ListNode<Integer> removeDuplicatesInUnsortedListUsingSorting(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return root;
		root = mergeSort(root);
		removeDuplicatesInSortedList(root);
		return root;
	}

	// Time : O(n2)
	public void removeDuplicatesInUnsortedCircularList(ListNode<Integer> root) {
		if (root == null || root.next == null)
			return;
		ListNode<Integer> cur1, cur2;
		cur1 = root;
		while (cur1 != null && cur1.next != root) {
			cur2 = cur1;
			while (cur2.next != root) {
				if (cur1.data == cur2.next.data)
					cur2.next = cur2.next.next;
				else
					cur2 = cur2.next;
			}
			cur1 = cur1.next;
		}
	}

	// Time : O(nlogn)
	public ListNode<Integer> removeDuplicatesInUnsortedCircularListUsingSorting(ListNode<Integer> root) {
		if (root == null || root.next == root)
			return root;
		ListNode<Integer> last;
		last = new CircularLinkedList<Integer>().getLastNodeInCLL(root);
		last.next = null;
		root = mergeSort(root);
		removeDuplicatesInSortedCircularList(root);
		last = new CircularLinkedList<Integer>().getLastNodeInCLL(root);
		last.next = root;
		return root;
	}

	public ListNode<Integer> removeAllNodesOfData(ListNode<Integer> root, int data) {
		if (root == null)
			return root;
		ListNode<Integer> cur, head;
		head = new ListNode<Integer>(0);
		head.next = root;
		cur = head;
		while (cur.next != null) {
			if (cur.next.data == data)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return head.next;
	}

	public ListNode<Integer> mergeKSortedLists(List<ListNode<Integer>> list) {
		if (null == list)
			return null;
		BinaryMinHeap<ListNode<Integer>> heap = new BinaryMinHeap<>();

		int k = list.size();
		ListNode<Integer> temp = null;

		for (int i = 0; i < k; i++) {
			temp = list.get(i);
			if (temp != null)
				heap.add(temp.data, temp);
		}
		ListNode<Integer> head = null, cur = null;

		while (heap.size() > 0) {
			temp = heap.extractMin();
			if (null == head) {
				head = temp;
				cur = head;
			} else {
				cur.next = temp;
				cur = cur.next;
			}
			if (temp.next != null) {
				heap.add(temp.next.data, temp.next);
			}
		}
		return head;
	}

}