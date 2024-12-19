package iuh.fit.se.dao;

import iuh.fit.se.entities.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> getAllOrders();

    public Order getOrderById(int id);

    public boolean addOrder(Order order);

    public List<Order> searchOrder(String text);

    public boolean editOrder(Order order);
    public boolean deleteOrder(int id);
}