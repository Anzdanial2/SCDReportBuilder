package BL.Components.Charts;

import BL.Components.Component;
import DataLayer.DataSource;

public abstract class Chart extends Component {
	public Chart(DataSource datasource) {
		super(datasource);
	}

	public void display(){
		draw();
	}
	protected abstract void draw();
}
