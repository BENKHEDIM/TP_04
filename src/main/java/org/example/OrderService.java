package org.example;

public class OrderService {
    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order ordre) {
        orderDao.saveOrder(ordre);
    }
}