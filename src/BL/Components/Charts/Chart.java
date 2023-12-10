package BL.Components.Charts;

import BL.Components.Component;
import DataLayer.DataSource;

/**
 * Abstract class representing a chart component.
 * This class serves as a base for different types of chart components,
 * providing a framework for drawing and displaying charts.
 */
public abstract class Chart extends Component {
	/**
	 * Constructor for creating a Chart object.
	 * Initializes the chart with a specified data source.
	 *
	 * @param datasource The data source to be used by the chart.
	 */
	public Chart(DataSource datasource) {
		super(datasource);
	}

	/**
	 * Displays the chart by invoking the draw method.
	 * This method should be implemented by subclasses to define
	 * specific drawing behavior for different types of charts.
	 */
	public void display(){
		draw();
	}
	/**
	 * Abstract method for drawing the chart.
	 * Subclasses must implement this method to define how the chart is drawn.
	 */
	protected abstract void draw();
}
