package com.raj.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LFUCache {
	private Node head = null;
	private int capatcity = 0;
	private HashMap<Integer, Integer> valueHash = null;
	private HashMap<Integer, Node> nodeHash = null;

	public LFUCache(int capacity) {
		this.capatcity = capacity;
		valueHash = new HashMap<>();
		nodeHash = new HashMap<>();
	}

	public int get(int key) {
		if (valueHash.containsKey(key)) {
			increaseCount(key);
			return valueHash.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {
		if (capatcity == 0) {
			return;
		}
		if (!valueHash.containsKey(key)) {
			if (valueHash.size() < capatcity) {
				valueHash.put(key, value);
			} else {
				removeOld();
				valueHash.put(key, value);
			}
			addToHead(key);
		}
		valueHash.put(key, value);
		increaseCount(key);
	}

	private void addToHead(int key) {
		if (head == null) {
			head = new Node(0);
			head.keys.add(key);
		} else if (head.count > 0) {
			Node node = new Node(0);
			node.keys.add(key);
			node.next = head;
			head.prev = node;
			head = node;
		} else {
			head.keys.add(key);
		}
		nodeHash.put(key, head);
	}

	private void increaseCount(int key) {
		Node node = nodeHash.get(key);
		node.keys.remove(key);

		if (node.next == null) {
			node.next = new Node(node.count + 1);
			node.next.prev = node;
			node.next.keys.add(key);
		} else if (node.next.count == node.count + 1) {
			node.next.keys.add(key);
		} else {
			Node tmp = new Node(node.count + 1);
			tmp.keys.add(key);
			tmp.prev = node;
			tmp.next = node.next;
			node.next.prev = tmp;
			node.next = tmp;
		}

		nodeHash.put(key, node.next);
		if (node.keys.isEmpty()) {
			remove(node);
		}
	}

	private void removeOld() {
		if (head == null) {
			return;
		}
		int old = 0;
		for (int n : head.keys) {
			old = n;
			break;
		}
		head.keys.remove(old);
		if (head.keys.isEmpty()) {
			remove(head);
		}
		nodeHash.remove(old);
		valueHash.remove(old);
	}

	private void remove(Node node) {
		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.count + "(" + temp.keys + "),");
			temp = temp.next;
		}
		System.out.println();
	}

	class Node {
		public final int count;
		public final Set<Integer> keys;
		public Node prev;
		public Node next;

		public Node(int count) {
			this.count = count;
			keys = new LinkedHashSet<>();
			prev = next = null;
		}
	}

	public static void main(String args[]) {
		LFUCache obj = new LFUCache(2);
		obj.put(1, 1);
		obj.print();
		obj.put(2, 2);
		obj.print();
		System.out.println(obj.get(1)); // returns 1
		obj.print();
		obj.put(3, 3); // evicts key 2
		obj.print();
		System.out.println(obj.get(2)); // returns -1 (not found)
		obj.print();
		System.out.println(obj.get(3)); // returns 3.
		obj.print();
		obj.put(4, 4); // evicts key 1.
		obj.print();
		System.out.println(obj.get(1)); // returns -1 (not found)
		obj.print();
		System.out.println(obj.get(3)); // returns 3
		obj.print();
		System.out.println(obj.get(4)); // returns 4
		obj.print();
	}
}