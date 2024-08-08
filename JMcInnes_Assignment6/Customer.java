/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Customer class encapsulates customer information with attributes 
 * for name and age. It includes constructors, getters, setters, and methods for string representation and equality checks.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class Customer {
    private String name;
    private int age;

    /**
     * Constructor to create a Customer object
     * @param name The name of the customer
     * @param age The age of the customer
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor to create a Customer object from another Customer object
     * @param customer The customer to copy
     */
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }


    /**
     * Provides a string representation of the customer
     * @return A string with the details of the customer
     */
    @Override
    public String toString() {
        return String.format("Customer: %s, Age: %d", name, age);
    }
    
    /**
     * Checks if two Customer objects are equal based on their attributes
     * @param obj The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        return name.equals(other.name) && age == other.age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}