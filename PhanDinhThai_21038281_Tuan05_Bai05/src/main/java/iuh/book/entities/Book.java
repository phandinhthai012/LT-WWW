package iuh.book.entities;

public class Book {
	private int id;
	private String name;
	private String author;
	private double price;
	private int quantity;
	private String description;
	private String image;
	public Book() {
		super();
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Book(String name, String author, double price, int quantity, String description, String image) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
	}

	public Book(int id, String name, String author, double price, int quantity, String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
