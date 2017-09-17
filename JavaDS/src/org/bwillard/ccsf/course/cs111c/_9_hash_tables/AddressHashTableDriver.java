package org.bwillard.ccsf.course.cs111c._9_hash_tables;

public class AddressHashTableDriver {

	public static void main(String[] args) {
		
		Address a1 = new Address("22 Irving", 94122, "Fun House");
		Address a2 = new Address("49 Ocean", 94112, "Flop House");
		Address a3 = new Address("7 California", 94111, "Pizza Escape");
		Address a4 = new Address("8 Greenwich", 94111, "Brazenhead");
		Address a5 = new Address("78 Mason", 94102, "Mackin Cheese");
		Address a6 = new Address("58 Judah", 94122, "Sushi House");
		Address a7 = new Address("32 Brannan", 94107, "Trocadero");
		//Address a9 = new Address("47 Octavia", 94103, "Mamas House");//5
		/*Address a11 = new Address("23 Ambigoowey", 94103, "Cmon Mans House");//6
		Address a12 = new Address("76 Spirit", 94103, "Gas Station");//9*/
		//Address a13 = new Address("57 Chompers", 94132, "Apple Lookin Mans House");//11
		//Address a14 = new Address("79 EightyNinth", 94110, "10 Scareds House");//11
		/*Address a3 = new Address("7 California", 94111, "Pizza Escape");//Hashes to 3
		Address a4 = new Address("16 Greenwich", 94111, "Brazenhead");//Attempts to hash to 3, collides, hashes at 4
		Address a6 = new Address("4 Judah", 94122, "Sushi House");//Attempts to hash at 4, collides, hashes at 5
		Address a8 = new Address("47 Quartz", 94062, "Brads old digs");//Attempts to hash at 5, collides, hashes at 6
		Address a10 = new Address("21 Jump", 94103, "90s Place");//Attempts to hash at 4, collides, attempts 5, collides, attempts 6, collides, attempts 7, hashes at 7
*/
	    /*22 Irving
	    49 Ocean
	    7 California
	    8 Greenwich
	    78 Mason
	    58 Judah
	    32 Brannan*/

		
		Address[] theAddresses = {a1, a2, a3, a4, a5, a6, a7/*, a8, a9, a10, a11, a12, a13, a14*/};
		
		AddressHashTable addressTable = new AddressHashTable(11);
		//HashTable addressTable = new HashTable(11);
		
		for(Address a : theAddresses) {
			addressTable.addAddress(a);
			//addressTable.put(a.getStreetAddress(), a.getZipCode());
		}
		
		/*
		22 Irving
	    49 Ocean
	    7 California
	    8 Greenwich
	    78 Mason
	    58 Judah
	    32 Brannan
	    */
		Address ab = addressTable.findAddress("21 Jones");
		
		Address a = addressTable.findAddress("22 Irving");
		Address b = addressTable.findAddress("49 Ocean");
		Address c = addressTable.findAddress("7 California");
		Address d = addressTable.findAddress("8 Greenwich");
		Address e = addressTable.findAddress("78 Mason");
		Address f = addressTable.findAddress("58 Judah");
		Address g = addressTable.findAddress("32 Brannan");
		//Address a = (Address)addressTable.get("22 Irving");
		System.out.println(a);
				
		a = addressTable.findAddress("32 Brannan");
		//a = (Address)addressTable.get("32 Brannan");
		
		addressTable.removeAddress("475 Quartz");
		//addressTable.remove("475 Quartz");
	}
}
