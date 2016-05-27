package org.bwillard.ccsf.course.cs211s.midTerm;

/**
 * Write a class called Course that describes a college course by its name, 
 * the name of the professor, the class location, the title of the textbook, 
 * the max number of students, the current number of students, and the number of credits.
 * Use a builder. 
 * Create a course in the driver.
 * 
 * @author bradleywillard
 *
 */
public class Course {

	private String name;
	private String professor;
	private String location;
	private String textbook;
	private int numStudents;
	private int numCredits;
	
	private static final int MAX_STUDENTS = 30;
	
	private Course(CourseBuilder builder) {
		this.name = builder.name;
		this.professor = builder.professor;
		this.location = builder.location;
		this.textbook = builder.textbook;
		this.numStudents = builder.numStudents;
		this.numCredits = builder.numCredits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTextbook() {
		return textbook;
	}

	public void setTextbook(String textbook) {
		this.textbook = textbook;
	}

	public int getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}

	public int getNumCredits() {
		return numCredits;
	}

	public void setNumCredits(int numCredits) {
		this.numCredits = numCredits;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", professor=" + professor
				+ ", location=" + location + ", textbook=" + textbook
				+ ", numStudents=" + numStudents + ", numCredits=" + numCredits
				+ "]";
	}



	public static class CourseBuilder {
		private String name;
		private String professor;
		private String location;
		private String textbook;
		private int numStudents;
		private int numCredits;
		
		public CourseBuilder(String name) {
			this.name = name;
			this.professor = "Jessica Masters";
			this.location  = "Phelan Campus, Batmale Hall, Room 413";
			this.textbook = "Core Java: Advanced Features";
			this.numStudents = MAX_STUDENTS;
			this.numCredits = 3;
		}
		
		public CourseBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public CourseBuilder professor(String professor) {
			this.professor = professor;
			return this;
		}
		
		public CourseBuilder location(String location) {
			this.location = location;
			return this;
		}
		
		public CourseBuilder textbook(String textbook) {
			this.textbook = textbook;
			return this;
		}
		
		public CourseBuilder numCredits(int numCredits) {
			this.numCredits = numCredits;
			return this;
		}
		
		public CourseBuilder numStudents(int numStudents) {
			this.numStudents = numStudents;
			return this;
		}
		
		public Course build() {
			if(this.name == null)
				throw new IllegalStateException("name cannot be null");
			return new Course(this);
		}
	}
	
	
}
