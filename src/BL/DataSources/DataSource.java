package BL.DataSources;

import BL.Components.CustomPoint;

import java.util.ArrayList;

public abstract class DataSource {
	protected ArrayList<CustomPoint> readData;
	protected String []legends;
	public abstract ArrayList<CustomPoint> getData();
	public abstract String [] getLegends();
	public abstract void load();
}
