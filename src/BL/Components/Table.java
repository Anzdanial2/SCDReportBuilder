package BL.Components;

import DataLayer.DataSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * Represents a table component for displaying data in tabular format.
 * Extends the abstract Component class, specifically for handling table display.
 */
public class Table extends Component {
	private JTable table;
	private JPanel tablePanel;  // Change the type to JPanel

	/**
	 * Constructor for the Table class.
	 * Initializes a table component with a specified data source.
	 *
	 * @param datasource The data source to be used for table data.
	 */

	public Table(DataSource datasource) {
		super(datasource);
	}

	/**
	 * Returns the JPanel that contains the displayed table.
	 *
	 * @return The JPanel containing the table.
	 */

	public JComponent getPanel() {
		return tablePanel;
	}

	/**
	 * Loads data from the data source and displays it in a table format.
	 */
	@Override
	public void display() {

		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		// Add columns to the model using legends array
		for (String legend : legends) {
			model.addColumn(legend);
		}

		// Add rows to the model using data from CustomPoint objects
		for (CustomPoint point : customPointList) {
			Object[] rowData = {point.getX(), point.getY()};
			model.addRow(rowData);
		}

		// Set the model for the JTable
		table.setModel(model);

		// Create a JScrollPane to display the table if needed
		JScrollPane scrollPane = new JScrollPane(table);
		tablePanel = new JPanel();  // Change this line to create a new JPanel
		tablePanel.add(scrollPane);  // Add the JScrollPane to the JPanel

		// Display the table (you might want to add this to a JFrame or another container)
		// JOptionPane.showMessageDialog(null, scrollPane, "Table Display", JOptionPane.INFORMATION_MESSAGE);
		this.table = table;
	}
	/**
	 * Returns the JTable instance used in this component.
	 *
	 * @return The JTable instance.
	 */
	public JTable getTable(){return table;}
}
