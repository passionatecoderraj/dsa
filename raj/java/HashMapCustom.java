/**
 * 
 */
package com.raj.java;

/**
 * @author Raj
 *
 */
public class HashMapCustom<K, V> {

	static class HashMapEntry<K, V> {
		K key;
		V value;
		HashMapEntry<K, V> next;

		public HashMapEntry(K key, V value, HashMapEntry<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return "HashMapEntry [key=" + key + ", value=" + value + ", next=" + next + "]";
		}
	}

	HashMapEntry<K, V>[] entry;
	int capacity;

	public HashMapCustom(int capacity) {
		super();
		this.capacity = capacity;
		entry = new HashMapEntry[this.capacity];
	}

	public HashMapCustom() {
		this.capacity = 8;
		entry = new HashMapEntry[this.capacity];
	}

	public void doubleTheCapacity() {
		HashMapEntry<K, V>[] b = new HashMapEntry[capacity * 2];
		System.arraycopy(entry, 0, b, 0, capacity);
		entry = b;
		capacity = capacity * 2;
	}

	public void put(K key, V value) {
		if (key == null)
			return;
		int hash = hash(key);

		HashMapEntry<K, V> newEntry = new HashMapEntry(key, value, null);

		if (entry[hash] != null) {
			newEntry.next = entry[hash];
		}

		entry[hash] = newEntry;
	}

	public V get(K key) {
		if (key == null)
			return null;
		int hash = hash(key);
		if (entry[hash] != null) {
			HashMapEntry<K, V> cur = entry[hash];
			while (cur != null) {
				if (cur.key.equals(key))
					return cur.value;
				cur = cur.next;
			}
		}
		return null;
	}

	private int hash(K key) {
		return key.hashCode() % capacity;
	}

	public void print() {
		for (int i = 0; i < entry.length; i++) {
			HashMapEntry<K, V> cur = entry[i];
			if (cur == null)
				continue;
			while (cur != null) {
				System.out.print(cur.key + "-" + cur.value + ", ");
				cur = cur.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		HashMapCustom<Integer, Integer> hashMapCustom = new HashMapCustom<Integer, Integer>();
		hashMapCustom.put(21, 12);
		hashMapCustom.put(25, 121);
		hashMapCustom.put(30, 151);
		hashMapCustom.put(33, 15);
		hashMapCustom.put(35, 89);

		System.out.println("value corresponding to key 21=" + hashMapCustom.get(21));
		System.out.println("value corresponding to key 51=" + hashMapCustom.get(51));

		System.out.print("Displaying : ");
		hashMapCustom.print();

	}
}
