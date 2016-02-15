package com.raj.nodes;

public class AVLTreeNodeWithCount<T> {
	public T data;
	public int height;
	public int count;
	public AVLTreeNodeWithCount<T> left;
	public AVLTreeNodeWithCount<T> right;
	public boolean visited;
	
	public AVLTreeNodeWithCount() {

	}

	
	public AVLTreeNodeWithCount(T data, int height, int count) {
		super();
		this.data = data;
		this.height = height;
		this.count = count;
		this.left = null;
		this.right = null;
	}

	public boolean isVisited() {
		return visited;
	}


	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	public AVLTreeNodeWithCount(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "AVLTreeNodeWithCount [data=" + data + "]";
	}

}
