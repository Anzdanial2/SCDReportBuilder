package DataLayer;

import BL.Components.CustomPoint;

import java.util.ArrayList;

/**
 * Abstract base class representing a data source.
 * This class provides a framework for data sources, defining methods to get data and legends, and to load data.
 */
public abstract class DataSource {
	protected ArrayList<CustomPoint> readData;
	protected String []legends;

	/**
	 * Abstract method to retrieve data from the data source.
	 *
	 * @return An ArrayList of CustomPoint objects representing the data.
	 */
	public abstract ArrayList<CustomPoint> getData();

	/**
	 * Abstract method to retrieve legends (column names or labels) from the data source.
	 *
	 * @return An array of String representing the legends.
	 */
	public abstract String [] getLegends();

	/**
	 * Abstract method to load data from the data source.
	 */
	public abstract void load();
}
