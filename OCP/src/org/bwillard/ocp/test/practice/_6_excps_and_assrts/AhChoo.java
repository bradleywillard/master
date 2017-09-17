package org.bwillard.ocp.test.practice._6_excps_and_assrts;

public class AhChoo {

	static class SneezeException extends Exception {}
	static class SniffleException extends SneezeException {}
	public static void main(String[] args) throws SneezeException {
		try {
			throw new SneezeException();
		} catch (SneezeException | RuntimeException e) {
			//e = new Exception();
			throw e;
		}

	}

}
