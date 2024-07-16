/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Plot class has constructors to create the data objects and 
 *    accessor and mutator methods to manipulate the plot coordinate data. 
 *    The plot class also defines methods to ensure properties do not overlap 
 *    and are not encompassed by another property. 
 * Due: 07/15/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class Plot {
	
	// Represents x and y coordinates of the upper left corner of the location
	private int x;
	private int y;
	
	// Represents the vertical and horizontal extents of the plot
	private int width;
	private int depth; 
	
	/* 
	 * Plot default constructor:
	 * Creates a default Plot with width and depth of 1
	 */
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	/*
	 * Plot paramaterized constructor:
	 * Creates a Plot using the given parameters (plot dimensions)
	 * @param x - the x coordinate of the plot
	 * @param y - the y coordinate of the plot
	 * @param width - the width of the plot
	 * @param depth - the depth of the plot
	 */
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/*
	 * Plot copy constructor:
	 * Creates a new plot given another plot
	 * This constructor must call an appropriate existing constructor
	 * @param otherPlot - the plot to make a copy of
	 */
	
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	/*
	 * Gets the x
	 * @ return x
	 */
	
	public int getX() {
		return x;
	}
	
	/*
	 * Sets the x
	 * @param x - the new x
	 */
	
	public void setX(int x) {
		this.x = x;
	}
	
	/*
	 * Gets the y
	 * @return y
	 */
	
	public int getY() {
		return y;
	}
	
	/*
	 * Sets the y
	 * @param y - the new y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/*
	 * Gets the width
	 * @return width
	 */
	
	public int getWidth() {
		return width;
	}
	
	/*
	 * Sets the width
	 * @param width - the new width
	 */
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	/*
	 * Gets the depth
	 * @return depth
	 */
	
	public int getDepth() {
		return depth;
	}
	
	/*
	 * Sets the depth
	 * @param depth - the new depth
	 */
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/*
	 * @param plot - the plot to test against and check if overlaps
	 * @return true - if the two plots overlap, false otherwise
	 */
	
	public boolean overlaps(Plot otherPlot) {
		// Overlap if x is to the right of the comparison plot
		boolean overlap = false;
		int rightX = this.x + this.width;
		int lowerY = this.y + this.depth;
		int newRightX = otherPlot.x + otherPlot.width;
		int newLowerY = otherPlot.x + otherPlot.depth;

		if (rightX < otherPlot.x || newRightX < this.x || 
		    lowerY < otherPlot.y || newLowerY < this.y) {

		   overlap = false;
	    }  else {
	       overlap = true;
	    }
				
 //     System.out.println("if (rightX <= otherPlot.x || newRightX <= this.x)"); 
 //    	System.out.println(rightX + " " + otherPlot.x + " " + newRightX + " " + this.x);
 //     System.out.println("if (newLowerY <= this.y || plot.y >= lowerY"); 
 //    	System.out.println(newLowerY + " " + this.y + " " + otherPlot.y + " " + lowerY);
 //    	System.out.println("Overlap:" + overlap);
      
        return overlap;
	}
	
	/*
	 * @param plot - the plot to test again and check if encompasses
	 * @return true - if the given plot is encompassed by this plot, false otherwise
	 */
	
	public boolean encompasses(Plot plot) {
		boolean encompass = false;
		double rightX = x + width;
		double lowerY = y + depth;
		double newRightX = plot.getX() + plot.getWidth();
		double newLowerY = plot.getY() + plot.getDepth();
		if (this.x <= plot.getX() && plot.getX() <= rightX &&
				this.y <= plot.getY() && plot.getY() <= lowerY &&
				this.x <= rightX && newRightX <= rightX &&
				this.y <= newLowerY && newLowerY <= lowerY) {
			encompass = true;
		}
		
		return encompass;	
	}

	/*
	 * Represents a Plot object in the following String format: x, y, width, depth
	 * @return string - representation of a plot
	 */
	
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}
}

