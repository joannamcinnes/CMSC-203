/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Coffee class represents coffee beverages with attributes for extra shot and syrup. 
 * It includes methods to calculate price, provide string representations, and check equality based on these attributes.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_SHOT_COST = 0.5;
    private final double EXTRA_SYRUP_COST = 0.5;
    
    /**
     * Constructor to create a Coffee object
     * @param name - The name of the coffee
     * @param size - The size of the coffee (small, medium, large)
     * @param extraShot - Whether the coffee has an extra shot
     * @param extraSyrup - Whether the coffee has extra syrup
     */
    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    /**
     * Calculates the price of the coffee based on its size and additional options
     * @return The price of the coffee
     */
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) price += EXTRA_SHOT_COST;
        if (extraSyrup) price += EXTRA_SYRUP_COST;
        // System.out.println("Coffee = " + price);
        // System.out.println("Extra shot = " + extraShot);
        // System.out.println("Extra syrup = " + extraSyrup);
        return price;
    }

    /**
     * Provides a string representation of the coffee
     * @return A string with the details of the coffee
     */
    @Override
    public String toString() {
        return String.format("Coffee: %s, Size: %s, Extra Shot: %b, Extra Syrup: %b, Price: %.2f",
                getName(), getSize(), extraShot, extraSyrup, calcPrice());
    }

    /**
     * Checks if two Coffee objects are equal based on their attributes
     * @param obj The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Coffee coffee = (Coffee) obj;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }
    
    // Getters and setters
    public boolean hasExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean hasExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
    public String getName() {
        return super.getBevName();
    }

    public void setName(String name) {
        super.setBevName(name);
    }
}