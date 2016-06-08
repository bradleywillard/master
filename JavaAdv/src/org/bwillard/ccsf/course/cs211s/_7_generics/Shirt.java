import java.awt.Color;

public class Shirt extends Clothing {
	
	private Color color;
	
	public Shirt(String name, double price, Size size, Color color) {
		super(name, price, size);
		this.color = color;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n  Color: " + color;
	}

}
