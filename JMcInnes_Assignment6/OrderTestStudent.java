/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The OrderTestStudent class validates the Order class for adding beverages, 
 * calculating order totals, retrieving beverages, and handling order-specific attributes and comparisons.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class for the Order class
public class OrderTestStudent {

    // Test method for adding a new beverage to the order
    @Test
    public void testAddNewBeverage() {
        Order order = new Order(10, Day.MONDAY, new Customer("Joanna", 24));
        order.addNewBeverage("Latte", Size.MEDIUM, true, true);
        assertEquals(1, order.findNumOfBevs());
    }

    // Test method for calculating the total order price
    @Test
    public void testCalcOrderTotal() {
        Order order = new Order(10, Day.MONDAY, new Customer("Joanna", 24));
        // Cost of med latte + shot, syrup: $2.00 + $0.50 + $0.50 + $0.50
        // Cost of large whiskey: $2.00 + $1.00
        order.addNewBeverage("Latte", Size.MEDIUM, true, true);
        order.addNewBeverage("Whiskey", Size.LARGE);
        assertEquals(6.50, order.calcOrderTotal(), 0.01);
    }
    
    // Test method for getting a beverage from the order
    @Test
    public void testGetBeverage() {
        Order order = new Order(10, Day.MONDAY, new Customer("Joanna", 24));
        order.addNewBeverage("Latte", Size.MEDIUM, true, true);
        Beverage beverage = order.getBeverage(0);
        assertTrue(beverage instanceof Coffee);
        // System.out.println("Beverage = " + beverage);
        assertEquals("Latte", beverage.getBevName());
    }

    // Test method for checking if the order is on a weekend
    @Test
    public void testIsWeekend() {
        Order order = new Order(10, Day.SATURDAY, new Customer("Joanna", 24));
        assertTrue(order.isWeekend());
        
        order = new Order(10, Day.MONDAY, new Customer("Joanna", 24));
        assertFalse(order.isWeekend());
    }

    // Test method for finding the number of beverages in the order
    @Test
    public void testFindNumOfBevs() {
        Order order = new Order(10, Day.MONDAY, new Customer("Joanna", 24));
        order.addNewBeverage("Latte", Size.MEDIUM, true, true);
        order.addNewBeverage("Whiskey", Size.LARGE);
        assertEquals(2, order.findNumOfBevs());
    }

    // Test method for finding the number of beverages of a specific type in the order
    @Test
    public void testFindNumOfBeveType() {
        Order order = new Order(10, Day.MONDAY, new Customer("Joanna", 24));
        order.addNewBeverage("Latte", Size.MEDIUM, true, true);
        order.addNewBeverage("Whiskey", Size.LARGE);
        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
    }
}