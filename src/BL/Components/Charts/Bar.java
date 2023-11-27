package BL.Components.Charts;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Bar extends Chart {

	private static final int AXIS_MARGIN = 50;
	private static final int BAR_WIDTH = 30;

	private Map<String, Integer> data;

	public Bar() {
		setBackground(Color.WHITE);
		initData();
	}

	private void initData() {
		data = new HashMap<>();
		data.put("Category A", 10);
		data.put("Category B", 40);
		data.put("Category C", 30);
		data.put("Category D", 5);
		data.put("Anas Asim", 64);
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
	}

	private void drawYAxis(Graphics g) {
		int maxFrequency = data.values().stream().max(Integer::compareTo).orElse(0);
		int yAxisHeight = getHeight() - AXIS_MARGIN * 2;

		for (int i = 0; i <= maxFrequency + 5; i += calculateYScale(maxFrequency)) {
			int scaledY = AXIS_MARGIN + yAxisHeight - i * yAxisHeight / (maxFrequency + 5);
			g.drawLine(AXIS_MARGIN - 5, scaledY, AXIS_MARGIN, scaledY);
			g.drawString(Integer.toString(i), AXIS_MARGIN - 30, scaledY + 5);
		}

		g.drawLine(AXIS_MARGIN, AXIS_MARGIN, AXIS_MARGIN, getHeight() - AXIS_MARGIN);
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

			Bar bar = new Bar();
			frame.add(bar);

			frame.setVisible(true);
		});
	}
}
