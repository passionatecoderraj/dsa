package com.interview.practice;

import com.interview.graph.CommonUtil;
import com.raj.linkedlist.DoubleLinkedList;
import com.raj.nodes.DLLNode;
import com.raj.nodes.ListNode;

public class PracticeSortingRelated2 {

	public void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	public int partition(int a[], int p, int r) {
		int key = a[r], j = p;
		for (int i = p; i < r; i++) {
			if (a[i] <= key) {
				CommonUtil.swap(a, i, j++);
			}
		}
		CommonUtil.swap(a, r, j);
		return j;
	}

	public int quickSelectFindKthSmallest(int a[], int low, int high, int k) {
		if (low <= high) {
			int pivot = partition(a, low, high);
			if (pivot - low == k) {
				return a[pivot];
			} else if (k > pivot - low) {
				// right sub array
				// position of k is changed ,it's k - length of left side -
				// 1(pivot)
				return quickSelectFindKthSmallest(a, pivot + 1, high, k - (pivot - low) - 1);
			} else {
				// lest sub array
				return quickSelectFindKthSmallest(a, low, pivot - 1, k);
			}
		}
		return -1;
	}

	public int quickSelectRandomPartition(int a[], int low, int high, int k) {
		if (low <= high) {
			int pivot = randomPartition(a, low, high);
			if (pivot - low == k) {
				return a[pivot];
			} else if (k > pivot - low) {
				return quickSelectRandomPartition(a, pivot + 1, high, k - (pivot - low) - 1);
			} else {
				return quickSelectRandomPartition(a, low, pivot - 1, k);
			}
		}
		return -1;
	}

	public int randomPartition(int[] a, int low, int high) {
		int n = high - low + 1;
		int rand = (int) ((Math.random() * n) + low);
		CommonUtil.swap(a, rand, high);
		return partition(a, low, high);
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

	public void mergeSort(int a[], int p, int r) {
		if (p < r) {
			int q = p + (r - p) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

	public void merge(int[] a, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int b[] = new int[n1];
		int c[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			b[i] = a[p + i];
		}

		for (int i = 0; i < n1; i++) {
			c[i] = a[q + 1 + i];
		}

		int i, j, k;
		i = j = 0;
		k = p;
		while (i < n1 && j < n2) {
			if (b[i] <= c[j]) {
				a[k++] = b[i++];
			} else {
				a[k++] = c[j++];
			}
		}
		while (i < n1) {
			a[k++] = b[i++];
		}
		while (j < n2) {
			a[k++] = c[j++];
		}
	}

	public ListNode<Integer> mergeSort(ListNode<Integer> root) {
		if (null == root || root.next == null)
			return root;
		ListNode<Integer> slow, fast;
		slow = fast = root;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode<Integer> root2 = slow.next;
		slow.next = null;
		mergeSort(root);
		mergeSort(root2);

		return merge(root, root2);
	}

	public ListNode<Integer> merge(ListNode<Integer> r1, ListNode<Integer> r2) {
		if (null == r1)
			return r2;
		if (null == r2)
			return r1;
		if (r1.data <= r2.data) {
			r1.next = merge(r1.next, r2);
			return r1;
		} else {
			r2.next = merge(r1, r2.next);
			return r2;
		}
	}

	public DLLNode<Integer> mergeSort(DLLNode<Integer> root) {
		if (null == root || root.next == null)
			return root;
		DLLNode<Integer> slow, fast;
		slow = fast = root;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		DLLNode<Integer> root2 = slow.next;
		slow.next = null;
		root2.prev = null;
		mergeSort(root);
		mergeSort(root2);

		return merge(root, root2);
	}

	public DLLNode<Integer> merge(DLLNode<Integer> r1, DLLNode<Integer> r2) {
		if (null == r1)
			return r2;
		if (null == r2)
			return r1;
		if (r1.data <= r2.data) {
			r1.next = merge(r1.next, r2);
			r1.prev = null;
			r1.next.prev = r1;
			return r1;
		} else {
			r2.next = merge(r1, r2.next);
			r2.prev = null;
			r2.next.prev = r2;
			return r2;
		}
	}
}
