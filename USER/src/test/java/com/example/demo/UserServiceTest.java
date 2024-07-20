package com.example.demo;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById_UserExists() {
        User user = new User();
        user.setIduser(1L);
        user.setName("John");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);
        assertEquals("John", result.getName());
    }

    @Test
    public void testGetUserById_UserDoesNotExist() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.getUserById(1L);
        });

        assertEquals("User not found with id: 1", exception.getMessage());
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("John");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUser(user);
        assertEquals("John", result.getName());
    }

    @Test
    public void testUpdateUser() {
        User existingUser = new User();
        existingUser.setIduser(1L);
        existingUser.setName("John");

        User updatedDetails = new User();
        updatedDetails.setName("Johnny");
        updatedDetails.setLastname("Doe");
        updatedDetails.setEmail("john@example.com");
        updatedDetails.setPhonenumber("1234567890");
        updatedDetails.setPassword("password");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        User result = userService.updateUser(1L, updatedDetails);

        assertEquals("Johnny", result.getName());
        assertEquals("Doe", result.getLastname());
        assertEquals("john@example.com", result.getEmail());
        assertEquals("1234567890", result.getPhonenumber());
        assertEquals("password", result.getPassword());
    }

    @Test
    public void testAuthenticateUser_Success() {
        User user = new User();
        user.setEmail("john@example.com");
        user.setPassword("password");

        when(userRepository.findByEmail("john@example.com")).thenReturn(user);

        User result = userService.authenticateUser("john@example.com", "password");

        assertNotNull(result);
        assertEquals("john@example.com", result.getEmail());
    }

    @Test
    public void testAuthenticateUser_Failure() {
        when(userRepository.findByEmail("john@example.com")).thenReturn(null);

        User result = userService.authenticateUser("john@example.com", "wrongpassword");

        assertNull(result);
    }

}
