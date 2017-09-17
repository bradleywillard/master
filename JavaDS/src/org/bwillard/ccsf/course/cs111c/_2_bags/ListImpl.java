package org.bwillard.ccsf.course.cs111c._2_bags;

public class ListImpl<T> implements ListInterface<T> {

	public static void main(String[] args) {
		ListInterface<Student> studentList = new ListImpl<Student>();
		for(int i = 1; i <= studentList.getLength(); i++) {
			Student s = (Student)studentList.getEntry(i);
			System.out.println(s.getFullName().getLast());
		}
		if(studentList.getLength() > 1) {
			Student firstStudent = studentList.getEntry(1);
			Student lastStudent = studentList.getEntry(studentList.getLength());
			studentList.replace(1, lastStudent);
			studentList.replace(studentList.getLength(), firstStudent);
		}
		
	}
	
	
	private boolean existsInList(String givenItem, ListInterface<T> myList){
		for(int i = 1; i <= myList.getLength(); i++) {
			if(myList.getEntry(i).equals(givenItem)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
