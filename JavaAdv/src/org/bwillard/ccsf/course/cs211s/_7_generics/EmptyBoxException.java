package org.bwillard.ccsf.course.cs211s._7_generics;

public class EmptyBoxException extends Exception {

	//no arg constructor
    public EmptyBoxException() {}

    //one arg constructor
    public EmptyBoxException(String message) {
       super(message);
    }
}
