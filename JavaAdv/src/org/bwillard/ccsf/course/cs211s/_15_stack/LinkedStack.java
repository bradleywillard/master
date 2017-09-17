package org.bwillard.ccsf.course.cs211s._15_stack;

import java.util.EmptyStackException;

/**
 * A custom stack that uses a home grown chain of Linked nodes like LinkedList
 * 
 * @author bradleywillard
 *
 * @param <T>
 */
public class LinkedStack<T> implements MyStackInterface<T> {

	Node<T> topNode;
	
	/**
	 * Constructor
	 */
	public LinkedStack() {
		topNode = null;
	}

	@Override
	public void push(T element) {
		//Create a new node (Nate Diaz) and push it to the topNode (Conor McGregor), 
		//dethroning Conor into 2nd place, putting Nate in topNode
		Node<T> newNode = new Node<T>(element, topNode);
		topNode = newNode;
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();
		else {
			T t = topNode.data;
			topNode = topNode.next;
			return t;
		}
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return topNode.data;
	} 
	
	@Override
	public boolean isEmpty() {
		return topNode == null;
	}
	
	@Override
	public void clear() {
		topNode = null;
	}
	
	@Override
	public void display() {
		if(isEmpty()) {
			System.out.println("The stack is empty!");
		} else {
			Node<T> current = topNode;
			while(current != null) {
				if(current.next == null) {
					System.out.print(current.data);
				} else {
					System.out.print(current.data + ", ");
				}
				current = current.next;
			}
		}
	}
	
	/**
	 * We'll allow for no getters/setters since it's a private inner class
	 * we're using for our chain of linked nodes
	 * 
	 * @author bradleywillard
	 *
	 */
	private class Node<T> implements java.io.Serializable {
		private T data;
		private Node<T> next;
		
		private Node(T data) {
			this.data = data;
			this.next = null;
		}
		
		private Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		
	}
	
}
