/**
 * 
 */
package com.raj.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raj
 *
 */

/*
 * Given a string, find its first non-repeating character in stream of
 * characters
 * 
 */

public class FindFirstNonRepeatingInStream {

	private Character firstNonRepeatingCharacter() {
		return list.head == null ? null : list.head.data;
	}

	public Character insertInStream(char ch) {
		if (list.search(ch)) {
			list.removeFromlist(ch);
		} else {
			list.insertInList(ch);
		}
		return firstNonRepeatingCharacter();
	}

	CustomizedDLL list = new CustomizedDLL();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFirstNonRepeatingInStream obj = new FindFirstNonRepeatingInStream();
		Character ch = null;
		obj.insertInStream('a');
		obj.insertInStream('b');
		obj.insertInStream('a');
		obj.insertInStream('a');
		obj.insertInStream('b');
		obj.insertInStream('d');
		obj.insertInStream('c');
		ch = obj.insertInStream('b');
		System.out.println(ch);
	}

}

/**
 * Customized DLL that does insert, delete and search operations in O(1)
 * @author Raj
 *
 */
class CustomizedDLL {
	DLLNode head = null, tail = null;

	Map<Character, DLLNode> map = new HashMap<>();

	public void printReverse() {
		DLLNode temp = tail;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.println();
	}

	public void insertInList(char data) {
		insert(data);
		map.put(data, tail);
	}

	public void removeFromlist(char data) {
		if (map.get(data) != null) {
			remove(map.get(data));
			map.put(data, null);
		}
	}

	public boolean search(char data) {
		return map.containsKey(data);
	}

	private void insert(char data) {
		DLLNode nn = new DLLNode(data);
		if (null == head) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			nn.prev = tail;
			tail = tail.next;
		}
	}

	private void remove(DLLNode node) {
		if (node == head) {
			head = head.next;
			if (null != head) {
				head.prev = null;
			}
		} else if (node == tail) {
			tail = tail.prev;
			if (null != tail) {
				tail.next = null;
			}
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}
}

class DLLNode {
	char data;
	DLLNode next;
	DLLNode prev;

	public DLLNode(char data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

}
