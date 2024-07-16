
/**
 * ManagementCompanyTestStudent: This class represents student test cases for a ManagementCompany object. 
 * We test the various constructors and methods. 
 * 
 * @author Joanna McInnes
 * @version 7/15/2024 -- extending ManagementCompanyTestGFA
 * 
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	ManagementCompany mc ; 
	
	@Before
	public void setUp() throws Exception {
		mc= new ManagementCompany("Railey", "555555555",6.0);
	}

	@After
	public void tearDown() throws Exception {
		mc=null;
	}

    @Test
    // Tests ManagementCompany default constructor (with no parameters)
    public void testDefaultConstructor() {
        ManagementCompany mcd = new ManagementCompany();
        assertEquals("", mcd.getName());
        assertEquals("", mcd.getTaxID());
        assertEquals(0.0, mcd.getMgmFeePer(), 0.01);
        assertEquals(0, mcd.getPropertiesCount());
    }

    @Test
    // Tests ManagementCompany parameterized constructor 
    public void testParameterizedConstructor() {
        assertEquals("Railey", mc.getName());
        assertEquals("555555555", mc.getTaxID());
        assertEquals(6.0, mc.getMgmFeePer(), 0.01);
    }

    @Test
    // Tests ManagementCompany copy constructor 
    public void testCopyConstructor() {
        ManagementCompany mcCopy = new ManagementCompany(mc);
        assertEquals(mc.getName(), mcCopy.getName());
        assertEquals(mc.getTaxID(), mcCopy.getTaxID());
        assertEquals(mc.getMgmFeePer(), mcCopy.getMgmFeePer(), 0.01);
 //       assertEquals(mc.getPlot(), mcCopy.getPlot());
    }

	@Test
	// Tests adding an array of properties (until exceeding allowable space in array)
	public void testAddProperty() {
        Property p1 = new Property("SilverBrook", "Potomac", 3420.0, "John McInnes");
        assertEquals(0, mc.addProperty(p1));
        assertEquals(1, mc.getPropertiesCount());

        Property p2 = new Property("Loblolly", "Lakewood", 1204.0, "Lois McInnes");
        assertEquals(1, mc.addProperty(p2));
        assertEquals(2, mc.getPropertiesCount());

        Property p3 = new Property("Sugar Creek Lodge", "New Philadelphia", 4630.0, "Mariel McInnes", 2, 2, 2, 2);
        assertEquals(2, mc.addProperty(p3));
        assertEquals(3, mc.getPropertiesCount());

        Property p4 = new Property("Sheridan Place", "Lebanon", 2504.0, "Joanna McInnes");
        assertEquals(3, mc.addProperty(p4));
        assertEquals(4, mc.getPropertiesCount());

        Property p5 = new Property("Hershey Park Lodge", "Lemont", 5310.0, "Tom Curfman");
        assertEquals(4, mc.addProperty(p5));
        assertEquals(5, mc.getPropertiesCount());

        Property p6 = new Property("Extra Property", "Extra", 8740.0, "Extra Owner");
        assertEquals(-1, mc.addProperty(p6)); // Should fail because array is full (max 5 properties)
    }

    @Test
    // Tests various invalid cases for adding properties
    public void testAddPropertyInvalidCases() {
        Property nullProperty = null;
        assertEquals(-2, mc.addProperty(nullProperty)); // Property is null

        Property outOfBoundProperty = new Property("Out of Bound", "Texas", 3000.0, "My Mom", 11, 11, 1, 1);
        assertEquals(-3, mc.addProperty(outOfBoundProperty)); // Property plot is not encompassed

//        Property overlapProperty = new Property("Overlap", "Overlap City", 4000.0, "Overlap Owner", 2, 2, 2, 2);
//        mc.addProperty(overlapProperty); // Adding first overlap property
//        Property anotherOverlapProperty = new Property("Another Overlap", "Overlap City", 5000.0, "Another Overlap Owner", 2, 2, 2, 2);
//        assertEquals(-4, mc.addProperty(anotherOverlapProperty)); // Overlaps with the existing property
    }

    @Test
    // Tests getting the name of the management company
    public void testGetName() {
        // Check if the name is correctly returned
        assertEquals("Railey", mc.getName());

        // Create another ManagementCompany with a different name and check
        ManagementCompany mc2 = new ManagementCompany("Company B", "1002003004", 7.0);
        assertEquals("Company B", mc2.getName());
    }
    
	@Test
    // Tests getting the count of properties
	public void testGetPropertiesCount() {
		Property p0 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mc.addProperty(p0),0,0);	
		assertEquals(mc.getPropertiesCount(), 1);
	}

	@Test
	public void testGetMgmFeePer() {
		// Check if the management fee percentage is correctly returned
		assertEquals(6.0, mc.getMgmFeePer(), 0.01);

		// Create another ManagementCompany with a different management fee and check
		ManagementCompany mc2 = new ManagementCompany("Company B", "1002003004", 8.9);
		assertEquals(8.9, mc2.getMgmFeePer(), 0.01);

		// Create another ManagementCompany with a different management fee and check
		ManagementCompany mc3 = new ManagementCompany("Company C", "4003002001", 0.2);
		assertEquals(0.2, mc3.getMgmFeePer(), 0.01);
	}

    @Test
    // Tests getting the total rent of several properties
    public void testGetTotalRent() {
        mc.addProperty("Property A", "City A", 1000, "Owner A");
        mc.addProperty("Property B", "City B", 2000, "Owner B");
        mc.addProperty("Property C", "City C", 3000, "Owner C");
        assertEquals(6000, mc.getTotalRent(), 0.01);
    }

    @Test
    // Tests identifying the highest rent of several properties
    public void testGetHighestRentPropperty() {
        mc.addProperty("Property A", "City A", 1000, "Owner A");
        mc.addProperty("Property B", "City B", 3000, "Owner B");
        mc.addProperty("Property C", "City C", 2000, "Owner C");
        assertEquals(3000, mc.getHighestRentPropperty().getRentAmount(), 0.01);
    }

    @Test
    // Tests removing  the last property
    public void testRemoveLastProperty() {
        mc.addProperty("Property A", "City A", 1000, "Owner A");
        mc.addProperty("Property B", "City B", 2000, "Owner B");
        assertEquals(2, mc.getPropertiesCount());
        mc.removeLastProperty();
        assertEquals(1, mc.getPropertiesCount());
    }

    @Test
    // Tests whether the properties array is full
    public void testIsPropertiesFull() {
        mc.addProperty("Property A", "City A", 1000, "Owner A");
        mc.addProperty("Property B", "City B", 2000, "Owner B");
        mc.addProperty("Property C", "City C", 3000, "Owner C");
        mc.addProperty("Property D", "City D", 4000, "Owner D");
        mc.addProperty("Property E", "City E", 5000, "Owner E");
        assertTrue(mc.isPropertiesFull());
    }

    @Test
    // Test getting the Tax ID
    public void testGetTaxID() {
    	// Check if the tax ID is correctly returned
    	assertEquals("555555555", mc.getTaxID());

    	// Create another ManagementCompany with a different tax ID and check
    	ManagementCompany mc2 = new ManagementCompany("My New Company", "123456789", 15.0);
    	assertEquals("123456789", mc2.getTaxID());
    }

    @Test
    // Tests whether the management fee is valid
    public void testIsMangementFeeValid() {
        assertTrue(mc.isManagementFeeValid());

        mc = new ManagementCompany("Railey", "555555555", 150.0);
        assertFalse(mc.isManagementFeeValid());
    }
    
	@Test
	public void testToString() {
		Property p0 = new Property ("Sunsational", "Beckman", 2613.0, "BillyBob Wilson",2,5,2,2);
		assertEquals(mc.addProperty(p0), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Railey, taxID: 555555555\n"
				+ "______________________________________________________\n"
				+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
				+ "______________________________________________________\n"
				+ "\n"
				+ " total management Fee: 156.78";
		System.out.println(expectedString);
		System.out.println(mc.toString());
		assertEquals(expectedString, mc.toString());
				
	}

	   @Test
	    public void testToStringMultiple() {
	        mc.addProperty("McInnes Home", "Rockville", 1205.0, "John McInnes");
	        mc.addProperty("Curfman Home", "Palmyra", 2205.1, "Tom Curfman");
	        mc.addProperty("Lakewood ES", "Rockville", 2305.2, "MCPS");
	        mc.addProperty("McInnes Home2", "Rockville", 3115.4, "Lois McInnes");
	        mc.addProperty("Curfman Home2", "Hershey", 5020.6, "Annette Curfman");

	        String expectedString = "List of the properties for Railey, taxID: 555555555\n"
	                        + "______________________________________________________\n"
	                        + "McInnes Home,Rockville,John McInnes,1205.0\n"
	                        + "Curfman Home,Palmyra,Tom Curfman,2205.1\n"
	                        + "Lakewood ES,Rockville,MCPS,2305.2\n"
	                        + "McInnes Home2,Rockville,Lois McInnes,3115.4\n"
	                        + "Curfman Home2,Hershey,Annette Curfman,5020.6\n"
	                        + "______________________________________________________\n"
	        				+ "\n"
	                        + " total management Fee: 831.078";
			System.out.println(expectedString);
			System.out.println(mc.toString());
	        assertEquals(expectedString, mc.toString());
	    }
}
