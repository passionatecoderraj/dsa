//package com.raj.ds;
//
//public class BinMinHeap<T> {
//	int heapsize;
//	HeapNode<T> arr[];
//
//	public void min_heapify(int i) {
//		int smallest, l, r;
//		l = getLeft(i);
//		r = getRight(i);
//		if (l != -1 && arr[l].weight < arr[i].weight) {
//			smallest = l;
//		} else {
//			smallest = i;
//		}
//		if (r != -1 && arr[r].weight < arr[smallest].weight) {
//			smallest = r;
//		}
//
//		if (smallest != i) {
//			// swap largest and i
//			swap(arr[i],arr[smallest]);
////			int temp = arr[i].weight;
////			arr[i] = arr[smallest];
////			arr[smallest].weight = temp;
//			
//			min_heapify(smallest);
//		}
//	}
//
//	private void swap(HeapNode<T> node1, HeapNode<T> node2) {
//		int weight = node1.weight;
//        T data = node1.data;
//        
//        node1.data = node2.data;
//        node1.weight = node2.weight;
//        
//        node2.data = data;
//        node2.weight = weight;
//	}
//
//	public void build_heap(HeapNode a[]) {
//		arr = a;
//		this.heapsize = arr.length;
//		for (int i = getLeavesFrom() - 1; i >= 0; i--) {
//			min_heapify(i);
//		}
//	}
//
//	public void print_heap() {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
//	}
//
//	public HeapNode<T> extract_min() {
//		if (this.heapsize < 1)
//			return null;
//
//		HeapNode<T> max = arr[0];
//		arr[0] = arr[this.heapsize - 1];
//		resizeHeap(this.heapsize, this.heapsize - 1);
//		min_heapify(0);
//		return max;
//	}
//
//	public void decrease_key(int i, HeapNode<T> key) {
//		if (i < 0 && i > this.heapsize - 1) {
//			return;
//		}
//		if (arr[i].weight < key.weight) {
//			return;
//		}
//
//		int parent = getParent(i);
//		if (parent < 0)
//			return;
//		arr[i] = key;
//
//		while (i > 0 && arr[i].weight < arr[parent].weight) {
//			swap(arr[i],arr[parent]);
//			
//			i = parent;
//			parent = getParent(i);
//			if (parent < 0)
//				return;
//		}
//	}
//
//	public void insert_key(int key) {
//		resizeHeap(this.heapsize, this.heapsize + 1);
//		arr[this.heapsize - 1] = Integer.MAX_VALUE;
//		decrease_key(this.heapsize - 1, key);
//	}
//
//	public void resizeHeap(int oldsize, int newsize) {
//		int[] na = null;
//
//		na = new int[newsize];
//		this.heapsize = newsize;
//
//		if (newsize > oldsize) {
//			for (int i = 0; i < oldsize; i++) {
//				na[i] = arr[i];
//			}
//		} else {
//			for (int i = 0; i < newsize; i++) {
//				na[i] = arr[i];
//			}
//		}
//
//		arr = null;
//		arr = na;
//	}
//
//	public int getLeft(int i) {
//		int j = 2 * i + 1;
//		if (j < this.heapsize) {
//			return j;
//		}
//		return -1;
//	}
//
//	public int getRight(int i) {
//		int j = 2 * i + 2;
//		if (j < this.heapsize) {
//			return j;
//		}
//		return -1;
//	}
//
//	public int getParent(int i) {
//		int j = (i - 1) / 2;
//		if (j >= 0) {
//			return j;
//		}
//		return -1;
//	}
//
//	public int getLeavesFrom() {
//		int j = this.heapsize / 2;
//		if (j >= 0) {
//			return j;
//		}
//		return -1;
//	}
//
//	public void heap_sort() {
//		int temp;
//		for (int i = this.heapsize - 1; i > 0; i--) {
//			temp = arr[0];
//			arr[0] = arr[this.heapsize - 1];
//			arr[this.heapsize - 1] = temp;
//			min_heapify(i);
//		}
//	}
//	
//*/
//	
//	public static void main(String[] args) {
//		HeapNode<String> node1 = new HeapNode<String>(3, "Tushar");
//		HeapNode<String> node2 = new HeapNode<String>(4, "Ani");
//		HeapNode<String> node3 = new HeapNode<String>(8, "Vijay");
//		HeapNode<String> node4 = new HeapNode<String>(10, "Pramila");
//		HeapNode<String> node5 = new HeapNode<String>(5, "Roy");
//		HeapNode<String> node6 = new HeapNode<String>(6, "NTF");
//				
//			
//      
//		BinMinHeap obj = new BinMinHeap();
////		int b[] = { 1, 14, 10, 8, 7, 9, 3, 2, 4, 6 };
////		obj.build_heap(b);
////		obj.print_heap();
////	
////		obj.insert_key(0);
////		obj.print_heap();
//		int freq[] = { 5, 9, 12, 13, 16, 45 };
//		obj.build_heap(freq);
//		obj.print_heap();
//		
////		obj.heap_sort();
////		obj.print_heap();
//
//	}
//
//}
