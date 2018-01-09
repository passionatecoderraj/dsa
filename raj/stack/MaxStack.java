/**
 * 
 */
package com.raj.stack;

import java.util.ArrayList;
import java.util.TreeMap;

import com.raj.nodes.DLLNode;

/**
 * @author Raj
 *Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.
 */
public class MaxStack {

	DLLNode<Integer> head;
	TreeMap<Integer, ArrayList<DLLNode<Integer>>> map;

	// Space : O(n)	
	/** initialize your data structure here. */
	public MaxStack() {
		head = new DLLNode<Integer>(-1);
		map = new TreeMap<>();
	}
	
	// Time : O(logn)
	public void push(int x) {
		DLLNode<Integer> node = new DLLNode<Integer>(x);
		node.next = head;
		head.prev = node;
		head = node;
		if (!map.containsKey(x)) {
			map.put(x, new ArrayList<>());
		}
		map.get(x).add(head);
	}

	// Time : O(logn)
	public int pop() {
		if (isEmpty())
			return -1;
		int top = head.data;
		int size = map.get(top).size();
		map.get(top).remove(size - 1);
		if (map.get(top).isEmpty()) {
			map.remove(top);
		}
		head = head.next;
		head.prev = null;
		return top;
	}

	// Time : O(1)
	public int top() {
		return isEmpty() ? -1 : head.data;
	}

	// Time : O(1)
	public int peekMax() {
		return isEmpty() ? -1 : map.lastKey();
	}

	// Time : O(logn)
	public int popMax() {
		if (isEmpty())
			return -1;
		int max = map.lastKey();
		int size = map.get(max).size();
		DLLNode<Integer> node = map.get(max).remove(size - 1);

		if (map.get(max).isEmpty()) {
			map.remove(max);
		}

		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		}

		return max;
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	void print() {
		DLLNode<Integer> temp = head;
		while (head != null) {
			System.out.print(head.data + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int res = -1;

		MaxStack stack = new MaxStack();
		stack.push(5);
		stack.push(1);
		stack.push(5);

		res = stack.top();
		System.out.println(res);
		res = stack.popMax();
		System.out.println(res);
		res = stack.top();
		System.out.println(res);
		res = stack.peekMax();
		System.out.println(res);
		res = stack.pop();
		System.out.println(res);
		res = stack.top();
		System.out.println(res);
	}

}
