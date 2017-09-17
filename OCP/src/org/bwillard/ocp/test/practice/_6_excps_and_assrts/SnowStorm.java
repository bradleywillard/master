package org.bwillard.ocp.test.practice._6_excps_and_assrts;

import java.io.IOException;
import java.sql.SQLException;

public class SnowStorm {

	public static void main(String[] args) {
		try (Walk walk1 = new Walk(); Walk walk2 = new Walk()) {
			throw new RuntimeException("rain");
		} catch(Exception e) {
			System.out.println(e.getMessage() + " " + e.getSuppressed().length);
		}

	}

	static class Walk implements AutoCloseable {
		@Override
		public void close() {
			throw new RuntimeException("snow");
		}
	}
	
	/*public void read() throws SQLException {
		try {
		 readFromDatabase();
		} catch (SQLException | Exception e) {
			throw e;
		}
		
	}
	
	public void readFromDatabase() throws SQLException {} */

}
