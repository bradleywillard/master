package org.bwillard.ccsf.course.cs111c._1_class_design;

public class MovieDocumentaryDriver {

	public static void main(String[] args) {
		Movie[] movies = new Movie[4];
		movies[0] = new Documentary("Shameless Will", 2010, "Indie Bands");
		movies[1] = new Movie("Vikings", 2011);
		movies[2] = new Movie("Sopranos Return", 2016);
		movies[3] = new Documentary("Brad Loves Lina");
		
		printMovieDocumentaries(movies);

	}
	
	static void printMovieDocumentaries(Movie[] movies) {
		for(Movie m : movies) {
			if( m instanceof Documentary ) {
				Documentary d = (Documentary)m;
				System.out.println(d.getTitle() + 
						" (" + d.getReleaseYear() + ")" +
						", " + d.getTopic());
			}
		}
	}

}
