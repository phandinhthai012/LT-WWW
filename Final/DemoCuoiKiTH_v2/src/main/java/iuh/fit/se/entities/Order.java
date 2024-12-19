package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Orders")
//@Table(name = "[order]") // Thoát từ khóa đặc biệt 'order'
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "ProID cannot be null")
    @NotBlank(message = "ProID cannot be blank")
    @Size(min = 1, max = 10, message = "ProID must be between 1 and 10 characters")
    @Column(name = "ProID")
    private String proID;
    @NotNull(message = "ProName cannot be null")
    @NotBlank(message = "ProName cannot be blank")
    @Column(name = "ProName")
    private String proName;
    @Min(value = 1, message = "Quantity must be greater than 0")
    @Column(name = "Quantity")
    private int quantity;
    @Min(value = 1, message = "Price must be greater than 0")
    @Column(name = "Price")
    private double price;


    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(@NotNull @Size(min = 1, max = 10, message = "ProID must be between 1 and 10 characters") String proID,
                 @NotNull(message = "ProName cannot be null") String proName,
                 @Min(value = 1, message = "Quantity must be greater than 0") int quantity,
                 @Min(value = 1, message = "Price must be greater than 0")double price) {
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
