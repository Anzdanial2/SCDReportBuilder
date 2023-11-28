package BL.Components.Charts;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Pie extends JPanel {
	private Map<String, Integer> data;
	private Color[] sliceColors;

	public Pie(Map<String, Integer> data) {
		this.data = data;
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

		int startAngle = 0;
		int colorIndex = 0;

		for (Map.Entry<String, Integer> entry : data.entrySet()) {
			String label = entry.getKey();
			int frequency = entry.getValue();

			double percentage = (double) frequency / total;
			int arcAngle = (int) Math.round(percentage * 360);

			g.setColor(sliceColors[colorIndex]);
			g.fillArc(50, 50, 200, 200, startAngle, arcAngle);
			g.fillRect(300, startAngle, 20, 20);
			g.drawString(label + " (" + frequency + ")", 330, startAngle + 15);

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
		Map<String, Integer> sampleData = new HashMap<>();
		sampleData.put("Category A", 25);
		sampleData.put("Category B", 30);
		sampleData.put("Category C", 20);
		sampleData.put("Category D", 25);

		JFrame frame = new JFrame("Pie Chart Example");
		Pie pieChart = new Pie(sampleData);
		frame.add(pieChart);

		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
