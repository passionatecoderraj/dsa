package com.raj.ds;

public class HeapNode<T> {
	public int weight;
	public T data;
	
	public HeapNode(int weight, T data) {
		super();
		this.weight = weight;
		this.data = data;
	}
	public HeapNode() {
	
	}
	@Override
	public String toString() {
		return "HeapNode [weight=" + weight + ", data=" + data + "]";
	}
	
	
}
