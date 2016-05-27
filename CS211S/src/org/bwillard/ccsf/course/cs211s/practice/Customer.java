package org.bwillard.ccsf.course.cs211s.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Customer {
	private String firstName, lastName;
	private int age;
	private Gender gender;
	private Address address;
	private List<Order> orders;
	
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Double getOrderTotal() {
		return getOrders() != null ? getOrders().stream().mapToDouble(Order::getTotal).sum() : 0;
	}
	public static void main(String[] args) {
		//1 What is the average age of the customers?
		List<Customer> cList = new ArrayList<>();
		cList.stream()
			.mapToDouble(Customer::getAge)
			.average();		
		//2 Get all Female customers between the age of 18 and 25
		cList.stream()
			.filter(c -> Gender.FEMALE.equals(c.getGender()))
			.filter(c -> c.getAge() >= 18)
			.filter(c -> c.getAge() <= 25)
			.collect(Collectors.toCollection(ArrayList::new));
		
		//3 Are there any customers who haven't spent any money?
		boolean spentNothing = cList.stream()
			.anyMatch(c -> c.getOrders() == null || c.getOrders().size() == 0);
		
		//4 Which customer spent the most money?
		Optional<Customer> cust = cList.stream()
				.filter(c -> c.getOrders() != null)
				.max((c1, c2) -> c1.getOrderTotal().compareTo(c2.getOrderTotal()));
			
		//5 Create a list of all addresses of customers in California
		List<Address> addresses = cList.stream()
				.filter(c -> "CA".equals(c.getAddress().getState()))
				.map(Customer::getAddress)
				.collect(Collectors.toList());
		
		//6 Create a map of the customers on each state {key=state, value=list of customers}
		Map<String, List<Customer>> stateCustMap = cList.stream()
				.collect(Collectors.groupingBy(c -> c.getAddress().getState()));
		//How many customers are in each state
		Map<String, Long> numCustPerStateMap = cList.stream()
				.collect(Collectors.groupingBy(c -> c.getAddress().getState(), Collectors.counting()));
		
		//7 Create a map of the highest spending customers in each state {key=state, value=customer}
		Map<String, Customer> highSpendCustMap = cList.stream()
				.collect(Collectors.groupingBy(c -> c.getAddress().getState(), 
						 Collectors.maxBy((c1, c2) -> c1.getOrderTotal().compareTo(c2.getOrderTotal()))));
		
		
	}
}


class Address {
	private String streetNumber, street, city, state, zip;

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
}

class Order {
	private List<String> items;
	private double total;
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}

enum Gender {MALE, FEMALE, UNSPECIFIED}

