package org.bwillard.ccsf.course.cs111c.labX;import java.util.Stack;public class Driver {	public static void main(String[] args) {		// create a graph like the one LabXExample, but without the edge highlighted in red		// the graph is disconnected		UndirectedGraph<String> numberMap = new UndirectedGraph<String>();		numberMap.addVertex("0");		numberMap.addVertex("1");		numberMap.addVertex("2");		numberMap.addVertex("3");		numberMap.addVertex("4");		numberMap.addVertex("5");		numberMap.addVertex("6");		numberMap.addEdge("0", "1");		numberMap.addEdge("3", "1");		numberMap.addEdge("2", "1");		numberMap.addEdge("2", "3");		numberMap.addEdge("4", "6");		numberMap.addEdge("6", "5");		System.out.println("There should be 7 vertices: " + numberMap.getNumberOfVertices());		System.out.println("There should be 6 edges: " + numberMap.getNumberOfEdges());				System.out.println("Breadth-First starting at 0 should be \n[0, 1, 3, 2]");		System.out.println(numberMap.getBreadthFirstTraversal("0"));		System.out.println("Breadth-First starting at 6 should be \n[6, 4, 5]");		System.out.println(numberMap.getBreadthFirstTraversal("6"));				System.out.println("Depth-First starting at 0 should be \n[0, 1, 3, 2]");		System.out.println(numberMap.getDepthFirstTraversal("0"));		System.out.println("Depth-First starting at 6 should be \n[6, 4, 5]");		System.out.println(numberMap.getDepthFirstTraversal("6"));				System.out.println("Is this graph (without red line) connected (should be no)? "						+ (numberMap.isConnected("0") ? "yes" : "no"));		// add the edge highlisted in red		// the graph is now connected		numberMap.addEdge("2", "4");		System.out.println("There should be 7 vertices: " + numberMap.getNumberOfVertices());		System.out.println("There should be 7 edges: " + numberMap.getNumberOfEdges());		System.out.println("Is this graph (with red line)connected (should be yes)? "						+ (numberMap.isConnected("0") ? "yes" : "no"));		System.out.println("Breadth-First starting at 0 should be \n[0, 1, 3, 2, 4, 6, 5]");		System.out.println(numberMap.getBreadthFirstTraversal("0"));		System.out.println("Depth-First starting at 0 should be \n[0, 1, 3, 2, 4, 6, 5]");		System.out.println(numberMap.getDepthFirstTraversal("0"));						// add another vertex (not shown in LabXExample picture)		// the graph is no longer connected		numberMap.addVertex("7");		System.out.println("There should be 8 vertices: " + numberMap.getNumberOfVertices());		System.out.println("There should be 7 edges: " + numberMap.getNumberOfEdges());		System.out.println("Is this graph connected now (should be no)? "						+ (numberMap.isConnected("0") ? "yes" : "no"));		// what edge could you add to make it connected? 		// is there more than one option? test it out!	}}