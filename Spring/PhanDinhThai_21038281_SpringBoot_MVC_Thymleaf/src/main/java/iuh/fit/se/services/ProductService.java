package iuh.fit.se.services;

import iuh.fit.se.enities.Product;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ProductService {

    public List<Product> getAllProduct();
    public Page<Product> getAllProductPagination(int page, int size);

    public List<Product> search(String keyword);

    public List<Product> findByPrice(double price);
    public List<Product> findByRegisterDate(Date registerDate);
    public  List<Product> findByCategory_Id(int categoryId);

    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);


}
