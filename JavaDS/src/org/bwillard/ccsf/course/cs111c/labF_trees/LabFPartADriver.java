package org.bwillard.ccsf.course.cs111c.labF_trees;


public class LabFPartADriver {

	public static void main(String[] args) {
		System.out.println("Traditional Binary Search Tree- No Dups");
		BinarySearchTree<String> nonDupTree = new BinarySearchTree<String>();
		nonDupTree.add("E");
		nonDupTree.add("B");
		nonDupTree.add("C");
		nonDupTree.add("A");
		nonDupTree.add("H");
		nonDupTree.add("D");
		nonDupTree.add("F");
		nonDupTree.add("G");
		System.out.println("Inorder should print \nABCDEFGH");
		nonDupTree.inorderTraverse();
		System.out.println("\nPreorder should print \nEBACDHFG");
		nonDupTree.preorderTraverse();
		nonDupTree.add("B");
		nonDupTree.add("F");
		nonDupTree.add("E");
		System.out.println("\nInorder should print \nABCDEFGH");
		nonDupTree.inorderTraverse();
		
		System.out.println("\n\nBinary Search Tree With Dups");
		BinarySearchTreeWithDups<String> dupTree = new BinarySearchTreeWithDups<String>();
		dupTree.add("E");
		dupTree.add("B");
		dupTree.add("C");
		dupTree.add("A");
		dupTree.add("H");
		dupTree.add("D");
		dupTree.add("F");
		dupTree.add("G");
		System.out.println("Inorder should print \nABCDEFGH");
		dupTree.inorderTraverse();
		System.out.println("\nPreorder should print \nEBACDHFG");
		dupTree.preorderTraverse();
		dupTree.add("G");
		dupTree.add("B");
		dupTree.add("B");
		dupTree.add("D");
		dupTree.add("E");
		dupTree.add("F");
		System.out.println("\nInorder should print \nABBBCDDEEFFGGH");
		dupTree.inorderTraverse();
		System.out.println("\nPreorder should print \nEBACBBDDHFEGFG");
		dupTree.preorderTraverse();
		System.out.println();
		
		System.out.println("getAllIterative should print \n[B, B, B]\n" + dupTree.getAllEntriesIterative("B"));
		System.out.println("getAllRecursive should print \n[B, B, B]\n" + dupTree.getAllEntriesRecursive("B"));
		System.out.println("getAllIterative should print \n[C]\n" + dupTree.getAllEntriesIterative("C"));
		System.out.println("getAllRecursive should print \n[C]\n" + dupTree.getAllEntriesRecursive("C"));
		System.out.println("getAllIterative should print \n[]\n" + dupTree.getAllEntriesIterative("I"));
		System.out.println("getAllRecursive should print \n[]\n" + dupTree.getAllEntriesRecursive("I"));

		// note that print order does not matter, as long as the contents match
		// to make testing easier, you might consider invoking Collections.sort on your ArrayList before you return it
		System.out.println("getLessThanIterative should print \n[A, B, B, B, C, D, D]\n" + dupTree.getAllEntriesLessThanIterative("E"));
		System.out.println("getLessThanRecursive should print \n[A, B, B, B, C, D, D]\n" + dupTree.getAllEntriesLessThanRecursive("E"));
		System.out.println("getLessThanIterative should print \n[A, B, B, B, C, D, D, E, E, F, F]\n" + dupTree.getAllEntriesLessThanIterative("G"));
		System.out.println("getLessThanRecursive should print \n[A, B, B, B, C, D, D, E, E, F, F]\n" + dupTree.getAllEntriesLessThanRecursive("G"));
		System.out.println("getLessThanIterative should print \n[]\n" + dupTree.getAllEntriesLessThanIterative("A"));
		System.out.println("getLessThanRecursive should print \n[]\n" + dupTree.getAllEntriesLessThanRecursive("A"));

		BinarySearchTree<Integer> nonDupTree2 = new BinarySearchTree<Integer>();
		nonDupTree2.add(72);
		nonDupTree2.add(423);
		nonDupTree2.add(173);
		nonDupTree2.add(91);
		nonDupTree2.add(18);
		nonDupTree2.add(52);
		nonDupTree2.add(43);
		nonDupTree2.add(17);
		nonDupTree2.add(61);
		nonDupTree2.add(198);
		//Now add a bunch of duplicates...
		nonDupTree2.add(72);
		nonDupTree2.add(423);
		nonDupTree2.add(173);
		nonDupTree2.add(91);
		nonDupTree2.add(18);
		nonDupTree2.add(52);
		nonDupTree2.add(43);
		nonDupTree2.add(17);
		nonDupTree2.add(61);
		nonDupTree2.add(198);
		System.out.println("Inorder should print \n17184352617291173198423");
		nonDupTree2.inorderTraverse();
		System.out.println("\nPreorder should print \n72181752436142317391198");
		nonDupTree2.preorderTraverse();
		
		nonDupTree2.add(72);
		nonDupTree2.add(423);
		nonDupTree2.add(173);
		nonDupTree2.add(91);
		nonDupTree2.add(18);
		nonDupTree2.add(52);
		nonDupTree2.add(43);
		nonDupTree2.add(17);
		nonDupTree2.add(31);
		nonDupTree2.add(78);
		
		BinarySearchTreeWithDups<Integer> dupTree2 = new BinarySearchTreeWithDups<Integer>();
		dupTree2.add(72);
		dupTree2.add(423);
		dupTree2.add(173);
		dupTree2.add(91);
		dupTree2.add(18);
		dupTree2.add(52);
		dupTree2.add(43);
		dupTree2.add(17);
		dupTree2.add(61);
		dupTree2.add(198);
		//Now add a bunch of duplicates...
		dupTree2.add(72);
		dupTree2.add(423);
		dupTree2.add(173);
		dupTree2.add(91);
		dupTree2.add(18);
		dupTree2.add(52);
		dupTree2.add(43);
		dupTree2.add(17);
		dupTree2.add(61);
		dupTree2.add(198);
		System.out.println();
		System.out.println("Inorder should print \n17184352617291173198423");
		dupTree2.inorderTraverse();
		System.out.println("\nPreorder should print \n72181752436142317391198");
		dupTree2.preorderTraverse();
		
		dupTree2.add(72);
		dupTree2.add(423);
		dupTree2.add(173);
		dupTree2.add(91);
		dupTree2.add(18);
		dupTree2.add(52);
		dupTree2.add(43);
		dupTree2.add(17);
		dupTree2.add(31);
		dupTree2.add(78);

	}
	
}
