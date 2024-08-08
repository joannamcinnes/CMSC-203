/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The AlcoholTestStudent class tests the Alcohol class for correct 
 * price calculations, string representations, and equality comparisons under different scenarios.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class for the Alcohol class
public class AlcoholTestStudent {

	// Tests calculating the price of various alcoholic beverages
	@Test
	public void testCalcPrice() {

		// Cost of a small whiskey that is not offered on the weekend: $2.00
		Alcohol alcohol = new Alcohol("Whiskey", Size.SMALL, false);
		assertEquals(2.00, alcohol.calcPrice(), 0.01);

		// Cost of a large whiskey that is offered on the weekend: $3.60
		alcohol = new Alcohol("Whiskey", Size.LARGE, true);
		assertEquals(3.60, alcohol.calcPrice(), 0.01);

		// Cost of a medium whiskey that is offered on the weekend: $3.10
		alcohol = new Alcohol("Whiskey", Size.MEDIUM, true);
		assertEquals(3.10, alcohol.calcPrice(), 0.01);
	}

	// Tests the toString functionality
	@Test
	public void testToString() {
		// Price of a medium whiskey (weekend): $2.00 + 0.50 + 0.60 = $3.10
		Alcohol alcohol = new Alcohol("Whiskey", Size.MEDIUM, true);
		System.out.println(alcohol.toString());
		assertTrue(alcohol.toString().contains("Whiskey"));
		assertTrue(alcohol.toString().contains("MEDIUM"));
		assertTrue(alcohol.toString().contains("true"));
		assertTrue(alcohol.toString().contains("Price: 3.1"));
	}

	// Tests whether two drinks are equivalent
	@Test
	public void testEquals() {
		Alcohol alcohol1 = new Alcohol("Whiskey", Size.MEDIUM, true);
		Alcohol alcohol2 = new Alcohol("Whiskey", Size.MEDIUM, true);
		Alcohol alcohol3 = new Alcohol("Whiskey", Size.LARGE, false);
		assertEquals(alcohol1, alcohol2);
		assertNotEquals(alcohol1, alcohol3);
	}
}
