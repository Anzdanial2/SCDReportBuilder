package BL.Components.Charts;

import BL.Components.CustomPoint;
import DataLayer.DataSource;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Line extends Chart {
	private ArrayList<CustomPoint> dataPoints;
	private String xLabel;
	private String yLabel;
	private Graphics g;
	public Line(Graphics g, DataSource dataSource){
		super(dataSource);
		dataPoints = new ArrayList<>();
		this.g = g;
	}

	public void setxLabel(String xLabel) {
		this.xLabel = xLabel;
	}

	public void setyLabel(String yLabel) {
		this.yLabel = yLabel;
	}
	public String getxLabel() {
		return xLabel;
	}

	public String getyLabel() {
		return yLabel;
	}
	public ArrayList<CustomPoint> getData() {
		return dataPoints;
	}
	public void setData(ArrayList<CustomPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}
	private double getMaxYValue() {
		return dataPoints.stream().mapToDouble(CustomPoint::getY).max().orElse(1.0);
	}
	protected void draw(){
		paintComponent(g);
		// Draw X-axis
		g.drawLine(50, getHeight() - 50, getWidth() - 50, getHeight() - 50);

		// Draw Y-axis
		g.drawLine(50, 50, 50, getHeight() - 50);

		// Draw X-axis labels
		for (int i = 0; i < dataPoints.size(); i++) {
			double xValue = (double) dataPoints.get(i).getX();
			int x = 50 + i * (getWidth() - 100) / (dataPoints.size() - 1);
			int y = getHeight() - 50;
			g.drawString(String.valueOf(xValue), x - 10, y + 15);
		}

		// Draw Y-axis labels
		for (int i = 0; i < dataPoints.size(); i++) {
			double yValue = dataPoints.get(i).getY();
			int x = 50;
			int y = getHeight() - 50 - (int) (yValue * (getHeight() - 100) / (getMaxYValue()));
			g.drawString(String.valueOf(yValue), x - 30, y + 5);
		}

		// Draw Line Chart
		g.setColor(Color.BLUE);
		for (int i = 0; i < dataPoints.size(); i++) {
			double xValue = (double) dataPoints.get(i).getX();
			double yValue = dataPoints.get(i).getY();

			int x = 50 + i * (getWidth() - 100) / (dataPoints.size() - 1);
			int y = getHeight() - 50 - (int) (yValue * (getHeight() - 100) / (getMaxYValue()));

			g.fillOval(x - 2, y - 2, 4, 4);

			// Draw line connecting points
			if (i > 0) {
				double prevXValue = (double) dataPoints.get(i - 1).getX();
				double prevYValue = dataPoints.get(i - 1).getY();

				int prevX = 50 + (i - 1) * (getWidth() - 100) / (dataPoints.size() - 1);
				int prevY = getHeight() - 50 - (int) (prevYValue * (getHeight() - 100) / (getMaxYValue()));

				g.drawLine(prevX, prevY, x, y);
			}
		}
	}

	public static void main(String []args){
		JFrame frame = new JFrame("Line Chart Example");
		ArrayList<CustomPoint> data = new ArrayList<>();
		data.add(new CustomPoint(0,10));
		data.add(new CustomPoint(10,20));
		data.add(new CustomPoint(20,40));
		data.add(new CustomPoint(30,20));
//		Line lineChart = new Line(data);
//		frame.add(lineChart);

		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public JComponent getPanel() {
		return this;
	}
}
