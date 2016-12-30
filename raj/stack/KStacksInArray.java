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
		a[top] = new StackNode(data, ptrs[stackNum], stackNum);
		ptrs[stackNum] = top++;
	}

	public int pop(int stackNum) {
		int index = ptrs[stackNum];
		if (index == -1)
			return -1;
		StackNode node = a[ptrs[stackNum]];
		StackNode last = a[top - 1];

		// swap last node with deleting node
		// updating last nodes ptr
		ptrs[last.stackNum] = node.stackNum;
		ptrs[node.stackNum] = last.stackNum;

		// deleting kth node
		a[ptrs[stackNum]] = a[top - 1];
		a[top - 1] = null;

		top--;
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
	int stackNum;

	public StackNode(int data, int prev, int stackNum) {
		super();
		this.data = data;
		this.prev = prev;
		this.stackNum = stackNum;
	}

	@Override
	public String toString() {
		return "StackNode [data=" + data + ", prev=" + prev + ", stackNum=" + stackNum + "]";
	}

}