package TripManagmentSystem.service;

import TripManagmentSystem.model.RegularUser;
import TripManagmentSystem.model.BusinessUser;
import TripManagmentSystem.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for User entities
 * Demonstrates testing OOP concepts (Inheritance, Polymorphism)
 */
class UserServiceTest {

    @Test
    void testRegularUserPolymorphism() {
        // Test POLYMORPHISM - getUserType() returns different values
        User regularUser = new RegularUser("John Doe", "john@email.com");
        
        assertEquals("REGULAR_USER", regularUser.getUserType());
        assertTrue(regularUser instanceof RegularUser);
    }

    @Test
    void testBusinessUserPolymorphism() {
        // Test POLYMORPHISM
        User businessUser = new BusinessUser("Jane Smith", "jane@company.com", "TechCorp", "TAX123");
        
        assertEquals("BUSINESS_USER", businessUser.getUserType());
        assertTrue(businessUser instanceof BusinessUser);
    }

    @Test
    void testRegularUserLoyaltyPoints() {
        RegularUser user = new RegularUser("Alice", "alice@email.com");
        
        // Test loyalty points
        assertEquals(0, user.getLoyaltyPoints());
        
        user.setLoyaltyPoints(100);
        assertEquals(100, user.getLoyaltyPoints());
    }

    @Test
    void testBusinessUserDiscount() {
        BusinessUser user = new BusinessUser("Bob", "bob@corp.com", "BigCorp", "TAX456");
        
        // Test discount calculation
        Double originalPrice = 1000.0;
        Double discountedPrice = user.calculateDiscountedPrice(originalPrice);
        
        assertEquals(900.0, discountedPrice, 0.01); // 10% discount
        assertTrue(user.hasCorporateAccount());
    }

    @Test
    void testUserInheritance() {
        // Test that both subclasses inherit from User
        RegularUser regularUser = new RegularUser("Test1", "test1@email.com");
        BusinessUser businessUser = new BusinessUser("Test2", "test2@email.com", "Corp", "TAX");
        
        // Both should have User properties
        assertNotNull(regularUser.getName());
        assertNotNull(regularUser.getEmail());
        assertNotNull(businessUser.getName());
        assertNotNull(businessUser.getEmail());
    }
}
