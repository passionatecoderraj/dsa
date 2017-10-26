package com.raj.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.raj.nodes.NestedInteger;

public class NestedIterator implements Iterator<Integer> {
	Stack<Iterator<NestedInteger>> stack = new Stack<>();
	Integer next = null;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack.push(nestedList.iterator());
	}

	@Override
	public Integer next() {
		Integer result = null;
		if (null != next) {
			result = next;
			next = null;
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		if (next != null) {
			return true;
		}
		while (!stack.isEmpty()) {
			Iterator<NestedInteger> it = stack.peek();
			if (it.hasNext()) {
				if (it.next().isInteger()) {
					next = it.next().getInteger();
					return true;
				} else {
					stack.push(it.next().getList().iterator());
				}
			} else {
				stack.pop();
			}
		}
		return false;
	}

	public static void main(String... args) {
		List<NestedInteger> nestedList = new ArrayList<>();
		NestedIterator obj = new NestedIterator(nestedList);
	}
}