package org.bwillard.ccsf.course.cs211s.midTerm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.bwillard.ccsf.course.cs211s.midTerm.Student.GradRequirement;
import static org.bwillard.ccsf.course.cs211s.midTerm.Student.StudentType;

public class StudentDriver {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		students.add(new MastersStudent("100", "Sir Bentley Wylard", Major.INFORMATION_SYSTEMS_MGMT, "Big Data"));
		students.add(new BachSciStudent("200", "Brad Willard", Major.PHYSICS, 4.22, GradRequirement.GPA, null));
		students.add(new MastersStudent("300", "Senora Lynn Ashes", Major.KINESIOLOGY, "Orthomolcular Biology"));
		students.add(new BachArtsStudent("400", "Brad Willard", Major.INFORMATION_SYSTEMS_MGMT, 4.2));
		students.add(new DocStudent("500", "Heyeim Bob", Major.BIOLOGY, "Cloning Humans"));
		students.add(new BachArtsStudent("600", "Lina Aspoy", Major.KINESIOLOGY, 3.8));
		students.add(new DocStudent("700", "K. Jello Eimcoming", Major.PHYSICS, "Molecular Construction"));
		students.add(new BachSciStudent("800", "Gilbert Melendez", Major.BIOLOGY, 3.1, GradRequirement.THESIS, "Protoplasmic Interference"));
		students.add(new BachSciStudent("900", "Keri-Ann Taylor-Melendez", Major.KINESIOLOGY, 3.7, GradRequirement.GPA, null));
		students.add(new BachArtsStudent("1000", "Zeta Jones", Major.COMPUTER_SCIENCE, 2.7));
		students.add(new DocStudent("1100", "Dr. Johnny Chop", Major.BIOLOGY, "Cellular Mutation"));
		students.add(new DocStudent("1200", "Dr. Mugsy Bugglers", Major.KINESIOLOGY, "Quantam Mechanics"));
		students.add(new BachArtsStudent("1300", "Tarzan Johnson", Major.PSYCHOLOGY, 1.9));
		students.add(new MastersStudent("1400", "Senora Beatrice Bogglemind", Major.COMPUTER_SCIENCE, "Artifical Intelligence"));
		students.add(new BachSciStudent("1500", "Schnookledorf Smith", Major.ENGINEERING, 2.5, GradRequirement.THESIS, "Sub-Oceanic Tunneling"));
		students.add(new MastersStudent("1600", "Count Chocula Johnson", Major.PSYCHOLOGY, "Non-Linear Dynamics"));
		students.add(new DocStudent("1700", "Tarzan Johnson", Major.INFORMATION_SYSTEMS_MGMT, "Data Wherehousing"));
		students.add(new MastersStudent("1800", "Sir Hang Sommore", Major.PHYSIOLOGY, "Cardiovascular Endocrinology"));
		students.add(new BachArtsStudent("1900", "Nate Diaz", Major.PHYSIOLOGY, 3.0));
		students.add(new BachSciStudent("2000", "Tarzan Johnson", Major.INFORMATION_SYSTEMS_MGMT, 4.0, GradRequirement.GPA, null));
		students.add(new DocStudent("2100", "Aggen B. Schnookledorf", Major.COMPUTER_SCIENCE, "Search Algorithms"));
		students.add(new BachSciStudent("2200", "Bob Adobba", Major.BIOLOGY, 4.1, GradRequirement.GPA, null));
		
		
		//Running methods on students...
		System.out.println();
		System.out.println("Running register() and payTuition() methods for each student...");
		System.out.println("--------------------------------------------------------------");
		for(Student s : students) {
			s.register();
			s.payTuition();
		}
		
		//java.util.Comparable : compareTo(Student s)
		Collections.sort(students);
		System.out.println();
		System.out.println("Students sorted by Name and Major (Comparable) : ");
		System.out.println("--------------------------------------------------------------");
		for(Student s : students)
			System.out.println(s.toString());
		
		//java.util.Comparator : compare(Student s1, Student s2)
		Collections.sort(students, new StudentComparator());
		System.out.println();
		System.out.println("Students sorted by Type or ID (Comparator) : ");
		System.out.println("--------------------------------------------------------------");
		for(Student s : students)
			System.out.println(s.toString());
		
		System.out.println("\nAverage GPA for all undegrads: ");
		System.out.println("--------------------------------------------------------------");
		double avg = getAverageGpaForUndergrads(students);
		System.out.println(avg);
		System.out.println();
		
		System.out.println("Compiled List of Thesis Topics for Graduates : ");
		System.out.println("--------------------------------------------------------------");
		Set<String> mastersList = getThesisTopicListForMastersStudents(students);
		for(String topic : mastersList)
			System.out.println(topic);
		System.out.println();
		
