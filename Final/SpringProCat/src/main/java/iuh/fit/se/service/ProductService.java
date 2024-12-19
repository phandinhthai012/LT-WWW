package iuh.fit.se.service;

import iuh.fit.se.entities.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    public List<Product> getALLProduct();
    //    Hiển thị danh sách toàn bộ Product (Phân trang 10 product trên 1 trang )
    public List<Product> getProductsPage(int page,int size);
    public  boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public List<Product> searchProduct(String text);
    public List<Product> seachDate(Date date);
    public List<Product> seachPrice(double price);
    public Product getProductById(int id);
    public List<Product> seacchProductByCategory(int id);
}
