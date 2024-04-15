package org.example;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Test
    public void testGetUserById() {
        // Création du mock pour UserRepository
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);

        // Création d'un utilisateur fictif
        long userId = 1;
        User expectedUser = new User(userId, "John Doe");

        // Configuration du comportement du mock
        Mockito.when(userRepositoryMock.findUserById(userId)).thenReturn(expectedUser);

        // Création de l'objet UserService à tester
        UserService userService = new UserService(userRepositoryMock);

        // Appel de la méthode à tester
        User actualUser = userService.getUserById(userId);

        // Vérification
        assertEquals(expectedUser, actualUser);

        // Vérification que la méthode findUserById a été appelée avec le bon argument
        Mockito.verify(userRepositoryMock).findUserById(userId);
    }
}