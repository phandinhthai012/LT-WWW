package iuh.fit.se.services.impl;

import iuh.fit.se.enities.Product;
import iuh.fit.se.repositories.ProductRepository;
import iuh.fit.se.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAllProductPagination(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Product> search(String keyword) {
        return productRepository.search(keyword);
    }

    @Override
    public List<Product> findByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> findByRegisterDate(Date registerDate) {
        return productRepository.findByRegisterDate(registerDate);
    }

    @Override
    public List<Product> findByCategory_Id(int categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        Product p = productRepository.findById(product.getId()).get();
        if (p == null) {
            return false;
        }
        p.setCode(product.getCode());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setRegisterDate(product.getRegisterDate());
        p.setDescription(product.getDescription());
        p.setCategory(product.getCategory());

        try {
            productRepository.save(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
