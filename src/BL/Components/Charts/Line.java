package BL.Components.Charts;
import DataLayer.DataSource;
import DataLayer.Database;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Line extends Chart {

	private static final int AXIS_MARGIN = 80; // Increased margin for Y-axis label
	private static final int POINT_SIZE = 8;
	private Map<Double, Double> data;

	public Line(DataSource dataSource) {
		super(dataSource);
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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawYAxis(g);
		drawXAxis(g);
		drawLinesAndPoints(g);
		drawLabels(g);
	}

	private void drawLabels(Graphics g) {
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


	private void drawVerticalString(Graphics g, String text, int x, int y) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.translate(x, y);
		g2d.rotate(-Math.PI / 2);
		g2d.drawString(text, 0, 0);
		g2d.dispose();
	}

	private void drawYAxis(Graphics g) {
		double maxFrequency = data.values().stream().mapToDouble(v -> v).max().orElse(0);
		int yAxisHeight = getHeight() - AXIS_MARGIN * 2;

		for (double i = 0; i <= maxFrequency; i += calculateYScale(maxFrequency)) {
			int scaledY = AXIS_MARGIN + yAxisHeight - (int) (i * yAxisHeight / maxFrequency);
			g.drawLine(AXIS_MARGIN - 5, scaledY, AXIS_MARGIN, scaledY);
			g.drawString(String.format("%.2f", i), AXIS_MARGIN - 45, scaledY + 5);
		}

		g.drawLine(AXIS_MARGIN, AXIS_MARGIN, AXIS_MARGIN, getHeight() - AXIS_MARGIN);
	}

	private double calculateYScale(double maxFrequency) {
		double yScale = 1;
		while (maxFrequency / yScale > 10) {
			yScale *= 2;
		}
		return yScale;
	}

	private void drawXAxis(Graphics g) {
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

			Line line = new Line(new Database(Database.ChartType.LINE));
			line.draw();
			frame.add(line);

			frame.setVisible(true);
		});
	}
}
