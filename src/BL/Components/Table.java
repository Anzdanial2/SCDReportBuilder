package BL.Components;

import BL.DataSources.CSV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Table extends Component{
	private CSV csvRead;
	private JScrollPane tablePanel;
	public Table(CSV read){
		csvRead = read;
	}
	public JScrollPane getTableScrollPane(){
		return tablePanel;
	}
	@Override
	public void display() {
		csvRead.load();
		ArrayList <CustomPoint> list = csvRead.getCSVData();
		String [] legends = csvRead.getLegends();

		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		// Add columns to the model using legends array
		for (String legend : legends) {
			model.addColumn(legend);
		}

		// Add rows to the model using data from CustomPoint objects
		for (CustomPoint point : list) {
			Object[] rowData = {point.getX(), point.getY()};
			model.addRow(rowData);
		}

		// Set the model for the JTable
		table.setModel(model);

		// Create a JScrollPane to display the table if needed
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel = scrollPane;
		// Display the table (you might want to add this to a JFrame or another container)
		JOptionPane.showMessageDialog(null, scrollPane, "Table Display", JOptionPane.INFORMATION_MESSAGE);

	}
}
