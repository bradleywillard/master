
public class Job implements Comparable <Job> {
  private String empID;
  private String department;
  private String familyJob;
  private String job;
  private Integer overtime;
  private Integer salary;
  private Integer totalBenefits;
  private Integer totalCompensation;


  public Job(String empID, String department, String familyJob, String job) {
    this.empID = empID;
    this.department = department;
    this.familyJob = familyJob;
    this.job = job;
  }

  public Job(String empID, String department, String familyJob,
                           String job, Integer salary, Integer overtime,
                           Integer totalBenefits, Integer totalCompensation) {
    this.empID = empID;
    this.department = department;
    this.familyJob = familyJob;
    this.job = job;
    this.salary = salary;
    this.overtime = overtime;
    this.totalBenefits = totalBenefits;
    this.totalCompensation = totalCompensation;
  }

  public String getEmpID() {
    return empID;
  }

  public void setEmpID(String empID) {
    this.empID = empID;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getFamilyJob() {
    return familyJob;
  }

  public void setFamilyJob(String familyJob) {
    this.familyJob = familyJob;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public Integer getOvertime() {
    return overtime;
  }

  public void setOvertime(Integer overtime) {
    this.overtime = overtime;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Integer getTotalBenefits() {
    return totalBenefits;
  }

  public void setTotalBenefits(Integer totalBenefits) {
    this.totalBenefits = totalBenefits;
  }

  public Integer getTotalCompensation() {
    return totalCompensation;
  }

  public void setTotalCompensation(Integer totalCompensation) {
    this.totalCompensation = totalCompensation;
  }

  @Override
  public String toString() {
    return "Employee: "+empID+" ("+totalCompensation+")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Job that = (Job) o;

    if (!empID.equals(that.empID)) return false;
    if (job != null ? !job.equals(that.job) : that.job != null) return false;
    return totalCompensation != 0 ? totalCompensation == that.totalCompensation : that.totalCompensation == 0;

  }

  @Override
  public int hashCode() {
    int result = empID.hashCode();
    result = 31 * result + (job != null ? job.hashCode() : 0);
    return result;
  }




  @Override
  public int compareTo(Job o) {
    if(totalCompensation == o.totalCompensation){
      if(salary==o.salary){
        return empID.compareTo(o.empID);
      }else{
        return salary.compareTo(o.salary);
      }
    }else{
      return totalCompensation.compareTo(o.totalCompensation);
    }
  }
}
