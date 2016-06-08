import java.awt.Color;

public class StoreFront {

	public static void main(String[] args) {
		Item item1 = new Book("Java Rules", 59.99, "Oracle");
		Clothing item2 = new Shirt("Womens Tee", 9.99, Clothing.Size.SMALL, Color.RED);
		
		FeatureSpot<Item> mainFeature = new FeatureSpot<>(item1, 60);
		FeatureSpot<Clothing> clothesFeature = new FeatureSpot<>(item2, 360);
		
		//FeatureSpot<String> wordFeature = new FeatureSpot<>("hi", 60);
		

	}

}
