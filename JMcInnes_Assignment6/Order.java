/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Order class manages a customer's order with details like 
 * order number, time, day, and a list of beverages. It provides methods to add 
 * beverages, calculate total price, and compare orders.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    /**
     * Constructor to create an Order object
     * @param orderTime The time the order was placed
     * @param orderDay The day the order was placed
     * @param customer The customer who placed the order
     */
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer);
        this.beverages = new ArrayList<>();
    }

    /**
     * Generates a random order number
     * @return A random order number between 10000 and 90000
     */
    private int generateOrderNumber() {
        return new Random().nextInt(80001) + 10000;
    }

    /**
     * Adds a new coffee beverage to the order
     * @param bevName The name of the beverage
     * @param size The size of the beverage
     * @param extraShot Whether the coffee has an extra shot
     * @param extraSyrup Whether the coffee has extra syrup
     */
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    /**
     * Adds a new alcohol beverage to the order
     * @param bevName The name of the beverage
     * @param size The size of the beverage
     */
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    /**
     * Adds a new smoothie beverage to the order
     * @param bevName The name of the beverage
     * @param size The size of the beverage
     * @param numOfFruits The number of fruits in the smoothie
     * @param addProtein Whether the smoothie has added protein
     */
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    /**
     * Calculates the total price of the order
     * @return The total price of the order
     */
    public double calcOrderTotal() {
        return beverages.stream().mapToDouble(Beverage::calcPrice).sum();
    }

    /**
     * Finds the number of beverages of a specific type in the order
     * @param type The type of the beverage
     * @return The number of beverages of the specified type
     */
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }


    /**
     * Gets a beverage from the order
     * @param itemNo The index of the beverage in the order
     * @return The beverage at the specified index, or null if the index is out of bounds
     */
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    /**
     * Checks if the order was placed on a weekend
     * @return True if the order was placed on a weekend, false otherwise
     */    
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    /**
     * Finds the total number of beverages in the order
     * @return The total number of beverages
     */
    public int findNumOfBevs() {
        return beverages.size();
    }

    /**
     * Compares this order to another order based on the order number
     * @param other The other order to compare to
     * @return A negative integer, zero, or a positive integer as this order number is less than, equal to, or greater than the other order number
     */
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }
    /**
     * Provides a string representation of the order
     * @return A string with the details of the order
     */
    @Override
    public String toString() {
        return String.format("Order Number: %d, Time: %d, Day: %s, Customer: %s, Beverages: %s",
                orderNumber, orderTime, orderDay, customer, beverages);
    }
    
    // Getters
    public int getOrderNumber() {
    	// System.out.println("Order number = " + orderNumber);
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    /**
     * Returns the total number of beverages in the order
     * @return The total number of beverages
     */
    public int getTotalItems() {
        return beverages.size();
    }
}
