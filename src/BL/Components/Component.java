package BL.Components;

import DataLayer.DataSource;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Abstract base class for different types of graphical components.
 * This class provides a framework for components that display data,
 * handling common functionalities such as data loading and setting up legends.
 */
public abstract class Component extends JPanel{
	protected ArrayList<CustomPoint> customPointList;
	protected String []legends;
	protected DataSource datasource;
	/**
	 * Constructor for the Component class.
	 * Initializes the component with a specified data source.
	 *
	 * @param datasource The data source to be used by the component.
	 */
	public Component(DataSource datasource){
		this.datasource = datasource;
	}

	/**
	 * Loads data from the data source and sets up the component with this data.
	 * This includes loading the data points and the legends.
	 */
	public void setData(){
		datasource.load();
		customPointList = datasource.getData();
		legends = datasource.getLegends();
	}

	/**
	 * Abstract method for displaying the component.
	 * Subclasses must implement this method to define specific display behavior.
	 */
	public abstract void display();
	/**
	 * Abstract method to get the JPanel representation of the component.
	 * Subclasses must implement this method to return the appropriate JPanel.
	 *
	 * @return JComponent that represents this component.
	 */
	public abstract JComponent getPanel();

}
