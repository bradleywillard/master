import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class EvictionTester {
	
	public static void main(String[] args) {
		
		List<Eviction> evictionList = new ArrayList<>();
		fillList(evictionList);
		
		// print all evictions with a cause of nuisance
		evictionList.stream()
			.filter(eviction -> 
				eviction.getEvictionCause()==
				Eviction.EvictionCause.NUISANCE)
			.forEach(System.out::println);
		
		// print all evictions on Market St
		evictionList.stream()
			.filter(eviction ->
				eviction.getAddress().indexOf("Foerster")>=0)
			.forEach(System.out::println);
		
		// map of all evictions in mission- key is id, value is the eviction
		Map<String, Eviction> map1 = evictionList.stream()
				.filter(evic -> evic.getNeighborhood().equals("Mission"))
				.collect(Collectors.toMap(
						evic -> evic.getId(), // key function
						Function.identity())); // value function
						// evic -> evic is the same as Function.identity()	

		// map with key- neighborhood and value- list of all evictions in that neighborhood 
		Map<String, List<Eviction>> map2 =
				evictionList.stream()
				.collect(Collectors.groupingBy(
						evic -> evic.getNeighborhood() ) );
		
		// map with key- neighborhood and value- number of evictions in that neighborhood
		Map<String, Long> map3 =
				evictionList.stream()
				.collect(Collectors.groupingBy(
						evic -> evic.getNeighborhood(),
						Collectors.counting() ));
		
	}

	private static void fillList(List<Eviction> list) {
		try (Scanner fileScan = new Scanner(
				new FileReader(new File("Evictions.csv")))) {
			String line = fileScan.nextLine();
			
			
			while(fileScan.hasNext()) {
				line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String id = lineScan.next();
				String address = lineScan.next();
				String zip = lineScan.next();
				String fileDate = lineScan.next();
				String neighborhood = lineScan.next();	
				Eviction.EvictionCause evictionCause = null;
				
				Eviction.EvictionCause[] array = Eviction.EvictionCause.values();
				boolean found = false;
				for(int i = 0; i < array.length && !found; i++){
					String temp = lineScan.next();
					if(temp.equalsIgnoreCase("true")){
						evictionCause = array[i];
						found = true;
					}
				}

				Eviction eviction = new Eviction(id, address, zip, fileDate, 
						neighborhood, evictionCause);	
				list.add(eviction);
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}

	
	
	
	
	

}
