
public class Employee implements Hireable {
	
	@DevelopmentInfo(developer="Jessica", 
			status=DevelopmentInfo.Status.LIVE)
	public void processingBonus() {
		System.out.println("processing employee bonus");
	}
	
	
	@Deprecated
	public void pay() {
		System.out.println("paying employee");
	}
	
	public void processingPay() {
		System.out.println("Processing the payment!");
	}
	
	@Override
	public void hire() {
		System.out.println("hiring");
	}
	
	@Override
	public void process() {
		
	}
	
	
	
	
	

}
