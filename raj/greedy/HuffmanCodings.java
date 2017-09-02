package com.raj.greedy;

import com.interview.graph.BinaryMinHeap;
import com.raj.nodes.BinaryTreeNode;
import com.raj.trees.binary.BinaryTree;

public class HuffmanCodings {

	public static void main(String[] args) {
		char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int freq[] = { 5, 9, 12, 13, 16, 45 };
		HuffmanCodings obj = new HuffmanCodings();
		obj.huffmanCodes(arr, freq);
	}

	public void huffmanCodes(char[] arr, int[] freq) {
		BinaryTreeNode<Integer> root = buildHuffmanCode(freq);

		int[] codes = new int[new BinaryTree().height(root)];
		printCodes(root, 0, codes);
	}

	private BinaryTreeNode<Integer> buildHuffmanCode(int[] freq) {
		BinaryMinHeap<BinaryTreeNode<Integer>> heap = new BinaryMinHeap<>();
		for (int i = 0; i < freq.length; i++) {
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(freq[i]);
			heap.add(freq[i], node);
		}

		while (heap.size() != 1) {
			BinaryTreeNode<Integer> l = heap.extractMin();
			BinaryTreeNode<Integer> r = heap.extractMin();
			int total = l.data + r.data;
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(total, l, r);
			heap.add(total, node);
		}
		return heap.extractMin();
	}

	public void printCodes(BinaryTreeNode<Integer> root, int level, int[] codes) {
		if (root == null)
			return;
		if (BinaryTree.isLeaf(root)) {
			System.out.print(root.data + " - ");
			for (int i = 0; i < level; i++) {
				System.out.print(codes[i]);
			}
			System.out.println();
		} else {
			if (root.left != null) {
				codes[level] = 0;
				printCodes(root.left, level + 1, codes);
			}
			if (root.right != null) {
				codes[level] = 1;
				printCodes(root.right, level + 1, codes);
			}
		}
	}
}
