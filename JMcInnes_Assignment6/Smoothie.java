/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Smoothie class represents smoothie beverages, including attributes 
 * for the number of fruits and added protein. It contains methods to calculate price and override 
 * string representation and equality checks.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */


public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean proteinPowder;
    private static final double PROTEIN_COST = 1.5;
    private static final double FRUIT_COST = 0.5;

    /**
     * Constructor to create a Smoothie object
     * @param name The name of the smoothie
     * @param size The size of the smoothie (small, medium, large)
     * @param numOfFruits The number of fruits in the smoothie
     * @param addProtein Whether the smoothie has added protein
     */
    public Smoothie(String name, Size size, int numOfFruits, boolean proteinPowder) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.proteinPowder = proteinPowder;
    }

    /**
     * Calculates the price of the smoothie based on its size, number of fruits, and additional protein
     * @return The price of the smoothie
     */
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        price += numOfFruits * FRUIT_COST;
        if (proteinPowder) price += PROTEIN_COST;
        // System.out.println("Smoothie = " + price);
        // System.out.println("Fruit = " + numOfFruits);
        // System.out.println("Protein = " + proteinPowder);
        return price;
    }

    /**
     * Provides a string representation of the smoothie
     * @return A string with the details of the smoothie
     */
    @Override
    public String toString() {
        return String.format("Smoothie: %s, Size: %s, Fruits: %d, Protein: %b, Price: %.2f",
                getName(), getSize(), numOfFruits, proteinPowder, calcPrice());
    }

    /**
     * Checks if two Smoothie objects are equal based on their attributes
     * @param obj The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Smoothie smoothie = (Smoothie) obj;
        return numOfFruits == smoothie.numOfFruits && proteinPowder == smoothie.proteinPowder;
    }
    
 // Getters and setters
    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean hasProtein() {
        return proteinPowder;
    }

    public void setAddProtein(boolean proteinPowder) {
        this.proteinPowder = proteinPowder;
    }
    
    public String getName() {
        return super.getBevName();
    }

    public void setName(String name) {
        super.setBevName(name);
    }
}