		System.out.println("Compiled List of Dissertation Topics for PhD Students : ");
		System.out.println("--------------------------------------------------------------");
		Set<String> dissTopics = getDissertationTopicListForDocStudents(students);
		for(String topic : dissTopics)
			System.out.println(topic);
		
		
		//Populate departments
		Department csDept = new CSDepartment(); 
		csDept.addStudent(StudentType.BACHELOR_SCI, "Buckethead Johnson", "222", Major.COMPUTER_SCIENCE, 2.7, GradRequirement.THESIS, "Microchip Spirtuality");
		csDept.addStudent(StudentType.BACHELOR_ARTS, "Jax Backer", "1092", Major.PSYCHOLOGY, 1.9);
		csDept.addStudent(StudentType.PHD, "Rock Ingorse", "5559", Major.KINESIOLOGY, "Kundalini Chelation Therapy");
		csDept.addStudent(StudentType.BACHELOR_SCI, "Bristol Buss", "902", Major.INFORMATION_SYSTEMS_MGMT, 3.7, GradRequirement.GPA);
		csDept.addStudent(StudentType.MASTERS, "Christopher Crucifix", "1597", Major.ENGINEERING, "Relativistic Epistemology");
		System.out.println("\n---------------Computer Science Department Majors----------------");
		csDept.printStudentsMajors();
		
		Department englishDept = new EnglishDepartment();
		englishDept.addStudent(StudentType.BACHELOR_SCI, "Ewe Chuddenthave", "1232", Major.PSYCHOLOGY, 2.8, GradRequirement.THESIS, "Purposeful Freudian Slips");
		englishDept.addStudent(StudentType.PHD, "Cromwell Bahmschell", "1092", Major.PSYCHOLOGY, "Moral Relativism");
		englishDept.addStudent(StudentType.BACHELOR_ARTS, "Buckethead Jones", "4224", Major.PSYCHOLOGY, 2.8);
		englishDept.addStudent(StudentType.BACHELOR_ARTS, "Gemma Teller", "9172", Major.PSYCHOLOGY, 3.1);
		englishDept.addStudent(StudentType.PHD, "Ricky Girly", "9995", Major.KINESIOLOGY, "Paranormal Encounters at Night");
		englishDept.addStudent(StudentType.BACHELOR_SCI, "Ono Noddaggen", "6092", Major.PHYSICS, 4.0, GradRequirement.GPA);
		englishDept.addStudent(StudentType.MASTERS, "Paleese Tup", "1956", Major.PHYSIOLOGY, "Psychological Babblings in England");
		System.out.println("\n---------------English Department----------------");
		englishDept.printStudentsMajors();
				
		System.out.println("\n---------------Graduation Requirements : CS Department----------------");
		printGradReqsForDepartment(csDept);
		System.out.println("\n---------------Graduation Requirements : English Department----------------");
		printGradReqsForDepartment(englishDept);
		
		List<Course> csCourseList = new ArrayList<Course>();
		Course advJava = new Course.CourseBuilder("Advanced Java")
					.numStudents(21)
					.build();
		csCourseList.add(advJava);
		Course introPython = new Course.CourseBuilder("Intro to Python")
					.professor("Craig Persiko")
					.location("Phelan Campus, Batmale Hall, Room 411")
					.textbook("Learning Python, 5th Edition, Mark Lutz")
					.build();
		csCourseList.add(introPython);
		Course introUnix = new Course.CourseBuilder("Intro to Unix")
					.professor("Constance Conner")
					.location("Online")
					.textbook("Online")
					.numCredits(2)
					.build();
		csCourseList.add(introUnix);
		Course shellScripting = new Course.CourseBuilder("Unix Shell Scripting")
					.professor("Peter Wood")
					.location("Online")
					.textbook("Unix Shell Programming, 3rd Edition, by Kochan and Wood. 2003")
					.numCredits(2)
					.build();
		csCourseList.add(shellScripting);
		
		System.out.println("\n---------------CS Courses----------------");
		for(Course c : csCourseList) {
			System.out.println(c);
		}
				
	}

	private static void printGradReqsForDepartment(Department dept) {
		for(Student s : dept.getEnrolledStudents()) {
			String type = s.getClass().getSimpleName();
			String name = s.getName();
			Graduator g = s.getGraduator();
			g.printGraduationRequirements(type, name);
		}
	}

	/**
	 * 
	 * @param students
	 * @return
	 */
	private static double getAverageGpaForUndergrads(List<Student> students) {
		Double totalGpa = 0.00;
		int numUndergrads = 0;
		for(Student s : students) {
			if(s instanceof BachArtsStudent) {
				BachArtsStudent bas = (BachArtsStudent)s;
				numUndergrads++;
				totalGpa += bas.getGpa();
			} else if(s instanceof BachSciStudent) {
				BachSciStudent bss = (BachSciStudent)s;
				numUndergrads++;
				totalGpa += bss.getGpa();
			}
		}
		return totalGpa/numUndergrads;
	}
	
	/**
	 * 
	 * @param students
	 * @return
	 */
	private static Set<String> getThesisTopicListForMastersStudents(List<Student> students) {
		Set<String> thesisTopics = new HashSet<String>();
		for(Student s : students) {
			if(s instanceof MastersStudent) {
				MastersStudent ms = (MastersStudent)s;
				thesisTopics.add(ms.getThesisTopic());
			}
		}
		return thesisTopics;
	}
	
	/**
	 * 
	 * @param students
	 * @return
	 */
	private static Set<String> getDissertationTopicListForDocStudents(List<Student> students) {
		Set<String> dissTopics = new HashSet<String>();
		for(Student s : students) {
			if(s instanceof DocStudent) {
				DocStudent ds = (DocStudent)s;
				dissTopics.add(ds.getDissertationTopic());
			}
		}
		return dissTopics;
	}
}
