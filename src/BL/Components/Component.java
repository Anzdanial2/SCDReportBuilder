package BL.Components;

import BL.DataSources.DataSource;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Component {
	protected ArrayList<CustomPoint> customPointList;
	protected String []legends;
	protected DataSource datasource;
	public Component(DataSource datasource){
		this.datasource = datasource;
	}
	public void setData(){
		datasource.load();
		customPointList = datasource.getData();
		legends = datasource.getLegends();
	}

	public abstract void display();
	public abstract JComponent getPanel();

}
