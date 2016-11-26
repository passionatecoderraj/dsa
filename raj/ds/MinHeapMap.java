package com.raj.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeapMap<T> {
	List<HeapNode<T>> heap = new ArrayList<>();
	Map<T, Integer> map = new HashMap<>();

	int heapSize;

	public void min_heapify(int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int smallest = i;

		if (l < heapSize && heap.get(l).weight < heap.get(smallest).weight) {
			smallest = l;
		}

		if (r < heapSize && heap.get(r).weight < heap.get(smallest).weight) {
			smallest = r;
		}

		if (i != smallest) {
			swap(i, smallest);
			min_heapify(smallest);
		}
	}

	private void swap(int i, int j) {
		HeapNode<T> temp = heap.get(i);
		replace(i, heap.get(j));
		replace(j, temp);

		HeapNode<T> t1 = heap.get(i);
		HeapNode<T> t2 = heap.get(j);
		map.put(t1.data, j);
		map.put(t2.data, i);
	}

	public void decrease(T data, int value) {
		if (containsData(data))
			decreaseKey(map.get(data), value);
	}

	public void decreaseKey(int index, int value) {
		if (heap.get(index).weight < value) {
			return;
		}

		HeapNode<T> node = heap.get(index);
		node.data = value;

		int parent = (index - 1) / 2;
		while (parent >= 0 && heap.get(parent).weight > value) {
			replace(index, heap.get(parent));
			map.put(heap.get(parent).data, index);

			index = parent;
			if (0 == index) {
				break;
			}
			parent = (parent - 1) / 2;
		}
		replace(index, node);
		map.put(node.data, index);

	}

	public void increaseKey(int index, int value) {
		if (heap.get(index).weight > value)
			return;
		HeapNode<T> node = heap.get(index);
		node.weight = value;

		replace(index, node);
		min_heapify(index);
	}

	private void replace(int index, HeapNode<T> value) {
		if (index < heap.size()) {
			heap.remove(index);
			heap.add(index, value);
		}
	}

	public void add(int weight, T data) {
		heap.add(new HeapNode<T>(weight, data));
		decreaseKey(heapSize++, weight, data);
	}

	public boolean remove(int index) {
		if (index >= heapSize)
			return false;
		heapSize--;
		swap(index, heapSize);
		increaseKey(index, heap.get(index).weight);
		return true;
	}

	public void sort() {
		int temp = heapSize;
		for (int i = heapSize - 1; i > 0; i--) {
			swap(heapSize - 1, 0);
			heapSize--;
			min_heapify(0);
		}
		heapSize = temp;
	}

	public void print() {
		for (int i = 0; i < heapSize; i++) {
			System.out.print(heap.get(i).data + " ");
		}
		System.out.println();
	}

	public boolean containsData(T data) {
		return map.containsKey(data);
	}

	public static void main(String args[]) {
		MinHeapMap<Integer> heap = new MinHeapMap<>();
		heap.add(3, 3);
		heap.add(2, 2);
		heap.add(1, 1);
		heap.add(7, 7);
		heap.add(8, 8);
		heap.add(4, 4);
		heap.add(10, 10);
		heap.add(16, 16);
		heap.add(12, 12);
		heap.print();

		int i = 0;
		class Node {
			int position;
			int value;

			public Node(int position, int value) {
				this.position = position;
				this.value = value;
			}

			@Override
			public String toString() {
				// return "(" + position + "," + value + ")";
				return Integer.toString(value);
			}

		}
		Node a[] = new Node[heap.map.size()];

		for (Integer key : heap.map.keySet()) {
			a[i++] = new Node(heap.map.get(key), key);
		}
		Arrays.sort(a, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.position - o2.position;
			}

		});

		System.out.println(Arrays.toString(a));
		heap.decrease(10, 0);
		heap.print();
	}
}
