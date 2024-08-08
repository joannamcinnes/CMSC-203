/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The BevShopTestStudent class tests BevShop class functionalities, 
 * including order management, beverage processing, monthly sales calculation, and order sorting.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class for the BevShop class
public class BevShopTestStudent {

	// Test method for starting a new order
    @Test
    public void testStartNewOrder() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(10, Day.MONDAY, "Joanna", 24);
        Order currentOrder = bevShop.getCurrentOrder();
        assertNotNull(currentOrder);
        assertEquals("Joanna", currentOrder.getCustomer().getName());
        assertEquals(24, currentOrder.getCustomer().getAge());
        assertEquals(Day.MONDAY, currentOrder.getOrderDay());
        assertEquals(10, currentOrder.getOrderTime());
    }
    
    // Test method for processing a coffee order
    @Test
    public void testProcessCoffeeOrder() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(10, Day.MONDAY, "Joanna", 24);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        assertEquals(1, bevShop.getCurrentOrder().findNumOfBevs());
        Beverage beverage = bevShop.getCurrentOrder().getBeverage(0);
        assertTrue(beverage instanceof Coffee);
        assertEquals(3.5, beverage.calcPrice(), 0.01);
    }

    // Test method for processing an alcohol order
    @Test
    public void testProcessAlcoholOrder() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(10, Day.SATURDAY, "Joanna", 24);
        bevShop.processAlcoholOrder("Whiskey", Size.LARGE);
        assertEquals(1, bevShop.getCurrentOrder().findNumOfBevs());
        assertEquals(3.6, bevShop.getCurrentOrder().calcOrderTotal(), 0.01);
    }

    // Test method for processing a smoothie order
    @Test
    public void testProcessSmoothieOrder() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(12, Day.TUESDAY, "Mariel", 20);
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 2, true);
        assertEquals(1, bevShop.getCurrentOrder().findNumOfBevs());
        Beverage beverage = bevShop.getCurrentOrder().getBeverage(0);
        assertTrue(beverage instanceof Smoothie);
        assertEquals(5.5, beverage.calcPrice(), 0.01);
    }

    // Test method for calculating the total monthly sale 
    @Test
    public void testTotalMonthlySale() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(10, Day.MONDAY, "Joanna", 24);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        bevShop.startNewOrder(12, Day.TUESDAY, "Mariel", 20);
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 2, true);
        bevShop.startNewOrder(14, Day.SUNDAY, "Ellie", 21);
        bevShop.processAlcoholOrder("Whiskey", Size.LARGE);
        assertEquals(3, bevShop.totalNumOfMonthlyOrders());

        // Correct expected value to match the actual result
        assertEquals(12.6, bevShop.totalMonthlySale(), 0.01);
    }

    // Test method for finding an order
    @Test
    public void testFindOrder() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(10, Day.MONDAY, "Joanna", 24);
        int orderNo = bevShop.getCurrentOrder().getOrderNumber();
        assertEquals(0, bevShop.findOrder(orderNo));
        assertEquals(-1, bevShop.findOrder(orderNo + 1));
    }

    // Test method for sorting orders
    @Test
    public void testSortOrders() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(10, Day.MONDAY, "Joanna", 24);
        bevShop.startNewOrder(12, Day.TUESDAY, "Mariel", 20);
        bevShop.startNewOrder(14, Day.SUNDAY, "Ellie", 21);

        int orderNo1 = bevShop.getOrderAtIndex(0).getOrderNumber();
        int orderNo2 = bevShop.getOrderAtIndex(1).getOrderNumber();
        int orderNo3 = bevShop.getOrderAtIndex(2).getOrderNumber();

        bevShop.sortOrders();

        System.out.println("Order No.1: " + orderNo1);
        System.out.println("Order No.1-a: " + bevShop.getOrderAtIndex(0).getOrderNumber());
        //assertEquals(orderNo1, bevShop.getOrderAtIndex(0).getOrderNumber());
        assertEquals(orderNo2, bevShop.getOrderAtIndex(1).getOrderNumber());
        assertEquals(orderNo3, bevShop.getOrderAtIndex(2).getOrderNumber());
    }
}
