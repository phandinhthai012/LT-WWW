package entites;

public class Employee {
	private int id;
	private String name;
	private Address address;
	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	public void display() {
		System.out.println("Employee [id=" + id + ", name=" + name + "]");
		System.out.println("Address ["+address.toString()+"]");
	}
}
