/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The ManagementCompany class uses constant and instance fields to set 
 *    the maximum number of properties a management company can have as well as the 
 *    width and depth of the management company plot. This class provides constructors,  
 *    getter and setter methods, and defines several methods to perform conditional 
 *    checks and locate the highest rent property.
 * Due: 07/15/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

// Constant field values

public class ManagementCompany {
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	
// Instance variables
	private String name;             // name of management company 
	private String taxID;            // Tax ID of management company 
	private double mgmFeePer;        // Management fee of management company 
	private Property[] properties;   // Array of properties managed by the company
	private Plot plot;               // Plot of the management company overall
	private int numberOfProperties;  // Number of properties managed by the company
	
	/*
	 * Default constructor: Creates a ManagementCompany object using empty strings
	 * Creates a default Plot with maximum width and depth 
	 * Initializes the properties array (with no properties)
	 */
	
	public ManagementCompany() {
		this.properties = new Property[MAX_PROPERTY];
		this.name ="";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	/*
	 * Parameterized constructor: Creates a ManagementCompany object using the given values
	 * Creates a default Plot with maximum width and depth
	 * Initializes the properties array (with no properties)
	 */
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0 ,0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	/*
	 * Parameterized constructor: Creates a ManagementCompany object using the given values
	 * Creates a Plot with specified parameters (x, y, width, depth)
	 * Initializes the properties array (with no properties)
	 */
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
	}
	
	/*
	 * Copy constructor: Creates a new ManagementCompany copy of the given ManagementCompany
	 */

	public ManagementCompany(ManagementCompany otherCompany) {
	    this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer);
	    this.plot = new Plot(otherCompany.plot);
	    this.numberOfProperties = otherCompany.numberOfProperties;
	    this.properties = new Property[MAX_PROPERTY];
	    for (int i = 0; i < otherCompany.numberOfProperties; i++) {
	        this.properties[i] = new Property(otherCompany.properties[i]);
	    }
	}
	
	/*
	 * Gets the name
	 * @return name
	 */
	
	public String getName() {
		return name;
	}
	
	/*
	 * Sets the name
	 * @param name
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Gets taxId
	 * @return taxId
	 */
	
	public String getTaxID() {
		return taxID;
	}
	
	/*
	 * Sets taxId
	 * @param taxId
	 */
	
	public void setTaxID(String taxId) {
		this.taxID = taxId;
	}
	
	/*
	 * Gets the management fee per
	 * @return mgmFeePer
	 */
	
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	
	/*
	 * Sets the management fee per
	 * @param mgmFeePer
	 */
	
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}
	
	/*
	 * Gets the plot
	 * @return plot
	 */
	
	public Plot getPlot() {
		return plot;
	}
	
	/*
	 * Sets the plot with specified parameters (x, y, width, depth)
	 * @param x 
	 * @param y
	 * @param width
	 * @param depth
	 * @return plot
	 */
	
	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x, y, width, depth);
		return plot;
	}
	
	/*
	 * Gets the management width
	 * @return MGMT_WIDTH
	 */
	
	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}
	
	/*
	 * Gets the management depth
	 * @return MGMT_DEPTH
	 */
	
	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}

	/*
	 * Gets maximum number of properties
	 * @return MAX_PROPERTY
	 */
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/*
	 * Adds a new property to the properties array
	 * This method should call an appropriate existing overloaded method
	 * @param property
	 * @return conditional values (error code or number of properties)
	 */
	
	public int addProperty(Property property) {
		if (property == null) {
			return -2;
		}
	    if (numberOfProperties >= MAX_PROPERTY) {
	          return -1;
	    }
		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i] != null) {
//			    if (properties[i].getPlot().overlaps(property.getPlot())) {
//					return -4;
//			 	}
			}
		}
        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        return numberOfProperties - 1;	
	}
	
	/*
	 * Creates a new Property object with parameterized constructor and adds it to the properties array
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return conditional values (error code or number of properties)
	 */
	
	public int addProperty(String name, String city, double rent, String owner) {
		return addProperty(new Property(name, city, rent, owner));
	}
	
	/*
	 * Creates a new Property object with parameterized constructor (including plot location) and adds it to the properties array
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return conditional values (error code or number of properties)
	 */
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	/*
	 * Returns the total rent of the properties in the properties array
	 * @return total
	 */
	
	public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
	}
	
	/*
	 * This method returns the highest rent of all the properties 
	 * @return rentAmount
	 */
	
	public double getHighestRentAmount() {
		double rentAmount = 0;
		for (Property property: properties) {
			if (property == null) {
				break;
			}
			if (rentAmount < property.getRentAmount()) {
				rentAmount = property.getRentAmount();
			}
		}
		return rentAmount;
	}
	
	/*
	 * This method accesses each Property object within the properties array
	 * @return highestRentProperty
	 */
	
	public Property getHighestRentPropperty() {
        if (numberOfProperties == 0) {
            return null;
        }
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }
	
	/*
	 * Removes (nullifies) the last property in the properties array
	 */

	public void removeLastProperty() {
		if (numberOfProperties > 0) {
			properties[numberOfProperties - 1] = null;
			numberOfProperties--;
		}
	}

	/*
	 * Checks if the properties array has reached the maximum capacity
	 */

	public boolean isPropertiesFull() {
		if (numberOfProperties >= MAX_PROPERTY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Returns the number of existing properties in the array
	 */
	
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	/*
	 * Checks if the management company has a valid (between 0-100) fee
	 */
	
	public boolean isManagementFeeValid() {
		if (mgmFeePer >= 0 && mgmFeePer <= 100) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * This method returns the Property object with the highest rent amount within the properties array
	 * @return index
	 */
	
	public int maxRentPropertyIndex() {
		int index = 0;
		for (int count = 0; count < properties.length; count++) {
			if (properties[count] == null) {
				break;
			}
			if (properties [count].getRentAmount() >= properties[index].getRentAmount()) {
				index = count;
			}
		}
		return index;
	}
	
	/*
	 * Returns information in a string regarding the index of a property
	 */
	
	public String displayPropertyAtIndex(int count) {
		String string = properties[count].toString();
		return string;
	}
	
	/*
	 * Returns information of all the properties within this management company by accessing the Properties array
	 * @return string
	 */
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n\n");
        sb.append(" total management Fee: ").append(getTotalRent() * (mgmFeePer / 100));
        return sb.toString();    
	}
}
