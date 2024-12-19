package iuh.fit.se.service.Impl;

import iuh.fit.se.dao.ProductDao;
import iuh.fit.se.entities.Product;
import iuh.fit.se.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getALLProduct() {
        return productDao.getALLProduct();
    }

    @Override
    public List<Product> getProductsPage(int page, int size) {
        return productDao.getProductsPage(page,size);
    }

    @Override
    public boolean addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public List<Product> searchProduct(String text) {
        return productDao.searchProduct(text);
    }

    @Override
    public List<Product> seachDate(Date date) {
        return productDao.seachDate(date);
    }

    @Override
    public List<Product> seachPrice(double price) {
        return productDao.seachPrice(price);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public List<Product> seacchProductByCategory(int id) {
        return productDao.seacchProductByCategory(id);
    }
}
