package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.UserService;

class UserServiceTest {
    UserService userService = new UserService();

    @ParameterizedTest
    @ValueSource(strings = {"user@example.com", "test123@domain.org"})
    @DisplayName("Test valid emails")
    void testValidEmail(String email) {
        assertTrue(userService.isValidEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalidEmail", "missing@dotcom", "@nodomain.com"})
    @DisplayName("Test invalid emails")
    void testInvalidEmail(String email) {
        assertFalse(userService.isValidEmail(email));
    }

    @Test
    @DisplayName("Test successful authentication")
    void testValidAuthentication() {
        assertTrue(userService.authenticate("admin", "1234"));
    }

    @Test
    @DisplayName("Test failed authentication")
    void testInvalidAuthentication() {
        assertFalse(userService.authenticate("user", "wrongpass"));
    }
}
