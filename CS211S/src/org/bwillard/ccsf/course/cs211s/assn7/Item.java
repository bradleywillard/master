package org.bwillard.ccsf.course.cs211s.assn7;


public abstract class Item implements Comparable<Item> {
	private String name;
	private double price;

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price > 0) {
			this.price = price;
		}
	}
	
	@Override
	public String toString() {
		return name + "\n  Price:" + price;
	}
	
	@Override
	public int compareTo(Item otherItem) {
		if(name.equalsIgnoreCase(otherItem.name)) {
			return Double.compare(price, otherItem.price);
		} else {
			return name.compareTo(otherItem.name);
		}
	}
	
	

}
