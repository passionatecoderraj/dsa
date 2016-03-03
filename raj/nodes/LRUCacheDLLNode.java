package com.raj.nodes;

public class LRUCacheDLLNode<T, V> {
	public T key;
	public V value;

	public LRUCacheDLLNode<T, V> prev;
	public LRUCacheDLLNode<T, V> next;

	public LRUCacheDLLNode() {

	}

	public LRUCacheDLLNode(T key, V value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}

	@Override
	public String toString() {
		return "(key=" + key + ", value=" + value + ")";
	}

}