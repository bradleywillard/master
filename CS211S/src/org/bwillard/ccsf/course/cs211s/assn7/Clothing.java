
public abstract class Clothing extends Item{

	public enum Size {SMALL, MEDIUM, LARGE};
	
	private Size size;
	
	public Clothing(String name, double price, Size size) {
		super(name, price);
		this.size = size;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n  Size: " + size;
	}
}
