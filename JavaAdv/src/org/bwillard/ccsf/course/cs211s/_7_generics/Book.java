
public class Book extends Item {
	
	private String author;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String name, double price, String author) {
		super(name, price);
		this.author = author;
	}

	@Override
	public String toString() {
		return super.toString() + "\n  Author:" + author;
	}
}
