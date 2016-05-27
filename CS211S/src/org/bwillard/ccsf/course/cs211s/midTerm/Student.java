package org.bwillard.ccsf.course.cs211s.midTerm;


public abstract class Student implements Comparable<Student> {

	private String id;
	private String name;
	private Major major;
	private GradRequirement gradReq;
	private int id2;
	
	protected Graduator graduator;
	
	protected static enum GradRequirement { GPA, THESIS, DISSERTATION }
	protected static enum StudentType { BACHELOR_ARTS, BACHELOR_SCI, MASTERS, PHD }
	
	public Student(String id, String name, Major major, GradRequirement gradReq) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.gradReq = gradReq;
	}
	
	public abstract void payTuition();
	
	public void register() {
		System.out.println("Registering " + this.getClass().getSimpleName() + " Student : " + name + " who's major is " + major);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}

	public GradRequirement getGradReq() {
		return gradReq;
	}

	public Graduator getGraduator() {
		return graduator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + id;
		//Just organize student in buckets by major....
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		if(obj instanceof Student) {
			Student other = (Student) obj;
			if (id != other.id)
				return false;
			if (major == null && other.major != null) {
				return false;
			} else if (major != null && major != other.major)
				return false;
			if (name == null && other.name != null) {
				return false;
			} else if (name != null && !name.equals(other.name))
				return false;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", major=" + major + "]";
	}

	@Override
	public int compareTo(Student o) {
		String thisName = "", thatName = "";
		if(this.name != null) thisName = this.name;
		if(o.getName() != null) thatName = o != null ? o.getName() : "";
		//if the names are the same, compare them based on major...
		if(name.compareTo(o.name) == 0) {
			return major.compareTo(o.major);
		} else {
			return name.compareTo(o.getName());
		}
	}
	
}
