package com.interview.practice;

import com.interview.graph.CommonUtil;
import com.interview.graph.MinHeap;
import com.raj.nodes.DLLNode;
import com.raj.nodes.ListNode;
import com.raj.sorting.MaxHeap;

public class PracticeSortingRelated {
	public void selectionSort(int[] a, int n) {
		int min_index = -1, temp;
		for (int i = 0; i < n; i++) {
			min_index = i;
			for (int j = i + 1; j < n; j++) {
				if (a[min_index] > a[j]) {
					min_index = j;
				}
			}
			if (min_index != i) {
				temp = a[min_index];
				a[min_index] = a[i];
				a[i] = temp;
			}
		}
	}

	public void bubbleSort(int[] a, int n) {
		boolean isSwapped = false;
		for (int i = 1; i <= n; i++) {
			isSwapped = false;
			for (int j = 0; j < n - i; j++) {
				if (a[j] > a[j + 1]) {
					CommonUtil.swap(a, j, j + 1);
					isSwapped = true;
				}
			}
			if (!isSwapped)
				break;
		}
	}

	public void insertionSort(int[] a, int n) {
		int key, j;
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	int heapSize;

	public void buildMaxHeap(int a[]) {
		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			maxHeapify(a, i);
		}
	}

	public void maxHeapify(int a[], int i) {
		int largest, left, right;
		left = (2 * i) + 1;
		right = (2 * i) + 2;

		largest = i;
		if (left < heapSize && a[left] > a[largest]) {
			largest = left;
		}

		if (right < heapSize && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != i) {
			CommonUtil.swap(a, largest, i);
			maxHeapify(a, largest);
		}
	}

	public void heapSort(int[] a, int n) {
		MaxHeap heap = new MaxHeap();
		heap.size = n;
		heap.buildMaxHeap(a);

		for (int i = n - 1; i > 0; i--) {
			CommonUtil.swap(a, 0, i);
			heap.size = i;
			heap.maxHeapify(a, 0);
		}
	}

	public void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	public int partition(int[] a, int p, int r) {
		int key = a[r];
		int j = p;
		for (int i = p; i < r; i++) {
			if (a[i] <= key) {
				CommonUtil.swap(a, i, j++);
			}
		}
		CommonUtil.swap(a, r, j);
		return j;
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

	public void mergeSort(int[] a, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

	public void merge(int a[], int p, int q, int r) {

		int i = 0, j = 0, k;
		int m = q - p + 1, n = r - q;
		int[] left = new int[m];
		int[] right = new int[n];

		for (i = 0; i < m; i++) {
			left[i] = a[p + i];
		}

		for (i = 0; i < n; i++) {
			right[i] = a[q + 1 + i];
		}

		i = 0;
		j = 0;
		k = p;
		while (i < m && j < n) {
			if (left[i] <= right[j]) {
				a[k++] = left[i++];
			} else {
				a[k++] = right[j++];
			}
		}
		while (i < m) {
			a[k++] = left[i++];
		}
		while (j < n) {
			a[k++] = right[j++];
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

	public ListNode<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data <= head2.data) {
			head1.next = merge(head1.next, head2);
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
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

	// Time : O(n+m), Space : O(n+m)
	// this is stable version of count sort
	// m represents the range of values of a
	// if m is 6 values of a are from 0 to 5
	public int[] countingSort(int a[], int n, int m) {
		int c[] = new int[m];
		int r[] = new int[n];
		for (int i = 0; i < n; i++) {
			c[a[i]]++;
		}

		for (int i = 1; i < m; i++) {
			c[i] += c[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			r[c[a[i]] - 1] = a[i];
			c[a[i]]--;
		}
		return r;
	}

	public int minLengthOfUnsortedArrayToSort(int a[], int n) {
		int l = 0, r = n - 1;
		while (l < r && a[l] < a[l + 1])
			l++;
		while (l < r && a[r] > a[r - 1])
			r--;
		if (l == r)
			return 0;
		else {
			int max = max(a, l, r);
			int min = min(a, l, r);
			int i = 0, j = n - 1;
			while (i < l && a[i] < min)
				i++;

			while (j > r && a[j] > max)
				j--;
			return j - i + 1;
		}

	}

	public int max(int[] a, int l, int r) {
		int m = Integer.MIN_VALUE;
		for (int i = l; i <= r; i++) {
			m = Math.max(a[i], m);
		}
		return m;
	}

	public int min(int[] a, int l, int r) {
		int m = Integer.MAX_VALUE;
		for (int i = l; i <= r; i++) {
			m = Math.min(a[i], m);
		}
		return m;
	}

	public void sortKSortedArray(int a[], int n, int k) {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		for (int i = 0; i < k; i++) {
			heap.add(a[i]);
		}
		int j = 0;
		for (int i = k; i < n; i++) {
			a[j++] = heap.minValue();
			heap.remove();
			heap.add(a[k]);
		}
		for (int i = 0; i < k; i++) {
			a[j++] = heap.minValue();
			heap.remove();
		}
	}

	// Time : O(logn+k), Space : O(1)
	public void findKCloseElementsInSortedArray(int[] a, int n, int key, int k) {
		int l = 0, r = n - 1, mid;
		int index = -1;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (a[mid] == key) {
				index = mid;
				break;
			} else if (a[mid] > key) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		l = index - 1;
		r = index + 1;
		int count = 0;

		while (count < k && l >= 0 && r < n) {
			if (a[index] - a[l] < a[r] - a[index]) {
				System.out.print(a[l] + " ");
				l--;
			} else {
				System.out.print(a[r] + " ");
				r++;
			}
			count++;
		}

		while (count < k && l >= 0) {
			l--;
		}

		while (count < k && r < n) {
			System.out.print(a[r] + " ");
			r++;
		}
	}

	/*
	 * Given an array which is sorted, but after sorting some elements are moved
	 * to either of the adjacent positions, i.e., arr[i] may be present at
	 * arr[i+1] or arr[i-1]. Write an efficient function to search an element in
	 * this array. Basically the element arr[i] can only be swapped with either
	 * arr[i+1] or arr[i-1].
	 */
	// Time : O(logn)
	public int searchInAlmostSortedArray(int[] a, int l, int h, int key) {
		int mid;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (a[mid] == key)
				return mid;
			if (mid > l && a[mid - 1] == key)
				return mid - 1;
			if (mid < h && a[mid + 1] == key)
				return mid + 1;
			if (a[mid] > key)
				h = mid - 2;
			else
				l = mid + 2;
		}
		return -1;
	}

}
