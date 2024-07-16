
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * PropertyTestStudent: This class represents student test cases for a Property object. 
 * We test the various constructors and methods. 
 * 
 * @author Joanna McInnes
 * @version 7/15/2024 -- extending PropertyTestGFA
 * 
 */

class PropertyTestStudent {
	Property propertyOne;
	Property defaultProperty;
	Property parameterizedProperty;
	Property parameterizedPropertyWithPlot;
	Property copyProperty;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
		defaultProperty = new Property();
		parameterizedProperty = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
		parameterizedPropertyWithPlot = new Property("Property DEF", "Bethesda", 3500.00, "Truist Bank", 2, 3, 5, 10);
		copyProperty = new Property(parameterizedProperty);
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
		defaultProperty = null;
		parameterizedProperty = null;
		parameterizedPropertyWithPlot = null;
		copyProperty = null;
	}

	@Test
	// Tests the default constructor
	void testDefaultConstructor() {
		assertEquals("", defaultProperty.getPropertyName());
		assertEquals("", defaultProperty.getCity());
		assertEquals("", defaultProperty.getOwner());
		assertEquals(0, defaultProperty.getRentAmount(), 0.01);
		assertNotNull(defaultProperty.getPlot());
	}

	@Test
	// Tests the parameterized constructor
	void testParameterizedConstructor() {
		assertEquals("Property ABC", parameterizedProperty.getPropertyName());
		assertEquals("Rockville", parameterizedProperty.getCity());
		assertEquals("Wells Fargo Bank", parameterizedProperty.getOwner());
		assertEquals(2450.00, parameterizedProperty.getRentAmount(), 0.01);
		assertNotNull(parameterizedProperty.getPlot());
	}


	@Test
	// Tests the parameterized constructor (with plot)
	public void testParameterizedConstructorWithPlot() {
		assertEquals("Property DEF", parameterizedPropertyWithPlot.getPropertyName());
		assertEquals("Bethesda", parameterizedPropertyWithPlot.getCity());
		assertEquals("Truist Bank", parameterizedPropertyWithPlot.getOwner());
		assertEquals(3500.00, parameterizedPropertyWithPlot.getRentAmount(), 0.01);
		assertNotNull(parameterizedPropertyWithPlot.getPlot());
		assertEquals(2, parameterizedPropertyWithPlot.getPlot().getX());
		assertEquals(3, parameterizedPropertyWithPlot.getPlot().getY());
		assertEquals(5, parameterizedPropertyWithPlot.getPlot().getWidth());
		assertEquals(10, parameterizedPropertyWithPlot.getPlot().getDepth());
	}

    @Test
	// Tests the copy constructor 
    public void testCopyConstructor() {
        assertEquals("Property ABC", copyProperty.getPropertyName());
        assertEquals("Rockville", copyProperty.getCity());
        assertEquals("Wells Fargo Bank", copyProperty.getOwner());
        assertEquals(2450.00, copyProperty.getRentAmount(), 0.01);
        assertNotNull(copyProperty.getPlot());
    }

	@Test
	// Tests the various setters and getters
	public void testGettersAndSetters() {
		defaultProperty.setPropertyName("Property ABC");
		assertEquals("Property ABC", defaultProperty.getPropertyName());

		defaultProperty.setCity("Gaithersburg");
		assertEquals("Gaithersburg", defaultProperty.getCity());

		defaultProperty.setOwner("Mariel McInnes");
		assertEquals("Mariel McInnes", defaultProperty.getOwner());

		defaultProperty.setRentAmount(6000.00);
		assertEquals(6000.00, defaultProperty.getRentAmount(), 0.01);
	}

	@Test
	void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0",propertyOne.toString());	
	}

}
