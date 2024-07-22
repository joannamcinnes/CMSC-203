
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents test cases for a HolidayBonus object.
 * The retail store with the highest amount sold in the category will receive $5,000. 
 * The retail store with the lowest amount sold in a category will receive $1,000. 
 * All other retail stores in district #5 will receive $2,000. 
 * If a retail store did not sell anything in a category, or they have a negative sales amount, 
 * they are not eligible for a bonus in that category. 
 * If only one retail store sold items in a category, they are eligible to receive only the bonus 
 * of $5000 for that category.
 * 
 * @author Joanna McInnes
 * @version 7/22/2024
 * 
 */
public class HolidayBonusTestStudent {

	private double[][] dataSet2;
	private double[][] dataSetEmpty;
	private double[][] dataSet3Negative;

	@Before
	// Data set for 4 stores with 5 categories of sales
	public void setUp() throws Exception {
		dataSet2 = new double[][] {
			{10.0, 20.0, 30.0},
			{40.0, 50.0, 60.0},
			{70.0, 80.0},
			{90.0, 100.0, 110.0, 120.0, 130.0}
		};

		// Data set for no stores
		dataSetEmpty = new double[][] {};

		// Data set for 4 stores with 5 categories of sales
		dataSet3Negative = new double[][] {
			{-1.0, -2.0, -3.0},
			{4.0, -5.0, 6.0},
			{-7.0, 8.0},
			{9.0, -10.0, 11.0, -12.0, -13.0}
		};
	}

	@After
	public void tearDown() throws Exception {
	}

	// Test computing HolidayBonus (using dataSet2)
	@Test
	public void testCalculateHolidayBonusB() {
		double[] bonuses = HolidayBonus.calculateHolidayBonus(dataSet2);
		// System.out.println("Debug: bonuses = " + java.util.Arrays.toString(bonuses));
		assertNotNull(bonuses);  // Make sure that the bonuses array is not null
		assertEquals(4, bonuses.length);  // Check the number of stores
		assertEquals(HolidayBonus.LOWEST_BONUS * 3, bonuses[0], 0.001);   // Store 0: 3 lowest bonuses
		assertEquals(HolidayBonus.OTHER_BONUS * 3, bonuses[1], 0.001);    // Store 1: 3 other bonuses
		assertEquals(HolidayBonus.OTHER_BONUS * 2, bonuses[2], 0.001);    // Store 2: 2 other bonuses
		assertEquals(HolidayBonus.HIGHEST_BONUS * 5, bonuses[3], 0.001);  // Store 3: 5 highest bonuses
	}

	// Test computing HolidayBonus (with empty data set)
	@Test
	public void testCalculateHolidayBonusWithEmptyData() {
		double[] bonuses = HolidayBonus.calculateHolidayBonus(dataSetEmpty);
		assertNotNull(bonuses);
		assertEquals(0, bonuses.length);
	}
	
	// Tests computing HolidayBonus using dataSet3 with negative data
    @Test
    public void testCalculateHolidayBonusWithNegativeSalesData() {
        // System.out.println("Starting negative test!");
    	double[] bonuses = HolidayBonus.calculateHolidayBonus(dataSet3Negative);
        // System.out.println("Debug: bonuses (negativeSalesData) = " + java.util.Arrays.toString(bonuses));
        assertNotNull(bonuses);
        assertEquals(4, bonuses.length);
        assertEquals(0, bonuses[0], 0.001); 							 // Store 0: no bonuses
        assertEquals(HolidayBonus.LOWEST_BONUS * 2, bonuses[1], 0.001);  // Store 1: 2 lowest bonuses
        assertEquals(HolidayBonus.HIGHEST_BONUS, bonuses[2], 0.001);	 // Store 2: 1 highest bonus
        assertEquals(HolidayBonus.HIGHEST_BONUS * 2, bonuses[3], 0.001); // Store 3: 2 highest bonuses
    }
    
	// Test computing total holiday bonuses (using dataSet2)
	@Test
	 public void testCalculateTotalHolidayBonus() {
	        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(dataSet2);
	        // System.out.println("Debug: totalBonus = " + totalBonus);
	        // Adding the total of store 0 (3 lowest bonuses) + store 1 and store 2 (5 other bonuses) + store 3 (5 highest bonuses)
	        assertEquals(HolidayBonus.LOWEST_BONUS * 3 + HolidayBonus.OTHER_BONUS * 5 + HolidayBonus.HIGHEST_BONUS * 5, totalBonus, 0.001);
	    }

	// Test computing total HolidayBonus (with empty data set)
    @Test
    public void testCalculateTotalHolidayBonusWithEmptyData() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(dataSetEmpty);
        // System.out.println("Debug: totalBonus (emptyData) = " + totalBonus);
        assertEquals(0.0, totalBonus, 0.001);
    }
}
