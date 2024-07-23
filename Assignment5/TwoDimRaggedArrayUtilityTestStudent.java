
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents student test cases for a TwoDimRaggedArrayUtility object.
 * We test the various constructors and methods. 
 * @author Joanna McInnes
 * @version 7/22/2024
 * 
 */
public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] data;

	@BeforeEach
	// Set up 2-dimensional ragged array for use in various tests
    public void setUp() {
        data = new double[][] {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0},
            {10.0}
        };
    }

	// Tests reading the file
    @Test
    public void testReadFile() throws FileNotFoundException {
    	
    	// Create an input file and insert data
        File inputFile = new File("test_input.txt");
        try (PrintWriter writer = new PrintWriter(inputFile)) {
            writer.println("1.0 2.0 3.0");
            writer.println("4.0 5.0");
            writer.println("6.0 7.0 8.0 9.0");
            writer.println("10.0");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read data from this file and compare with expected values for each row
        double[][] result = TwoDimRaggedArrayUtility.readFile(inputFile);
        assertNotNull(result);
        assertEquals(4, result.length);
        assertArrayEquals(new double[] {1.0, 2.0, 3.0}, result[0]);
        assertArrayEquals(new double[] {4.0, 5.0}, result[1]);
        assertArrayEquals(new double[] {6.0, 7.0, 8.0, 9.0}, result[2]);
        assertArrayEquals(new double[] {10.0}, result[3]);
    }
    
    // Tests writing the file
    @Test
    public void testWriteToFile() throws IOException {
    	
    	// Create an output file and write data to it
        File outputFile = new File("test_output.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, outputFile);

        // Read data from the file and compare with expected values for each row
        double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertNotNull(result);
        assertEquals(4, result.length);
        assertArrayEquals(new double[] {1.0, 2.0, 3.0}, result[0]);
        assertArrayEquals(new double[] {4.0, 5.0}, result[1]);
        assertArrayEquals(new double[] {6.0, 7.0, 8.0, 9.0}, result[2]);
        assertArrayEquals(new double[] {10.0}, result[3]);
    }
    
    // Tests computing the total of all elements in the two-dimensional array
    @Test
    public void testGetTotal() {
        double total = TwoDimRaggedArrayUtility.getTotal(data);
        assertEquals(55.0, total, 0.001);
    }

    // Tests computing the average of all elements in the two-dimensional array
    @Test
    public void testGetAverage() {
        double average = TwoDimRaggedArrayUtility.getAverage(data);
        assertEquals(5.5, average, 0.001);
    }

    // Tests computing total of the selected row in the two-dimensional array 
    @Test
    public void testGetRowTotal() {
    	double rowTotal;
    	
    	// Test for each row in the array
    	rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 0);
        assertEquals(6.0, rowTotal, 0.001);
          
        rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 1);
        assertEquals(9.0, rowTotal, 0.001);
        
        rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 2);
        assertEquals(30.0, rowTotal, 0.001);
        
        rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 3);
        assertEquals(10.0, rowTotal, 0.001);
    }

    // Tests computing total of the selected column in the two-dimensional array 
    @Test
    public void testGetColumnTotal() {
        double columnTotal;
        
       	// Test for each column in the array
        columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);
        assertEquals(21.0, columnTotal, 0.001);
        
        columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 1);
        assertEquals(14.0, columnTotal, 0.001);
        
        columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 2);
        assertEquals(11.0, columnTotal, 0.001);
        
        columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 3);
        assertEquals(9.0, columnTotal, 0.001);
    }

    // Tests getting the largest element of the selected row
    @Test
    public void testGetHighestInRow() {
    	
        double highest;
        
    	// Test for each row in the array
        highest = TwoDimRaggedArrayUtility.getHighestInRow(data, 0);
        assertEquals(3.0, highest, 0.001);
        
        highest = TwoDimRaggedArrayUtility.getHighestInRow(data, 1);
        assertEquals(5.0, highest, 0.001);
        
        highest = TwoDimRaggedArrayUtility.getHighestInRow(data, 2);
        assertEquals(9.0, highest, 0.001);
        
        highest = TwoDimRaggedArrayUtility.getHighestInRow(data, 3);
        assertEquals(10.0, highest, 0.001);
    }

    // Tests getting the index of the largest element of the selected row
    @Test
    public void testGetHighestInRowIndex() {
        int highestIndex;
        
       	// Test for each row in the array
        highestIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0);
        assertEquals(2, highestIndex);
        
        highestIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 1);
        assertEquals(1, highestIndex);
        
        highestIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2);
        assertEquals(3, highestIndex);
        
        highestIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 3);
        assertEquals(0, highestIndex);
    }

    // Tests getting the smallest element of the selected row
    @Test
    public void testGetLowestInRow() {
        double lowest;
        
       	// Test for each row in the array
        lowest = TwoDimRaggedArrayUtility.getLowestInRow(data, 0);
        assertEquals(1.0, lowest, 0.001);
        
        lowest = TwoDimRaggedArrayUtility.getLowestInRow(data, 1);
        assertEquals(4.0, lowest, 0.001);
        
        lowest = TwoDimRaggedArrayUtility.getLowestInRow(data, 2);
        assertEquals(6.0, lowest, 0.001);
        
        lowest = TwoDimRaggedArrayUtility.getLowestInRow(data, 3);
        assertEquals(10.0, lowest, 0.001);
    }

    // Tests getting the index of the smallest element of the selected row
    @Test
    public void testGetLowestInRowIndex() {
        int lowestIndex;
        
       	// Test for each row in the array
        lowestIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 0);
        assertEquals(0, lowestIndex);
        
        lowestIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1);
        assertEquals(0, lowestIndex);
        
        lowestIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 2);
        assertEquals(0, lowestIndex);
        
        lowestIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 3);
        assertEquals(0, lowestIndex);
    }
 
    // Tests getting the largest element of the selected column
    @Test
    public void testGetHighestInColumn() {
        double highest;
        
       	// Test for each column in the array
        highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, 0);
        assertEquals(10.0, highest, 0.001);
        
        highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, 1);
        assertEquals(7.0, highest, 0.001);
        
        highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, 2);
        assertEquals(8.0, highest, 0.001);
        
        highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, 3);
        assertEquals(9.0, highest, 0.001);
    }

    // Tests getting the index of the largest element of the selected column
    @Test
    public void testGetHighestInColumnIndex() {
    	int highestIndex;
    	
       	// Test for each column in the array
        highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 0);
        assertEquals(3, highestIndex);
        
        highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1);
        assertEquals(2, highestIndex);
        
        highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 2);
        assertEquals(2, highestIndex);
        
        highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 3);
        assertEquals(2, highestIndex);
    }

    // Tests getting the smallest element of the selected column   
    @Test
    public void testGetLowestInColumn() {
    	double lowest;
    	
       	// Test for each column in the array  	
        lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, 0);
        assertEquals(1.0, lowest, 0.001);
        
        lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, 1);
        assertEquals(2.0, lowest, 0.001);
        
        lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, 2);
        assertEquals(3.0, lowest, 0.001);
        
        lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, 3);
        assertEquals(9.0, lowest, 0.001);
    }

    // Tests getting the index of the smallest element of the selected column
    @Test
    public void testGetLowestInColumnIndex() {
    	int lowestIndex;
    	
        lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 0);
        assertEquals(0, lowestIndex);

        lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1);
        assertEquals(0, lowestIndex);
        
        lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 2);
        assertEquals(0, lowestIndex);
        
        lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 3);
        assertEquals(2, lowestIndex);
    }
    
    // Tests getting the largest element in the two-dimensional array
    @Test
    public void testGetHighestInArray() {
    	double highest = TwoDimRaggedArrayUtility.getHighestInArray(data);
        assertEquals(10.0, highest, 0.001);
    }

    // Tests getting the smallest element in the two-dimensional array
    @Test
    public void testGetLowestInArray() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInArray(data);
        assertEquals(1.0, lowest, 0.001);
    }
}
