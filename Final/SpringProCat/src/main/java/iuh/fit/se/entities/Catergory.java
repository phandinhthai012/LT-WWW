package iuh.fit.se.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CATEGORYs")
public class Catergory {
    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "CATEGORY_NAME", columnDefinition = "NVARCHAR(255)")
    private String name;
    @OneToMany(mappedBy = "catergory",fetch = FetchType.LAZY)
    private List<Product> dsProduct;

    public Catergory() {
    }

    public Catergory(String name) {
        this.name = name;
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

    public List<Product> getDsProduct() {
        return dsProduct;
    }

    public void setDsProduct(List<Product> dsProduct) {
        this.dsProduct = dsProduct;
    }

    @Override
    public String toString() {
        return "Catergory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
