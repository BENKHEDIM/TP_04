package org.example;
import org.junit.Test;

import static org.mockito.Mockito.*;
public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        // Création des mocks
        OrderService orderServiceMock = mock(OrderService.class);
        OrderDao orderDaoMock = mock(OrderDao.class);

        // Initialisation du contrôleur avec le mock du service
        OrderController orderController = new OrderController(orderServiceMock);

        // Création d'un ordre
        Order ordre = new Order(1,"Dummy",30);

        // Définition du comportement attendu des mocks
        doNothing().when(orderServiceMock).createOrder(ordre);
        doNothing().when(orderDaoMock).saveOrder(ordre);

        // Appel de la méthode à tester
        orderController.createOrder(ordre);

        // Vérification que la méthode du service est appelée avec le bon argument
        verify(orderServiceMock).createOrder(ordre);


    }
}