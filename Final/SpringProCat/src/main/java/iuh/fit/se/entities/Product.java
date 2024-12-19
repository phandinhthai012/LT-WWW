package iuh.fit.se.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CODE", columnDefinition = "NVARCHAR(255)")
    private String code;
    @Column(name = "NAME", columnDefinition = "NVARCHAR(255)")
    private String name;
    @Column(name = "DESCRIPTION", columnDefinition = "NVARCHAR(255)")
    private String description;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "REGISTER_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date resgiterDate;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Catergory catergory;


    public Product() {
    }

    public Product(String code, String name, String description, double price, Date resgiterDate) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.resgiterDate = resgiterDate;
    }

    public Product(Catergory catergory, Date resgiterDate, double price, String description, String name, String code) {
        this.catergory = catergory;
        this.resgiterDate = resgiterDate;
        this.price = price;
        this.description = description;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getResgiterDate() {
        return resgiterDate;
    }

    public void setResgiterDate(Date resgiterDate) {
        this.resgiterDate = resgiterDate;
    }

    public Catergory getCatergory() {
        return catergory;
    }

    public void setCatergory(Catergory catergory) {
        this.catergory = catergory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "resgiterDate=" + resgiterDate +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", id=" + id +
                ", category=" + catergory +
                '}';
    }
}
