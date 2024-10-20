package iuh.book.entities;

public class Receipt {
	private int id;
	private String name;
	private String address;
	private double total;
	private String payment;
	private String listIDBook;

	public Receipt() {
		super();
	}

	public Receipt(String name, String address, double total, String payment, String listIDBook) {
		super();
		this.name = name;
		this.address = address;
		this.total = total;
		this.payment = payment;
		this.listIDBook = listIDBook;
	}

	public Receipt(int id, String name, String address, double total, String payment, String listIDBook) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.total = total;
		this.payment = payment;
		this.listIDBook = listIDBook;
	}

	public int getId() {
		return id;
	}

	public String getListIDBook() {
		return listIDBook;
	}

	public void setListIDBook(String listIDBook) {
		this.listIDBook = listIDBook;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Receipt(String name, String address, double total, String payment) {
		super();
		this.name = name;
		this.address = address;
		this.total = total;
		this.payment = payment;
	}
}
