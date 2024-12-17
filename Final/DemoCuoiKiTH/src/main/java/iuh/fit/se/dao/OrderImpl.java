package iuh.fit.se.dao;

import iuh.fit.se.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderImpl implements OrderDao {
    @Autowired
    private EntityManager entityManager;

    @Override

    public List<Order> getAllOrders() {
        String query = "SELECT o FROM Order o";
        List<Order> orders = entityManager.createQuery(query, Order.class).getResultList();
        return orders;
    }

    @Override

    public Order getOrderById(int id) {
        return entityManager.find(Order.class, id);
    }

    @Override

    public boolean addOrder(Order order) {

        try {
            entityManager.persist(order);
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    @Override

    public List<Order> searchOrder(String text) {
        String sql = "SELECT o FROM Order o WHERE o.proName LIKE :text";
        List<Order> orders = entityManager.createQuery(sql, Order.class).setParameter("text", "%" + text + "%").getResultList();
        return orders;
    }

    @Override

    public boolean editOrder(Order order) {
        try {
            entityManager.merge(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOrder(int id) {
        try {
            Order order = entityManager.find(Order.class, id);
            entityManager.remove(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
