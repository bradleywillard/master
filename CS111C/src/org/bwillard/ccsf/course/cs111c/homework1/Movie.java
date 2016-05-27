package org.bwillard.ccsf.course.cs111c.homework1;

public class Movie implements Comparable<Movie> {
	private String title;
	private int releaseYear;
	
	protected final static int DEFAULT_RELEASE_YEAR = 2015;
	
	public Movie(String title, int releaseYear) {
		this.title = title;
		this.releaseYear = releaseYear;
	}
	
	public Movie(String title) {
		this(title, DEFAULT_RELEASE_YEAR);
	}

	public String getTitle() {
		return title;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	
	public void changeTitle(String title) {
		//Enforce initial setup of object via the constructor...
		if(this.title != null && !"".equals(this.title)) {
			this.title = title;
		}
	}
	public void changeReleaseYear(int releaseYear) {
		//No movies without titles allowed
		if(this.title != null && !"".equals(this.title)) {
			this.releaseYear = releaseYear;
		}
	}
	
	@Override
	public String toString(){
		return this.title + " (" + this.releaseYear + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Movie)) {
			return false;
		}
		Movie m = (Movie)obj;
		return this.title != null && m.title != null
				&& this.title.equalsIgnoreCase(m.title) 
				&& this.releaseYear == m.releaseYear;
	}

	@Override
	public int compareTo(Movie o) {
		if(this.title.compareTo(o.title) == 0){
			String yearThis = String.valueOf(this.releaseYear);
			String yearThat = String.valueOf(o.releaseYear);
			return yearThis.compareTo(yearThat);
		} else {
			return this.title.compareTo(o.title);
		}
	}
	
}
