package org.bwillard.ccsf.course.cs111c.homework1;

public class MovieDriver {
	
	public static void main(String[] args) {
		Movie[] movies = new Movie[5];
		movies[0] = new Movie("Shameless Will", 2010);
		movies[1] = new Movie("Vikings", 2011);
		movies[2] = new Movie("Sopranos Return", 2016);
		movies[3] = new Movie("Brad Loves Lina");
		movies[4] = new Movie("Brad Goes Back to School");
		
		
		printMovies(movies);
	}
	
	static void printMovies(Movie[] movies) {
		for(Movie m : movies) {
			System.out.println(m.getTitle() + " (" + m.getReleaseYear() + ")");
		}
	}
}
