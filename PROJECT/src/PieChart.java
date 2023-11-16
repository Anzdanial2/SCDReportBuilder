import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PieChart extends JPanel {
    ArrayList<Double> data;

    public PieChart(ArrayList<Double> data){
        this.data = data;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Report Builder");
        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        ArrayList<Double> data = new ArrayList<>();
        data.add(25.0);
        data.add(33.0);
        data.add(10.0);
        data.add(2.0);
        //CustomColor feature to do...
        //Passing as argument
        PieChart pieChart = new PieChart(data);
        mainFrame.add(pieChart);
        mainFrame.setVisible(true);
    }
}

