package com.raj.matrix;

public class TrieForMatrix {
	public TrieNodeForMatrix root;

	public TrieForMatrix() {
		this.root = new TrieNodeForMatrix(' ');
	}

	public boolean insertKthRowOfMatrix(int a[][], int m, int n, int k) {
		TrieNodeForMatrix cur, temp, newNode;
		cur = root;
		int data;
		for (int j = 0; j < n; j++) {
			data = a[k][j];
			temp = cur.getNode(data);
			if (temp == null) {
				newNode = new TrieNodeForMatrix(data);
				cur.child[data] = newNode;
				cur = newNode;
			} else {
				cur = temp;
			}
		}
		if (cur.end_of_row) {
			return false;
		}
		cur.end_of_row = true;
		return true;
	}

	public void printRootToLeavePaths(int level, TrieNodeForMatrix node, int[] a) {
		if (node == null)
			return;
		if (isLeaf(node)) {
			a[level] = node.data;
			for (int i = 1; i <= level; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
		}
		a[level] = node.data;
		for (int i = 0; i < node.child.length; i++) {
			printRootToLeavePaths(level + 1, node.child[i], a);
		}
	}

	private boolean isLeaf(TrieNodeForMatrix node) {
		for (int i = 0; i < node.child.length; i++) {
			if (node.child[i] != null)
				return false;
		}
		return true;
	}

}

class TrieNodeForMatrix {
	public int data;
	public TrieNodeForMatrix child[] = null;
	public boolean end_of_row;

	public TrieNodeForMatrix(int data) {
		super();
		this.data = data;
		this.child = new TrieNodeForMatrix[2];
		this.end_of_row = false;
	}

	public TrieNodeForMatrix getNode(int data) {
		if (null != child)
			return child[data];
		return null;
	}
}