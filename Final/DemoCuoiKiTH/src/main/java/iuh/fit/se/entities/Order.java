package iuh.fit.se.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
//@Table(name = "[order]") // Thoát từ khóa đặc biệt 'order'
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "ProID")
    private String proID;
    @Column(name = "ProName")
    private String proName;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Price")
    private double price;


    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(String proID, String proName, int quantity, double price) {
        this.proID = proID;
        this.proName = proName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", proID='" + proID + '\'' +
                ", proName='" + proName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
