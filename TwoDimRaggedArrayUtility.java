/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The TwoDimRaggedArrayUtility class manipulates a two-dimensional ragged array of doubles. 
 *     This class uses methods that read and write arrays from files. It also includes methods that perform calculations 
 *     to get the total, average, and highest/lowest values within the two-dimensional array. This class is also used to 
 *     create a Sales Report for Retail District #5, and accommodates positive and negative numbers.
 * Due: 07/22/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import java.io.*;

public class TwoDimRaggedArrayUtility {

	/*
	 * Reads from a file and returns a ragged array of doubles
	 * The maximum rows is 10 and the maximum columns for each row is 10
	 * Each row in the file is separated by a new line and each element in the row is separated by a space
	 * @param file - the file to read from
	 * @return a two-dimensional ragged (depending on data) array of doubles
	 * if the file is not empty, returns a null if file is empty
	 * @throws IOException - if an I/O error occurs
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
		final int MAX_ROWS = 10;
		final int MAX_COLUMNS = 10;
		String[][] tempData = new String[MAX_ROWS][MAX_COLUMNS];

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		int rowCount = 0;

		// Read the file into two-dimensional temporary array of size MAX_ROWS by MAX_COLUMNS
		try {
			while ((line = reader.readLine()) != null && rowCount < MAX_ROWS) {
				String[] values = line.split(" ");
				for (int col = 0; col < values.length && col < MAX_COLUMNS; col++) {
					tempData[rowCount][col] = values[col];
				}
				rowCount++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// If there are no rows, return null
		if (rowCount == 0) {
			return null;
		}

		// Transition from temporary array to the ragged array of doubles
		// Count the length of each row
		double[][] data = new double[rowCount][];
		for (int row = 0; row < rowCount; row++) {
			int colCount = 0;
			for (int col = 0; col < MAX_COLUMNS; col++) {
				if (tempData[row][col] != null) {
					colCount++;
				} else {
					break;
				}
			}
			data[row] = new double[colCount];
			for (int col = 0; col < colCount; col++) {
				data[row][col] = Double.parseDouble(tempData[row][col]);
			}
		}

		return data;
	}

	/*
	 * Writes the ragged array of doubles into the file
	 * Each row is on a separate line within the file and each double is separated by a space
	 * @param data - the two-dimensional ragged array of doubles
	 * @param file - the file to write to
	 * @throws IOException - if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

		// Double loop to write the ragged array of doubles into the file
		try {
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					writer.write(data[i][j] + " ");
				}
				writer.newLine();
			}
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Returns the total of all the elements of the two-dimensional array
	 * @param data - the two-dimensional ragged array of doubles
	 * @return - the sum of all the elements in the two-dimensional array
	 */ 
	public static double getTotal(double[][] data) {
		double total = 0;

		// Compute the total of all the values of the two-dimensional ragged array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		return total;
	}

