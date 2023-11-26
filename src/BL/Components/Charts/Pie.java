package BL.Components.Charts;

import java.awt.*;
import java.util.ArrayList;

public class Pie extends Chart {
	private ArrayList<Double> data;
	private Graphics g;
	public Pie(ArrayList<Double> data, Graphics g){
		this.data = data;
		this.g = g;
	}
	protected void draw(){
		paintComponent(g);
		double totalSum = data.stream().mapToDouble(Double::doubleValue).sum();
		int startAngle = 0;

		for (int i = 0; i < data.size() - 1; i++) {
			double value = data.get(i);
			double angle = 360.0 * (value / totalSum);
			int endAngle = Math.max(1, (int) Math.round(angle));
			g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
			g.fillArc(50, 50, 250, 250, startAngle, endAngle);
			startAngle += endAngle;
		}
		double lastValue = data.get(data.size() - 1);
		double lastAngle = 360.0 - startAngle;
		int lastEndAngle = Math.max(1, (int) Math.round(lastAngle));
		g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
		g.fillArc(50, 50, 250, 250, startAngle, lastEndAngle);
	}

}
