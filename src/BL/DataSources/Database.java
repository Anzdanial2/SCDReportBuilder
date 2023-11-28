package BL.DataSources;

import BL.Components.CustomPoint;

import java.sql.*;
import java.util.ArrayList;

public class Database extends DataSource {

	// Database connection parameters
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/SCDREPORTBUILDER";
	private static final String USERNAME = "anzdanial";
	private static final String PASSWORD = "2001";
	private ChartType chartType;
	private static final String TABLE_NAME_LINE = "LINECHART";
	private static final String TABLE_NAME_BAR = "BARCHART";
	private static final String TABLE_NAME_PIE = "PIECHART";

	// Enum for ChartType
	public enum ChartType {
		LINE, BAR, PIE
	}

	// Chart type and corresponding table names and queries


	private String getTableName() {
		switch (chartType) {
			case LINE:
				return TABLE_NAME_LINE;
			case BAR:
				return TABLE_NAME_BAR;
			case PIE:
				return TABLE_NAME_PIE;
			default:
				throw new IllegalArgumentException("Unsupported chart type: " + chartType);
		}
	}

	private String getSelectQuery() {
		return "SELECT * FROM " + getTableName();
	}

	public Database(ChartType chartType) {
		this.chartType = chartType;
	}

	@Override
	public ArrayList<CustomPoint> getData() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement(getSelectQuery());
			 ResultSet resultSet = preparedStatement.executeQuery()) {

			readData = new ArrayList<>();

			// Retrieve result set metadata to get column names
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (resultSet.next()) {
				Object x = resultSet.getString(metaData.getColumnName(1));
				double y = resultSet.getDouble(metaData.getColumnName(2));
				readData.add(new CustomPoint(x, y));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return readData != null ? readData : new ArrayList<>();
	}

	@Override
	public String[] getLegends() {
		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			 PreparedStatement preparedStatement = connection.prepareStatement(getSelectQuery());
			 ResultSet resultSet = preparedStatement.executeQuery()) {

			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			legends = new String[columnCount];

			for (int i = 1; i <= columnCount; i++) {
				legends[i - 1] = metaData.getColumnName(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return legends != null ? legends : new String[0];
	}

	@Override
	public void load() {
		// You can perform additional loading tasks if needed
	}

	public static void main(String[] args) {
		// Create an instance of Database for a specific chart type
		Database lineChartDatabase = new Database(ChartType.LINE);

		// Test getData() method
		ArrayList<CustomPoint> data = lineChartDatabase.getData();
		System.out.println("Data from the database:");
		for (CustomPoint point : data) {
			System.out.println("X: " + point.getX() + ", Y: " + point.getY());
		}

		// Test getLegends() method
		String[] legends = lineChartDatabase.getLegends();
		System.out.println("Legends:");
		for (String legend : legends) {
			System.out.println(legend);
		}


		Database BarChartDatabase = new Database(ChartType.BAR);

		// Test getData() method
		ArrayList<CustomPoint> dataBar = BarChartDatabase.getData();
		System.out.println("Data from the database:");
		for (CustomPoint point : dataBar) {
			System.out.println("X: " + point.getX() + ", Y: " + point.getY());
		}

		// Test getLegends() method
		String[] legendsBar = BarChartDatabase.getLegends();
		System.out.println("Legends:");
		for (String legend : legendsBar) {
			System.out.println(legend);
		}
	}
}
