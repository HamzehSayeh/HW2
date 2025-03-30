package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.najah.code.Product;

import java.util.concurrent.TimeUnit;

class ProductTest {

    @Test
    @DisplayName("Test valid product creation")
    void testValidProduct() {
        Product product = new Product("Laptop", 1000.0);
        assertAll(
            () -> assertEquals("Laptop", product.getName()),
            () -> assertEquals(1000.0, product.getPrice()),
            () -> assertEquals(0.0, product.getDiscount())
        );
    }

    @Test
    @DisplayName("Test product price validation")
    void testProductPrice() {
        Product validProduct = new Product("Laptop", 1000); // Valid path
        assertNotNull(validProduct);

        assertThrows(IllegalArgumentException.class, () -> new Product("Phone", -50)); // Exception path
    }


    @ParameterizedTest
    @CsvSource({"10, 900", "20, 800", "30, 700"})
    @DisplayName("Test applying valid discounts")
    void testApplyDiscount(double discount, double expectedPrice) {
        Product product = new Product("TV", 1000);
        product.applyDiscount(discount);
        assertEquals(expectedPrice, product.getFinalPrice());
    }

    @Test
    @DisplayName("Test discount application")
    void testValidAndInvalidDiscount() {
        Product product = new Product("Fridge", 500);
        
        product.applyDiscount(10); // Valid discount path
        assertEquals(450, product.getPrice());
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("Ensure getFinalPrice runs within time limit")
    void testGetFinalPricePerformance() {
        Product product = new Product("Table", 150);
        product.applyDiscount(10);
        product.getFinalPrice();
    }
}
