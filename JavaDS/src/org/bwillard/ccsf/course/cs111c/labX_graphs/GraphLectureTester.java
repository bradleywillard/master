package org.bwillard.ccsf.course.cs111c.labX_graphs;

import java.util.Calendar;
import java.util.Date;

public class GraphLectureTester {

	public static void main(String[] args) {

		DirectedGraph<String> lectureGraph = new DirectedGraph<String>();
		lectureGraph.addVertex("A");
		lectureGraph.addVertex("B");
		lectureGraph.addVertex("C");
		lectureGraph.addVertex("D");
		lectureGraph.addVertex("E");
		lectureGraph.addVertex("F");
		lectureGraph.addVertex("G");
		lectureGraph.addVertex("H");

		lectureGraph.addEdge("A", "B");
		lectureGraph.addEdge("A", "E");
		lectureGraph.addEdge("B", "C");
		lectureGraph.addEdge("B", "G");
		lectureGraph.addEdge("C", "D");
		lectureGraph.addEdge("D", "B");
		lectureGraph.addEdge("E", "A");
		lectureGraph.addEdge("E", "D");
		lectureGraph.addEdge("E", "F");
		lectureGraph.addEdge("F", "D");
		lectureGraph.addEdge("G", "C");
		lectureGraph.addEdge("G", "D");
		lectureGraph.addEdge("H", "E");

		lectureGraph.display();

		System.out.println("There should be 8 vertices: "
				+ lectureGraph.getNumberOfVertices());
		System.out.println("There should be 13 edges: "
				+ lectureGraph.getNumberOfEdges());

		System.out.println("Breadth-First starting at A:");
		System.out.println(lectureGraph.getBreadthFirstTraversal("A"));
		System.out.println("Breadth-First starting at H:");
		System.out.println(lectureGraph.getBreadthFirstTraversal("H"));

		System.out.println("Depth-First starting at A:");
		System.out.println(lectureGraph.getDepthFirstTraversal("A"));
		System.out.println("Depth-First starting at H:");
		System.out.println(lectureGraph.getDepthFirstTraversal("H"));

	}
}
