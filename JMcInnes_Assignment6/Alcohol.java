/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Alcohol class represents alcoholic beverages with a weekend charge attribute.
 * It implements methods to calculate price and override string representation and equality checks.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class Alcohol extends Beverage {
	private boolean offeredInWeekend;
	private static final double WEEKEND_COST = 0.6;

	/**
	 * Constructor to create an Alcohol object
	 * @param name The name of the alcohol
	 * @param size The size of the alcohol (small, medium, large)
	 * @param isWeekend Whether the alcohol is purchased on a weekend
	 */
	public Alcohol(String name, Size size, boolean offeredInWeekend) {
		super(name, Type.ALCOHOL, size);
		this.offeredInWeekend = offeredInWeekend;
	}

	/**
	 * Calculates the price of the alcohol based on its size and whether it has a weekend charge
	 * @return The price of the alcohol
	 */
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if (offeredInWeekend) price += WEEKEND_COST;
		return price;
	}

	/**
	 * Provides a string representation of the alcohol
	 * @return A string with the details of the alcohol
	 */
	@Override
	public String toString() {
		return String.format("Alcohol: %s, Size: %s, Weekend: %b, Price: %.2f",
				getName(), getSize(), offeredInWeekend, calcPrice());
	}

	/**
	 * Checks if two Alcohol objects are equal based on their attributes
	 * @param obj The object to compare with
	 * @return True if the objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
		Alcohol alcohol = (Alcohol) obj;
		return offeredInWeekend == alcohol.offeredInWeekend;
	}

	// Getters and setters
	public String getName() {
		return super.getBevName();
	}

	public void setName(String name) {
		super.setBevName(name);
	}

	public boolean isWeekend() {
		return offeredInWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.offeredInWeekend = isWeekend;
	}
}