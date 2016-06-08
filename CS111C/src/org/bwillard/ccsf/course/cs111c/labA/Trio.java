package org.bwillard.ccsf.course.cs111c.labA;


@SuppressWarnings("rawtypes")
public class Trio<T extends Comparable> implements Comparable {
	
	private T item1;
	private T item2;
	private T item3;
	
	public Trio(T item1, T item2, T item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}

	public T getItem1() {
		return item1;
	}

	public void setItem1(T item1) {
		this.item1 = item1;
	}

	public T getItem2() {
		return item2;
	}

	public void setItem2(T item2) {
		this.item2 = item2;
	}

	public T getItem3() {
		return item3;
	}

	public void setItem3(T item3) {
		this.item3 = item3;
	}
	
	@Override
	public String toString() {
		return "item1 : " + item1 + ", item2 : " + item2 + ", item3 : " + item3;
	}
	
	public boolean contains(Object value) {
		return value == null ? false :
			value.equals(item1) || value.equals(item2) || value.equals(item3);
	}

	public boolean sameItems() {
		//if(item1 == null && item2 == null || item3 == null)
		//correction to above code 10/1/2015
		if(item1 == null && item2 == null && item3 == null)
			return true;
		else if(item1 == null || item2 == null || item3 == null)
			return false;
		return item1.equals(item2) && item2.equals(item3);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Trio<?>)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Trio<T> trio = (Trio<T>)obj;
		
		return
		   (trio.getItem1().equals(item1) &&
		    trio.getItem2().equals(item2) &&
		    trio.getItem3().equals(item3)) 
		    ||
		   (trio.getItem1().equals(item1) &&
			trio.getItem3().equals(item2) &&
			trio.getItem2().equals(item3))
			||	    
		   (trio.getItem3().equals(item1) &&
		    trio.getItem2().equals(item2) &&
		    trio.getItem1().equals(item3))
		    ||
		   (trio.getItem3().equals(item1) &&
			trio.getItem1().equals(item2) &&
			trio.getItem2().equals(item3))
		    ||
		   (trio.getItem2().equals(item1) &&
			trio.getItem1().equals(item2) &&
			trio.getItem3().equals(item3))
		    ||
		   (trio.getItem2().equals(item1) &&
			trio.getItem3().equals(item2) &&
			trio.getItem1().equals(item3));	
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object o) {
		if(o instanceof Trio<?>) {
			Trio<T> trio = (Trio<T>)o;
			T smallestItem1 = getSmallestItemInTrio(this);
			T smallestItem2 = getSmallestItemInTrio(trio);
			
			return smallestItem1.compareTo(smallestItem2);
			
			//Initial solution before I changed it to use helper method,
			//leaving it here as a museum artifact...
			/*List<T> list = new ArrayList<T>();
			list.add(item1);
			list.add(item2);
			list.add(item3);
			Collections.sort(list);
			
			List<T> list2 = new ArrayList<T>();
			list2.add(trio.getItem1());
			list2.add(trio.getItem2());
			list2.add(trio.getItem3());
			Collections.sort(list2);
			
			return list.get(0).compareTo(list2.get(0));*/
			
		}
		return 0;
	}
	
	
	/**
	 * Helper method for comparing two trios...
	 * @param trio
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private T getSmallestItemInTrio(Trio<T> trio) {
		T item1 = trio.getItem1();
		T item2 = trio.getItem2();
		T item3 = trio.getItem3();
		if(trio.sameItems()){
			//Any item will do since they're all equal in this case...
			return item1;
		} else if(item1.compareTo(item2) == -1 && 
				  item1.compareTo(item3) == -1) {
			return item1;
		} else if(item2.compareTo(item1) == -1 && 
				  item2.compareTo(item3) == -1) {
			return item2;
		} else if(item3.compareTo(item1) == -1 && 
				  item3.compareTo(item2) == -1) {
			return item3;
		}
		
		//Something really went wrong. We should never reach here...
		return null;
	}
}
