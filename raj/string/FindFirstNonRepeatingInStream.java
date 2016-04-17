/**
 * 
 */
package com.raj.string;

/**
 * @author Raj
 *
 */

/*
 * Given a string, find its first non-repeating character in stream of
 * characters
 * 
 */
/*
 * http://www.geeksforgeeks.org/find-first-non-repeating-character-stream-
 * characters/
 */

public class FindFirstNonRepeatingInStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFirstNonRepeatingInStream obj = new FindFirstNonRepeatingInStream();
		char ch = 0;
		obj.insertInStream('a');
		obj.insertInStream('a');
		obj.insertInStream('a');
		obj.insertInStream('b');
		obj.insertInStream('b');
		obj.insertInStream('c');
		obj.insertInStream('d');
		obj.insertInStream('b');
		ch = obj.firstNonRepeatingCharacter();
		System.out.println(ch);
	}

	public char firstNonRepeatingCharacter() {
		return list.head == null ? 0 : list.head.data;
	}

	public char insertInStream(char ch) {
		if (!repeated[ch]) {
			if (inDLL[ch] == null) {
				list.insert(ch);
				inDLL[ch] = list.tail;
			} else {
				list.remove(inDLL[ch]);
				inDLL[ch] = null;
				repeated[ch] = true;
			}
		}
		return firstNonRepeatingCharacter();
	}

	boolean[] repeated = new boolean[256];
	DLLNode[] inDLL = new DLLNode[256];
	DLL list = new DLL();

	class DLL {
		DLLNode head = null, tail = null;

		public void insert(char data) {
			DLLNode nn = new DLLNode(data);
			tail = nn;
			if (null == head) {
				head = nn;
			} else {
				DLLNode temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = nn;
				nn.prev = temp;
			}
		}

		public void remove(DLLNode node) {
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

}
