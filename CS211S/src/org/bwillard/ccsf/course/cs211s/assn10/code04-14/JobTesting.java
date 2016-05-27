import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.time.*;

public class JobTesting {
  public static void main(String[] args) {

    List<Job> jobList = new ArrayList<>();
    fillList(jobList);
    
    // jobs in the majors office
    jobList.stream()
    	.filter(job ->  job.getDepartment().indexOf("Mayor")>=0);
    
    // find average overtime amount by first mapping to an IntStream
    System.out.println("the average overtime is " +
    jobList.stream()
    	.mapToInt(job -> job.getOvertime())
    	.average()
    	);
    
    // sort by overtime amount and then print the first 20
    jobList.stream()
    	.sorted((job1, job2) ->
    		Integer.compare(job1.getOvertime(), job2.getOvertime())
    	 )
    	.limit(20)
    	.forEach(System.out::println);
    
    // create a map with empID as key and job description as value
    Map<String, String> map1 = jobList.stream()
    	.collect(Collectors.toMap(
    			job -> job.getEmpID(),
    			job -> job.getJob() ));
    			
    // create a key with department as key and list of jobs in that department as value
    Map<String, List<Job>> map2 =
    		jobList.stream()
    		.collect(Collectors.groupingBy(j -> j.getDepartment()));
 
   }

  
  private static int fillList(List<Job> list) {
    int count = 0;
    try (Scanner fileScan = new Scanner(
        new FileReader(new File("Jobs.csv")))) {
      String line = fileScan.nextLine(); // column headers
      while(fileScan.hasNext()) {
        line = fileScan.nextLine();
        // this structure assumes perfectly formatted input data
        Scanner lineScan = new Scanner(line);
        lineScan.useDelimiter(",");
        String empId = lineScan.next();
        String department = lineScan.next();
        String jobFamily = lineScan.next();
        String job = lineScan.next();
        Integer salaries = lineScan.nextInt();
        Integer overtime = lineScan.nextInt();
        Integer totalBenefits = lineScan.nextInt();
        Integer compensation = lineScan.nextInt();
        Job eb = new Job(empId,
            department,
            jobFamily,
            job,
            salaries,
            overtime,
            totalBenefits,
            compensation);
        list.add(eb);
        count++;
      }
    } catch(IOException ex) {
      ex.printStackTrace();
    }
    return count;
  }
 
 
}
