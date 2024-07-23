/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The HolidayBonus class calculates holiday bonuses given a ragged array of doubles
 *     which represent the sales for each store in each category. The class will take in a bonus amount 
 *     for the store with the highest sales in a category as well as the bonus amount for the store with the
 *     lowest sales in a category. It will also take in the bonus amount for all other stores. 
 *     The retail store with the highest amount sold in the category will receive $5,000. 
 *	   The retail store with the lowest amount sold in a category will receive $1,000. 
 * 	   All other retail stores in district #5 will receive $2,000. 
 *     If a retail store didn’t sale anything in a category, or they have a negative sales amount, 
 *     they are not eligible for a bonus in that category. 
 *     If only one retail store sold items in a category, they are eligible to receive only the bonus 
 *     of $5000 for that category.
 * Due: 07/22/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class HolidayBonus {
	
    // Set the bonus amounts
	public static final double HIGHEST_BONUS = 5000;
	public static final double LOWEST_BONUS = 1000;
	public static final double OTHER_BONUS = 2000;

	/*
	 * No-arg constructor 
	 */
	public HolidayBonus() {

	}

	/*
	 * Calculates the holiday bonus for each store
	 * Passes in a two-dimensional ragged array of doubles (representing store sales)
	 * Returns an array of doubles which represents the holiday bonuses for each of the stores in the district
	 * Uses methods from the class TwoDimRaggedArrayUtility when needed
	 * @param data - the two-dimensional array of store sales
	 * @return an array of the bonus for each store
	 */
	
	public static double[] calculateHolidayBonus(double[][] data) {
        // System.out.println("Debug: Starting calculateHolidayBonus");

        // Create array of doubles for bonuses
        double[] bonuses = new double[data.length];

        // Compute the maximum number of columns
        int maxColumns = getMaxColumns(data);
        // System.out.println("Debug: maxColumns = " + maxColumns);

        // Loop over all columns 
        for (int col = 0; col < maxColumns; col++) {
            // Get index for highest and lowest bonuses
            int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndexPositive(data, col);
            int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndexPositive(data, col);
            // System.out.println("Debug: For column " + col + ", highestIndex = " + highestIndex + ", lowestIndex = " + lowestIndex);

            // Check if highest index has valid sales
            if (highestIndex != -1 && data[highestIndex][col] > 0) {
                bonuses[highestIndex] += HIGHEST_BONUS;
                // System.out.println("Debug: Added HIGHEST_BONUS to store " + highestIndex);
            } else {
                highestIndex = -1; // Invalidate if highest is not eligible
            }

            // Check if lowest index has valid sales (positive) and is different from highest index
            if (lowestIndex != -1 && data[lowestIndex][col] > 0 && highestIndex != lowestIndex) {
                bonuses[lowestIndex] += LOWEST_BONUS;
                // System.out.println("Debug: Added LOWEST_BONUS to store " + lowestIndex);
            } else {
                lowestIndex = -1; // Invalidate if lowest is not eligible
            }

            // Compute other bonuses at the store
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && row != highestIndex && row != lowestIndex && data[row][col] > 0) {
                    bonuses[row] += OTHER_BONUS;
                    // System.out.println("Debug: Added OTHER_BONUS to store " + row);
                }
            }
        }
        // System.out.println("Debug: Finished calculateHolidayBonus");
        return bonuses;
    }
	
	/*
	 * Calculates the total holiday bonuses
	 * Pass in a two-dimensional ragged array of doubles
	 * Returns a double which represents the total of all Holiday Bonuses for the District
	 * @param data - the two-dimensional array of store sales
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double totalBonus = 0;
		// Calculate the holiday bonuses for each store
		double[] bonuses = calculateHolidayBonus(data);

		// Compute the total of all holiday bonuses for all stores
		for (int i = 0; i < bonuses.length; i++) {
			totalBonus += bonuses[i];
		}
		return totalBonus;
	}

	/*
	 * Helper method to get the maximum number of columns in the ragged array
	 * @param data - the two-dimensional array of store sales
	 * @return the maximum number of columns
	 */
	private static int getMaxColumns(double[][] data) {
		int maxColumns = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > maxColumns) {
				maxColumns = data[i].length;
			}
		}
		return maxColumns;
	}	
}
