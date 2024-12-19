package iuh.fit.se.impl;

import iuh.fit.se.dao.OrderDao;
import iuh.fit.se.entities.Order;
import iuh.fit.se.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    @Transactional
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    @Transactional
    public boolean addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    @Transactional
    public List<Order> searchOrder(String text) {
        return orderDao.searchOrder(text);
    }

    @Override
    @Transactional
    public boolean editOrder(Order order) {
        return orderDao.editOrder(order);
    }

    @Override
    public boolean deleteOrder(int id) {
        return orderDao.deleteOrder(id);
    }
}
