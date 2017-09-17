package org.bwillard.ocp.test.practice._6_excps_and_assrts;

public class JammedTurkeyCage implements AutoCloseable {


	@Override
	public void close() throws IllegalStateException {
		throw new IllegalStateException("Jammed!");
	}

	public static void main(String[] args) {
		/*try(JammedTurkeyCage t1 = new JammedTurkeyCage();
			JammedTurkeyCage t2 = new JammedTurkeyCage()) {
			System.out.println("put turkeys in");
			//throw new IllegalStateException("turkeys ran out");
		} catch (RuntimeException e) {
			System.out.println("caught: " + e.getMessage());
			for(Throwable t : e.getSuppressed()) {
				System.out.println(t.getMessage());
			}
		}*/
		
		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			throw new IllegalStateException("turkeys ran off");
		} finally {
			throw new RuntimeException("and we couldn't find them");
		}
	}
}
