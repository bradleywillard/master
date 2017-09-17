package org.bwillard.ccsf.course.cs111c._8_sort_lists;


public class LinkedGroup<T extends Comparable<? super T>> /*implements GroupInterface<T>*/ {
	
	Node firstNode;
	int length;

	void insertInOrder(Node<T> nodeToInsert) {
		T item = nodeToInsert.getData();
		Node currentNode = firstNode;
		Node previousNode = null;
		
		while(currentNode != null && item.compareTo((T)currentNode.getData()) > 0) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		if (previousNode != null) {
			previousNode.setNextNode(nodeToInsert);
			nodeToInsert.setNextNode(currentNode);
		} else {
			nodeToInsert.setNextNode(firstNode);
			firstNode = nodeToInsert;
		}
	}
	
	void insertionSort() {
		if(length > 1) {
			Node unsortedPart = firstNode.getNextNode();
			firstNode.setNextNode(null);
			
			while(unsortedPart != null) {
				Node nodeToInsert = unsortedPart;
				unsortedPart = unsortedPart.getNextNode();
				insertInOrder(nodeToInsert);
			}
		}
	}
	
	
	public boolean isSorted(Node<Comparable> firstInChain) {
		Node<Comparable> current = firstInChain;
		while(current.next != null) {
			if(current.data.compareTo(current.next.data) > 0) {
				return false;
			}
			current = current.next;
		}
		return true;
	}
}