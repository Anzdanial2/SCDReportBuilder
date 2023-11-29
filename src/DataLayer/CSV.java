package DataLayer;

import BL.Components.CustomPoint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV extends DataSource {
	private String fileName;
	private boolean isLineData;  // Flag to identify line chart data

	public CSV(String fileName) {
		this.fileName = fileName;
		readData = new ArrayList<>();
	}

	public ArrayList<CustomPoint> getData() {
		return readData;
	}

	public String[] getLegends() {
		return legends;
	}

	public void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String temp = reader.readLine();  // Read the first line to get column names

			if (temp != null) {
				legends = temp.split(",");
			}

			if (legends.length < 2) {
				// Handle the case where there are not enough columns
				System.out.println("Insufficient columns for data.");
				return;
			}

			// Evaluate whether it is line chart data based on the first and second occurring values
			isLineData = !isString(legends[0]) && !isString(legends[1]);

			// Process the rest of the lines based on the chart type
			while ((temp = reader.readLine()) != null) {
				String[] values = temp.split(",");
				values[0] = values[0].trim();
				values[1] = values[1].trim();

				if (isLineData) {
					// For line chart data, use both values as x and y
					readData.add(new CustomPoint(Double.parseDouble(values[0]), Double.parseDouble(values[1])));
				} else {
					// For bar or pie chart data, use the first value as x and the second as y
					readData.add(new CustomPoint(values[0], Double.parseDouble(values[1])));
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private boolean isString(String value) {
		try {
			Double.parseDouble(value);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

//	public static void main(String[] args) {
//		// Replace "sample.csv" with the actual file path if needed
//		CSV csv = new CSV("chartData.txt");
//		csv.load();
//
//		// Print legends
//		System.out.println("Legends:");
//		for (String legend : csv.getLegends()) {
//			System.out.println(legend);
//		}
//
//		// Print data
//		System.out.println("\nData:");
//		for (CustomPoint point : csv.getData()) {
//			System.out.println("X: " + point.getX() + ", Y: " + point.getY());
//		}
//	}
}
