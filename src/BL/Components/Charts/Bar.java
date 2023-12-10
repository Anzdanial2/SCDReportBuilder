package BL.Components.Charts;

import DataLayer.DataSource;
import DataLayer.Database;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Bar extends Chart {

	private static final int AXIS_MARGIN = 70;
	private static final int BAR_WIDTH = 30;
	private boolean displayLegends;
	private boolean displayAxisValues;

	private Map<String, Integer> data;

	public Bar(DataSource dataSource, boolean displayLegends, boolean displayAxisValues) {
		super(dataSource);
		this.displayAxisValues = displayAxisValues;
		this.displayLegends = displayLegends;
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
		for(int i = 0; i < customPointList.size(); i++) {
			data.put((String) customPointList.get(i).getX(), (int) customPointList.get(i).getY());
		}
	}

	public void setDisplayLegends(boolean displayLegends) {
		this.displayLegends = displayLegends;
	}

	public void setDisplayAxisValues(boolean displayAxisValues) {
		this.displayAxisValues = displayAxisValues;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int panelWidth = getWidth();
		int panelHeight = getHeight();

		// Draw y-axis with labels
		drawYAxis(g);

		// Draw x-axis with labels
		drawXAxis(g);

		// Draw bars
		drawBars(g);
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
		if (displayAxisValues) {
			int maxFrequency = data.values().stream().max(Integer::compareTo).orElse(0);
			int yAxisHeight = getHeight() - AXIS_MARGIN * 2;

			for (int i = 0; i <= maxFrequency + 5; i += calculateYScale(maxFrequency)) {
				int scaledY = AXIS_MARGIN + yAxisHeight - i * yAxisHeight / (maxFrequency + 5);
				g.drawLine(AXIS_MARGIN - 5, scaledY, AXIS_MARGIN, scaledY);
				g.drawString(Integer.toString(i), AXIS_MARGIN - 30, scaledY + 5);
			}

			g.drawLine(AXIS_MARGIN, AXIS_MARGIN, AXIS_MARGIN, getHeight() - AXIS_MARGIN);
		}
	}

	private int calculateYScale(int maxFrequency) {
		// Add a margin of 5 units
		int margin = 5;
		int yScale = 1;

		while ((maxFrequency + margin) / yScale > 10) {
			yScale *= 2; // Increase the scale if the range is too large
		}

		return yScale;
	}

	private void drawXAxis(Graphics g) {
		if (displayAxisValues) {
			int numCategories = data.size();
			int xAxisWidth = getWidth() - AXIS_MARGIN * 2;

			int intervalWidth = xAxisWidth / (numCategories + 1);

			int currentX = AXIS_MARGIN + intervalWidth;

			for (String category : data.keySet()) {
				g.drawLine(currentX, getHeight() - AXIS_MARGIN, currentX, getHeight() - AXIS_MARGIN + 5);
				g.drawString(category, currentX - 10, getHeight() - AXIS_MARGIN + 20);
				currentX += intervalWidth;
			}

			g.drawLine(AXIS_MARGIN, getHeight() - AXIS_MARGIN, getWidth() - AXIS_MARGIN, getHeight() - AXIS_MARGIN);
		}
	}

	private void drawBars(Graphics g) {
		int maxFrequency = data.values().stream().max(Integer::compareTo).orElse(0);
		int yAxisHeight = getHeight() - AXIS_MARGIN * 2;
		int currentX = AXIS_MARGIN + (getWidth() - AXIS_MARGIN * 2) / (data.size() + 1);

		for (Map.Entry<String, Integer> entry : data.entrySet()) {
			int barHeight = entry.getValue() * yAxisHeight / (maxFrequency + 5);
			int barY = getHeight() - AXIS_MARGIN - barHeight;
			g.fillRect(currentX - BAR_WIDTH / 2, barY, BAR_WIDTH, barHeight);
			currentX += (getWidth() - AXIS_MARGIN * 2) / (data.size() + 1);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Bar Chart Example");
			frame.setSize(600, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			Bar bar = new Bar(new Database(Database.ChartType.BAR), false,false);
			bar.draw();
			frame.add(bar);

			frame.setVisible(true);
		});
	}
}
