package BL.Components;

/**
 * Represents a point in a data set with an x and y value.
 * The x value can be any object (such as a String or a Number),
 * while the y value is a double, typically representing a numeric data point.
 */
public class CustomPoint {
	private Object x;
	private double y;
	/**
	 * Constructor for creating a CustomPoint.
	 * Initializes the point with an x value and a y value.
	 *
	 * @param x The x value of the point. Can be any object.
	 * @param y The y value of the point. Should be a double representing a numeric value.
	 */

	public CustomPoint(Object x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Retrieves the x value of the point.
	 *
	 * @return The x value of this point.
	 */
	public Object getX() {
		return x;
	}
	/**
	 * Retrieves the y value of the point.
	 *
	 * @return The y value of this point.
	 */
	public double getY() {
		return y;
	}
}
