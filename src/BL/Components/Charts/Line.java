package BL.Components.Charts;
import DataLayer.DataSource;
import DataLayer.Database;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a line chart. It extends the Chart class and
 * is used to display a line chart using data from a specified data source.
 * It supports features like displaying legends and axis values.
 */

public class Line extends Chart {

	private static final int AXIS_MARGIN = 80; // Increased margin for Y-axis label
	private static final int POINT_SIZE = 8;
	private Map<Double, Double> data;
	private boolean displayLegends;
	private boolean displayAxisValues;

	/**
	 * Constructs a Line chart with the specified data source and configuration for legends and axis values.
	 *
	 * @param dataSource         The data source to use for chart data.
	 * @param displayLegends     Boolean flag to determine if legends should be displayed.
	 * @param displayAxisValues  Boolean flag to determine if axis values should be displayed.
	 */
	public Line(DataSource dataSource, boolean displayLegends, boolean displayAxisValues) {
		super(dataSource);
		this.displayLegends = displayLegends;
		this.displayAxisValues = displayAxisValues;
	}

	@Override
	protected void draw() {
		setBackground(Color.WHITE);
		initData();
	}

	@Override
	public JComponent getPanel() {
		return this;
	}

	/**
	 * Initiates the data for the line chart from the customPointList.
	 */
	private void initData() {
		data = new HashMap<>();
		setData();
		for (int i = 0; i < customPointList.size(); i++) {
			try {
				String xString = (String) customPointList.get(i).getX();
				double x = Double.parseDouble(xString);
				double y = customPointList.get(i).getY();
				data.put(x, y);
			} catch (NumberFormatException e) {
				System.err.println("Error parsing x value to double: " + e.getMessage());
			}
		}
	}

	/**
	 * Sets the visibility of legends on the chart.
	 *
	 * @param displayLegends Boolean flag to set the visibility of legends.
	 */
	public void setDisplayLegends(boolean displayLegends) {
		this.displayLegends = displayLegends;
	}

	// Method to set the display of axis values
	public void setDisplayAxisValues(boolean displayAxisValues) {
		this.displayAxisValues = displayAxisValues;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawYAxis(g);
		drawXAxis(g);
		drawLinesAndPoints(g);
		drawLabels(g);
	}

	private void drawLabels(Graphics g) {
		if (displayLegends && legends != null) {
			g.setFont(new Font("Arial", Font.PLAIN, 12));
			g.setColor(Color.BLACK);

			if (legends != null) {
				if (legends.length > 0) {
					// Draw the X-axis legend horizontally
					g.drawString(legends[0], getWidth() / 2 - 50, getHeight() - 20); // Adjusted position for X-axis label
				}
				if (legends.length > 1) {
					// Draw the Y-axis legend vertically
					drawVerticalString(g, legends[1], 15, getHeight() / 2);
				}
			}
		}
	}


	private void drawVerticalString(Graphics g, String text, int x, int y) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.translate(x, y);
		g2d.rotate(-Math.PI / 2);
		g2d.drawString(text, 0, 0);
		g2d.dispose();
	}

	private void drawYAxis(Graphics g) {
		if(displayAxisValues) {
			double maxFrequency = data.values().stream().mapToDouble(v -> v).max().orElse(0);
			int yAxisHeight = getHeight() - AXIS_MARGIN * 2;

			for (double i = 0; i <= maxFrequency; i += calculateYScale(maxFrequency)) {
				int scaledY = AXIS_MARGIN + yAxisHeight - (int) (i * yAxisHeight / maxFrequency);
				g.drawLine(AXIS_MARGIN - 5, scaledY, AXIS_MARGIN, scaledY);
				g.drawString(String.format("%.2f", i), AXIS_MARGIN - 45, scaledY + 5);
			}

			g.drawLine(AXIS_MARGIN, AXIS_MARGIN, AXIS_MARGIN, getHeight() - AXIS_MARGIN);
		}
	}

	private double calculateYScale(double maxFrequency) {
		double yScale = 1;
		while (maxFrequency / yScale > 10) {
			yScale *= 2;
		}
		return yScale;
	}

	private void drawXAxis(Graphics g) {
		if (displayAxisValues) {
			int xAxisWidth = getWidth() - AXIS_MARGIN * 2;
			int intervalWidth = xAxisWidth / (data.size() + 1);

			List<Double> sortedKeys = data.keySet().stream().sorted().collect(Collectors.toList());
			int currentX = AXIS_MARGIN + intervalWidth;

			for (double category : sortedKeys) {
				g.drawLine(currentX, getHeight() - AXIS_MARGIN, currentX, getHeight() - AXIS_MARGIN + 5);
				g.drawString(String.format("%.2f", category), currentX - 10, getHeight() - AXIS_MARGIN + 20);
				currentX += intervalWidth;
			}

			g.drawLine(AXIS_MARGIN, getHeight() - AXIS_MARGIN, getWidth() - AXIS_MARGIN, getHeight() - AXIS_MARGIN);
		}
	}

	private void drawLinesAndPoints(Graphics g) {
		g.setColor(Color.BLUE);
		double maxFrequency = data.values().stream().mapToDouble(v -> v).max().orElse(0);
		int yAxisHeight = getHeight() - AXIS_MARGIN * 2;
		int xAxisWidth = getWidth() - AXIS_MARGIN * 2;
		int intervalWidth = xAxisWidth / (data.size() + 1);

		List<Double> sortedKeys = data.keySet().stream().sorted().collect(Collectors.toList());
		Point previousPoint = null;

		for (double key : sortedKeys) {
			int x = AXIS_MARGIN + intervalWidth * (sortedKeys.indexOf(key) + 1);
			int y = getHeight() - AXIS_MARGIN - (int) (data.get(key) * yAxisHeight / maxFrequency);
			Point currentPoint = new Point(x, y);

			if (previousPoint != null) {
				g.drawLine(previousPoint.x, previousPoint.y, currentPoint.x, currentPoint.y);
			}

			g.fillOval(currentPoint.x - POINT_SIZE / 2, currentPoint.y - POINT_SIZE / 2, POINT_SIZE, POINT_SIZE);
			previousPoint = currentPoint;
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Line Chart Example");
			frame.setSize(600, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			Line line = new Line(new Database(Database.ChartType.LINE), false, false);
			line.draw();
			frame.add(line);

			frame.setVisible(true);
		});
	}
}
