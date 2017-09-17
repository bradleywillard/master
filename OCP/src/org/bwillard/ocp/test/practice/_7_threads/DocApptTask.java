package org.bwillard.ocp.test.practice._7_threads;

import java.util.concurrent.RecursiveTask;

class Patient {}
class Room {}
class Doctor {}

public class DocApptTask extends RecursiveTask {
	
	private static int MAX_WAIT_ROOM_CAPACITY = 20;
	private Patient[] patients;
	private Room[] rooms;
	private Doctor[] doctors;
	
	public DocApptTask(int numPatients, int numRooms, int numDoctors) {
		this.patients = new Patient[numPatients];
		this.rooms = new Room[numRooms];
		this.doctors = new Doctor[numDoctors];
	}
	
	@Override
	protected Object compute() {
		// TODO Auto-generated method stub
		return null;
	}

}
