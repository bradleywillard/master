package org.bwillard.ccsf.course.cs211s._7_generics;

public class EmptyBoxException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constuctor
	 */
    public EmptyBoxException() {}

    /**
     * Constructor 
     * 
     * @param message
     */
    public EmptyBoxException(String message) {
       super(message);
    }
}
