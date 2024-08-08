/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The SmoothieTestStudent class tests the Smoothie class for accurate 
 * price calculations, string representations, and equality checks, considering fruit 
 * count and protein addition.
 * Due: 08/07/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmoothieTestStudent {

	// Test calculating the price of various smoothies
    @Test
    public void testCalcPrice() {
    	// Smoothie price (small, 1 fruit, no protein) = $2.00 + 0.50
        Smoothie smoothie = new Smoothie("Berry Blast", Size.SMALL, 1, false);
        assertEquals(2.50, smoothie.calcPrice(), 0.01);

        // Smoothie price (large, 3 fruits, with protein) = $2.00 + $1.00 + 1.50 + 1.50
        smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        assertEquals(6.00, smoothie.calcPrice(), 0.01);
    }

    // Test the toString functionality
    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 2, true);
        assertTrue(smoothie.toString().contains("Berry Blast"));
        assertTrue(smoothie.toString().contains("MEDIUM"));
        assertTrue(smoothie.toString().contains("true"));
        assertTrue(smoothie.toString().contains("2"));
        assertTrue(smoothie.toString().contains("Price: 5.0"));
    }

    /// Test comparision of various smoothies
    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Berry Blast", Size.MEDIUM, 2, true);
        Smoothie smoothie2 = new Smoothie("Berry Blast", Size.MEDIUM, 2, true);
        Smoothie smoothie3 = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        assertEquals(smoothie1, smoothie2);
        assertNotEquals(smoothie1, smoothie3);
    }
}
