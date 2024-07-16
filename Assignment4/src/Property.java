/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Property class has various constructors and getter and setter methods. 
 *    The Property class defines a toString method to return the property information as a string. 
 * Due: 07/15/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class Property {
	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot plot;
	
	/*
	 * Default constructor: Creates a new Property using empty Strings
	 * Also creates a default Plot
	 */
	
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.rentAmount = 0;
		this.plot = new Plot();
	}
	
	/*
	 * Parameterized constructor: Creates a new Property object using given values
	 * Also creates a default Plot
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 */
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		this.plot = new Plot();
	}
	
	/*
	 * Parameterized constructor: Creates a new Property object using given values (including the Plot location)
	 * Also creates a Plot using given values of a plot
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param owner - the owner's name
	 * @param rentAmount - rent amount
	 * @param x - the x coordinate of the plot
	 * @param y - the y coordinate of the plot
	 * @param width - the width coordinate of the plot
	 * @param depth - the depth coordinate of the plot
	 */
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/*
	 * Copy constructor: Creates a new copy of the given property object
	 * @param otherProperty - the Property object to make a copy of
	 */
		public Property(Property otherProperty) {
			this.propertyName = otherProperty.propertyName;
			this.city = otherProperty.city;
			this.owner = otherProperty.owner;
			this.rentAmount = otherProperty.rentAmount;
			this.plot = otherProperty.plot;
	}
		
	/*
	 * Gets the property name
	 * @return propertyName
	 */
	
		public String getPropertyName() {
			return propertyName;
		}
		
	/*
	 * Sets the property name
	 * @param propertyName
	 */
	
		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}
		
	/*
	 * Gets the city
	 * @return city
	 */
		
		public String getCity() {
			return city;
		}
		
	/*
	 * Sets the city
	 * @param city
	 */
		
		public void setCity(String city) {
			this.city = city;
		}
		
	/*
	 * Gets the owner
	 * @return owner
	 */
		
		public String getOwner() {
			return owner;
		}
		
	/*
	 * Sets the owner
	 * @param owner
	 */
		public void setOwner(String owner) {
			this.owner = owner;
		}
		
	/*
	 * Gets rent amount
	 * @return rentAmount
	 */
			
		public double getRentAmount() {
			return rentAmount;
		}
			
	/*
	 * Sets rent amount
	 * @param rentAmount
	 */
			
		public void setRentAmount(double rentAmount) {
			this.rentAmount = rentAmount;
		}	
		
	/*
	 * Gets the plot
	 * @return Plot
	 */
			
		public Plot getPlot() {
			return plot;
		}
		
	/*
	 * Sets the plot
	 * @param plot
	 */
		public void setPlot(Plot plot) {
			this.plot = plot;
		}
		
	/*
	 * Represents a Property object in the following String format: propertyName, city, owner, rentAmount
	 * @override toString in class Object
	 * @return string
	 */
		
	    @Override
	    public String toString() {
//			System.out.println("Property Name: " + propertyName + "\nLocated in city: " + city + "\nBelonging to: " + owner + "\nRent Amount: " + rentAmount);
            return propertyName + "," + city + "," + owner + "," + rentAmount;
		}
}


