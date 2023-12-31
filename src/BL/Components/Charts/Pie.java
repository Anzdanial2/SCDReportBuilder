package BL.Components.Charts;

import DataLayer.DataSource;
import DataLayer.Database;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


/**
 * This class represents a pie chart. It extends the Chart class and
 * is used to display a pie chart using data from a specified data source.
 * It includes features such as displaying legends and generating random colors for each pie slice.
 */
public class Pie extends Chart {
	private Map<String, Integer> data;
	private Color[] sliceColors;
	private boolean displayLegends;

	/**
	 * Constructs a Pie chart with the specified data source and configuration for displaying legends.
	 *
	 * @param dataSource      The data source to use for chart data.
	 * @param displayLegends  Boolean flag to determine if legends should be displayed.
	 */

	public Pie(DataSource dataSource, boolean displayLegends) {
		super(dataSource);
		this.displayLegends = displayLegends;
	}

	/**
	 * Sets the visibility of legends on the chart.
	 *
	 * @param displayLegends Boolean flag to set the visibility of legends.
	 */

	public void setDisplayLegends(boolean displayLegends){
		this.displayLegends = displayLegends;
	}

	private void initData() {
		data = new HashMap<>();
		setData();
		for(int i = 0; i < customPointList.size(); i++) {
			data.put((String) customPointList.get(i).getX(), (int) customPointList.get(i).getY());
		}
		generateRandomColors();
	}

	private void generateRandomColors() {
		sliceColors = new Color[data.size()];
		for (int i = 0; i < sliceColors.length; i++) {
			sliceColors[i] = generateRandomColor();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawPieChart(g);
	}

	private void drawPieChart(Graphics g) {
		int total = data.values().stream().mapToInt(Integer::intValue).sum();

		int centerX = 250; // Adjust the center X position as needed
		int centerY = 150; // Adjust the center Y position as needed
		int radius = 100; // Adjust the radius as needed

		int startAngle = 0;
		int colorIndex = 0;

		for (Map.Entry<String, Integer> entry : data.entrySet()) {
			String label = entry.getKey();
			int frequency = entry.getValue();

			double percentage = (double) frequency / total;
			int arcAngle = (int) Math.round(percentage * 360);

			g.setColor(sliceColors[colorIndex]);

			// Draw pie slice
			g.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, startAngle, arcAngle);

			if(displayLegends) {
				// Draw color legend
				g.fillRect(400, 50 + colorIndex * 30, 20, 20);

				// Draw label
				g.drawString(label + " (" + frequency + ")", 430, 65 + colorIndex * 30);
			}
			startAngle += arcAngle;
			colorIndex++;
		}
	}

	private Color generateRandomColor() {
		return new Color((int) (Math.random() * 256),
				(int) (Math.random() * 256),
				(int) (Math.random() * 256));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pie Chart Example");
		Pie pieChart = new Pie(new Database(Database.ChartType.PIE), false);
		pieChart.draw();
		frame.add(pieChart);

		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	protected void draw() {
		setBackground(Color.white);
		initData();
	}

	@Override
	public JComponent getPanel() {
		return this;
	}
}
