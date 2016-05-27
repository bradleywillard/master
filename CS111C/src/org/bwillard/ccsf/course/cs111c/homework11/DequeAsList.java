package org.bwillard.ccsf.course.cs111c.homework11;

import org.bwillard.ccsf.course.cs111c.homework6.LList;
import org.bwillard.ccsf.course.cs111c.homework6.ListInterface;

public class DequeAsList implements DequeInterface {

private ListInterface list;

public DequeAsList() {
       list = new LList();
}

public void addToFront(Object newEntry) {
   if(isEmpty()){
	   list.add(newEntry);
   } else {
	   for(int i = list.getLength(); i >= 1; i--) {
		   list.add(i+1, list.getEntry(i));
	   }
	   list.add(1,newEntry);
   }
}

public Object removeFront() {
	Object item = null;
	if(!isEmpty()) {  
	   item = list.remove(1);
	}
	return item;
}

public Object getFront() {
	if(!list.isEmpty())
		return list.getEntry(1);
	else
		return null;
}

public void addToBack(Object newEntry) {
       list.add(newEntry);
}

public Object removeBack() {
       return list.remove(list.getLength());
}

public Object getBack() {
       return list.getEntry(list.getLength());
}

public boolean isEmpty() {
       return list.isEmpty();
}

public void clear() {
       list.clear();
}

}