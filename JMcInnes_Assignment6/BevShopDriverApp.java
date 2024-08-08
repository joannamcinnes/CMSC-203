/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The BevShopDriverApp class has a main method to demonstrate all 
 * classes that use BevShop and Customer objects.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());

        // Handle the first order
        System.out.println("Start please a new order:");
        bevShop.startNewOrder(10, Day.MONDAY, "John", 23);
        System.out.println("Your Total Order for now is " + bevShop.getCurrentOrder().calcOrderTotal());
        System.out.println("Would you please enter your name John");
        System.out.println("Would you please enter your age 23");

        System.out.println("Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol");

        for (int i = 1; i <= 3; i++) {
            System.out.println("Would you please add an alcohol drink");
            bevShop.processAlcoholOrder("Whiskey", Size.SMALL);
            System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
            System.out.println("The Total price on the Order is " + bevShop.getCurrentOrder().calcOrderTotal());

            if (i < 3) {
                System.out.println("Your current alcohol drink order is less than 4");
            }
        }

        System.out.println("You have a maximum alcohol drinks for this order");
        System.out.println("Would you please add a COFFEE to your order:");
        bevShop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        // Handle the second order
        System.out.println("#------------------------------------#");
        System.out.println("Would you please start a new order");
        bevShop.startNewOrder(12, Day.TUESDAY, "Ray", 18);
        System.out.println("Would you please enter your name: Ray");
        System.out.println("Would you please enter your age: 18");
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add a SMOOTHIE to order");
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add a SMOOTHIE to order");
        bevShop.processSmoothieOrder("Green Goodness", Size.MEDIUM, 2, false);
        System.out.println("Would you please add a COFFEE to order");
        bevShop.processCoffeeOrder("Americano", Size.SMALL, true, true);
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add a drink");
        if (bevShop.getCurrentOrder().getCustomer().getAge() < bevShop.getMinAgeForAlcohol()) {
            System.out.println("Your Age is not appropriate for alcohol drink!!");
        }
        System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
        int totalFruits = 0;
        for (Beverage beverage : bevShop.getCurrentOrder().getBeverages()) {
            if (beverage instanceof Smoothie) {
                totalFruits += ((Smoothie) beverage).getNumOfFruits();
            }
        }
        System.out.println("The total number of fruits is " + totalFruits);

        if (totalFruits >= bevShop.getMaxNumOfFruits()) {
            System.out.println("You reached a Maximum number of fruits");
        }

        System.out.println("Total price on the second Order: " + bevShop.getCurrentOrder().calcOrderTotal());
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());

        scanner.close();
    }
} 