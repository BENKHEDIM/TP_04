package org.example;

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createOrder(Order ordre) {
        orderService.createOrder(ordre);
    }
}