	/*
	 * Returns the average of the elements in the two-dimensional array
	 * @param data - the two-dimensional ragged array of doubles
	 * @return the average of the elements in the two-dimensional array (total of elements/number of elements)
	 */
	public static double getAverage(double[][] data) {
		double total = 0;
		int numOfElements = 0;

		// Compute the sum of the values of the two-dimensional ragged array and the total number of elements
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
				numOfElements += 1;
			}
		}

		// Compute the average and return it
		return (total / numOfElements);
	}

	/*
	 * Returns the total of the selected row in the two-dimensional array (index 0 refers to the first row)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param row - the row index to take the total of
	 * @return the total of the specified row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;

		// Loop over all columns in the selected row
		for (int j = 0; j <data[row].length; j++) {
			total += data[row][j];
		}
		return total;
	}

	/*
	 * Returns the total of the selected column in the two-dimensional array (index 0 refers to the first column)
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method
	 * @param data - the two-dimensional ragged array of doubles
	 * @param col - the column index to take the total of
	 * @return the total of the specified column
	 */

	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;

		// Loop over all rows in the selected column
		for (int i = 0; i < data.length; i++) {
			if (col <= data[i].length - 1)
				total += data[i][col];
		}
		return total;
	}

	/*
	 * Returns the largest element of the selected row in the two dimensional array (index 0 refers to the first row)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param row - the row index to find the largest element of
	 * @return the largest element in the specified row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] > highest)
				highest = data[row][j];
		}
		return highest;
	}

	/*
	 * Returns the largest element of the selected row in the two dimensional array (index 0 refers to the first row)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param row - the row index to find the largest element of
	 * @return the index of the largest element in the specified row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		int index = 0;
		double highest = data[row][0];
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] > highest) {
				highest = data[row][j];
				index = j;
			}
		}
		return index;
	}

	/*
	 * Returns the smallest element of the selected row in the two dimensional array (index 0 refers to the first row)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param row - the row index to find the smallest element of
	 * @return the smallest element in the specified row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0]; 
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] < lowest)
				lowest = data[row][j];
		}
		return lowest;
	}

	/*
	 * Returns the index of the smallest element of the selected row in the two dimensional array (index 0 refers to the first row)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param row - the row index to find the smallest element of
	 * @return the index of the smallest element in the specified row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int index = 0;
		for (int i = 0; i < data[row].length; ++i) {
			if (data[row][i] < data[row][index]) {
				index = i;
			}
		}
		return index;
	}

	/*
	 * Returns the largest element of the selected column in the two dimensional array (index 0 refers to the first column)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param col - the column index to find the largest element of
	 * @return the largest element in the specified column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = Double.NEGATIVE_INFINITY;  // initialize to lowest possible value
		for (int i = 0; i < data.length; i++) {
			if (col <= data[i].length - 1) {
				if (data[i][col] > highest)
					highest = data[i][col];
			}
		}
		return highest;
	}

	/*
	 * Returns index of the largest element of the selected column in the two dimensional array (index 0 refers to the first column)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param col - the column index to find the largest element of
	 * @return the index of the largest element in the specified column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int index = -1;
		double highest = Double.NEGATIVE_INFINITY;
		// System.out.println("Debug: Initial highest value is " + highest);
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				// System.out.println("Debug: Checking value at row " + i + ", column " + col + ": " + data[i][col]);
				if (data[i][col] > highest) {
					highest = data[i][col];
					index = i;
					// System.out.println("Debug: New highest value is " + highest + " at index " + index);
				}
			}
		}
		return index;
	}
	
	/*
	 * Returns index of the largest positive element of the selected column in the two dimensional array (index 0 refers to the first column)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param col - the column index to find the largest element of
	 * @return the index of the largest element in the specified column
	 */
	public static int getHighestInColumnIndexPositive(double[][] data, int col) {
		int index = -1;
		double highest = Double.NEGATIVE_INFINITY;
		// System.out.println("Debug: Initial highest value is " + highest);
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				// System.out.println("Debug: Checking value at row " + i + ", column " + col + ": " + data[i][col]);
				// Check if data is greater than zero
				if (data[i][col] > highest && data[i][col] > 0) {
					highest = data[i][col];
					index = i;
					// System.out.println("Debug: New highest value is " + highest + " at index " + index);
				}
			}
		}
		return index;
	}

	/*
	 * Returns the smallest element of the selected column in the two dimensional array (index 0 refers to the first column)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param col - the column index to find the smallest element of
	 * @return the smallest element in the specified column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.POSITIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length && data[i][col] < lowest) {
				lowest = data[i][col];
			}
		}
		return lowest;
	}

	/*
	 * Returns the index of the smallest element of the selected column in the two-dimensional array (index 0 refers to the first column)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param col - the column index to find the smallest element of
	 * @return the index of the smallest element in the specified column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int index = -1;
		double lowest = Double.POSITIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length && data[i][col] < lowest) {
				lowest = data[i][col];
				index = i;
			}
		}
		return index;
	}
	
	/*
	 * Returns the index of the smallest positive element of the selected column in the two-dimensional array (index 0 refers to the first column)
	 * @param data - the two-dimensional ragged array of doubles
	 * @param col - the column index to find the smallest element of
	 * @return the index of the smallest element in the specified column
	 */
	public static int getLowestInColumnIndexPositive(double[][] data, int col) {
		int index = -1;
		double lowest = Double.POSITIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			// Check if data is greater than zero
			if (col < data[i].length && data[i][col] < lowest && data[i][col] > 0) {
				lowest = data[i][col];
				index = i;
			}
		}
		return index;
	}

	/*
	 * Returns the largest element in the two dimensional array
	 * @param data - the two-dimensional ragged array of doubles
	 * @return the largest element in the two-dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		return highest;
	}

	/*
	 * Returns the smallest element in the two dimensional array
	 * @param data - the two-dimensional ragged array of doubles
	 * @return the smallest element in the two-dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = Double.POSITIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}
}
