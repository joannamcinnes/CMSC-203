
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * PlotTestStudent: This class represents student test cases for a Plot object. 
 * We test the various constructors and methods. 
 * 
 * @author Joanna McInnes
 * @version 7/15/2024 -- extending PlotTestGFA
 * 
 */
public class PlotTestStudent {
	private Plot plot1, plot5;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 3, 6, 7);
		plot5 = new Plot(3, 4, 4, 3);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

    @Test
    // Tests Plot default constructor (with width and depth of 1, or dimensions 0,0,1,1)
    public void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    // Tests Plot parameterized constructor (with dimensions 2,3,6,7)
    public void testParameterizedConstructor() {
        Plot plot = new Plot(2, 3, 6, 7);
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(6, plot.getWidth());
        assertEquals(7, plot.getDepth());
    }

    @Test
    // Tests Plot copy constructor
    public void testCopyConstructor() {
        Plot plot1 = new Plot(2, 3, 6, 7);
        Plot plot2 = new Plot(plot1);
        assertEquals(2, plot2.getX());
        assertEquals(3, plot2.getY());
        assertEquals(6, plot2.getWidth());
        assertEquals(7, plot2.getDepth());
    }
    
    @Test
    // Tests all setter and getter methods for all instance variables
    public void testSettersAndGetters() {
        Plot plot = new Plot();
        plot.setX(2);
        plot.setY(3);
        plot.setWidth(6);
        plot.setDepth(7);

        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(6, plot.getWidth());
        assertEquals(7, plot.getDepth());
    }

    @Test
    // Tests the 'overlaps' methods (with various plot locations/sizes)
    public void testOverlaps() {
        
        Plot plot1 = new Plot(0, 0, 10, 10);   // Plot1: starting at (0,0): 10x10  
        Plot plot2 = new Plot(5, 5, 10, 10);   // Plot2: starting at (5,5): 10x10 // Overlaps 
        Plot plot3 = new Plot(10, 10, 2, 2);   // Plot3: starting at (10,10): 2x2 // Overlaps (boundary case)
        Plot plot4 = new Plot(12, 12, 2, 2);   // Plot3: starting at (12,12): 2x2 // Does not overlap

        assertTrue(plot1.overlaps(plot2));
        assertTrue(plot1.overlaps(plot3));
        assertFalse(plot1.overlaps(plot4));
    }

    @Test
    // Tests the 'encompasses' method (with various plot locations/sizes) 
    public void testEncompasses() {
        Plot plot1 = new Plot(0, 0, 10, 10);    // Plot1: starting at (0,0): 10x10
        Plot plot2 = new Plot(1, 1, 5, 5);      // Plot2: starting at (1,1): 5x5
        Plot plot3 = new Plot(0, 0, 10, 10);    // Plot1: starting at (0,0): 10x10
        Plot plot4 = new Plot(-2, -2, 15, 15);  // Plot1: starting at (-2,-2): 15x15

        assertTrue(plot1.encompasses(plot2));
        assertTrue(plot1.encompasses(plot3));
        assertFalse(plot1.encompasses(plot4));
    }

    @Test
    // Tests the 'toString' method to ensure that the correct string is returned
    public void testToString() {
        Plot plot = new Plot(2, 3, 6, 7);
        assertEquals("2,3,6,7", plot.toString());
    }
}
