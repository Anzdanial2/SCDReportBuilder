package BL.Reports;

import BL.Components.Component;
import BL.Components.Image;
import BL.Components.Text;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;

public class Report {
	private ArrayList<Component> componentList;
	private static int ID = 0;
	private String title;
	private LocalDateTime timeStamp;
	private Exporter exporter;

	public Report(String title){
		this.title = title;
		this.timeStamp = LocalDateTime.now();
		this.componentList = new ArrayList<>();
		ID++;
	}
	public void add(Component component){
		componentList.add(component);
	}
	public void display(){
		for (Component component : componentList) {
			component.display();
		}
	}
//	public void save(){
//
//	}
	public void load(){
		for (Component component : componentList) {
			if(component instanceof Text || component instanceof Image)
				continue;
			else
				component.setData();
		}
	}
	public void export(Exporter export){
		export.export();
	}
	public String getTitle(){return title;}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public ArrayList<Component> getComponentList(){
		return componentList;
	}
}
