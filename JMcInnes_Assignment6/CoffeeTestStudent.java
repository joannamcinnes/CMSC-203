/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The CoffeeTestStudent class verifies the Coffee class's price calculations, 
 * string representations, and equality checks, covering various configurations.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class for the Coffee class
public class CoffeeTestStudent {
	
	// Test method for calculating the price of the coffee beverage
	@Test
	public void testCalcPrice() {
		Coffee coffee = new Coffee("Latte", Size.SMALL, true, false);
		assertEquals(2.5, coffee.calcPrice(), 0.01);
		coffee = new Coffee("Latte", Size.LARGE, true, true);
		assertEquals(4.0, coffee.calcPrice(), 0.01);
	}

	// Test method for the toString method
	@Test
	public void testToString() {
		Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, true);
		assertTrue(coffee.toString().contains("Latte"));
		assertTrue(coffee.toString().contains("MEDIUM"));
		assertTrue(coffee.toString().contains("true"));
		assertTrue(coffee.toString().contains("Price: 3.5"));
	}

	// Test method for the equals method
	@Test
	public void testEquals() {
		Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, true, true);
		Coffee coffee2 = new Coffee("Latte", Size.MEDIUM, true, true);
		Coffee coffee3 = new Coffee("Latte", Size.LARGE, true, false);
		assertEquals(coffee1, coffee2);
		assertNotEquals(coffee1, coffee3);
	}
}
