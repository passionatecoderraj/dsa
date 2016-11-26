package com.raj.stack;

import java.util.Arrays;

public class KStacksInArray {

	StackNode a[];
	int ptrs[];
	int top;

	KStacksInArray(int size, int k) {
		a = new StackNode[size];
		ptrs = new int[k];
		Arrays.fill(ptrs, -1);
		top = 0;
	}

	public void push(int stackNum, int data) {
		int prev = ptrs[stackNum];
		ptrs[stackNum] = top++;
		a[ptrs[stackNum]] = new StackNode(data, prev);
	}

	public int pop(int stackNum) {
		int index = ptrs[stackNum];
		if (index == -1)
			return -1;
		StackNode node = a[ptrs[stackNum]];
		a[ptrs[stackNum]] = null;
		swap(a, ptrs[stackNum], --top);
		ptrs[stackNum] = node.prev;
		return node.data;
	}

	public void print() {
		for (int i = 0; i < top; i++) {
			System.out.print(a[i].data + " ");
		}
		System.out.println();
	}

	private void swap(StackNode[] b, int i, int j) {
		StackNode temp = b[i];
		b[i] = b[j];
		b[j] = temp;
	}

	public static void main(String args[]) {
		KStacksInArray obj = new KStacksInArray(1000, 3);
		obj.push(0, 0);
		obj.push(1, 1);
		obj.push(2, 2);
		obj.push(0, 0);
		obj.push(0, 0);
		obj.push(1, 1);
		obj.push(1, 1);
		obj.push(2, 2);
		obj.push(2, 2);
		obj.push(0, 0);
		obj.push(1, 1);
		obj.push(1, 1);
		obj.push(0, 0);
		obj.print();
		obj.pop(0);
		obj.print();
		obj.pop(0);
		obj.print();

	}
}

class StackNode {
	int data;
	int prev;

	public StackNode(int data, int prev) {
		super();
		this.data = data;
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "StackNode [data=" + data + ", prev=" + prev + "]";
	}

}