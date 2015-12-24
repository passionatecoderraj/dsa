package com.raj.greedy;

import java.util.LinkedList;
import java.util.Queue;

import com.interivew.trees.BinaryTree;
import com.interivew.trees.BinaryTreeNode;

public class HuffmanCodingsWithSortedInput {

	public static void main(String[] args) {
		char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int freq[] = { 5, 9, 12, 13, 16, 45 };
		HuffmanCodingsWithSortedInput obj = new HuffmanCodingsWithSortedInput();
		obj.huffmanCodes(arr, freq);
	}

	public void huffmanCodes(char[] arr, int[] freq) {
		BinaryTreeNode<Integer> root = buildHuffmanCode(freq);

		int[] codes = new int[BinaryTree.height(root)];
		printCodes(root, 0, codes);
	}

	private BinaryTreeNode<Integer> buildHuffmanCode(int[] freq) {
		Queue<BinaryTreeNode<Integer>> q1 = new LinkedList<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> q2 = new LinkedList<BinaryTreeNode<Integer>>();

		for (int i = 0; i < freq.length; i++) {
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(freq[i]);
			q1.add(node);
		}

		while (!(q1.size() == 0 && q2.size() == 1)) {
			BinaryTreeNode<Integer> l = null;
			BinaryTreeNode<Integer> r = null;

			if (q1.isEmpty() && !q2.isEmpty()) {
				l = q2.poll();
				r = q2.poll();

			} else if (!q1.isEmpty() && q2.isEmpty()) {
				l = q1.poll();
				r = q1.poll();
			} else if (!q1.isEmpty() && !q2.isEmpty()) {
				if (q1.peek().data > q2.peek().data) {
					l = q2.poll();
					r = q1.poll();
				} else {
					l = q1.poll();
					r = q2.poll();
				}
			}

			int total = l.data + r.data;
			BinaryTreeNode<Integer> node = new BinaryTreeNode<>(total, l, r);
			q2.add(node);
			
		}
		return q2.remove();
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
