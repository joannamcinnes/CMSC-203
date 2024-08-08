/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The BevShop class represents a BevShop and implements the BevShopInterface
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a beverage shop that manages orders of different types of beverages
public class BevShop implements BevShopInterface {
    private List<Order> orders;
    private Order currentOrder;
    private int numOfAlcoholDrink;

    // Constructor to create a BevShop object
    public BevShop() {
        this.orders = new ArrayList<>();
    }


    /**
     * Checks if the given time is within the valid operating hours
     * @param time The time to check
     * @return True if the time is valid, false otherwise
     */
    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    /**
     * Gets the maximum number of fruits allowed in a smoothie
     * @return The maximum number of fruits
     */
    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    /**
     * Gets the minimum age required to order an alcoholic beverage
     * @return The minimum age for alcohol
     */
    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    /**
     * Checks if the number of fruits exceeds the maximum allowed
     * @param numOfFruits The number of fruits to check
     * @return True if the number of fruits is valid, false otherwise
     */
    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    /**
     * Gets the maximum number of alcoholic beverages allowed in a single order
     * @return The maximum number of alcoholic beverages
     */
    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    /**
     * Checks if the customer is eligible to order more alcoholic beverages
     * @return True if eligible, false otherwise
     */
    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholDrink < MAX_ORDER_FOR_ALCOHOL;
    }

    /**
     * Gets the number of alcoholic beverages ordered in the current order
     * @return The number of alcoholic beverages
     */
    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholDrink;
    }

    /**
     * Checks if the customer's age is valid to order alcoholic beverages
     * @param age The age to check
     * @return True if the age is valid, false otherwise
     */
    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    /**
     * Starts a new order with the given parameters
     * @param time The time the order is placed
     * @param day The day the order is placed
     * @param customerName The name of the customer
     * @param customerAge The age of the customer
     */
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (!isValidTime(time)) {
            throw new IllegalArgumentException("Invalid order time");
        }
        this.currentOrder = new Order(time, day, new Customer(customerName, customerAge));
        this.numOfAlcoholDrink = 0;
        orders.add(currentOrder);
    }

    /**
     * Processes a coffee order by adding it to the current order
     * @param bevName The name of the beverage
     * @param size The size of the beverage
     * @param extraShot Whether the coffee has an extra shot
     * @param extraSyrup Whether the coffee has extra syrup
     */
    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    /**
     * Processes an alcohol order by adding it to the current order if the customer is eligible
     * @param bevName The name of the beverage
     * @param size The size of the beverage
     */
    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (isValidAge(currentOrder.getCustomer().getAge()) && isEligibleForMore()) {
            currentOrder.addNewBeverage(bevName, size);
            numOfAlcoholDrink++;
        }
    }

    /**
     * Processes a smoothie order by adding it to the current order
     * @param bevName The name of the beverage
     * @param size The size of the beverage
     * @param numOfFruits The number of fruits in the smoothie
     * @param addProtein Whether the smoothie has added protein
     */
    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (isMaxFruit(numOfFruits)) {
            throw new IllegalArgumentException("Exceeds the maximum number of fruits");
        }
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    /**
     * Finds the index of an order by its order number
     * @param orderNo The order number to search for
     * @return The index of the order if found, -1 otherwise
     */
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Calculates the total price of an order by its order number
     * @param orderNo The order number
     * @return The total price of the order if found, 0 otherwise
     */
    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

    /**
     * Calculates the total sales for the month
     * @return The total monthly sales
     */
    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    /**
     * Gets the total number of orders placed in the month
     * @return The total number of monthly orders
     */
    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    /**
     * Gets the current order being processed
     * @return The current order
     */
    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * Gets the order at a specific index in the list of orders
     * @param index The index of the order
     * @return The order at the specified index, or null if the index is out of bounds
     */
    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    // Sorts the orders based on their order numbers
    @Override
    public void sortOrders() {
        Collections.sort(orders);
    }
}
