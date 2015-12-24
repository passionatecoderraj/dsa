/**
 * 
 */
package com.raj.graph;

/**
 * @author Raj
 *
 */
public class ListNode<T> {
	
	Node head=null;
	class Node{
		
		T data;
		Node next;
	}
	
	public void add(T data){
		Node temp = new Node();
		temp.data = data;
		temp.next = null;
		
		if(null == head){
			head = temp;
		}
		else{
			Node tail;
			tail = head;
			while(tail.next!=null){
				tail = tail.next;
			}
			tail.next = temp;
		}
	}
	
	public void insertAtHead(T data){
		Node temp = new Node();
		temp.data = data;
		temp.next = head;
		head = temp;
	}
	
	
//	public T remove(T data){
//		if(head == null) return null;
//		Node temp = head;
//		
//		boolean isfound=false;
//		Node prev;
//		while(temp.data != data){
//			prev = temp;
//			temp = temp.next;
//		}
//		
//		if(temp.next == null && temp.data == data){
//			head = null;
//			return temp.data;
//		}
//		else{
//			
//			while(temp.next.data != data){
//				temp = temp.next;
//			}
//			
//		}
//		
//	}
//	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
