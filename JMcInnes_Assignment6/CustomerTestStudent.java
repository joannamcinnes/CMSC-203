/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The CustomerTestStudent class tests the Customer class to ensure 
 * correct handling of customer information, including constructors, string representations, 
 * and equality comparisons.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTestStudent {

	 // Tests creation of a new customer and getting their name and age.
    @Test
    public void testCustomer() {
        Customer customer = new Customer("Joanna", 24);
        assertEquals("Joanna", customer.getName());
        assertEquals(24, customer.getAge());
    }
    
    // Tests the toString functionality 
    @Test
    public void testToString() {
        Customer customer = new Customer("Joanna", 24);
        assertTrue(customer.toString().contains("Joanna"));
        assertTrue(customer.toString().contains("24"));
    }

    // Tests for different customers
    @Test
    public void testEquals() {
        Customer customer1 = new Customer("Joanna", 24);
        Customer customer2 = new Customer("Joanna", 24);
        Customer customer3 = new Customer("Mariel", 20);
        assertEquals(customer1, customer2);
        assertNotEquals(customer1, customer3);
    }
}
