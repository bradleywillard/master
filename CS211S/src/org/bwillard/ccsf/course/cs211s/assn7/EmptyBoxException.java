package org.bwillard.ccsf.course.cs211s.assn7;

public class EmptyBoxException extends Exception {

	//no arg constructor
    public EmptyBoxException() {}

    //one arg constructor
    public EmptyBoxException(String message) {
       super(message);
    }
}
