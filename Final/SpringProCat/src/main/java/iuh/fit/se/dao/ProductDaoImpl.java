package iuh.fit.se.dao;

import iuh.fit.se.entities.Product;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Product> getALLProduct() {
        String query = "SELECT p FROM Product p";
        return entityManager.createQuery(query,Product.class).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> getProductsPage(int page, int size) {
        String query = "SELECT p FROM Product p";
        return entityManager.createQuery(query,Product.class).setFirstResult((page-1)*size).setMaxResults(size).getResultList();
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            entityManager.persist(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        try {
            entityManager.merge(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> searchProduct(String text) {
        String query = "SELECT p FROM Product p WHERE p.name like :text or p.code like :text or p.description like :text";
        return entityManager.createQuery(query,Product.class).setParameter("text","%"+text+"%").getResultList();
    }

    @Override
    public List<Product> seachDate(Date date) {
        String query = "SELECT p FROM Product p WHERE p.resgiterDate = :date";
        return entityManager.createQuery(query,Product.class).setParameter("date",date).getResultList();
    }

    @Override
    public List<Product> seachPrice(double price) {
        String query = "SELECT p FROM Product p WHERE p.price = :price";
        return entityManager.createQuery(query,Product.class).setParameter("price",price).getResultList();
    }

    @Override
    public List<Product> seacchProductByCategory(int id) {
        String query = "SELECT p FROM Product p WHERE p.catergory.id = :id";
        return entityManager.createQuery(query,Product.class).setParameter("id",id).getResultList();
    }
}
