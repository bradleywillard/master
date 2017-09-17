package org.bwillard.ocp.test.practice._6_excps_and_assrts;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class Rethrow {

	public void parseData() throws SQLException, DateTimeParseException {
		
	}
	
	public void multiCatch() throws SQLException, DateTimeParseException {
		try {
			parseData();
		} catch (SQLException | DateTimeParseException e) {
			System.err.println(e);
			throw e;
		}
	}
	
	public static void main(String[] args) {
		Rethrow r = new Rethrow();
		try {
			r.multiCatch();
		} catch (DateTimeParseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
