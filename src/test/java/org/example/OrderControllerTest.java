package org.example;
import org.junit.Test;

import static org.mockito.Mockito.*;
public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        // Création du mock pour OrderService
        OrderService orderServiceMock = mock(OrderService.class);

        // Création du mock pour OrderDao
        OrderDao orderDaoMock = mock(OrderDao.class);

        // Injection du mock de OrderDao dans le constructeur de OrderService
        OrderService orderService = new OrderService(orderDaoMock);

        // Création de l'objet OrderController à tester avec le mock de OrderService
        OrderController orderController = new OrderController(orderService);

        // Création d'un objet de commande fictif
        Order order = new Order(1234, "Nom du client");

        // Appel de la méthode à tester
        orderController.createOrder(order);

        // Vérification que OrderService.createOrder est appelé avec le bon argument
        verify(orderServiceMock).createOrder(order);

        // Vérification que OrderDao.saveOrder est appelé avec l'objet de commande créé
        verify(orderDaoMock).saveOrder(order);
    }
}