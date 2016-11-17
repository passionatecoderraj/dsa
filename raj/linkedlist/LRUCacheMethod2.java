/**
 * 
 */
package com.raj.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.raj.nodes.LRUCacheDLLNode;;

/**
 * @author Raj
 *
 */
public class LRUCacheMethod2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// DLL is opposite of queue as we insert at front and remove from rear
		LRUCacheMethod2 ob = new LRUCacheMethod2(3);
		ob.put(7, 7);
		ob.put(0, 0);
		ob.put(1, 1);
		ob.put(2, 2);
		ob.put(0, 0);
		ob.put(3, 3);
		ob.put(0, 0);
		ob.put(4, 4);
		ob.put(2, 2);
		ob.put(3, 3);
		ob.put(0, 0);
		ob.put(3, 3);
		ob.put(2, 2);
		ob.put(1, 1);
		ob.put(2, 2);
		ob.print(ob.head);

	}

	private int capacity;
	private LRUCacheDLLNode<Integer, Integer> head, tail;
	private Map<Integer, LRUCacheDLLNode<Integer, Integer>> map;

	public LRUCacheMethod2(int capacity) {
		super();
		this.capacity = capacity;
		map = new HashMap<Integer, LRUCacheDLLNode<Integer, Integer>>(capacity);
	}

	public void print(LRUCacheDLLNode<Integer, Integer> nn) {
		LRUCacheDLLNode<Integer, Integer> cur = nn;
		while (cur != null) {
			System.out.print(cur + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	// sort of deque
	public void remove(LRUCacheDLLNode<Integer, Integer> nn) {
		if (nn.prev != null) {
			nn.prev.next = nn.next;
		} else {
			head = nn.next;
		}

		if (nn.next != null) {
			nn.next.prev = nn.prev;
		} else {
			tail = nn.prev;
		}
	}

	public void setHead(LRUCacheDLLNode<Integer, Integer> nn) {
		nn.next = head;
		nn.prev = null;
		if (head != null)
			head.prev = nn;
		head = nn;
		if (null == tail)
			tail = nn;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			LRUCacheDLLNode<Integer, Integer> node = map.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			LRUCacheDLLNode<Integer, Integer> node = map.get(key);
			remove(node);
			setHead(node);
		} else {
			LRUCacheDLLNode<Integer, Integer> nn = new LRUCacheDLLNode<Integer, Integer>(key, value);

			if (map.size() >= capacity) {
				map.remove(tail.key);
				remove(tail);
			}
			setHead(nn);
			map.put(key, nn);
		}
	}
	
	Stack<Character> stack = new Stack<>();
	
}
