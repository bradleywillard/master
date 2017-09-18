package practice;

import java.util.LinkedList;
import java.util.List;

public class MultiNodePlay {

	private Node head;
	
	private class Node {
		Node next;
		Node below;
		int value;
	}
	
	private MultiNodePlay(final int value, final int size) {
		createMultiNode(value, size);
	}
	
	public static void main(String[] args) {
		MultiNodePlay mnp = new MultiNodePlay(7, 7);
		
		System.out.println("\nExpected hops before flattening linked Node for 49: (Expect 6) : " + mnp.hops(49));
		System.out.println("Expected hops before flattening linked Node for 70: (Expect 12) : " + mnp.hops(70));
		System.out.println("Expected hops before flattening linked Node for 126: (Expect 21) : " + mnp.hops(126));
		System.out.println("Expected hops before flattening linked Node for 210: (Expect 37) : " + mnp.hops(210));
		System.out.println("Expected hops before flattening linked Node for 343: (Expect 54) : " + mnp.hops(343));
		
		List<Node> flatList = mnp.flattenList();
		System.out.println("\nExpected hops after flattening linked Node for 49: (Expect 6) : " + mnp.hops(flatList, 49));
		System.out.println("Expected hops after flattening linked Node for 70: (Expect 12) : " + mnp.hops(flatList, 70));
		System.out.println("Expected hops after flattening linked Node for 126: (Expect 21) : " + mnp.hops(flatList, 126));
		System.out.println("Expected hops after flattening linked Node for 210: (Expect 37) : " + mnp.hops(flatList, 210));
		System.out.println("Expected hops after flattening linked Node for 343: (Expect 54) : " + mnp.hops(flatList, 343));
		
		System.out.print("\nFlattened List : [");
		flatList.stream().forEach(node -> System.out.print(node.value + " "));
		System.out.print("]\n\n");
	}
	
	/**
	 * Constructor
	 * 
	 * @param value
	 * @param size
	 */
	private void createMultiNode(final int value, final int size) {
		createTopNodeRow(value, size);
		createChildNodes(value, size);
	}

	/**
	 * Creates the main flat row of singly linked nodes
	 * @param value
	 * @param size
	 */
	private void createTopNodeRow(final int value, final int size) {
		head = new Node();
		Node curr = head;
		int i = 1;
		while(i <= size) {
			curr.value = value * i; 
			if(i == size) break;
			curr.next = new Node();
			curr = curr.next;
			i++;
		}
	}

	/**
	 * Creates child node columns for nodes in the top node row
	 * @param value
	 * @param size
	 */
	private void createChildNodes(final int value, final int size) {
		Node column = head;
		while(column != null) {
			int i = 1;
			System.out.print("[");
			Node curr = column;
			System.out.print(curr.value + ", ");
			while(i <= size) {
				Node below = new Node();
				below.value = column.value * (i + 1);
				curr.below = below;
				i++;
				System.out.print(below.value);
				if(i <= size) System.out.print(", ");
				curr = curr.below;
			}
			System.out.println("]");
			column = column.next;
		}
	}
	
	/**
	 * Creates a flattened horizontal LinkedList from the MultiLevel Node matrix
	 * Adds Nodes from left to right
	 *  
	 * @return
	 */
	private List<Node> flattenList() {
		List<Node> flatList = new LinkedList<>();
		Node curr = head;
		while(curr != null) {
			flatList.add(curr);
			Node below = curr.below;
			while(below != null) {
				flatList.add(below);
				below = below.below;
			}
			curr = curr.next;
		}
		return flatList;
	}
	
	/**
	 * Counts the number of hops to find the search value in the LinkedList and returns once found.
	 * O(n) in the worst case
	 * 
	 * @param nodeList
	 * @param searchVal
	 * @return
	 */
	private int hops(List<Node> nodeList, final int searchVal) {
		int hops = 0;
		for(Node node : nodeList) {
			if(node.value == searchVal) 
				break;
			hops++;
		}
		return hops;
	}
	
	/**
	 * Counts the number of hops to find the search value traversing through the MultiLevel Node and returns once found.
	 * 0(n^2) in the worst case if the searchVal is never found
	 * @param searchVal
	 * @return
	 */
	private int hops(final int searchVal) {
		int hops = 0;
		Node curr = head;
		while(curr != null) {
			if(curr.value == searchVal) {
				return hops;
			}
			hops++;
			Node below = curr.below;
			while(below != null) {
				if(below.value == searchVal) {
					return hops;
				}
				below = below.below;
				hops++;
			}
			curr = curr.next;
		}
		return hops;
	}
	
}
