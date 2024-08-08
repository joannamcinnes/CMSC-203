/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Beverage class is an abstract base class for beverages with attributes 
 * for name, type, size, and pricing constants. It defines methods for price calculation, 
 * string representation, and equality checks.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public abstract class Beverage {
	private String name;
	private Type type;
	private Size size;
	private static final double BASE_PRICE = 2.0;
	private static final double SIZE_PRICE = 0.5;

	/**
	 * Constructor to create a Beverage object.
	 * @param name The name of the beverage.
	 * @param type The type of the beverage.
	 * @param size The size of the beverage (small, medium, large).
	 */
	public Beverage(String name, Type type, Size size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}

	// Menu for increasing the price based on size
	public double addSizePrice() {
		double price = BASE_PRICE;
		switch (size) {
		case MEDIUM:
			price += SIZE_PRICE;
			break;
		case LARGE:
			price += 2 * SIZE_PRICE;
			break;
		default:
			break;
		}
		return price;
	}

	/**
	 * Calculates the price of the beverage. Must be implemented by subclasses.
	 * @return The price of the beverage.
	 */
	public abstract double calcPrice();

	/**
	 * Provides a string representation of the beverage.
	 * @return A string with the details of the beverage.
	 */
	@Override
	public String toString() {
		return String.format("Beverage: %s, Size: %s", name, size);
	}

	/**
	 * Checks if two Beverage objects are equal based on their attributes.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Beverage beverage = (Beverage) obj;
		return name.equals(beverage.name) &&
				type == beverage.type &&
				size == beverage.size;
	}

	// Getters and setters
	public String getBevName() {
		return name;
	}

	public void setBevName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public double getBasePrice() {
		return BASE_PRICE;
	}

	public double getSizePrice() {
		return SIZE_PRICE;
	}
}