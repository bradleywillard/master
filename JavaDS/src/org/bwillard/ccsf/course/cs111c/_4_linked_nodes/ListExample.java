package org.bwillard.ccsf.course.cs111c._4_linked_nodes;

public class ListExample {

	public static void main(String[] args) {

		Student s1 = new Student("Alison", "A123");
		Student s2 = new Student("Barb", "B691");
		Student s3 = new Student("Dan", "D208");	
		Student s4 = new Student("Stewart", "S810");
		
		// create nodes
		
		Node<Student> firstNode = new Node<Student>(s1);
		Node<Student> secondNode = new Node<Student>(s2);
		Node<Student> thirdNode = new Node<Student>(s3);
		Node<Student> fourthNode = new Node<Student>(s4);
		
		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		
		System.out.println(firstNode.next.next.data);
		
		printRoster(firstNode);
		printStudent(firstNode, "D208");
		printStudent(firstNode, "Q208");
		
		Node<Student> emptyChain = null;
		printRoster(emptyChain);
		printStudent(emptyChain, "D208");
		
		// code to remove Dan from the chain
		// node prior to Dan is Barb
		// set Barb's next pointer to be Stewart (which was Dan's next)
		printRoster(firstNode);
		secondNode.next = thirdNode.next;
		thirdNode = null;
		printRoster(firstNode);
		
		// add in a new student
		Student s5 = new Student("Elise", "E612");
		Node<Student> fifthNode = new Node<Student>(s5);
		// node prior to where I want to add is Barb
		// the node after where I want to add is Stewart
		Node<Student> tempNode = secondNode.next;
		secondNode.next = fifthNode;
		fifthNode.next = tempNode;
		
	
	}

	public static void printRoster(Node<Student> firstNode) {
		Node<Student> current = firstNode;
		// firstNode and current are aliases
		// they refer to the exact same Node in memory
		
		while(current != null) { 
			Student currentStudent = current.data;
			System.out.println(currentStudent);
			current = current.next;
		}
		// current is garbage collected
		// firstNode and every node linked from it are still in tact
		
	}
	
	public static void printStudent(Node<Student> firstNode, String studentID ) {
		Node<Student> current = firstNode;
		boolean found = false;
		
		while(!found && current != null) {
			Student currentStudent = current.data;
			String currentStudentID = currentStudent.getStudentID();
			if(currentStudentID.equals(studentID)) {
				System.out.println(currentStudent);
				found = true;
			}
			current = current.next;
		}
		if(!found) {
			System.out.println(studentID + " was not found");
		}
		
	}

	
	/* Notes about using assignment wtih nodes:
	 * 
	 * if you assign a node variable to a value, that only
	 * changes what node the variable points to. it does NOT
	 * change any nodes.
	 * 	  example: current = current.next
	 * this just changes the variable
	 * 
	 * if you assign the .next value of a node variable, that
	 * changes the node itself
	 *    example: current.next = current.next.next
	 * this changes the structure of the list itself
	 * 
	 * if you were to change .data value of a node, that changes the
	 * underlying object that the list points to
	 *    example: current.data.setStudentID
	 */
	
	
	
	
	
	
}
